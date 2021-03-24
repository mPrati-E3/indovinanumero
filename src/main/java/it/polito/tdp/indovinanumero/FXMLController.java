package it.polito.tdp.indovinanumero;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class FXMLController {
	
	private final int NMAX = 100;
	private final int TMAX = 8;
	private int segreto;
	private int tentativiUtente;
	private boolean inGioco = false;

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
    	
    	this.segreto = (int)(Math.random() * NMAX)+1;
    	this.tentativiUtente=0;
    	this.inGioco=true;
    	
    	hboxProva.setDisable(false);
    	txtTentativiFatti.clear();
    	txtTentativo.clear();
    	txtRimasti.setText(Integer.toString(TMAX));
    	
    }

    @FXML
    void doProva(ActionEvent event) {
    	
    	String TentativoAttualeS = txtTentativo.getText();
    	int TentativoAttualeI;
    	try {
    		TentativoAttualeI = Integer.parseInt(TentativoAttualeS);
    	} catch (NumberFormatException e) {
    		txtTentativiFatti.appendText("Devi inserire un valore numerico! \n");
    		return;
    	}
    	
    	this.tentativiUtente++;
    	
    	if (TentativoAttualeI == this.segreto) {
    		txtTentativiFatti.appendText("Hai vinto! Hai utilizzato: "+tentativiUtente+" tentativi \n");
    		hboxProva.setDisable(true);
    		this.inGioco=false;
    		return;
    	}
    	
    	if (tentativiUtente == TMAX) {
    		txtTentativiFatti.appendText("Hai perso! Il numero segreto era: "+this.segreto+"\n");
    		hboxProva.setDisable(true);
    		this.inGioco=false;
    		return;
    	}
    	
    	if (TentativoAttualeI<this.segreto) {
    		txtTentativiFatti.appendText(TentativoAttualeI+": Tentativo troppo basso \n");
    	} else {
    		txtTentativiFatti.appendText(TentativoAttualeI+": Tentativo troppo alto \n");
    	}
    	
    	txtRimasti.setText(Integer.toString(TMAX-tentativiUtente));
    	
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
}
