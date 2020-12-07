package DAOImpl;

import java.util.List;
import DAO.SongDAO;
import enums.SentenciasSong;
import model.Disc;
import model.Genre;
import model.Song;

public class SongDAOImpl extends SongDAO {

	/**
	 * Search all songs
	 * @return List<Song>: all songs
	 */
	public static List<Song> SelectAll(){
		return null;
	}

	/**
	 * Search songs from a playlist
	 * @param id(int): playlist id
	 * @return List<Song>: songs selected from a playlist
	 */
	public static List<Song> SelectForPlaylist(int id){
		return null;
	}

	/**
	 * Search songs from a disc
	 * @param d(Disc)
	 * @return List<Song>: songs selected from a disc
	 */
	public static List<Song> SelectForDisc(Disc d){
		return null;
	}

	/**
	 * Search songs by name
	 * @param name(String): song name
	 * @return List<Song>: songs selected by name
	 */
	public static List<Song> SelectForName(String name){
		return null;
	}

	/**
	 * Search songs depending the statement and parameters
	 * @param sql(SentenciasSong): statement by want to search
	 * @param name(String): song name
	 * @param disc(Disc): song disc
	 * @param genre(Genre): song genre
	 * @param n(int): playlist id
	 * @return List<Song>: songs selected based on the statement
	 */
	private static List<Song> Search(SentenciasSong sql, String name, Disc disc, Genre genre, int n){
		return null;
	}

	public static boolean ExistSong(int id_disc, String n){
		return true;
	}

}
