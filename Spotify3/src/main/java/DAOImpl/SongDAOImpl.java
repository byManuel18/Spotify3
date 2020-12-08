package DAOImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import DAO.SongDAO;
import enums.SentenciasSong;
import model.Disc;
import model.Genre;
import model.Song;
import utilities.ConnectionManager;

public class SongDAOImpl extends SongDAO {

	private static final long serialVersionUID = 1L;

	/**
	 * Search all songs
	 * @return List<Song>: all songs
	 */
	public static List<Song> SelectAll(){
		return Search(SentenciasSong.SELECTALL,"",null,null,-1);
	}

	/**
	 * Search songs from a playlist
	 * @param id(int): playlist id
	 * @return List<Song>: songs selected from a playlist
	 */
	public static List<Song> SelectForPlaylist(int id){
		return Search(SentenciasSong.SELECTBYID,"",null,null,id);
	}

	/**
	 * Search songs from a disc
	 * @param d(Disc)
	 * @return List<Song>: songs selected from a disc
	 */
	public static List<Song> SelectForDisc(Disc d){
		return Search(SentenciasSong.SELECTFORDISC,"",d,null,-1);
	}

	/**
	 * Search songs by name
	 * @param name(String): song name
	 * @return List<Song>: songs selected by name
	 */
	public static List<Song> SelectForName(String name){
		return Search(SentenciasSong.SELECTBYNAME,name,null,null,-1);
	}

	/**
	 * Search songs depending the statement and parameters
	 * @param sql(SentenciasSong): statement by want to search
	 * @param name(String): song name
	 * @param disc(Disc): song disc
	 * @param genre(Genre): song genre
	 * @param n(int): playlist id
	 * @return List<Song>: songs selected based on the statement
	 */
	private static List<Song> Search(SentenciasSong sql, String name, Disc disc, Genre genre, int n){
		Query query=null;
		List<Song> lists=new ArrayList<Song>();
		ConnectionManager.getManager().getTransaction().begin();
		try{
			if(sql==SentenciasSong.SELECTALL){
				query = ConnectionManager.getManager().createNamedQuery("Song_findAll", Song.class);
			}else if(sql==SentenciasSong.SELECTFORPLAYLIST){
				query = ConnectionManager.getManager().createNamedQuery("Song_findForPlaylist", Song.class);
			}else if(sql==SentenciasSong.SELECTBYNAME){
				query = ConnectionManager.getManager().createNamedQuery("Song_findByName", Song.class);
			}else if(sql==SentenciasSong.SELECTFORDISC){
				query = ConnectionManager.getManager().createNamedQuery("Song_findForDisc", Song.class);
			}
			lists.addAll((List<Song>)query.getResultList());
		}catch (Exception e) {
			// TODO: handle exception
		}

		ConnectionManager.getManager().getTransaction().commit();
		ConnectionManager.CloseEntityManager();
		return lists;
	}

	public static boolean ExistSong(int id_disc, String n){
		boolean result=false;
		Song s = null;
		ConnectionManager.getManager().getTransaction().begin();
		try{
			Query query = ConnectionManager.getManager().createNamedQuery("Song_exist", Song.class);
			query.setParameter("ID_DISC", id_disc);
			query.setParameter("name", n);
			s=(Song)query.getSingleResult();
		}catch (Exception e){

		}

		ConnectionManager.getManager().getTransaction().commit();
		ConnectionManager.CloseEntityManager();
		if(s!=null){
			result=true;
		}
		return result;
	}

}
