package utilities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import enums.TypeBDD;
import model.Options;

public class ConnectionManager {
	private static Options o=XMLManager.GetChannel();
	private static EntityManagerFactory emf=null;
	private static EntityManager manager=null;

	public static EntityManager getManager(){
		if(manager==null){
			getConection();
			try{
				manager=emf.createEntityManager();
			}catch (Exception e) {
				// TODO: handle exception
			}

		}
		return manager;
	}

	public static  void getConection(){
		if(emf==null){
			try{
				emf=Persistence.createEntityManagerFactory(o.getTypeBDD().toString());
			}catch (Exception e) {
				if(o.getTypeBDD()==TypeBDD.H2){
					emf=Persistence.createEntityManagerFactory(TypeBDD.MySQL.toString());
				}else if(o.getTypeBDD()==TypeBDD.MySQL){
					emf=Persistence.createEntityManagerFactory(TypeBDD.H2.toString());
				}
			}

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
			emf=null;

		}

	}
	public static void CloseEntityManager(){
		if(manager!=null){
			manager.close();
			manager=null;
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
