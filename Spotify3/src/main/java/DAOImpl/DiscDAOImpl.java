package DAOImpl;

import java.time.LocalDate;
import java.util.List;

import DAO.DiscDAO;
import enums.SentenciasDisc;
import model.Artist;
import model.Disc;

public class DiscDAOImpl extends DiscDAO{

	/**
	 * Search discs by name
	 * @param name(String): disc name
	 * @return List<Disc>: discs selected by name
	 */
	public static List<Disc> SearchByName(String name){
		return null;
	}

	/**
	 * Search discs depending the statement and parameters
	 * @param sent(SentenciasDisc): statement by want to search (Author or name)
	 * @param id(int): disc id
	 * @param artista(Artista): disc author
	 * @param argumentos(String): disc name
	 * @param date(LocalDate): disc date release
	 * @return List<Disc>: discs selected based on the statement
	 */
	private static List<Disc> Search(SentenciasDisc sent, int id, Artist artista, String argumentos, LocalDate date){
		return null;
	}

	public static boolean ExistDisc(String n, int id_artist){
		return true;
	}

}
