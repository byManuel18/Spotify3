package DAO;

import java.util.Set;

import enums.SentenciasArtista;
import model.Artist;

public class ArtistDAO extends Artist {

	/**
	 * Default constructor
	 */
	public ArtistDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * full constructor
	 * @param id(int): artist id
	 * @param name(String): artist name
	 * @param nationality(String): artist nationality
	 * @param photo(String): artist photo
	 */
	public ArtistDAO(int id, String name, String nationality, String photo) {
		super(id, name, nationality, photo);
		// TODO Auto-generated constructor stub
	}

	/**
	 * constructor without id
	 * @param name(String): artist name
	 * @param nationality(String): artist nationality
	 * @param photo(String): artist photo
	 */
	public ArtistDAO(String name, String nationality, String photo) {
		super(name, nationality, photo);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor that receives an artist
	 * @param a(Artist)
	 */
	public ArtistDAO(Artist a){

	}

	/**
	 * Select an artist from the database based on the parameter ID
	 * @param id(int): Artist id
	 */
	public ArtistDAO(int id){

	}

	/**
	 * According the artist id, update or insert: if id is -1, insert artist
	 * if id is greater than 0, update artist
	 * @return int: 1 if has been updated or inserted, 0 if didn't work, -1 if error
	 */
	public int update(){
		return 0;
	}

	/**
	 * According the artist id, delete that artist from the data base
	 * @return int: 1 if the artist has been deleted, 0 if didn't work, -1 if error
	 */
	public int delete(){
		return 0;
	}

	/**
	 * Search artists by name
	 * @param name(String): Artist name
	 * @return Set<Artist>: artist selected by name
	 */
	public  static Set<Artist> SelectbyName(String name){
		return null;
	}

	/**
	 * Search artists by nationality
	 * @param name(String): Artist nationality
	 * @return Set<Artist>: artist selected by nationality
	 */
	public  static Set<Artist> SelectbyNacionalidad(String name){
		return null;
	}

	/**
	 * Search all artists
	 * @return Set<Artist>: all artists
	 */
	public  static Set<Artist> SelectAll(){
		return null;
	}

	/**
	 * Search artists depending the statement and the parameter
	 * @param sql(SentenciasArtista): statement by want to search (name or nationality)
	 * @param parametro(String): parameter by want to search
	 * @return Set<Artist>: artists selected based on the statement
	 */
	private static Set<Artist> Search(SentenciasArtista sql,String parametro){
		return null;
	}

	public static boolean existArtist(String s){
		return true;
	}

}
