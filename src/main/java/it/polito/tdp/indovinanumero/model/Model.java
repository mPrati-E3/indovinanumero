package it.polito.tdp.indovinanumero.model;

public class Model {
	
	private final int NMAX = 100;
	private final int TMAX = 8;
	private int segreto;
	private int tentativiUtente;
	
	public Model () {
		this.tentativiUtente=0;
	}
	
	public void NuovaPartita() {
    	//------------Set della logica del gioco------------
    	
    	//genera numero segreto
    	this.segreto = (int)(Math.random() * NMAX)+1;
    	//azzera i tentativi dell'utente
    	this.tentativiUtente=0;
	}
	
	public int FaiTentativo(int t) {
		
		//numero nell'intervallo?
		if (!tentativoValido(t)) {
			return 3;
		}
		
    	//aumento i tentativi fatti dall'utente
    	this.tentativiUtente++;
    	
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
    		return -1;
    	} else {
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
	
	//valuta se il tentativo è valido (è nell'intervallo)
	private boolean tentativoValido(int t) {
		if (t<1 || t>NMAX) {
			return false;
		}
		
		return true;
	}
	
	//ritorna quanti tentativi sono rimasti all'utente
	public int quantiRimasti() {
		return this.TMAX-this.tentativiUtente;
	}

}
