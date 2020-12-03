package DAOImpl;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import DAO.GenreDAO;
import model.Genre;
import utilities.ConnectionManager;


@NamedQueries({
    @NamedQuery(name="Genre.findAll",
                query="SELECT g FROM GENRE g"),
    @NamedQuery(name="Genre.exist",
    query="SELECT g FROM GENRE g WHERE g.nombre= :name"),

})
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
		Query query = ConnectionManager.getManager().createNamedQuery("Genre.exist");
		query.setParameter("name",name);
		Genre g=(Genre)query.getSingleResult();
		if(g!=null){
			result=true;
		}
		return result;
	}

}
