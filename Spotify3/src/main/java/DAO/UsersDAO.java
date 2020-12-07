package DAO;

import java.util.Set;

import enums.SentenciasUsers;
import model.User;

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
		//this.setSubscriptions(u.getSubscriptions());
	}

	/**
	 * Select a user form the database based on the parameter id
	 * @param id(int): user id
	 */
	public UsersDAO(int id){
	}

	/**
	 * Select a user form the database based on the parameter mail
	 * @param email(String): user mail
	 */
	public UsersDAO(String email){

	}

	/**
	 * According the user id, update or insert: if id is -1, insert user
	 * if id is greater than 0, update user
	 * @return int: 1 if has been updated or inserted, 0 if didn't work, -1 if error
	 */
	public int update(){
		return 0;
	}

	/**
	 * According the user id, deactivate that user (cant use that user)
	 * @return int: 1 if the artist has been deactivated, 0 if didn't work, -1 if error
	 */
	public int defuse(){
		return 0;
	}



}
