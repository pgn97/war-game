package model;

class Jogador {

	String nome;
	Cor cor;
	Objetivo objetivo;
	int numTerritorio;
	int distribuiExe;
	Continente []continente;
	Carta []carta;
	int[] distribuiCont = {0, 0, 0, 0, 0, 0};
	boolean compra = false;
	String getNome() {
		return nome;
	}
	
	Jogador(String n, Cor c){
		nome = n;
		cor = c;
		numTerritorio = 0;
		distribuiExe = 0;
		carta = new Carta[0];
		continente = new Continente[0];
	}

	void aumentaTer() {
		numTerritorio++;
	}
	void diminuiExercitoTerritorio (int i) {
		numTerritorio -= i;
	}
	int getNumTerritorio() {
		return numTerritorio;
	}
	Cor getCor() {
		return cor;
	}
	
	Objetivo getObjetivo() {
		return objetivo;
	}
	
	void setNumTerritorio(int num) {
		numTerritorio = num;
	}
	void setObjetivo (Objetivo o) {
		objetivo = o;
	}
	Carta [] getArrayCartas() {
		return carta;
	}
	
	void adicionaCarta (Carta c) {
		Carta[] temp = new Carta [carta.length + 1]; 
		for (int i = 0; i < carta.length; i++) {
			temp[i] = carta[i];
		}
		temp[carta.length] = c; // antes era temp[carta.length + 1] = c; mas eu troquei pq se o tamanho eh n+1, o ultimo indice é n
		setCartas(temp);
	}
	
	void setCartas(Carta[] c) {
		carta = c;
	}
	void novoContinente(Continente c) {
		Continente[] temp = new Continente [continente.length + 1]; 
		for (int i = 0; i < continente.length; i++) {
			temp[i] = continente[i];
		}
		temp[continente.length] = c;
		continente = temp;
	}
	Continente[] getContinente() {
		return continente;
	}
	int getDistribuiExe () {
		return distribuiExe;
	}
	void distribuiu () {
		distribuiExe--;
	}
	void aumentaExe (int num) {
		distribuiExe += num;
	}
	void podeComprar() {
		compra = true;
	}
	boolean getCompra () {
		return compra;
	}
	void jaComprou () {
		compra = false;
	}

	public void aumentaExe(int num, int i) {
		distribuiCont[i]+=num;
		
	}

	public int[] getDistribuiCont() {
		return distribuiCont;
	}

	public void distribuiu(int i) {
		distribuiCont[i]--;
		
	}
	void perdeTer() {
		numTerritorio--;
	}

}
