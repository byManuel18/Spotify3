package discography.Spotify3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import enums.TypeBDD;
import model.Genre;
import model.Options;
import utilities.ConnectionManager;
import utilities.XMLManager;

/**
 * Hello world!
 *
 */
public class App{



    public static void main( String[] args ){
    	Genre g1=new Genre("Si");
    	ConnectionManager.getOpcion().setTypeBDD(TypeBDD.MySQL);

    	ConnectionManager.getManager().getTransaction().begin();
    	System.out.println(ConnectionManager.getManager().find(Genre.class,1));
    	ConnectionManager.getManager().getTransaction().commit();
    	ConnectionManager.CloseAllConection();

    }
}
