package DAOImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import DAO.DiscDAO;
import enums.SentenciasArtista;
import enums.SentenciasDisc;
import model.Artist;
import model.Disc;
import utilities.ConnectionManager;

public class DiscDAOImpl extends DiscDAO{

	/**
	 * Search discs by name
	 * @param name(String): disc name
	 * @return List<Disc>: discs selected by name
	 */
	public static List<Disc> SearchByName(String name){

		return Search(SentenciasDisc.SELECTBYNAME, -1, null, name, null);
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
		Query query=null;
		List<Disc> listds=new ArrayList<Disc>();
		ConnectionManager.getManager().getTransaction().begin();
		try{
			if(sent==SentenciasDisc.SELECTALL){
				query = ConnectionManager.getManager().createNamedQuery("Disc_findAll",Disc.class);
			}else if(sent==SentenciasDisc.SELECTBYID){
				query= ConnectionManager.getManager().createNamedQuery("Disc_findId",Disc.class);
			}else if(sent==SentenciasDisc.SELECTBYNAME){
				query = ConnectionManager.getManager().createNamedQuery("Artist_byName",Artist.class);
				query.setParameter("name", argumentos+"%");
			}
			listds.addAll((List<Disc>)query.getResultList());
		}catch (Exception e) {
			// TODO: handle exception
		}

		ConnectionManager.getManager().getTransaction().commit();
		ConnectionManager.CloseEntityManager();
		return listds;
	}

	public static boolean ExistDisc(String n, int id_artist){
		boolean result=false;
		Disc g=null;
		ConnectionManager.getManager().getTransaction().begin();
		try{
			Query query = ConnectionManager.getManager().createNamedQuery("Disc_exist",Disc.class);
			query.setParameter("name",n);
			query.setParameter("artist", id_artist);
			g=(Disc)query.getSingleResult();
		}catch (Exception e) {
			// TODO: handle exception
		}
		ConnectionManager.getManager().getTransaction().commit();
		ConnectionManager.CloseEntityManager();
		if(g!=null){
			result=true;
		}
		return result;
	}

}
