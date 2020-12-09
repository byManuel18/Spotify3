package DAOImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import DAO.UsersDAO;
import enums.SentenciasUsers;
import model.Artist;
import model.User;
import utilities.ConnectionManager;

public class UsersDAOImpl extends UsersDAO{

	/**
	 * Show subscribers from a playlist
	 * @param idlista(int): playlist id
	 * @return List<User>: subscribers from the playlist
	 */
	public static List<User> SelectSubscribers(int idlista){
		return null;
	}
	/**
	 * Show All subscribers
	 * @return List<User>: subscribers from the playlist
	 */
	public static List<User> SelectAllSubscribers(){
		return Search(SentenciasUsers.SELECTALL, -1, "");
	}

	/**
	 * Search users depending the statement and parameters
	 * @param sql(SentenciasUsers): statement by want to search
	 * @param n(int): playlist id
	 * @param argument(String): parameters
	 * @return List<User>: users selected based on the statement
	 */
	private static List<User> Search(SentenciasUsers sql,int n,String argument){
		List<User> userlist=new ArrayList<User>();
		Query query=null;
		ConnectionManager.getManager().getTransaction().begin();
		try{
			if(SentenciasUsers.SELECTALL==sql){
				query = ConnectionManager.getManager().createNamedQuery("User_findAll",User.class);
			}
			userlist.addAll((List<User>)query.getResultList());
		}catch (Exception e) {
			// TODO: handle exception
		}

		ConnectionManager.getManager().getTransaction().commit();
		ConnectionManager.CloseEntityManager();
		return userlist;
	}

}
