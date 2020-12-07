package discography.Spotify3;

import java.io.IOException;

import enums.Escenas;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Ejecutable extends Application{
	private static Scene scene;
	private static Stage stge;
	@Override
	public void start(Stage sta) throws Exception {
		try {
			scene = new Scene(loadFXML(Escenas.INICIO.getUrl()), 600, 400);
			stge=sta;
    		stge.setTitle("INICIO DE SESIÓN");
    		stge.getIcons().add(new Image("/assets/icono.png"));
    		stge.setResizable(false);
    		stge.setScene(scene);
            //stage.setResizable(false);
            stge.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Ejecutable.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
	public static void main(String[] args) {
		launch(args);
	}
	public static void CambiarEscena(double h,double w,Escenas e){

    	try {
			scene = new Scene(loadFXML(e.getUrl()), h, w);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	stge.setScene(scene);
    	stge.centerOnScreen();
    }
	public static void CambiarTitulo(String tit){
    	stge.setTitle(tit);
    }
    public static void CambiarResizable(boolean re){
    	stge.setResizable(re);
    }
    public static void PonerMaximizado(boolean max){
    	stge.setMaximized(max);
    }



}
