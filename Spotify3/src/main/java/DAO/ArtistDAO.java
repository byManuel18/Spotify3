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



}
