package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import enums.SentenciasPlayList;
import model.Playlist;
import model.User;
import utilities.ConnectionManager;

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
		this.setId(pl.getId());
		this.setName(pl.getName());
		this.setDescription(pl.getDescription());
		this.setCreator(pl.getCreator());
		this.setSongs(pl.getSongs());
		this.setSubscribers(pl.getSubscribers());
		}

	/**
	 * Select a playlist form the database based on the parameter id
	 * @param id(int): playlist id
	 */
	public PlayListDAO(int id){
		Playlist pl = null;
		ConnectionManager.getManager().getTransaction().begin();
		try{
			pl=ConnectionManager.getManager().find(Playlist.class, id);
		}catch (Exception e){

		}
		ConnectionManager.getManager().getTransaction().commit();
		ConnectionManager.CloseEntityManager();
		if(pl!=null){
			this.setCreator(pl.getCreator());
			this.setDescription(pl.getDescription());
			this.setId(pl.getId());
			this.setName(pl.getName());
			this.setSongs(pl.getSongs());
			this.setSubscribers(pl.getSubscribers());
		}
	}

	/**
	 * According the playlist id, update or insert: if id is -1, insert playlist
	 * if id is greater than 0, update playlist
	 * @return int: 1 if has been updated or inserted, 0 if didn't work, -1 if error
	 */
	public int update(){
		int result=-1;
		Playlist pl = new Playlist(this.getId(),this.getName(), this.getDescription(), this.getCreator());
		pl.setSongs(this.getSongs());
		pl.setSubscribers(this.getSubscribers());
		ConnectionManager.getManager().getTransaction().begin();
		if(pl.getId()>0){
			try{
				ConnectionManager.getManager().merge(pl);
				result=1;
			}catch (Exception e){

			}
		}else{
			try{
				ConnectionManager.getManager().persist(pl);
				ConnectionManager.getManager().flush();
				this.setId(pl.getId());
				result=1;
			}catch (Exception e) {
				// TODO: handle exception
			}
		}

		ConnectionManager.getManager().getTransaction().commit();
		ConnectionManager.CloseEntityManager();
		return result;
	}

	/**
	 * According the playlist id, delete that playlist from the database
	 * @return int: 1 if the playlist has been deleted, 0 if didn't work, -1 if error
	 */
	public int delete(){
		int result=-1;
		Playlist pl = new Playlist(this.getId(),this.getName(), this.getDescription(), this.getCreator());
		pl.setSongs(this.getSongs());
		pl.setSubscribers(this.getSubscribers());
		if(pl.getId()>0){
			ConnectionManager.getManager().getTransaction().begin();
			try{
				ConnectionManager.getManager().remove(ConnectionManager.getManager().contains(pl) ? pl : ConnectionManager.getManager().merge(pl));
				result=1;
			}catch (Exception e) {
				// TODO: handle exception
			}
			ConnectionManager.getManager().getTransaction().commit();
			ConnectionManager.CloseEntityManager();
		}

		return result;
	}

}
