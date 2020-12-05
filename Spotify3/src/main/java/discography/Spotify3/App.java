package discography.Spotify3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mysql.cj.jdbc.SuspendableXAConnection;

import DAO.GenreDAO;
import DAOImpl.GenreDAOImpl;
import enums.TypeBDD;
import model.Artist;
import model.Disc;
import model.Genre;
import model.Options;
import model.Song;
import utilities.ConnectionManager;
import utilities.XMLManager;

/**
 * Hello world!
 *
 */
public class App{



    public static void main( String[] args ){
    	/*Artist a=new Artist("Yo mismo", "si", "no");
        Disc d=new Disc("Primero", a, "Puede ser que no tenga", LocalDate.now());
    	List<Song> ls=new ArrayList<Song>();
        List<Disc> ld=new ArrayList<Disc>();
    	Genre g=new Genre("Rock");
    	ls.add(new Song("la primera", 200,g, d));
    	d.setSonglist(ls);
    	ld.add(d);
    	a.setDisclist(ld);*/
    	/*if(GenreDAOImpl.Exist("pedro")){
    		System.out.println("Existe");
    	}*/
    	/*ConnectionManager.getManager().getTransaction().begin();
    	ConnectionManager.getManager().persist(a);
    	ConnectionManager.getManager().getTransaction().commit();*/



    	List<Artist> autores= ConnectionManager.getManager().createQuery("FROM Artist").getResultList();
    	for(Artist a: autores){
    		System.out.println(a);
    		for(Disc d:a.getDisclist()){
    			System.out.println(d);
    			for(Song s:d.getSonglist()){
    				System.out.println(s);
    			}
    		}

    	}
    	ConnectionManager.CloseAllConection();


    }
}
