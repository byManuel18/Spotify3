package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import enums.SentenciasGenre;
import model.Genre;

public class GenreDAO extends Genre{

	/**
	 * Default constructor
	 */
	public GenreDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * full constructor
	 * @param id(int): genre id
	 * @param name(String): genre name
	 */
	public GenreDAO(int id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}

	/**
	 * constructor without id
	 * @param name(String): genre name
	 */
	public GenreDAO(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	/**
	 * constructor that receives a genre
	 * @param g(Genre)
	 */
	public GenreDAO(Genre g){

	}

	/**
	 * Select a genre from the database based on the parameter id
	 * @param id(int): genre int
	 */
	public GenreDAO(int id){


	}

	/**
	 * According the genre id, update or insert: if id is -1, insert genre
	 * if id is greater than 0, update genre
	 * @return int: 1 if has been updated or inserted, 0 if didn't work, -1 if error
	 */
	public int update(){
		return 0;
	}

	/**
	 * According the genre id, delete that artist from the data base
	 * @return int: 1 if the genre has been deleted, 0 if didn't work, -1 if error
	 */
	public int delete(){
		return 0;
	}

	/**
	 * Search all genre
	 * @return Set<Genre>: all genres
	 */
	public static Set<Genre> SelectALL(){
		return null;
	}

	/**
	 * Search genres depending the statement and the parameter
	 * @param sql(SentenciasGenre): statement by want to search (name)
	 * @param id(int): genre id
	 * @param argument(String): genre name
	 * @return
	 */
	private static Set<Genre> Search(SentenciasGenre sql,int id,String argument){
		return null;
	}

	/**
	 * Check if a genre already exists on the database
	 * @param name(String): genre name
	 * @return true if exist
	 */
	public static boolean Exist(String  name){
		return true;
	}
}
