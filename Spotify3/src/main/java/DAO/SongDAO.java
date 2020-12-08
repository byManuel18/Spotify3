package DAO;

import java.util.Set;

import enums.SentenciasSong;
import model.Disc;
import model.Genre;
import model.Song;
import utilities.ConnectionManager;

public class SongDAO extends Song{

	/**
	 * Default constructor
	 */
	public SongDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * full constructor
	 * @param id(int): song id
	 * @param name(String): song name
	 * @param duration(int): song duration
	 * @param genre(Genre): song genre
	 * @param disc(Disc): song disc
	 */
	public SongDAO(int id, String name, int duration, Genre genre, Disc disc) {
		super(id, name, duration, genre, disc);
		// TODO Auto-generated constructor stub
	}

	/**
	 * constructor without id
	 * @param name(String): song name
	 * @param duration(int): song duration
	 * @param genre(Genre): song genre
	 * @param disc(Disc): song disc
	 */
	public SongDAO(String name, int duration, Genre genre, Disc disc) {
		super(name, duration, genre, disc);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor that receives a song
	 * @param s(Song)
	 */
	public SongDAO(Song s){
		this.setId(s.getId());
		this.setName(s.getName());
		this.setDuration(s.getDuration());
		this.setGenre(s.getGenre());
		this.setDisc(s.getDisc());
	}

	/**
	 * Select a song from the database based on the parameter id
	 * @param id(int): song id
	 */
	public SongDAO(int id){
		Song s = null;
		ConnectionManager.getManager().getTransaction().begin();
		try{
			s=ConnectionManager.getManager().find(Song.class, id);
		}catch(Exception e){

		}

		ConnectionManager.getManager().getTransaction().commit();
		ConnectionManager.CloseAllConection();
		if(s!=null){
			this.setId(id);
			this.setName(s.getName());
			this.setDuration(s.getDuration());
			this.setGenre(s.getGenre());
			this.setDisc(s.getDisc());
		}
	}

	/**
	 * According the song id, update or insert: if id is -1, insert song
	 * if id is greater than 0, update song
	 * @return int: 1 if has been updated or inserted, 0 if didn't work, -1 if error
	 */
	public int update(){
		int result=-1;
		Song s= new Song(this.getId(), this.getName(), this.getDuration() ,this.getGenre(), this.getDisc());
		ConnectionManager.getManager().getTransaction().begin();
		if(s.getId()>0){
			try{
				ConnectionManager.getManager().merge(s);
				result=1;
			}catch (Exception e){

			}
		}else{
			try{
				ConnectionManager.getManager().persist(s);
				ConnectionManager.getManager().flush();
				this.setId(s.getId());
				result=1;
			}catch (Exception e){

			}
		}

		ConnectionManager.getManager().getTransaction().commit();
		ConnectionManager.CloseEntityManager();
		return result;
	}

	/**
	 * According the song id, delete that song form the database
	 * @return int: 1 if the song has been deleted, 0 if didn't work, -1 if error
	 */
	public int delete(){
		int result=-1;
		Song s= new Song(this.getId(), this.getName(), this.getDuration() ,this.getGenre(), this.getDisc());
		if(s.getId()>0){
			ConnectionManager.getManager().getTransaction().begin();
			try{
				ConnectionManager.getManager().remove(ConnectionManager.getManager().contains(s) ? s : ConnectionManager.getManager().merge(s));
				result=1;
			}catch (Exception e){
				System.out.println(e.getMessage());
			}

			ConnectionManager.getManager().getTransaction().commit();
			ConnectionManager.CloseEntityManager();
		}
		return result;
	}

}
