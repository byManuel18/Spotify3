package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import discography.Spotify3.Ejecutable;
import enums.Escenas;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AdministrationController extends GeneralController{
	@FXML
	private ImageView genreimg_;
	@FXML
	private ImageView artistimg_;

	public void initialize(URL location, ResourceBundle resources) {
		genreimg_.setImage(new Image("/assets/generos.jpg"));
		artistimg_.setImage(new Image("/assets/artist.png"));

	}
	@FXML
	private void Return(){
		Ejecutable.CambiarEscena(600, 400, Escenas.INICIO);
		Ejecutable.CambiarTitulo("INICIO DE SESIÓN");
	}
	@FXML
	private void Genre(){
		Ejecutable.CambiarEscena(600, 400, Escenas.GENRE);
		Ejecutable.CambiarTitulo("GENRES");
	}
	@FXML
	private void Artist(){
		Ejecutable.CambiarEscena(1285, 894, Escenas.ARTIST);
		Ejecutable.CambiarTitulo("ARTIST");
		Ejecutable.CambiarResizable(true);
		Ejecutable.PonerMaximizado(true);
	}

}
