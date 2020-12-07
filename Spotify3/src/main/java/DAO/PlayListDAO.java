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

}
