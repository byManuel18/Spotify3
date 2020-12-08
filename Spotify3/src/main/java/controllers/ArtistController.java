package controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import DAO.ArtistDAO;
import DAO.DiscDAO;
import DAO.GenreDAO;
import DAO.SongDAO;
import DAOImpl.ArtistDAOImpl;
import DAOImpl.DiscDAOImpl;
import DAOImpl.GenreDAOImpl;
import DAOImpl.SongDAOImpl;
import discography.Spotify3.Ejecutable;
import enums.Escenas;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Artist;
import model.Disc;
import model.Genre;
import model.Song;
import utilities.GeneralUtilities;

public class ArtistController extends GeneralController {
	@FXML
	private RadioButton busqueda_name_artis;
	@FXML
	private RadioButton busqueda_nacionalidad_artis;
	@FXML
	private Button b_search_artist;
	@FXML
	private Button b_add_song;
	@FXML
	private Button b_clear_song;
	@FXML
	private Button b_edit_song;
	@FXML
	private TextField t_b_artist;
	@FXML
	private TextField name_song;
	@FXML
	private TextField duracion_song;
	@FXML
	private ChoiceBox<String> genero_song;
	@FXML
	private Button b_add;
	@FXML
	private Button b_edit;
	@FXML
	private ImageView imge_artist;
	@FXML
	private TextField name_artist;
	@FXML
	private TextField url_artist;
	@FXML
	private TextField nacionaliti_artist;
	@FXML
	private ImageView imag_disc;
	@FXML
	private DatePicker date_disc;
	@FXML
	private TextField name_disc;
	@FXML
	private TextField url_disc;
	@FXML
	private Button b_edit_disc;
	@FXML
	private Button b_add_disc;
	@FXML
	private Button b_clear_disc;
	@FXML
	private TableView<Artist> artisttamble;
	@FXML
	private javafx.scene.control.TableColumn<Artist, ImageView> columna_image;
	@FXML
	private javafx.scene.control.TableColumn<Artist, String> columna_name;
	@FXML
	private javafx.scene.control.TableColumn<Artist, String> columna_nacionalidad;
	@FXML
	private TableView<Disc> dist_table;
	@FXML
	private TableColumn<Disc, String> columdiscname;
	@FXML
	private TableColumn<Disc, LocalDate> columdiscfecha;
	@FXML
	private TableColumn<Disc, ImageView> columdiscimage;

	@FXML
	private TableView<Song> song_list;
	@FXML
	private TableColumn<Song, String> cname_song;
	@FXML
	private TableColumn<Song, String> cgenero_song;
	@FXML
	private TableColumn<Song, Integer> cduracion_song;
	private Artist get = null;
	private Disc disc = null;
	private Song song = null;
	private ObservableList<Artist> artistlist_;
	private ObservableList<Disc> discarlist;
	private ObservableList<Song> songlist;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		artistlist_ = FXCollections.observableArrayList();
		discarlist = FXCollections.observableArrayList();
		songlist = FXCollections.observableArrayList();
		b_edit.setDisable(true);
		b_add_disc.setDisable(true);
		b_clear_disc.setDisable(true);
		b_edit_disc.setDisable(true);
		b_add_song.setDisable(true);
		b_clear_song.setDisable(true);
		b_edit_song.setDisable(true);
		genero_song.setDisable(true);
		b_search_artist.setDisable(true);
		t_b_artist.setDisable(true);
		for (Genre g : GenreDAOImpl.SelectALL()) {
			genero_song.getItems().add(g.getName());
		}
		ShowAll();

		this.columna_name.setCellValueFactory(eachRowData -> {
			return new SimpleObjectProperty<>(eachRowData.getValue().getName());
		});
		this.columna_nacionalidad.setCellValueFactory(eachRowData -> {
			return new SimpleObjectProperty<>(eachRowData.getValue().getNationality());
		});
		this.columna_image.setCellValueFactory(eachRowData -> {
			ImageView img=null;
			try{
				img=new ImageView(eachRowData.getValue().getPhoto());
				img.setFitHeight(75);
				img.setFitWidth(75);
			}catch (Exception e) {
				// TODO: handle exception
			}
			return new SimpleObjectProperty<>(img);
		});
		// -------
		this.columdiscname.setCellValueFactory(eachRowData -> {
			return new SimpleObjectProperty<>(eachRowData.getValue().getName());
		});
		this.columdiscfecha.setCellValueFactory(eachRowData -> {
			return new SimpleObjectProperty<>(eachRowData.getValue().getDate());
		});
		this.columdiscimage.setCellValueFactory(eachRowData -> {
			ImageView img=null;
			try{
				img=new ImageView(eachRowData.getValue().getPhoto());
				img.setFitHeight(75);
				img.setFitWidth(75);
			}catch (Exception e) {
				// TODO: handle exception
			}
			return new SimpleObjectProperty<>(img);
		});
		// -------
		this.cname_song.setCellValueFactory(eachRowData -> {
			return new SimpleObjectProperty<>(eachRowData.getValue().getName());
		});
		this.cduracion_song.setCellValueFactory(eachRowData -> {
			return new SimpleObjectProperty<>(eachRowData.getValue().getDuration());
		});
		this.cgenero_song.setCellValueFactory(eachRowData -> {
			return new SimpleObjectProperty<>(eachRowData.getValue().getGenre().getName());
		});

		artisttamble.setItems(artistlist_);
		dist_table.setItems(discarlist);
		song_list.setItems(songlist);

	}

	@FXML
	private void ShowAll() {
		b_search_artist.setDisable(true);
		busqueda_nacionalidad_artis.setSelected(false);
		busqueda_name_artis.setSelected(false);
		t_b_artist.setDisable(true);
		t_b_artist.clear();
		artistlist_.clear();
		artistlist_.addAll(ArtistDAOImpl.SelectAll());
	}

	@FXML
	public void Return() {
		Ejecutable.CambiarEscena(600, 400, Escenas.ADMINISTRATION);
		Ejecutable.CambiarTitulo("Administration");
		Ejecutable.CambiarResizable(false);
		Ejecutable.PonerMaximizado(false);
	}

	@FXML
	private void ShowArtis() {
		Artist art=artisttamble.getSelectionModel().getSelectedItem();
		if(art!=null){
			get=new ArtistDAO(art.getId());
		}
		//get = artisttamble.getSelectionModel().getSelectedItem();

		if (get != null) {
			try{
				imge_artist.setImage(new Image(get.getPhoto()));
			}catch (Exception e) {
				imge_artist.setImage(null);
			}
			url_artist.setText(get.getPhoto());
			name_artist.setText(get.getName());
			nacionaliti_artist.setText(get.getNationality());
			discarlist.clear();
			discarlist.addAll(get.getDisclist());
			songlist.clear();
			disc = null;
			song = null;
			b_edit.setDisable(false);
			b_add.setDisable(true);
			b_clear_disc.setDisable(false);
			b_add_disc.setDisable(false);
			url_disc.clear();
			imag_disc.setImage(null);
			name_disc.clear();
			date_disc.setValue(null);

		}
	}

	@FXML
	private void ShowDisc() {

			disc =dist_table.getSelectionModel().getSelectedItem();

		if (disc != null) {
			song = null;
			songlist.clear();
			songlist.addAll(disc.getSonglist());
			try{
				imag_disc.setImage(new Image(disc.getPhoto()));
			}catch (Exception e) {
				// TODO: handle exception
			}

			name_disc.setText(disc.getName());
			url_disc.setText(disc.getPhoto());
			date_disc.setValue(disc.getDate());
			b_add_disc.setDisable(true);
			b_edit_disc.setDisable(false);
			name_song.clear();
			duracion_song.clear();
			genero_song.setValue(null);
			genero_song.setDisable(false);
			b_add_song.setDisable(false);
			b_clear_song.setDisable(false);
			b_edit_song.setDisable(true);

		}
	}

	@FXML
	private void ClearArtist() {
		b_edit.setDisable(true);
		b_add.setDisable(false);
		get = null;
		disc = null;
		song = null;
		discarlist.clear();
		songlist.clear();
		imge_artist.setImage(null);
		url_artist.clear();
		name_artist.clear();
		nacionaliti_artist.clear();
		b_add_disc.setDisable(true);
		b_clear_disc.setDisable(true);
		b_edit_disc.setDisable(true);
		url_disc.clear();
		name_disc.clear();
		date_disc.setValue(null);
		imag_disc.setImage(null);
		name_song.clear();
		duracion_song.clear();
		genero_song.setValue(null);
		genero_song.setDisable(true);
		b_add_song.setDisable(true);
		b_clear_song.setDisable(true);
		b_edit_song.setDisable(true);

	}

	@FXML
	private void EditArtist() {
		if (GeneralUtilities.ValidateURL(url_artist.getText()) && name_artist.getText().length() > 0
				&& nacionaliti_artist.getText().length() > 0) {
			boolean procede = false;
			if (name_artist.getText().toUpperCase().equals(get.getName())) {
				if (confirm("información", "¿Editar artista?", "   ")) {
					procede = true;
				}
			} else {
				if (!ArtistDAOImpl.existArtist(name_artist.getText().toUpperCase())) {
					if (confirm("información", "¿Editar artista?", "   ")) {
						procede = true;
					}
				}else{
					muestraerror("Error", "No se ha podido editar", "Artista existente");
				}
			}

			if (procede) {
				get.setName(name_artist.getText().toUpperCase());
				get.setNationality(nacionaliti_artist.getText().toUpperCase());
				get.setPhoto(url_artist.getText());
				ArtistDAO update = new ArtistDAO(get);
				if (update.update() > 0) {
					for(Artist a:artistlist_){
						if(a.getId()==get.getId()){
							artistlist_.remove(a);
							break;
						}
					}
					artistlist_.add(update);
					muestrinformacion("Información", "Artista editado correctamente", "   ");
				} else {
					muestraerror("Error", "No se ha podido editar", "Problema con la base de datos");
				}
			}
		} else {
			muestraerror("Error", "No se ha podido editar", "Campos vacíos o incorrectos");
		}
	}

	@FXML
	private void AddArtist() {
		if (GeneralUtilities.ValidateURL(url_artist.getText()) && name_artist.getText().length() > 0
				&& nacionaliti_artist.getText().length() > 0) {
			if (!ArtistDAOImpl.existArtist(name_artist.getText().toUpperCase())) {
				if (confirm("Información", "¿Seguro que desea añadir Artista?", "   ")) {
					ArtistDAO toadd = new ArtistDAO(name_artist.getText().toUpperCase(),
							nacionaliti_artist.getText().toUpperCase(), url_artist.getText());
					if (toadd.update() > 0) {
						artistlist_.add(toadd);
						url_artist.clear();
						imge_artist.setImage(null);
						name_artist.clear();
						nacionaliti_artist.clear();
						muestrinformacion("Información", "Artista creado correctamente", "  ");
					} else {
						muestraerror("Error", "No se ha podido crear", "Problema con la base de datos");
					}
				}
			} else {
				muestraerror("Error", "Artista existente", "Ya hay un artista con ese nombre");
			}
		} else {
			muestraerror("Error", "No se ha podido crear", "Campos vacíos o incorrectos");
		}
	}

	@FXML
	private void deleteArtist() {
		if (get != null) {
			if (confirm("Informaciónn", "¿Eliminar Artista?", "   ")) {
				ArtistDAO d = new ArtistDAO(get);
				if (d.delete() > 0) {
					artistlist_.remove(get);
					ClearArtist();
					muestrinformacion("Información", "Eliminado correctamente", "   ");
				} else {
					muestraerror("Error", "No se ha podido eliminar", "Problema con la base de datos");
				}
			}
		}
	}

	@FXML
	private void viewImgArtist() {
		imge_artist.setImage(new Image(url_artist.getText()));
	}

	@FXML
	private void viewImgDisck() {
		imag_disc.setImage(new Image(url_disc.getText()));
	}

	@FXML
	private void ClearDisc() {
		disc = null;
		song = null;
		songlist.clear();
		imag_disc.setImage(null);
		url_disc.clear();
		name_disc.clear();
		date_disc.setValue(null);
		b_edit_disc.setDisable(true);
		b_add_disc.setDisable(false);
		name_song.clear();
		genero_song.setValue(null);
		genero_song.setDisable(true);
		duracion_song.clear();
		b_add_song.setDisable(true);
		b_clear_song.setDisable(true);
		b_edit_song.setDisable(true);

	}

	@FXML
	private void EditDdisc() {
		if (GeneralUtilities.ValidateURL(url_disc.getText()) && name_disc.getText().length() > 0
				&& date_disc.getValue() != null) {
			boolean procede=false;
			if(name_disc.getText().toUpperCase().equals(disc.getName())){
				if(confirm("Información", "¿Seguro que desea editar?", "   ")){
					procede=true;
				}
			}else{
				if(!DiscDAOImpl.ExistDisc(name_disc.getText().toUpperCase(), get.getId())){
					if(confirm("Información", "¿Seguro que desea editar?", "   ")){
						procede=true;
					}
				}else{
					muestraerror("Error", "No se ha podido editar", "Disco existente");
				}
			}
			if (procede) {
				disc.setName(name_disc.getText().toUpperCase());
				disc.setDate(date_disc.getValue());
				disc.setPhoto(url_disc.getText());
				DiscDAO toupdate = new DiscDAO(disc);
				if (toupdate.update() > 0) {

					for(Disc a:discarlist){
						if(a.getId()==get.getId()){
							discarlist.remove(a);
							break;
						}
					}
					discarlist.add(toupdate);

					muestrinformacion("Información", "Disco editado correctamente", "   ");
				} else {
					muestraerror("Error", "No se ha podido editar", "Problema con la base de datos");
				}
			}
		} else {
			muestraerror("Error", "No se ha podido editar", "Campos vacíos o incorrectos");
		}
	}

	@FXML
	private void AddDisc() {
		if (GeneralUtilities.ValidateURL(url_disc.getText()) && name_disc.getText().length() > 0
				&& date_disc.getValue() != null) {
			if (!DiscDAOImpl.ExistDisc(name_disc.getText().toUpperCase(), get.getId())) {
				if (confirm("Información", "¿Seguro que desea añadir el disco?", "   ")) {
					DiscDAO toadd = new DiscDAO(name_disc.getText().toUpperCase(), get, url_disc.getText(),
							date_disc.getValue());
					if (toadd.update() > 0) {
						discarlist.add(toadd);
						imag_disc.setImage(null);
						name_disc.clear();
						url_disc.clear();
						muestrinformacion("Información", "Disco añadido correctamente", "   ");
					} else {
						muestraerror("Error", "No se ha podido crear", "Problema con la base de datos");
					}
				}
			} else {
				muestraerror("Error", "Ese disco ya existe", "   ");
			}
		} else {
			muestraerror("Error", "No se ha podido crear", "Campos vacíos o incorrectos");
		}
	}

	@FXML
	private void deleteDisc() {
		if (disc != null) {
			if (confirm("Información", "¿Eliminar disco?", "   ")) {
				DiscDAO d = new DiscDAO(disc);
				if (d.delete() > 0) {
					discarlist.remove(disc);
					ClearDisc();
					muestrinformacion("Información", "Disco eliminado correctamente", "    ");
				} else {
					muestraerror("Error", "No se ha podido eliminar", "Problema con la base de datos");
				}
			}
		}
	}

	@FXML
	private void ShowSong() {
		song = song_list.getSelectionModel().getSelectedItem();
		if (song != null) {
			genero_song.setValue(null);
			name_song.setText(song.getName());
			genero_song.setValue(song.getGenre().getName());
			duracion_song.setText(Integer.toString(song.getDuration()));
			b_add_song.setDisable(true);
			b_clear_song.setDisable(false);
			b_edit_song.setDisable(false);
		}
	}

	@FXML
	private void ClearSong() {
		song = null;
		name_song.clear();
		genero_song.setValue(null);
		duracion_song.clear();
		b_add_song.setDisable(false);
		b_clear_song.setDisable(false);
		b_edit_song.setDisable(true);

	}

	@FXML
	private void AddSong() {
		if (name_song.getText().length() > 0 && date_disc.getValue() != null
				&& GeneralUtilities.ValidateNmber(duracion_song.getText()) && genero_song.getValue() != null) {
			if (!SongDAOImpl.ExistSong(disc.getId(), name_song.getText().toUpperCase())) {
				if (confirm("Información", "¿Seguro que desea añadir la canción?", "   ")) {
					Genre g = null;
					for (Genre gs : GenreDAOImpl.SelectALL()) {
						if (gs.getName().equals(genero_song.getValue())) {
							g = gs;
							break;
						}
					}
					SongDAO toadd = new SongDAO(name_song.getText().toUpperCase(),
							Integer.parseInt(duracion_song.getText()), g, disc);

					if (toadd.update() > 0) {
						songlist.add(toadd);
						name_song.clear();
						duracion_song.clear();
						genero_song.setValue(null);
						muestrinformacion("Información", "Canción añadida correctamente", "   ");
					} else {
						muestraerror("Error", "No se ha podido crear", "Problema con la base de datos");
					}
				}
			} else {
				muestraerror("Error", "Esta canción ya existe", "   ");
			}
		} else {
			muestraerror("Error", "No se ha podido crear", "Campos vacíos o incorrectos");
		}
	}

	@FXML
	private void deleteSong() {
		if (song != null) {
			if (confirm("Información", "¿Eliminar canción?", "    ")) {
				SongDAO s = new SongDAO(song);
				if (s.delete() > 0) {
					songlist.remove(song);
					ClearSong();
					muestrinformacion("Información", "Canción eliminada correctamente", "   ");
				} else {
					muestraerror("Error", "No se ha podido eliminar", "Problema con la base de datos");
				}
			}
		}
	}

	@FXML
	private void EditSong() {
		if (name_song.getText().length() > 0 && date_disc.getValue() != null
				&& GeneralUtilities.ValidateNmber(duracion_song.getText()) && genero_song.getValue() != null) {
			boolean procede = false;
			if(name_song.getText().toUpperCase().equals(song.getName())){
				if(confirm("Información", "¿Seguro que desea editar?", "   ")){
					procede=true;
				}
			}else{
				if(!SongDAOImpl.ExistSong(disc.getId(), name_song.getText().toUpperCase())){
					if(confirm("Información", "¿Seguro que desea editar?", "   ")){
						procede=true;
					}
				}else{
					muestraerror("Error", "No se ha podido editar", "Cancion Existente");
				}
			}
			if (procede) {
				Genre g = null;
				for (Genre gs : GenreDAOImpl.SelectALL()) {
					if (gs.getName().equals(genero_song.getValue())) {
						g = gs;
						break;
					}
				}
				song.setDuration(Integer.parseInt(duracion_song.getText()));
				song.setName((name_song.getText().toUpperCase()));
				song.setGenre(g);
				SongDAO toupdate = new SongDAO(song);
				if (toupdate.update() > 0) {
					for(Song a:songlist){
						if(a.getId()==song.getId()){
							songlist.remove(a);
							break;
						}
					}
					songlist.add(toupdate);
					muestrinformacion("Información", "Canción editada corectamente", "   ");
				} else {
					muestraerror("Error", "No se ha podido editar", "Problema con la base de datos");
				}

			}
		} else {
			muestraerror("Error", "No se ha podido editar", "Campos vacíos o incorrectos");
		}
	}

	@FXML
	private void ClikSearchbyNameArtist() {
		if (busqueda_name_artis.isSelected()) {
			busqueda_nacionalidad_artis.setSelected(false);
			t_b_artist.setDisable(false);
			b_search_artist.setDisable(false);
		} else {
			t_b_artist.setDisable(true);
			b_search_artist.setDisable(true);
		}

	}

	@FXML
	private void ClikSearchbyNacionalityArtist() {
		if (busqueda_nacionalidad_artis.isSelected()) {
			busqueda_name_artis.setSelected(false);
			t_b_artist.setDisable(false);
			b_search_artist.setDisable(false);
		} else {
			t_b_artist.setDisable(true);
			b_search_artist.setDisable(true);
		}
	}

	@FXML
	private void SearchArtist() {
		if (busqueda_nacionalidad_artis.isSelected()) {
			if (t_b_artist.getText().length() > 0) {
				ClearDisc();
				artistlist_.clear();
				artistlist_.addAll(ArtistDAOImpl.SelectbyNacionalidad(t_b_artist.getText().toUpperCase()));
			}

		} else if (busqueda_name_artis.isSelected()) {
			if (t_b_artist.getText().length() > 0) {
				ClearDisc();
				artistlist_.clear();
				artistlist_.addAll(ArtistDAOImpl.SelectbyName(t_b_artist.getText().toUpperCase()));
			}
		}
	}

}
