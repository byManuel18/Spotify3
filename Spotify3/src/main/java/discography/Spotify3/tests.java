package discography.Spotify3;

import DAO.ArtistDAO;
import DAO.DiscDAO;
import DAO.GenreDAO;
import DAO.UsersDAO;
import DAOImpl.ArtistDAOImpl;
import DAOImpl.GenreDAOImpl;
import DAOImpl.UsersDAOImpl;
import enums.TypeBDD;
import model.Artist;
import model.Genre;
import model.Playlist;
import model.User;
import utilities.ConnectionManager;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class tests {

	public static void main(String[] args) {
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



    	/*List<Artist> autores= ConnectionManager.getManager().createQuery("FROM Artist").getResultList();
    	for(Artist a: autores){
    		System.out.println(a);
    		for(Disc d:a.getDisclist()){
    			System.out.println(d);
    			for(Song s:d.getSonglist()){
    				System.out.println(s);
    			}
    		}

    	}*/
    	//GenreDAO g=new GenreDAO("Oleee");
    	//System.out.println(g.update());
    	/*for(Genre g:GenreDAOImpl.SelectALL()){
    		System.out.println(g);
    	}

    	GenreDAO g=new GenreDAO("Prubas");
    	System.out.println(g.update());
    	System.out.println(g);*/


		//ConnectionManager.getManager().getTransaction().begin();
		//User s=ConnectionManager.getManager().find(User.class, 2);
		//User ss=ConnectionManager.getManager().find(User.class, 1);
		//s.getPlaylistCreates().add(new Playlist("Prueba segunda", "lista de alvaro", s));
		/*List<User> ul=ConnectionManager.getManager().createQuery("FROM User").getResultList();
		for(User u:ul){
			System.out.println(u);
		}

		for(Playlist p:s.getPlaylistCreates()){
			System.out.println(p+ "    "+p.getCreator());
		}*/
		/*List<Playlist> sub=new ArrayList<Playlist>();
		sub.add(s.getPlaylistCreates().get(0));
		ss.setSubscriptions(sub);*/

		/*for(Playlist pl:ss.getSubscriptions()){
			System.out.println(pl+ "     "+pl.getCreator());
			for(User u: pl.getSubscribers()){
				System.out.println(u);
			}
		}
		ConnectionManager.getManager().getTransaction().commit();*/
		//ConnectionManager.getOpcion().setTypeBDD(TypeBDD.MySQL);
		/*for(Artist a :ArtistDAOImpl.SelectbyName("He sido")){
			System.out.println(a);
		}*/
	//	ConnectionManager.getManager().getTransaction().begin();

		//ArtistDAO n=new ArtistDAO(2);
		//System.out.println(n);
	//	ConnectionManager.getManager().getTransaction().commit();
		/*List<User> listau=UsersDAOImpl.SelectAllSubscribers();
		for(User u:listau){
			UsersDAO n=new UsersDAO(u.getId());
			for(Playlist p:n.getPlaylistCreates()){
				System.out.println(p);
			}
		}*/
		User u=new UsersDAO(12);
		System.out.println(u);
		for(Playlist pl:u.getPlaylistCreates()){
			System.out.println(pl);
		}
		for(Playlist pl:u.getSubscriptions()){
			System.out.println(pl);
		}
    	ConnectionManager.CloseAllConection(); //NO BORRAR ESTA LÏNEA NUNCA; DEJADLA AL FINAL DE TODO

	}

}
