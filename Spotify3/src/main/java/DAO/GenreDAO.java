package DAO;


import java.util.Set;
import enums.SentenciasGenre;
import model.Genre;
import utilities.ConnectionManager;

public class GenreDAO extends Genre{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public GenreDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * full constructor
	 * @param id(int): genre id
	 * @param name(String): genre name
	 */
	public GenreDAO(int id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}

	/**
	 * constructor without id
	 * @param name(String): genre name
	 */
	public GenreDAO(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	/**
	 * constructor that receives a genre
	 * @param g(Genre)
	 */
	public GenreDAO(Genre g){
		this.setId(g.getId());
		this.setName(g.getName());
	}

	/**
	 * Select a genre from the database based on the parameter id
	 * @param id(int): genre int
	 */
	public GenreDAO(int id){
		Genre g=null;
		ConnectionManager.getManager().getTransaction().begin();
		g=ConnectionManager.getManager().find(Genre.class, id);
		ConnectionManager.getManager().getTransaction().commit();
		ConnectionManager.CloseEntityManager();
		if(g!=null){
			this.setId(id);
			this.setName(g.getName());
		}

	}

	/**
	 * According the genre id, update or insert: if id is -1, insert genre
	 * if id is greater than 0, update genre
	 * @return int: 1 if has been updated or inserted, 0 if didn't work, -1 if error
	 */
	public int update(){
		int result=-1;
		Genre n=new Genre(this.getId(), this.getName());
		ConnectionManager.getManager().getTransaction().begin();
		ConnectionManager.getManager().persist(n);
		result=1;
		ConnectionManager.getManager().getTransaction().commit();

		return result;
	}

	/**
	 * According the genre id, delete that artist from the data base
	 * @return int: 1 if the genre has been deleted, 0 if didn't work, -1 if error
	 */
	public int delete(){
		int result=0;
		Genre n=new Genre(this.getId(), this.getName());;
		ConnectionManager.getManager().getTransaction().begin();
		ConnectionManager.getManager().remove(n);
		result=1;
		ConnectionManager.getManager().getTransaction().commit();
		return result;
	}


}
