package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import DAO.GenreDAO;
import DAOImpl.GenreDAOImpl;
import discography.Spotify3.Ejecutable;
import enums.Escenas;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.TextFieldTableCell;
import model.Artist;
import model.Genre;


public class GenreController extends GeneralController{

	@FXML
	private TableView<Genre> genre_table;
	@FXML
	private TableColumn<Genre, String> name_genre;
	@FXML
	private TextField newname_;
	private ObservableList<Genre> genres_;

	public void initialize(URL location, ResourceBundle resources) {
		genres_=FXCollections.observableArrayList();
		ShowAll();
		this.name_genre.setCellValueFactory(eachRowData -> {
			return new SimpleObjectProperty<>(eachRowData.getValue().getName());
		});

		name_genre.setCellFactory(TextFieldTableCell.forTableColumn());
		name_genre.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Genre,String>>() {
			@Override
			public void handle(CellEditEvent<Genre, String> event) {
				Genre edit=(Genre) event.getTableView().getItems().get(event.getTablePosition().getRow());
				String old=edit.getName();
				if(!edit.getName().equals(event.getNewValue().toUpperCase())){
					if(!GenreDAOImpl.Exist(event.getNewValue().toUpperCase())){
						if(confirm("CONFIRM", "SAVE?", "   ")){
							edit.setName(event.getNewValue().toUpperCase());
							GenreDAO editsave=new GenreDAO(edit);
							if(editsave.update()>0){
								muestrinformacion("INFO UPDATE", "Update Worked"," ");
							}else{
								muestraerror("Error", " ", " ");
								edit.setName(old);
							}
						}
					}else{
						edit.setName(old);
						muestrinformacion("Info","Existing Genre", "   ");
					}

				}

			}
		});

		genre_table.setEditable(true);
		genre_table.setItems(genres_);

	}

	private void ShowAll(){
		genres_.clear();
		genres_.addAll(GenreDAOImpl.SelectALL());
	}
	@FXML
	public void Return(){
		Ejecutable.CambiarEscena(600, 400, Escenas.ADMINISTRATION);
		Ejecutable.CambiarTitulo("Administration");
	}
	@FXML
	public void DeleteGenre(){
		Genre todelete=genre_table.getSelectionModel().getSelectedItem();
		if(todelete!=null){
			if(confirm("Confirm","¿Quieres eliminar el registro selecionado?", "El género "+todelete.getName()+" se perderá")){
				GenreDAO delet=new GenreDAO(todelete);
				if(delet.delete()>0){
					muestrinformacion("Info", "Género eliminado correctamente" , " ");
					genres_.remove(todelete);
				}else{
					muestraerror("Error", "A ocurrido un error, pruebe más tarde", "  ");
				}
			}
		}
	}
	@FXML
	public void AddGenre(){
		if(newname_.getText().length()>0){
			if(!GenreDAOImpl.Exist(newname_.getText().toUpperCase())){
				if(confirm("Info", "¿Quieres añadir el gérero "+newname_.getText().toUpperCase()+" al registro?", "  ")){
					GenreDAO toadd=new GenreDAO(newname_.getText().toUpperCase());
					if(toadd.update()>0){
						genres_.add(toadd);
						newname_.clear();
						muestrinformacion("Info", "Se ha añadido el género "+toadd.getName() , " ");
					}else{
						muestraerror("Error", "A ocurrido un error, pruebe más tarde", "  ");
					}
				}

			}else{
				muestrinformacion("Info", "Gérero existente" , " ");
			}
		}
	}

}
