package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import discography.Spotify3.Ejecutable;
import enums.Escenas;
import enums.TypeBDD;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import utilities.ConnectionManager;
import utilities.XMLManager;

public class ConexionesController extends GeneralController{
	@FXML
	private ChoiceBox<TypeBDD> type_;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		for(TypeBDD t:TypeBDD.values()){
			type_.getItems().add(t);
		}
		type_.setValue(ConnectionManager.getOpcion().getTypeBDD());

	}

	@FXML
	public void Return(){
		Ejecutable.CambiarEscena(600, 400, Escenas.INICIO);
		Ejecutable.CambiarTitulo("Administration");
	}
	@FXML
	public void Save(){
		if(type_.getValue()!=ConnectionManager.getOpcion().getTypeBDD()){
			if(confirm("Informacioón","¿Cambiar Base de datos?", "   ")){
				ConnectionManager.getOpcion().setTypeBDD(type_.getValue());
				XMLManager.SetOption(ConnectionManager.getOpcion());
			}
		}
	}


}
