package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import DAO.UsersDAO;
import discography.Spotify3.Ejecutable;
import enums.Escenas;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utilities.GeneralUtilities;

public class RegistryController extends GeneralController{
	@FXML
	private ImageView image_;
	@FXML
	private TextField url_;
	@FXML
	private TextField name_;
	@FXML
	private TextField mail_;
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	@FXML
	private void Return(){
		Ejecutable.CambiarEscena(600, 400, Escenas.INICIO);
		Ejecutable.CambiarTitulo("INICIO DE SESIÓN");
	}
	@FXML
	private void EnterImage(){
		if(url_.getText().length()>0){
			image_.setImage(new Image(url_.getText()));
		}
	}
	@FXML
	private void Clear(){
		url_.clear();
		mail_.clear();
		name_.clear();
		image_.setImage(null);
	}

	@FXML
	private void Add(){
		boolean correct = false;
		if(url_.getText().length()>0 && mail_.getText().length()>0 && name_.getText().length()>0){
			if(!GeneralUtilities.ValidateMAIL(mail_.getText())){
				mail_.clear();
			}else{
				if(!GeneralUtilities.ValidateURL(url_.getText())){
					url_.clear();
				}else{
					correct=true;
				}
			}
			if(correct){
				UsersDAO u =new UsersDAO(mail_.getText());
				if(u.getId()>0){
					muestraerror("Error", "Cuenta ya existente", "     ");
					if(!u.isActive()){
						if(confirm("Información", "Este usuario se encuentra desactivado", "¿Desea volver a activarlo?")){
							u.setActive(true);
							if(u.update()>0){
								muestrinformacion("Información", "Usuario activado", "   ");
							}
						}
					}
				}else{
					if(confirm("Informacion","¿Desea registrar usuario?"," ")){
						u.setActive(true);
						u.setName(name_.getText().toUpperCase());
						u.setMail(mail_.getText());
						u.setPhoto(url_.getText());
						if(u.update()>0){
							muestrinformacion("Información", "Usuario registrado", "  ");
							Return();
						}else{
							muestraerror("Error", "No se ha podido registrar", "    ");
						}
					}
				}
			}else{
				muestraerror("Error", "Campo erróneos", "    ");
			}
		}else{
			muestraerror("Error", "No dejes campos en blanco", "   ");
		}
	}

}
