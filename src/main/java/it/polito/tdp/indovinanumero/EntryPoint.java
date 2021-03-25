package it.polito.tdp.indovinanumero;

import javafx.application.Application;
import static javafx.application.Application.launch;

import it.polito.tdp.indovinanumero.model.Model;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class EntryPoint extends Application {

    @Override
    public void start(Stage stage) throws Exception {
    	
    	//creo il modello 
    	Model model = new Model();
    	//definisco il controller
    	FXMLController controller;
    	
    	//definisco il loader e lo assegno con ciò che prendo dalla scene
    	FXMLLoader loader= new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
    	
        //Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
    	//estraggo la radice direttamente del loader che ho fatto prima
    	Parent root = loader.load();
    	
        Scene scene = new Scene(root);
    	
    	//dal loader estraggo il controller e lo assegno alla variabile dedicata
    	controller=loader.getController();
    	//chiamo il metodo del controller che mi setta il model
    	controller.setModel(model);
    
        
        //scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("Indovina il numero");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
