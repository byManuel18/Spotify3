package DAO;

import java.time.LocalDate;
import java.util.Set;

import enums.SentenciasDisc;
import model.Artist;
import model.Disc;

public class DiscDAO extends Disc{

	/**
	 * Default Constructor
	 */
	public DiscDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Full constructor
	 * @param id(int): disc id
	 * @param name(String): disc name
	 * @param artist(Artist): disc artist
	 * @param photo(String): disc photo
	 * @param date(LocalDate): disc date release
	 */
	public DiscDAO(int id, String name, Artist artist, String photo, LocalDate date) {
		super(id, name, artist, photo, date);
		// TODO Auto-generated constructor stub
	}

	/**
	 * constructor without id
	 * @param name(String): disc name
	 * @param artist(Artist): disc artist
	 * @param photo(String): disc photo
	 * @param date(LocalDate): disc date release
	 */
	public DiscDAO(String name, Artist artist, String photo, LocalDate date) {
		super(name, artist, photo, date);
		// TODO Auto-generated constructor stub
	}

	/**
	 * constructor that receives a disc
	 * @param disc(Disc)
	 */
	public DiscDAO(Disc disc){

	}

	/**
	 * Select a disc from the database based on the parameter id
	 * @param id(int): disc id
	 */
	public DiscDAO(int id){

	}

	/**
	 * According the disc id, update or insert: if id is -1, insert disc
	 * if id is greater than 0, update disc
	 * @return int: 1 if has been updated or inserted, 0 if didn't work, -1 if error
	 */
	public int update(){
		return 0;
	}

	/**
	 * According the disc id, delete that disc from the data base
	 * @return int: 1 if the disc has been deleted, 0 if didn't work, -1 if error
	 */
	public int delete(){
		return 0;
	}


}
