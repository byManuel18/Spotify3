package discography.Spotify3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mysql.cj.jdbc.SuspendableXAConnection;

import DAO.GenreDAO;
import DAOImpl.GenreDAOImpl;
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

    	if(GenreDAOImpl.Exist("pedro")){
    		System.out.println("Existe");
    	}
    	ConnectionManager.CloseAllConection();


    }
}
