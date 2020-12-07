package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import DAO.UsersDAO;
import discography.Spotify3.App;
import discography.Spotify3.Ejecutable;
import enums.Escenas;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.User;
import utilities.GeneralUtilities;

public class StartController extends GeneralController{

	@FXML
	private TextField email_;

	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	@FXML
	private void Registry(){
		Ejecutable.CambiarEscena(600, 400, Escenas.REGISTRY);
		Ejecutable.CambiarTitulo("Registry");
	}
	@FXML
	private void Conexiones(){
		Ejecutable.CambiarEscena(600, 400, Escenas.CONEXIONES);
		Ejecutable.CambiarTitulo("Connections");
	}
	@FXML
	private void Administration(){
		Ejecutable.CambiarEscena(600, 400, Escenas.ADMINISTRATION);
		Ejecutable.CambiarTitulo("Administration");
	}
	@FXML
	private void GetIn(){
		if(email_.getText().length()>0){
			if(GeneralUtilities.ValidateMAIL(email_.getText())){
				User u=new UsersDAO(email_.getText());
				if(u.getId()>0){
					if(u.isActive()){
						if(confirm("Información", "¿Iniciar sesión?", "  ")){
							App.setUser(u);
							Ejecutable.CambiarEscena(1295, 764, Escenas.USERVIEW);
							Ejecutable.CambiarResizable(true);
							Ejecutable.CambiarTitulo(u.getName());
						}
					}else{
						muestraerror("Error", "Usuario desactivado", "   ");
					}

				}else{
					muestraerror("Error", "Error con la base de datos", "   ");
				}
			}else{
				muestraerror("Error", "Email no válido", "   ");
			}

		}else{
			muestraerror("Error", "Campo vacío", "   ");
		}

	}

}
