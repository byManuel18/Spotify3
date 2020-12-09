package DAO;

import java.util.Set;

import enums.SentenciasArtista;
import model.Artist;
import model.Genre;
import utilities.ConnectionManager;

public class ArtistDAO extends Artist {

	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public ArtistDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * full constructor
	 * @param id(int): artist id
	 * @param name(String): artist name
	 * @param nationality(String): artist nationality
	 * @param photo(String): artist photo
	 */
	public ArtistDAO(int id, String name, String nationality, String photo) {
		super(id, name, nationality, photo);
		// TODO Auto-generated constructor stub
	}

	/**
	 * constructor without id
	 * @param name(String): artist name
	 * @param nationality(String): artist nationality
	 * @param photo(String): artist photo
	 */
	public ArtistDAO(String name, String nationality, String photo) {
		super(name, nationality, photo);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor that receives an artist
	 * @param a(Artist)
	 */
	public ArtistDAO(Artist a){
		this.setId(a.getId());
		this.setName(a.getName());
		this.setNationality(a.getNationality());
		this.setPhoto(a.getPhoto());
		this.setDisclist(a.getDisclist());

	}

	/**
	 * Select an artist from the database based on the parameter ID
	 * @param id(int): Artist id
	 */
	public ArtistDAO(int id){
		Artist a=null;
		ConnectionManager.getManager().getTransaction().begin();
		try{
			a=ConnectionManager.getManager().find(Artist.class, id);

			if(a!=null){
				//ConnectionManager.getManager().merge(a);
				this.setId(id);
				this.setName(a.getName());
				this.setNationality(a.getNationality());
				this.setPhoto(a.getPhoto());
				this.setDisclist(a.getDisclist());
			}
		}catch (Exception e) {
			// TODO: handle exception
		}

		ConnectionManager.getManager().getTransaction().commit();
		ConnectionManager.CloseEntityManager();


	}

	/**
	 * According the artist id, update or insert: if id is -1, insert artist
	 * if id is greater than 0, update artist
	 * @return int: 1 if has been updated or inserted, 0 if didn't work, -1 if error
	 */
	public int update(){
		int result=-1;
		Artist a=new Artist(this.getId(),this.getName(),this.getNationality(),this.getPhoto());
		a.setDisclist(this.getDisclist());
		ConnectionManager.getManager().getTransaction().begin();
		if(a.getId()>0){
			try{
				ConnectionManager.getManager().merge(a);
				result=1;
			}catch (Exception e){

			}
		}else{
			try{
				ConnectionManager.getManager().persist(a);
				ConnectionManager.getManager().flush();
				this.setId(a.getId());
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
	 * According the artist id, delete that artist from the data base
	 * @return int: 1 if the artist has been deleted, 0 if didn't work, -1 if error
	 */
	public int delete(){
		int result =-1;
		Artist a=new Artist(this.getId(),this.getName(),this.getNationality(),this.getPhoto());
		a.setDisclist(this.getDisclist());
		if(a.getId()>0){
			ConnectionManager.getManager().getTransaction().begin();
			try{
				ConnectionManager.getManager().remove(ConnectionManager.getManager().contains(a) ? a : ConnectionManager.getManager().merge(a));
				result=1;
			}catch (Exception e) {
				// TODO: handle exception
			}
			ConnectionManager.getManager().getTransaction().commit();
			ConnectionManager.CloseEntityManager();
		}

		return result;
	}



}
