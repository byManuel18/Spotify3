package controllers;


import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import DAO.ArtistDAO;
import DAO.DiscDAO;
import DAO.PlayListDAO;
import DAO.SongDAO;
import DAO.UsersDAO;
import DAOImpl.ArtistDAOImpl;
import DAOImpl.DiscDAOImpl;
import DAOImpl.PlayListDAOImpl;
import DAOImpl.SongDAOImpl;
import discography.Spotify3.App;
import discography.Spotify3.Ejecutable;
import enums.Escenas;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Artist;
import model.Disc;
import model.Playlist;
import model.Song;
import model.User;
import utilities.GeneralUtilities;

public class UserViewController extends GeneralController{
	@FXML
	private RadioButton radio_by_name;
	@FXML
	private RadioButton radio_by_creator;
	@FXML
	private TextField search_name_playtosuscribe;
	@FXML
	private TextField searh_name_artist;
	@FXML
	private TextField searh_name_song;
	@FXML
	private TextField searh_name_disc;
	@FXML
	private TextArea descripcion_new_playlist;
	@FXML
	private TextField name_new_playlist;
	@FXML
	private ImageView img_user;
	@FXML
	private TextField name_user;
	@FXML
	private TextField url_user;
	@FXML
	private TextField email_user;
	@FXML
	private TableView<Playlist> listasuser_principal_table;
	@FXML
	private TableColumn<Playlist,String> nombrelistauser_principal;
	@FXML
	private TableColumn<Playlist, String> descripcionlistauser_principal;
	@FXML
	private TableColumn<Playlist, Integer> duracionlistauser_principal;
	private ObservableList<Playlist> playlist_user_principal;
	@FXML
	private TableView<Song> songuser_principal_table;
	@FXML
	private TableColumn<Song, String> nombresong_principal;
	@FXML
	private TableColumn<Song, String> genresong_principal;
	@FXML
	private TableColumn<Song, String> artistsong_principal;
	@FXML
	private TableColumn<Song, Integer> durationsong_principal;
	@FXML
	private TableColumn<Song, String> disksong_principal;
	private ObservableList<Song> songlist_user_principal;
	@FXML
	private TableView<Playlist> playlistsuscrpciones_table;
	@FXML
	private TableColumn<Playlist,String> nombrelistausersub_principal;
	@FXML
	private TableColumn<Playlist, String> descripcionlistausersub_principal;
	@FXML
	private TableColumn<Playlist, Integer> duracionlistausersub_principal;
	@FXML
	private TableColumn<Playlist, String> artistalistausersub_principal;
	private ObservableList<Playlist> playlistsubs_principal;
	@FXML
	private TableView<Song> songsubscriber_table;
	@FXML
	private TableColumn<Song, String> nombresong_principal_sub;
	@FXML
	private TableColumn<Song, String> genresong_principal_sub;
	@FXML
	private TableColumn<Song, String> artistsong_principal_sub;
	@FXML
	private TableColumn<Song, Integer> durationsong_principal_sub;
	@FXML
	private TableColumn<Song, String> disksong_principal_sub;
	private ObservableList<Song> listsongsubscr_principal;
	@FXML
	private TableView<Playlist> table_playlist_edit;
	@FXML
	private TableColumn<Playlist,String> c_name_playlist_edit;
	@FXML
	private TableColumn<Playlist, String> c_descript_playlist_edit;
	@FXML
	private TableColumn<Playlist, Integer> c_duration_playlist_edit;
	//------
	@FXML
	private TableView<Artist> tabla_artis;
	@FXML
	private TableColumn<Artist, String> c_name_artis;
	@FXML
	private TableColumn<Artist, ImageView> c_imag_artist;
	@FXML
	private TableColumn<Artist, String> c_nacionaliti_artist;
	private ObservableList<Artist> list_artists;
	//--------------------------------------------------------
	@FXML
	private TableView<Song> table_song_playlistedit;
	@FXML
	private TableColumn<Song, String> c_name_song_playlistedit;
	@FXML
	private TableColumn<Song, String> c_genre_song_playlistedit;
	@FXML
	private TableColumn<Song, String> c_artist_song_playlistedit;
	@FXML
	private TableColumn<Song, String> c_disc_song_playlistedit;
	@FXML
	private TableColumn<Song, Integer> c_duracion_song_playlistedit;
	private ObservableList<Song> lista_song_mipplaylist_edit;

	private Playlist playlist_selected;

	@FXML
	private TableView<Disc> table_disc_misplaylist_edit;
	@FXML
	private TableColumn<Disc, String> c_namedisc_misplaylist_edit;
	@FXML
	private TableColumn<Disc, LocalDate> c_datedisc_misplaylist_edit;
	@FXML
	private TableColumn<Disc, ImageView> c_imgdisc_misplaylist_edit;
	private ObservableList<Disc> list_disc_misplaylist_edit;
	//---------------------------------------------------------
	@FXML
	private TableView<Song> table_song_toadd;
	@FXML
	private TableColumn<Song, String> c_name_song_toadd;
	@FXML
	private TableColumn<Song, String> c_genre_song_toadd;
	@FXML
	private TableColumn<Song, String> c_nameartist_song_toadd;
	@FXML
	private TableColumn<Song, String> c_namedisc_song_toadd;
	@FXML
	private ObservableList<Song> lista_sog_toadd;
	@FXML
	private TableView<Playlist> table_allplylist;
	@FXML
	private TableColumn<Playlist, String> c_name_allplaylist;
	@FXML
	private TableColumn<Playlist, String> c_description_allplaylist;
	@FXML
	private TableColumn<Playlist, String> c_author_allplaylist;
	@FXML
	private TableColumn<Playlist, Integer> c_duracion_allplaylist;
	private ObservableList<Playlist> allplaylist;
	//-----------------------------
	@FXML
	private TableView<Playlist> table_mysubs_edir;
	@FXML
	private TableColumn<Playlist, String> c_mysubs_edir_name;
	@FXML
	private TableColumn<Playlist, String> c_mysubs_edir_descrip;
	@FXML
	private TableColumn<Playlist, String> c_mysubs_edir_author;
	@FXML
	private TableColumn<Playlist, Integer> c_mysubs_edir_duration;
	private ObservableList<Playlist> lista_allmysubs_edit;



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		name_user.setText(App.getUser().getName());
		url_user.setText(App.getUser().getPhoto());
		email_user.setText(App.getUser().getMail());
		try{
			img_user.setImage(new Image(App.getUser().getPhoto()));
		}catch (Exception e) {
			img_user.setImage(null);
		}

		playlist_user_principal=FXCollections.observableArrayList();
		songlist_user_principal=FXCollections.observableArrayList();
		playlistsubs_principal=FXCollections.observableArrayList();
		listsongsubscr_principal=FXCollections.observableArrayList();
		ShowListasUser();
		ShowListasSubsUser();

		this.nombrelistauser_principal.setCellValueFactory(eachRowData -> {
			return new SimpleObjectProperty<>(eachRowData.getValue().getName());
		});
		this.descripcionlistauser_principal.setCellValueFactory(eachRowData -> {
			return new SimpleObjectProperty<>(eachRowData.getValue().getDescription());
		});

		this.duracionlistauser_principal.setCellValueFactory(eachRowData -> {
			int result=0;
			for(Song s:eachRowData.getValue().getSongs()){
				result+=s.getDuration();
			}
			return new SimpleObjectProperty<>(result);
		});
		//-----------------------------------------------------------------
		this.nombresong_principal.setCellValueFactory(eachRowData -> {
			return new SimpleObjectProperty<>(eachRowData.getValue().getName());
		});
		this.genresong_principal.setCellValueFactory(eachRowData -> {
			return new SimpleObjectProperty<>(eachRowData.getValue().getGenre().getName());
		});
		this.artistsong_principal.setCellValueFactory(eachRowData -> {
			return new SimpleObjectProperty<>(eachRowData.getValue().getDisc().getArtist().getName());
		});
		this.disksong_principal.setCellValueFactory(eachRowData -> {
			return new SimpleObjectProperty<>(eachRowData.getValue().getDisc().getName());
		});
		this.durationsong_principal.setCellValueFactory(eachRowData -> {
			return new SimpleObjectProperty<>(eachRowData.getValue().getDuration());
		});
		//----------------------------------------------------------------------
		this.nombrelistausersub_principal.setCellValueFactory(eachRowData -> {
			return new SimpleObjectProperty<>(eachRowData.getValue().getName());
		});
		this.descripcionlistausersub_principal.setCellValueFactory(eachRowData -> {
			return new SimpleObjectProperty<>(eachRowData.getValue().getDescription());
		});
		this.duracionlistausersub_principal.setCellValueFactory(eachRowData -> {
			int result=0;
			for(Song s:eachRowData.getValue().getSongs()){
				result+=s.getDuration();
			}
			return new SimpleObjectProperty<>(result);
		});
		this.artistalistausersub_principal.setCellValueFactory(eachRowData -> {
			return new SimpleObjectProperty<>(eachRowData.getValue().getCreator().getName());
		});
		//--------------------------------------------------------------------------------------
		this.nombresong_principal_sub.setCellValueFactory(eachRowData -> {
			return new SimpleObjectProperty<>(eachRowData.getValue().getName());
		});
		this.genresong_principal_sub.setCellValueFactory(eachRowData -> {
			return new SimpleObjectProperty<>(eachRowData.getValue().getGenre().getName());
		});
		this.artistsong_principal_sub.setCellValueFactory(eachRowData -> {
			return new SimpleObjectProperty<>(eachRowData.getValue().getDisc().getArtist().getName());
		});
		this.disksong_principal_sub.setCellValueFactory(eachRowData -> {
			return new SimpleObjectProperty<>(eachRowData.getValue().getDisc().getName());
		});
		this.durationsong_principal_sub.setCellValueFactory(eachRowData -> {
			return new SimpleObjectProperty<>(eachRowData.getValue().getDuration());
		});
		//-------------------------------------------------------------------------------
		this.c_name_playlist_edit.setCellValueFactory(eachRowData -> {
			return new SimpleObjectProperty<>(eachRowData.getValue().getName());
		});
		this.c_descript_playlist_edit.setCellValueFactory(eachRowData -> {
			return new SimpleObjectProperty<>(eachRowData.getValue().getDescription());
		});
		this.c_duration_playlist_edit.setCellValueFactory(eachRowData -> {
			int result=0;
			for(Song s:eachRowData.getValue().getSongs()){
				result+=s.getDuration();
			}
			return new SimpleObjectProperty<>(result);
		});
		//--------------------------------------------------------------------------------

		listasuser_principal_table.setItems(playlist_user_principal);
		songuser_principal_table.setItems(songlist_user_principal);
		playlistsuscrpciones_table.setItems(playlistsubs_principal);
		songsubscriber_table.setItems(listsongsubscr_principal);
		table_playlist_edit.setItems(playlist_user_principal);



	}

	@FXML
	private void Return(){
		App.setUser(null);
		Ejecutable.CambiarEscena(600, 400, Escenas.INICIO);
		Ejecutable.CambiarTitulo("INICIO DE SESIÓN");
	}
	@FXML
	private void ShowListasUser(){
		playlist_user_principal.clear();
		playlist_user_principal.addAll(App.getUser().getPlaylistCreates());
	}
	@FXML
	private void ShowListasSubsUser(){
		playlistsubs_principal.clear();
		playlistsubs_principal.addAll(App.getUser().getSubscriptions());
	}
	@FXML
	private void VeiwSongPrincipalPlayList(){
		Playlist v=listasuser_principal_table.getSelectionModel().getSelectedItem();
		if(v!=null){
			songlist_user_principal.clear();
			songlist_user_principal.addAll(v.getSongs());
		}
	}
	@FXML
	private void ViewSongPrincipalSubscriber(){
		Playlist v=playlistsuscrpciones_table.getSelectionModel().getSelectedItem();
		if(v!=null){
			listsongsubscr_principal.clear();
			listsongsubscr_principal.addAll(v.getSongs());
		}
	}
	@FXML
	private void EditUser(){
		if(name_user.getText().length()>0&&email_user.getText().length()>0&&url_user.getText().length()>0){
			boolean good=true;
			if(!GeneralUtilities.ValidateMAIL(email_user.getText())){
				email_user.clear();
				good=false;
			}
			if(!GeneralUtilities.ValidateURL(url_user.getText())){
				url_user.clear();
				img_user.setImage(null);
				good=false;
			}
			if(good){
				if(confirm("Información", "¿Editar?", "  ")){
					App.getUser().setName(name_user.getText());
					App.getUser().setMail(email_user.getText());
					App.getUser().setPhoto(url_user.getText());
					UsersDAO up=new UsersDAO(App.getUser());
					if(up.update()>0){
						muestrinformacion("Información", "Usuario editado correctamente", "  ");
					}else{
						muestraerror("Error", "Error con la base de datos", "  ");
					}
				}
			}else{
				muestraerror("Error", "Campos erroneos", "  ");
			}

		}else{
			muestraerror("Error", "Campos vacíos", "  ");
		}
	}
	@FXML
	private void SetImage(){
		if(url_user.getText().length()>0&&GeneralUtilities.ValidateURL(url_user.getText())){
			img_user.setImage(new Image(url_user.getText()));
		}
	}
	@FXML
	private void Inabilitar(){
		if(confirm("Información","¿Desactivar cuenta?", "  ")){
			App.getUser().setActive(false);
			UsersDAO toup=new UsersDAO(App.getUser());
			if(toup.update()>0){
				muestrinformacion("Información", "Cuenta desactivada", "  ");
				Return();
			}else{
				muestraerror("Error", "Error con la base de datos", "  ");
			}
		}
	}
	@FXML
	private void ClearNewPlayList(){
		name_new_playlist.clear();
		descripcion_new_playlist.clear();
	}
	@FXML
	private void AddPlayList(){
		if(name_new_playlist.getText().length()>0&&descripcion_new_playlist.getText().length()>0){
			if(!PlayListDAOImpl.ExistSameName(App.getUser().getId(), name_new_playlist.getText().toUpperCase())){
				if(confirm("Informacion", "¿Crear Play List?", "  ")){
					PlayListDAO insert=new PlayListDAO(name_new_playlist.getText().toUpperCase(),
							descripcion_new_playlist.getText().toUpperCase(), App.getUser());
					if(insert.update()>0){
						//App.getUser().setSynchro(false);
						App.getUser().getPlaylistCreates().add(insert);
						//ShowListasUser();
						playlist_user_principal.add(insert);
						muestrinformacion("Informacion", "Play List creada", "  ");
						name_new_playlist.clear();
						descripcion_new_playlist.clear();
					}else{
						muestraerror("Error", "Error con la base de datos", "  ");
					}
				}
			}else{
				muestraerror("Error", "Ya creaste una Playlist con ese nombre", "  ");
			}
		}else{
			muestraerror("Error", "Campos vacíos", "  ");
		}
	}
	@FXML
	private void RemuvePlayList(){
		Playlist v=table_playlist_edit.getSelectionModel().getSelectedItem();
		if(v!=null){
			if(confirm("Informacion", "¿Borrar?", "  ")){
				PlayListDAO todel=new PlayListDAO(v);
				if(todel.delete()>0){
					//App.getUser().setSynchro(false);
					//ShowListasUser();
					playlist_user_principal.remove(v);
					muestrinformacion("Informacion", "Play List borrada", "  ");
				}else{
					muestraerror("Error", "Error con la base de datos", "  ");
				}
			}
		}
	}
	@FXML
	private void ShowSongMiList(){
		this.playlist_selected=table_playlist_edit.getSelectionModel().getSelectedItem();
		if(playlist_selected!=null){
			lista_song_mipplaylist_edit.clear();
			lista_song_mipplaylist_edit.addAll(playlist_selected.getSongs());
		}

	}
	@FXML
	private void ShowAllArtist(){
		searh_name_artist.clear();
		list_artists.clear();
		list_artists.addAll(ArtistDAOImpl.SelectAll());
	}
	@FXML
	private void ClearDiscEdit(){
		list_disc_misplaylist_edit.clear();
		searh_name_disc.clear();

	}
	@FXML
	private void SearchNameDisc(){
		if(searh_name_disc.getText().length()>0){
			list_disc_misplaylist_edit.clear();
			list_disc_misplaylist_edit.addAll(DiscDAOImpl.SearchByName(searh_name_disc.getText().toUpperCase()));
		}
	}
	@FXML
	private void ShowDiscArtist(){
		Artist n=tabla_artis.getSelectionModel().getSelectedItem();
		if(n!=null){
			list_disc_misplaylist_edit.clear();
			list_disc_misplaylist_edit.addAll(new ArtistDAO(n.getId()).getDisclist());
		}
	}
	@FXML
	private void SearchSongByName(){
		if(searh_name_song.getText().length()>0){
			lista_sog_toadd.clear();
			lista_sog_toadd.addAll(SongDAOImpl.SelectForName(searh_name_song.getText().toUpperCase()));
		}

	}
	@FXML
	private void ClearSongToAdd(){
		lista_sog_toadd.clear();
		searh_name_song.clear();
	}
	@FXML
	private void ShowSongDisc(){
		Disc p=table_disc_misplaylist_edit.getSelectionModel().getSelectedItem();
		if(p!=null){
			lista_sog_toadd.clear();
			lista_sog_toadd.addAll(new DiscDAO(p.getId()).getSonglist());
		}


	}
	@FXML
	private void ReLoad(){
		/*if(playlist_user_principal!=null&&playlistsubs_principal!=null){
			playlist_selected=null;
			if(lista_song_mipplaylist_edit!=null){
				lista_song_mipplaylist_edit.clear();
			}
			songlist_user_principal.clear();
			listsongsubscr_principal.clear();
			playlist_user_principal.clear();
			playlistsubs_principal.clear();
			playlist_user_principal.addAll(App.getUser().getPlaylistCreates());
			playlistsubs_principal.addAll(App.getUser().getSubscriptions());
		}*/


	}
	@FXML
	private void ClickMisPlayList(){
		if(list_artists==null){
			list_artists=FXCollections.observableArrayList();
			lista_song_mipplaylist_edit=FXCollections.observableArrayList();
			list_disc_misplaylist_edit=FXCollections.observableArrayList();
			lista_sog_toadd=FXCollections.observableArrayList();
			ShowAllArtist();

			this.c_name_artis.setCellValueFactory(eachRowData -> {
				return new SimpleObjectProperty<>(eachRowData.getValue().getName());
			});

			this.c_nacionaliti_artist.setCellValueFactory(eachRowData -> {
				return new SimpleObjectProperty<>(eachRowData.getValue().getNationality());
			});
			this.c_imag_artist.setCellValueFactory(eachRowData -> {
				ImageView n=null;
				try{
					n=new ImageView(eachRowData.getValue().getPhoto());
					n.setFitHeight(30);
					n.setFitWidth(30);
				}catch(Exception e){

				}

				return new SimpleObjectProperty<>(n);
			});
			//----------------------------
			this.c_name_song_playlistedit.setCellValueFactory(eachRowData -> {
				return new SimpleObjectProperty<>(eachRowData.getValue().getName());
			});
			this.c_genre_song_playlistedit.setCellValueFactory(eachRowData -> {
				return new SimpleObjectProperty<>(eachRowData.getValue().getGenre().getName());
			});
			this.c_artist_song_playlistedit.setCellValueFactory(eachRowData -> {
				return new SimpleObjectProperty<>(eachRowData.getValue().getDisc().getArtist().getName());
			});
			this.c_disc_song_playlistedit.setCellValueFactory(eachRowData -> {
				return new SimpleObjectProperty<>(eachRowData.getValue().getDisc().getName());
			});
			this.c_duracion_song_playlistedit.setCellValueFactory(eachRowData -> {
				return new SimpleObjectProperty<>(eachRowData.getValue().getDuration());
			});
			//----------------------------
			this.c_namedisc_misplaylist_edit.setCellValueFactory(eachRowData -> {
				return new SimpleObjectProperty<>(eachRowData.getValue().getName());
			});
			this.c_datedisc_misplaylist_edit.setCellValueFactory(eachRowData -> {
				return new SimpleObjectProperty<>(eachRowData.getValue().getDate());
			});
			this.c_imgdisc_misplaylist_edit.setCellValueFactory(eachRowData -> {
				ImageView n=new ImageView(eachRowData.getValue().getPhoto());
				n.setFitHeight(30);
				n.setFitWidth(30);
				return new SimpleObjectProperty<>(n);
			});
			//------------------------------
			this.c_name_song_toadd.setCellValueFactory(eachRowData -> {
				return new SimpleObjectProperty<>(eachRowData.getValue().getName());
			});
			this.c_genre_song_toadd.setCellValueFactory(eachRowData -> {
				return new SimpleObjectProperty<>(eachRowData.getValue().getGenre().getName());
			});
			this.c_nameartist_song_toadd.setCellValueFactory(eachRowData -> {
				return new SimpleObjectProperty<>(eachRowData.getValue().getDisc().getArtist().getName());
			});
			this.c_namedisc_song_toadd.setCellValueFactory(eachRowData -> {
				return new SimpleObjectProperty<>(eachRowData.getValue().getDisc().getName());
			});


			tabla_artis.setItems(list_artists);
			table_song_playlistedit.setItems(lista_song_mipplaylist_edit);
			table_disc_misplaylist_edit.setItems(list_disc_misplaylist_edit);
			table_song_toadd.setItems(lista_sog_toadd);
		}
	}
	@FXML
	private void SearchNameArtist(){
		if(searh_name_artist.getText().length()>0){
			list_artists.clear();
			list_artists.addAll(ArtistDAOImpl.SelectbyName(searh_name_artist.getText().toUpperCase()));
		}
	}
	@FXML
	private void AddSongToList(){

		if(playlist_selected!=null){
			Song s=table_song_toadd.getSelectionModel().getSelectedItem();
			boolean existe=false;
			if(s!=null){
				if(confirm("Información", "¿Agregar canción a la lista?", "  ")){
					Playlist ps=playlist_selected;
					PlayListDAO tadd=new PlayListDAO(ps);
						for( Song so:tadd.getSongs()){
							if(so.getId()==s.getId()){
								existe=true;
								break;
							}
						}
						if(!existe){

							ps.getSongs().add(s);
							if(tadd.update()>0){
								for(Playlist pls:playlist_user_principal){
									if(pls.getId()==ps.getId()){
										playlist_user_principal.remove(pls);
										break;
									}
								}
								lista_song_mipplaylist_edit.add(s);
								playlist_user_principal.add(tadd);

							}


						}else{
							muestraerror("Error", "Error en la base de datos", "Comprueba que la canción no esté ya incluida");
						}

					}
				}
			//}
		}

	}
	@FXML
	private void AddAllSongOfDisc(){
		Disc d=table_disc_misplaylist_edit.getSelectionModel().getSelectedItem();
		if(d!=null){
			if(confirm("Información", "¿Agregar todo el disco a la PlayList?", "  ")){
				Playlist ps=playlist_selected;
				for(Song s:d.getSonglist()){
					if(!ps.getSongs().contains(s)){
						lista_song_mipplaylist_edit.add(s);
						ps.getSongs().add(s);
					}

				}
				PlayListDAO psd=new PlayListDAO(ps);
				psd.update();
				//ShowListasUser();

			}
		}
	}
	@FXML
	private void DeleteSongToList(){
		if(playlist_selected!=null){
			Song s=table_song_playlistedit.getSelectionModel().getSelectedItem();
			if(s!=null){
				if(confirm("Información","¿Desea borrar la canción de la PlayList?", "   ")){
					Playlist pl=playlist_selected;
					PlayListDAO psd=new PlayListDAO(pl);
					psd.getSongs().remove(s);
					if(psd.update()>0){
						lista_song_mipplaylist_edit.remove(s);
						for(Playlist pls:playlist_user_principal){
							if(pls.getId()==playlist_selected.getId()){
								playlist_user_principal.remove(pls);
								break;
							}
						}
						playlist_user_principal.add(psd);
						songlist_user_principal.clear();
						//ShowListasUser();
						muestrinformacion("Información", "Canción borrada de la playlist", "  ");
					}else{
						muestraerror("Error", "Error en la base de datos", " ");
					}
				}
			}
		}
	}
	@FXML
	private void ClickOnSuscriptions(){
		if(allplaylist==null){
			allplaylist=FXCollections.observableArrayList();
			lista_allmysubs_edit=FXCollections.observableArrayList();
			lista_allmysubs_edit.addAll(App.getUser().getSubscriptions());
			ShowAllPlayList();
			this.c_name_allplaylist.setCellValueFactory(eachRowData -> {
				return new SimpleObjectProperty<>(eachRowData.getValue().getName());
			});
			this.c_description_allplaylist.setCellValueFactory(eachRowData -> {
				return new SimpleObjectProperty<>(eachRowData.getValue().getDescription());
			});
			this.c_author_allplaylist.setCellValueFactory(eachRowData -> {
				return new SimpleObjectProperty<>(eachRowData.getValue().getCreator().getName());
			});
			this.c_duracion_allplaylist.setCellValueFactory(eachRowData -> {
				int s=0;
				for(Song so:eachRowData.getValue().getSongs()){
					s+=so.getDuration();
				}
				return new SimpleObjectProperty<>(s);
			});
			//-------------------------------
			this.c_mysubs_edir_name.setCellValueFactory(eachRowData -> {
				return new SimpleObjectProperty<>(eachRowData.getValue().getName());
			});
			this.c_mysubs_edir_descrip.setCellValueFactory(eachRowData -> {
				return new SimpleObjectProperty<>(eachRowData.getValue().getDescription());
			});
			this.c_mysubs_edir_author.setCellValueFactory(eachRowData -> {
				return new SimpleObjectProperty<>(eachRowData.getValue().getCreator().getName());
			});
			this.c_mysubs_edir_duration.setCellValueFactory(eachRowData -> {
				int s=0;
				for(Song so:eachRowData.getValue().getSongs()){
					s+=so.getDuration();
				}
				return new SimpleObjectProperty<>(s);
			});

			table_mysubs_edir.setItems(lista_allmysubs_edit);

			table_allplylist.setItems(allplaylist);
		}
	}
	@FXML
	private void ShowAllPlayList(){
		allplaylist.clear();
		allplaylist.addAll(PlayListDAOImpl.SearchAllExceptUSer(App.getUser().getId()));
	}
	@FXML
	private void Desus(){
		Playlist pl=table_mysubs_edir.getSelectionModel().getSelectedItem();
		if(pl!=null){
			if(confirm("Información", "¿Desuscribirse de la PlayList?", "  " )){
				User u=App.getUser();
				u.getSubscriptions().remove(pl);
				if(new UsersDAO(u).update()>0){
					lista_allmysubs_edit.remove(pl);
					playlistsubs_principal.remove(pl);
					//App.getUser().setSynchro(false);
					muestrinformacion("Información", "Se ha desuscrito correctamente", "  ");
				}else{
					muestraerror("Error", "Error en la base de datos", " ");
				}
			}
		}

	}
	@FXML
	private void Sub(){
		Playlist pl=table_allplylist.getSelectionModel().getSelectedItem();
		if(pl!=null){
			boolean exist=false;
			if(confirm("Información", "¿Suscribirse a la PlayList?", "  " )){
				User u=new UsersDAO(App.getUser().getId());
				for(Playlist pls:u.getSubscriptions()){
					if(pls.getId()==pl.getId()){
						exist=true;
						break;
					}
				}
				if(!exist){
					u.getSubscriptions().add(pl);
					if(new UsersDAO(u).update()>0){
						lista_allmysubs_edit.add(pl);
						playlistsubs_principal.add(pl);
						muestrinformacion("Información", "Se ha suscrito correctamente", "  ");
					}
				}else{
					muestraerror("Error", "Error en la base de datos", " Compruebe que no esté ya suscrito ");
				}

			}
		}

	}
	@FXML
	private void OnClikSearhByNameSus(){

		if(radio_by_name.isSelected()){
			radio_by_creator.setSelected(false);
		}

	}
	@FXML
	private void OnClikSearhByAuthorSus(){

		if(radio_by_creator.isSelected()){
			radio_by_name.setSelected(false);
		}

	}
	@FXML
	private void SearchSus(){
		if(radio_by_name.isSelected()){
			if(search_name_playtosuscribe.getText().length()>0){
				allplaylist.clear();
				allplaylist.addAll(PlayListDAOImpl.SearchAllExceptUSerAndNameList(App.getUser().getId(), search_name_playtosuscribe.getText().toUpperCase()));

			}

		}else if(radio_by_creator.isSelected()){
			if(search_name_playtosuscribe.getText().length()>0){
				allplaylist.clear();
				allplaylist.addAll(PlayListDAOImpl.SearchAllExceptUSerAndNameCreator(App.getUser().getId(), search_name_playtosuscribe.getText().toUpperCase()));
			}
		}
	}



}
