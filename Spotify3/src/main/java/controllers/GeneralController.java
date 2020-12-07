package controllers;

import java.util.Optional;

import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

abstract class GeneralController implements Initializable{
	protected void muestraerror(String title, String header, String description) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(description);
        alert.showAndWait();
    }

	protected void muestrinformacion(String title, String header, String description) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(description);
        alert.showAndWait();
    }

	protected boolean confirm(String uno,String dos,String tres) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("CONFIRMAR");
        if(dos.length()>0){
        	 alert.setHeaderText(dos);
        }else{
        	 alert.setHeaderText("A punto de eliminar");
        }
        if(tres.length()>0){
        	alert.setContentText(tres);
        }else{
        	alert.setContentText("¿Desea eliminar el elemento?");
        }

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }

	}
}
