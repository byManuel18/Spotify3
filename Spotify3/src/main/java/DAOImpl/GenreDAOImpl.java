package DAOImpl;

import java.util.ArrayList;


import java.util.List;
import javax.persistence.Query;
import DAO.GenreDAO;
import enums.SentenciasGenre;
import model.Genre;
import utilities.ConnectionManager;


public class GenreDAOImpl extends GenreDAO{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Check if a genre already exists on the database
	 * @param name(String): genre name
	 * @return true if exist
	 */
	public static boolean Exist(String  name){
		boolean result=false;
		ConnectionManager.getManager().getTransaction().begin();
		Query query = ConnectionManager.getManager().createNamedQuery("Genre_exist",Genre.class);
		query.setParameter("name",name);
		Genre g=(Genre)query.getSingleResult();
		ConnectionManager.getManager().getTransaction().commit();
		ConnectionManager.CloseEntityManager();
		if(g!=null){
			result=true;
		}
		return result;
	}

	/**
	 * Search all genre
	 * @return List<Genre>: all genres
	 */
	public static List<Genre> SelectALL(){
		return Search(SentenciasGenre.SELECTALL, -1, "");
	}

	/**
	 * Search genres depending the statement and the parameter
	 * @param sql(SentenciasGenre): statement by want to search (name)
	 * @param id(int): genre id
	 * @param argument(String): genre name
	 * @return
	 */
	private static List<Genre> Search(SentenciasGenre sql,int id,String argument){
		Query query=null;
		List<Genre> listgs=new ArrayList<Genre>();
		ConnectionManager.getManager().getTransaction().begin();
		if(sql==SentenciasGenre.SELECTALL){
			query = ConnectionManager.getManager().createNamedQuery("Genre_findAll",Genre.class);
		}
		listgs.addAll((List<Genre>)query.getResultList());
		ConnectionManager.getManager().getTransaction().commit();
		ConnectionManager.CloseEntityManager();

		return listgs;
	}

}
