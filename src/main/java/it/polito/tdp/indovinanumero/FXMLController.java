package it.polito.tdp.indovinanumero;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.indovinanumero.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class FXMLController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtTentativiFatti;

    @FXML
    private Button btnNuova;

    @FXML
    private TextField txtRimasti;

    @FXML
    private HBox hboxProva;

    @FXML
    private TextField txtTentativo;

    @FXML
    private Button btnProva;

    @FXML
    void doNuova(ActionEvent event) {
    	
    	//fai partire la logica del gioco dal modello
    	model.NuovaPartita();
    	
    	//------------Pulizia e reset dell'interfaccia------------
    	hboxProva.setDisable(false);
    	txtTentativiFatti.clear();
    	txtTentativo.clear();
    	txtRimasti.setText(Integer.toString(model.getTMAX()));
    	
    }

    @FXML
    void doProva(ActionEvent event) {
    	
    	//prendo l'input dell'utente e mi assicuro sia un integer
    	String TentativoAttualeS = txtTentativo.getText();
    	int TentativoAttualeI;
    	try {
    		TentativoAttualeI = Integer.parseInt(TentativoAttualeS);
    	} catch (NumberFormatException e) {
    		txtTentativiFatti.appendText("Devi inserire un valore numerico! \n");
    		return;
    	}
    	
    	//diminuisco il numero di tentativi rimasti
    	txtRimasti.setText(Integer.toString(this.model.quantiRimasti()));
    	
    	//mi comporto diversamente a seconda del return del metodo principale del modello
    	switch (this.model.FaiTentativo(TentativoAttualeI)) {
    		case -1: 
    			txtTentativiFatti.appendText(TentativoAttualeI+": Tentativo troppo basso \n");
    			break;
    		case 0:
    			txtTentativiFatti.appendText("Hai vinto! Hai utilizzato: "+(model.getTU()-1)+" tentativi \n");
        		hboxProva.setDisable(true);
        		return;
    		case 1:
    			txtTentativiFatti.appendText(TentativoAttualeI+": Tentativo troppo alto \n");
    			break;
    		case 2:
    			txtTentativiFatti.appendText("Hai perso! Il numero segreto era: "+model.getSegreto()+"\n");
        		hboxProva.setDisable(true);
        		return;
    		case 3:
    			txtTentativiFatti.appendText("Il tentativo fatto non è valido! \n");
    			break;
    		default:
    			txtTentativiFatti.appendText("Errore sconosciuto \n");
    			break;
    	}

    
    	
    }

    @FXML
    void initialize() {
        assert txtTentativiFatti != null : "fx:id=\"txtTentativiFatti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnNuova != null : "fx:id=\"btnNuova\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRimasti != null : "fx:id=\"txtRimasti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert hboxProva != null : "fx:id=\"hboxProva\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTentativo != null : "fx:id=\"txtTentativo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnProva != null : "fx:id=\"btnProva\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model m) {
    	this.model=m;
    }
}
