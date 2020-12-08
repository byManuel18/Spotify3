package DAOImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import DAO.ArtistDAO;
import enums.SentenciasArtista;
import model.Artist;
import utilities.ConnectionManager;

public class ArtistDAOImpl extends ArtistDAO{

	/**
	 * Search artists by name
	 * @param name(String): Artist name
	 * @return List<Artist>: artist selected by name
	 */
	public  static List<Artist> SelectbyName(String name){
		return Search(SentenciasArtista.SELECTBYNAME, -1, name);
	}
	/**
	 * Search artists by id
	 * @param id(int): Artist id
	 * @return List<Artist>: artist selected by id
	 */
	public  static List<Artist> SelectbyId(int id){
		return Search(SentenciasArtista.SELECTBYID, id, "");
	}

	/**
	 * Search artists by nationality
	 * @param nationality(String): Artist nationality
	 * @return List<Artist>: artist selected by nationality
	 */
	public  static List<Artist> SelectbyNacionalidad(String nationality){
		return Search(SentenciasArtista.SELECTBYNACIONALIDAD, -1, "");
	}

	/**
	 * Search all artists
	 * @return List<Artist>: all artists
	 */
	public  static List<Artist> SelectAll(){
		return Search(SentenciasArtista.SELECTALL, -1, "");
	}

	/**
	 * Search artists depending the statement and the parameter
	 * @param sql(SentenciasArtista): statement by want to search (name or nationality)
	 * @param parametro(String): parameter by want to search
	 * @return List<Artist>: artists selected based on the statement
	 */
	private static List<Artist> Search(SentenciasArtista sql,int id, String parametro){
		Query query=null;
		List<Artist> lista=new ArrayList<Artist>();
		ConnectionManager.getManager().getTransaction().begin();
		try{
			if(sql==SentenciasArtista.SELECTALL){
				query = ConnectionManager.getManager().createNamedQuery("Artist_findAll",Artist.class);
			}
			if(sql==SentenciasArtista.SELECTBYNAME){
				query = ConnectionManager.getManager().createNamedQuery("Artist_byName",Artist.class);
				query.setParameter("name", parametro+"%");
			}
			if(sql==SentenciasArtista.SELECTBYNACIONALIDAD){
				query = ConnectionManager.getManager().createNamedQuery("Artist_byNationality",Artist.class);
			}
			if(sql==SentenciasArtista.SELECTBYID){
				query = ConnectionManager.getManager().createNamedQuery("Artist_byId", Artist.class);
				}
			lista.addAll((List<Artist>)query.getResultList());
		}catch (Exception e) {
			// TODO: handle exception
		}

		ConnectionManager.getManager().getTransaction().commit();
		ConnectionManager.CloseEntityManager();

		return lista;
	}

	public static boolean existArtist(String name){
		boolean result=false;
		Artist a=null;
		ConnectionManager.getManager().getTransaction().begin();
		try{
			Query query = ConnectionManager.getManager().createNamedQuery("Artist_exist",Artist.class);
			query.setParameter("name",name);
			a=(Artist)query.getSingleResult();
		}catch (Exception e) {
			// TODO: handle exception
		}
		ConnectionManager.getManager().getTransaction().commit();
		ConnectionManager.CloseEntityManager();
		if(a!=null){
			result=true;
		}
		return result;
	}

}
