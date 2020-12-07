package DAOImpl;

import java.util.List;
import DAO.UsersDAO;
import enums.SentenciasUsers;
import model.User;

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
	 * Search users depending the statement and parameters
	 * @param sql(SentenciasUsers): statement by want to search
	 * @param n(int): playlist id
	 * @param argument(String): parameters
	 * @return List<User>: users selected based on the statement
	 */
	private static List<User> Search(SentenciasUsers sql,int n,String argument){
		return null;
	}

}
