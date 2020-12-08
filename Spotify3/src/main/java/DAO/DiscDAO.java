package DAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Artist;
import model.Disc;
import model.Song;
import utilities.ConnectionManager;

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
		this.setId(disc.getId());
		this.setName(disc.getName());
		this.setArtist(disc.getArtist());
		this.setPhoto(disc.getPhoto());
		this.setDate(disc.getDate());
		this.setSonglist(disc.getSonglist());
	}

	/**
	 * Select a disc from the database based on the parameter id
	 * @param id(int): disc id
	 */
	public DiscDAO(int id){
		Disc d= null;
		ConnectionManager.getManager().getTransaction().begin();
		try{
			d=ConnectionManager.getManager().find(Disc.class,id);
			if(d!=null){
				ConnectionManager.getManager().merge(d);



			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}

		ConnectionManager.getManager().getTransaction().commit();
		ConnectionManager.CloseEntityManager();
		this.setId(id);
		this.setName(d.getName());
		this.setDate(d.getDate());
		this.setPhoto(d.getPhoto());
		this.setSonglist(d.getSonglist());
		this.setArtist(d.getArtist());

	}

	/**
	 * According the disc id, update or insert: if id is -1, insert disc
	 * if id is greater than 0, update disc
	 * @return int: 1 if has been updated or inserted, 0 if didn't work, -1 if error
	 */
	public int update(){
		int result=-1;
		Disc d = new Disc(this.getId(), this.getName(), this.getArtist(), this.getPhoto(), this.getDate());
		d.setSonglist(this.getSonglist());
		ConnectionManager.getManager().getTransaction().begin();
		if(d.getId()>0){
			try{
				ConnectionManager.getManager().merge(d);
				result=1;
			}catch (Exception e){

			}
		}else{
			try{
				ConnectionManager.getManager().persist(d);
				ConnectionManager.getManager().flush();
				this.setId(d.getId());
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
	 * According the disc id, delete that disc from the data base
	 * @return int: 1 if the disc has been deleted, 0 if didn't work, -1 if error
	 */
	public int delete(){
		int result=-1;
		Disc d = new Disc(this.getId(),this.getName(), this.getArtist(), this.getPhoto(), this.getDate());
		d.setSonglist(this.getSonglist());

		if(d.getId()>0){

			ConnectionManager.getManager().getTransaction().begin();
			try{
				ConnectionManager.getManager().remove(ConnectionManager.getManager().contains(d) ? d : ConnectionManager.getManager().merge(d));
				result=1;

			}catch (Exception e) {

			}
			ConnectionManager.getManager().getTransaction().commit();
			ConnectionManager.CloseEntityManager();
		}

		return result;
	}

}
