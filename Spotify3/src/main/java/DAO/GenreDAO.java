package DAO;



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
		try{
			g=ConnectionManager.getManager().find(Genre.class, id);
		}catch (Exception e) {
			// TODO: handle exception
		}

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
		if(n.getId()>0){
			try{
				ConnectionManager.getManager().merge(n);
				result=1;
			}catch (Exception e) {

			}

		}else{
			try{
				ConnectionManager.getManager().persist(n);
				ConnectionManager.getManager().flush();
				this.setId(n.getId());
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
	 * According the genre id, delete that artist from the data base
	 * @return int: 1 if the genre has been deleted, 0 if didn't work, -1 if error
	 */
	public int delete(){
		int result=-1;
		Genre n=new Genre(this.getId(), this.getName());
		if(n.getId()>0){
			ConnectionManager.getManager().getTransaction().begin();
			try{
				ConnectionManager.getManager().remove(ConnectionManager.getManager().contains(n) ? n : ConnectionManager.getManager().merge(n));
				result=1;
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}

			ConnectionManager.getManager().getTransaction().commit();
			ConnectionManager.CloseEntityManager();
		}

		return result;
	}


}
