package DAO;

import java.util.Set;

import enums.SentenciasSong;
import model.Disc;
import model.Genre;
import model.Song;

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

	}

	/**
	 * According the song id, update or insert: if id is -1, insert song
	 * if id is greater than 0, update song
	 * @return int: 1 if has been updated or inserted, 0 if didn't work, -1 if error
	 */
	public int update(){
		return 0;
	}

	/**
	 * According the song id, delete that song form the database
	 * @return int: 1 if the song has been deleted, 0 if didn't work, -1 if error
	 */
	public int delete(){
		return 0;
	}

	/**
	 * Search all songs
	 * @return Set<Song>: all songs
	 */
	public static Set<Song> SelectAll(){
		return null;
	}

	/**
	 * Search songs from a playlist
	 * @param id(int): playlist id
	 * @return Set<Song>: songs selected from a playlist
	 */
	public static Set<Song> SelectForPlaylist(int id){
		return null;
	}

	/**
	 * Search songs from a disc
	 * @param d(Disc)
	 * @return Set<Song>: songs selected from a disc
	 */
	public static Set<Song> SelectForDisc(Disc d){
		return null;
	}

	/**
	 * Search songs by name
	 * @param name(String): song name
	 * @return Set<Song>: songs selected by name
	 */
	public static Set<Song> SelectForName(String name){
		return null;
	}

	/**
	 * Search songs depending the statement and parameters
	 * @param sql(SentenciasSong): statement by want to search
	 * @param name(String): song name
	 * @param disc(Disc): song disc
	 * @param genre(Genre): song genre
	 * @param n(int): playlist id
	 * @return Set<Song>: songs selected based on the statement
	 */
	private static Set<Song> Search(SentenciasSong sql, String name, Disc disc, Genre genre, int n){
		return null;
	}

	public static boolean ExistSong(int id_disc, String n){
		return true;
	}
}
