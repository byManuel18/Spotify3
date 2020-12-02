package utilities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Options;

public class ConnectionManager {
	private static Options o=XMLManager.GetChannel();
	private static EntityManagerFactory emf=null;
	private static EntityManager manager=null;

	public static EntityManager getManager(){
		if(manager!=null){
			getConection();
			manager=emf.createEntityManager();
		}
		return manager;
	}

	private static  void getConection(){
		if(emf==null){
			emf=Persistence.createEntityManagerFactory(o.getTypeBDD().toString());
		}

	}

	public static Options getOpcion() {
		return o;
	}

	public static void setOpcio(Options o) {
		ConnectionManager.o = o;
	}

	private static void CloseEntityManagerFactory(){
		if(emf!=null){
			emf.close();
		}

	}
	public static void CloseEntityManager(){
		if(manager!=null){
			manager.close();
		}
	}

	public static void CloseAllConection(){
		CloseEntityManagerFactory();
		CloseEntityManager();
	}

	public static void ChangeConection(){
		CloseEntityManagerFactory();
		CloseEntityManager();
		getConection();
	}


}
