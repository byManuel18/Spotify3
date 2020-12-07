package DAOImpl;

import java.util.List;
import DAO.ArtistDAO;
import enums.SentenciasArtista;
import model.Artist;

public class ArtistDAOImpl extends ArtistDAO{

	/**
	 * Search artists by name
	 * @param name(String): Artist name
	 * @return List<Artist>: artist selected by name
	 */
	public  static List<Artist> SelectbyName(String name){
		return null;
	}

	/**
	 * Search artists by nationality
	 * @param name(String): Artist nationality
	 * @return List<Artist>: artist selected by nationality
	 */
	public  static List<Artist> SelectbyNacionalidad(String name){
		return null;
	}

	/**
	 * Search all artists
	 * @return List<Artist>: all artists
	 */
	public  static List<Artist> SelectAll(){
		return null;
	}

	/**
	 * Search artists depending the statement and the parameter
	 * @param sql(SentenciasArtista): statement by want to search (name or nationality)
	 * @param parametro(String): parameter by want to search
	 * @return List<Artist>: artists selected based on the statement
	 */
	private static List<Artist> Search(SentenciasArtista sql,String parametro){
		return null;
	}

	public static boolean existArtist(String s){
		return true;
	}

}
