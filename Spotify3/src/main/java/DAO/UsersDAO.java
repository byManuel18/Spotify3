package DAO;

import java.util.Set;

import javax.persistence.Query;

import enums.SentenciasUsers;
import model.Disc;
import model.User;
import utilities.ConnectionManager;

public class UsersDAO extends User{

	/**
	 * Default constructor
	 */
	public UsersDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Full constructor
	 * @param id(int): user id
	 * @param mail(String): user mail
	 * @param name(String): user name
	 * @param photo(String): user photo
	 * @param active(Boolean): if user account is activated or not("deleted")
	 */
	public UsersDAO(int id, String mail, String name, String photo,boolean active) {
		super(id, mail, name, photo,active);
		// TODO Auto-generated constructor stub
	}

	/**
	 * constructor without id
	 * @param mail(String): user mail
	 * @param name(String): user name
	 * @param photo(String): user photo
	 * @param active(Boolean): if user account is activated or not("deleted")
	 */
	public UsersDAO(String mail, String name, String photo,boolean active) {
		super(mail, name, photo,active);
		// TODO Auto-generated constructor stub
	}

	/**
	 * constructor that receives a user
	 * @param u(User)
	 */
	public UsersDAO(User u){
		this.setId(u.getId());
		this.setActive(u.isActive());
		this.setMail(u.getMail());
		this.setName(u.getName());
		this.setPhoto(u.getPhoto());
		this.setPlaylistCreates(u.getPlaylistCreates());
		this.setSubscriptions(u.getSubscriptions());
	}

	/**
	 * Select a user form the database based on the parameter id
	 * @param id(int): user id
	 */
	public UsersDAO(int id){
		User u= null;
		ConnectionManager.getManager().getTransaction().begin();
		try{
			u=ConnectionManager.getManager().find(User.class, id);
		}catch(Exception e){

		}
		if(u!=null){
			this.setId(id);
			this.setActive(u.isActive());
			this.setMail(u.getMail());
			this.setName(u.getName());
			this.setPhoto(u.getPhoto());
			this.setPlaylistCreates(u.getPlaylistCreates());
			this.setSubscriptions(u.getPlaylistCreates());
		}
		ConnectionManager.getManager().getTransaction().commit();
		ConnectionManager.CloseEntityManager();
	}

	/**
	 * Select a user form the database based on the parameter mail
	 * @param email(String): user mail
	 */
	public UsersDAO(String email){
		User u=null;
		ConnectionManager.getManager().getTransaction().begin();
		try{
			Query query = ConnectionManager.getManager().createNamedQuery("User_findbyname",User.class);
			query.setParameter("name",email);
			u=(User)query.getSingleResult();
			 ConnectionManager.getManager().merge(u);
			if(u!=null){
				this.setId(u.getId());
				this.setActive(u.isActive());
				this.setMail(email);
				this.setName(u.getName());
				this.setPhoto(u.getPhoto());
				this.setPlaylistCreates(u.getPlaylistCreates());
				this.setSubscriptions(u.getPlaylistCreates());
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		ConnectionManager.getManager().getTransaction().commit();
		ConnectionManager.CloseEntityManager();

		//User_findbyname
	}

	/**
	 * According the user id, update or insert: if id is -1, insert user
	 * if id is greater than 0, update user
	 * @return int: 1 if has been updated or inserted, 0 if didn't work, -1 if error
	 */
	public int update(){
		int result=-1;
		User u = new User(this.getId(),this.getMail(), this.getName(), this.getPhoto(), this.isActive());
		u.setPlaylistCreates(this.getPlaylistCreates());
		u.setSubscriptions(this.getSubscriptions());
		ConnectionManager.getManager().getTransaction().begin();
		if(u.getId()>0){
			try{
				ConnectionManager.getManager().merge(u);
				result=1;
			}catch (Exception e){

			}
		}else{
			try{
				ConnectionManager.getManager().persist(u);
				ConnectionManager.getManager().flush();
				this.setId(u.getId());
				result=1;
			}catch (Exception e) {
				// TODO: handle exception
			}
		}

		ConnectionManager.getManager().getTransaction().commit();
		ConnectionManager.CloseEntityManager();
		return result;
	}

	/**
	 * According the user id, deactivate that user (cant use that user)
	 * @return int: 1 if the artist has been deactivated, 0 if didn't work, -1 if error
	 */
	public int defuse(){
		int result=-1;
		User u = new User(this.getId(),this.getMail(),this.getName(),this.getPhoto(),false);
		u.setPlaylistCreates(this.getPlaylistCreates());
		u.setSubscriptions(this.getSubscriptions());
		ConnectionManager.getManager().getTransaction().begin();
		if(u.getId()>0){
			try{
				ConnectionManager.getManager().merge(u);
				result=1;
			}catch (Exception e){

			}
		}else{
			try{
				ConnectionManager.getManager().persist(u);
				ConnectionManager.getManager().flush();
				this.setId(u.getId());
				result=1;
			}catch (Exception e) {
				// TODO: handle exception
			}
		}

		ConnectionManager.getManager().getTransaction().commit();
		ConnectionManager.CloseEntityManager();
		return result;
	}



}
