package DAOImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import DAO.PlayListDAO;
import enums.SentenciasPlayList;
import model.Genre;
import model.Playlist;
import utilities.ConnectionManager;

public class PlayListDAOImpl extends PlayListDAO{

	/**
	 * Search playlists by creator
	 * @param id(int): creator id
	 * @return List<Playlist>: playlist selected by author
	 */
	public static List<Playlist> SearchID_Creator(int id){
		return Search(SentenciasPlayList.SELECTFORCREATOR,"",id);
	}

	/**
	 * Search all playlist
	 * @return List<Playlist>: all playlists
	 */
	public static List<Playlist> SelectAll(){
		return Search(SentenciasPlayList.SELECTALL,"",-1);
	}

	/**
	 * Search playlists by a subscriber
	 * @param id(int): subscriber id
	 * @return List<Playlist>: playlists selected by a subscriber
	 */
	public static List<Playlist> SearchbyUserSubscriber(int id){
		return Search(SentenciasPlayList.SELECTFORUSERSUBSCRIBER,"",id);
	}

	/**
	 * Search playlists where the user isn't the creator
	 * @param id(int): user id
	 * @return List<playlist>: playlists selected where user isn't the creator
	 */
	public static List<Playlist> SearchAllExceptUSer(int id){
		return Search(SentenciasPlayList.SLECTALLEXCEPTUSER,"",id);
	}

	/**
	 * Search playlists by name where the user isn't the creator
	 * @param id(int): user id
	 * @param name(name): playlist name
	 * @return List<Playlist>: playlists selected by name where user isn't the creator
	 */
	public static List<Playlist> SearchAllExceptUSerAndNameList(int id,String name){
		return  Search(SentenciasPlayList.SLECTALLEXCEPTUSERANDNAME,name,id);
	}

	/**
	 * Search playlists by creator name where the user isn't the creator
	 * @param id(int): user id
	 * @param name(string): creator name
	 * @return List<Playlist>: playlists selected by creator where user isn't the creator
	 */
	public static List<Playlist> SearchAllExceptUSerAndNameCreator(int id,String name){
		return  Search(SentenciasPlayList.SLECTALLEXCEPTUSERANDNAMEFROMCREATOR,name,id);
	}


	/**
	 * Search playlists depending the statement and parameters
	 * @param sql(SentenciasPlayList): statement by want to search
	 * @param argument(String): parameter by want to search
	 * @param id(int): user id
	 * @return List<Playlist>: playlists selected based on the statement
	 */
	private static List<Playlist> Search(SentenciasPlayList sql,String argument, int id){
		Query query =null;
		List<Playlist> listpl= new ArrayList<Playlist>();
		ConnectionManager.getManager().getTransaction().begin();
		try{
			if(sql==SentenciasPlayList.SELECTALL){
				query = ConnectionManager.getManager().createNamedQuery("Playlist_findAll", Playlist.class);
			}else if(sql==SentenciasPlayList.SELECTBYID){
				query = ConnectionManager.getManager().createNamedQuery("Playlist_findById", Playlist.class);
			}else if(sql==SentenciasPlayList.SELECTFORCREATOR){
				query = ConnectionManager.getManager().createNamedQuery("Playlist_findForCreator", Playlist.class);
			}else if(sql==SentenciasPlayList.SELECTFORUSERSUBSCRIBER){
				query = ConnectionManager.getManager().createNamedQuery("Playlist_findForUser", Playlist.class);
			}else if(sql==SentenciasPlayList.SLECTALLEXCEPTUSER){
				query = ConnectionManager.getManager().createNamedQuery("Playlist_findEXceptUser", Playlist.class);
				query.setParameter("id", id);
			}else if(sql==SentenciasPlayList.SLECTALLEXCEPTUSERANDNAME){
				query = ConnectionManager.getManager().createNamedQuery("Playlist_SLECTALLEXCEPTUSERANDNAME", Playlist.class);
			query.setParameter("id", id);
			query.setParameter("name", argument+"%");
			}else if(sql==SentenciasPlayList.SLECTALLEXCEPTUSERANDNAMEFROMCREATOR){
				query = ConnectionManager.getManager().createNamedQuery("Playlist_SLECTALLEXCEPTUSERANDNAMEFROMCREATOR", Playlist.class);
				query.setParameter("id", id);
				query.setParameter("name", argument+"%");
			}
			listpl.addAll((List<Playlist>)query.getResultList());
		}catch (Exception e) {
			// TODO: handle exception
		}

		ConnectionManager.getManager().getTransaction().commit();
		ConnectionManager.CloseEntityManager();
		return listpl;
	}

	/**
	 * Add a song to a playlist
	 * @param id_song(int): song id
	 * @param id_list(int): playlist id
	 * @return int: 1 if has been added, 0 if didn't work, -1 if error
	 */
	public static int addSongToPlayList(int id_song,int id_list){
		return 0;
	}

	/**
	 * Delete a song from a playlist
	 * @param id_song(int): song id
	 * @param id_list(int): playlist id
	 * @return int: 1 if the song has been deleted from the playlist, 0 if didn't work, -1 if error
	 */
	public static int DeleteSongToPlayList(int id_song,int id_list){
		return 0;
	}

	/**
	 * unsubscribe a user from a playlist
	 * @param id_user(int): user id
	 * @param id_lista(int): playlist id
	 * @return int: 1 if the user has been unsubscribed from the playlist, 0 if didn't work, -1 if error
	 */
	public static int Desuscribe(int id_user,int id_lista){
		return 0;
	}

	/**
	 * Subscribe a user into a playlist
	 * @param id_user(int): user id
	 * @param id_lista(int): playlist id
	 * @return int: 1 if the user has been subscribed into the playlist, 0 if didn't work, -1 if error
	 */
	public static int Subscribe(int id_user,int id_lista){
		return 0;
	}

	public static boolean ExistSameName(int id, String n){
		boolean result=false;
		Playlist pl=null;
		ConnectionManager.getManager().getTransaction().begin();
		try{
			Query query = ConnectionManager.getManager().createNamedQuery("Playlist_findForName",Playlist.class);
			query.setParameter("creator",id);
			query.setParameter("name",n);
			pl=(Playlist)query.getSingleResult();
		}catch (Exception e) {
			// TODO: handle exception
		}
		ConnectionManager.getManager().getTransaction().commit();
		ConnectionManager.CloseEntityManager();
		if(pl!=null){
			result=true;
		}
		return result;
	}

}
