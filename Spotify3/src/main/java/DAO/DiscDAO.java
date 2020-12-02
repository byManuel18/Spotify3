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

	/**
	 * Search discs by name
	 * @param name(String): disc name
	 * @return Set<Disc>: discs selected by name
	 */
	public static Set<Disc> SearchByName(String name){
		return null;
	}

	/**
	 * Search discs depending the statement and parameters
	 * @param sent(SentenciasDisc): statement by want to search (Author or name)
	 * @param id(int): disc id
	 * @param artista(Artista): disc author
	 * @param argumentos(String): disc name
	 * @param date(LocalDate): disc date release
	 * @return Set<Disc>: discs selected based on the statement
	 */
	private static Set<Disc> Search(SentenciasDisc sent, int id, Artist artista, String argumentos, LocalDate date){
		return null;
	}

	public static boolean ExistDisc(String n, int id_artist){
		return true;
	}
}
