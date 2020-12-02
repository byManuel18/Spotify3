package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import enums.SentenciasPlayList;
import model.Playlist;
import model.User;

public class PlayListDAO extends Playlist{


	/**
	 * Default constructor
	 */
	public PlayListDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Full constructor
	 * @param id(int): playlist id
	 * @param name(String): playlist name
	 * @param description(String): playlist description
	 * @param creator(User): playlist creator
	 */
	public PlayListDAO(int id, String name, String description, User creator) {
		super(id, name, description, creator);
		// TODO Auto-generated constructor stub
	}

	/**
	 * constructor without id
	 * @param name(String): playlist name
	 * @param description(String): playlist description
	 * @param creator(User): playlist creator
	 */
	public PlayListDAO(String name, String descripcion, User creator) {
		super(name, descripcion, creator);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor that receives a playlist
	 * @param pl(PlayList)
	 */
	public PlayListDAO(Playlist pl){
		}

	/**
	 * Select a playlist form the database based on the parameter id
	 * @param id(int): playlist id
	 */
	public PlayListDAO(int id){
	}

	/**
	 * According the playlist id, update or insert: if id is -1, insert playlist
	 * if id is greater than 0, update playlist
	 * @return int: 1 if has been updated or inserted, 0 if didn't work, -1 if error
	 */
	public int update(){
		return 0;
	}

	/**
	 * According the playlist id, delete that playlist from the database
	 * @return int: 1 if the playlist has been deleted, 0 if didn't work, -1 if error
	 */
	public int delete(){
		return 0;
	}

	/**
	 * Search playlists by creator
	 * @param id(int): creator id
	 * @return Set<Playlist>: playlist selected by author
	 */
	public static Set<Playlist> SearchID_Creator(int id){
		return null;
	}

	/**
	 * Search all playlist
	 * @return Set<Playlist>: all playlists
	 */
	public static Set<Playlist> SelectAll(){
		return null;
	}

	/**
	 * Search playlists by a subscriber
	 * @param id(int): subscriber id
	 * @return Set<Playlist>: playlists selected by a subscriber
	 */
	public static Set<Playlist> SearchbyUserSubscriber(int id){
		return null;
	}

	/**
	 * Search playlists where the user isn't the creator
	 * @param id(int): user id
	 * @return Set<playlist>: playlists selected where user isn't the creator
	 */
	public static Set<Playlist> SearchAllExceptUSer(int id){
		return null;
	}

	/**
	 * Search playlists by name where the user isn't the creator
	 * @param id(int): user id
	 * @param name(name): playlist name
	 * @return Set<Playlist>: playlists selected by name where user isn't the creator
	 */
	public static Set<Playlist> SearchAllExceptUSerAndNameList(int id,String name){
		return null;
	}

	/**
	 * Search playlists by creator name where the user isn't the creator
	 * @param id(int): user id
	 * @param name(string): creator name
	 * @return Set<Playlist>: playlists selected by creator where user isn't the creator
	 */
	public static Set<Playlist> SearchAllExceptUSerAndNameCreator(int id,String name){
		return null;
	}


	/**
	 * Search playlists depending the statement and parameters
	 * @param sql(SentenciasPlayList): statement by want to search
	 * @param argument(String): parameter by want to search
	 * @param id(int): user id
	 * @return Set<Playlist>: playlists selected based on the statement
	 */
	private static Set<Playlist> Search(SentenciasPlayList sql,String argument, int id){
		return null;
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
		return true;
	}
}
