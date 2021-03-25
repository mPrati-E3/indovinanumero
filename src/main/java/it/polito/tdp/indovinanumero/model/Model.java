package it.polito.tdp.indovinanumero.model;

import java.util.HashSet;
import java.util.Set;

public class Model {
	
	private final int NMAX = 100;
	private final int TMAX = 8;
	private int segreto;
	private int tentativiUtente;
	private int actualMAX = NMAX;
	private int actualMIN = 1;
	
	private Set<Integer> tentInser;
	
	public Model () {
		this.tentativiUtente=0;
	}
	
	public void NuovaPartita() {
    	//------------Set della logica del gioco------------
    	
    	//genera numero segreto
    	this.segreto = (int)(Math.random() * NMAX)+1;
    	//azzera i tentativi dell'utente
    	this.tentativiUtente=0;
    	
    	this.actualMAX = this.NMAX;
    	this.actualMIN = 1;
    	
    	this.tentInser = new HashSet<Integer>();
	}
	
	public int FaiTentativo(int t) {
		
		//numero nell'intervallo?
		if (!tentativoValido(t)) {
			return 3;
		}
		
    	//aumento i tentativi fatti dall'utente
    	this.tentativiUtente++;
    	
    	this.tentInser.add(t);
    	
    	//l'utente ha indovinato correttamente
    	if (t == this.segreto) {
    		return 0;
    	}
    	
    	//l'utente ha esaurito i tentativi
    	if (tentativiUtente == TMAX) {
    		return 2;
    	}
    	
    	//l'utente ha fatto un tentativo non corretto e non ha esaurito i tentativi
    	if (t<this.segreto) {
    		this.actualMIN=t;
    		return -1;
    	} else {
    		actualMAX=t;
    		return 1;
    	}
    	
	}
	
	//ritorna al controller il segreto
	public int getSegreto() {
		return this.segreto;
	}
	
	//ritorna al controller i tentativi fatti dall'utente
	public int getTU() {
		return this.tentativiUtente;
	}
	
	//ritorna al controller i tentativi massimi
	public int getTMAX() {
		return this.TMAX;
	}
	
	//ritorna al controller il massimo attuale
	public int getAM() {
		return this.actualMAX;
	}
	
	//ritorna al controller i minimo attuale
	public int getAm() {
		return this.actualMIN;
	}
	
	
	//valuta se il tentativo è valido (è nell'intervallo)
	private boolean tentativoValido(int t) {
		if (t<this.actualMIN || t>this.actualMAX) {
			return false;
		}
		
		if (this.tentInser.contains(t)) {
			return false;
		}
		
		return true;
	}
	
	//ritorna quanti tentativi sono rimasti all'utente
	public int quantiRimasti() {
		return this.TMAX-this.tentativiUtente;
	}

}
