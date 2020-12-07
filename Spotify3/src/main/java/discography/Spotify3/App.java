package discography.Spotify3;

import model.User;
import utilities.ConnectionManager;

/**
 * Hello world!
 *
 */
public class App{
  private static User user=null;
  public static void main( String[] args){
	  	ConnectionManager.getConection();

        Ejecutable.main(args);

        ConnectionManager.CloseAllConection();
   }

   public static void setUser(User s){
       	user=s;
   }

   public static User getUser(){
      	return user;
   }

}
