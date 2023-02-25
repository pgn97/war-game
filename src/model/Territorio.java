package model;


import java.util.HashSet;
import java.util.Set;

class Territorio {
	String nome;
	Cor cor;
	int numExercito;
	Set <Territorio>vizinhos;
	Continente continente;
	
	//construtor
	
	Territorio(String n, Continente c){
		nome = n;
		continente = c;
		vizinhos = new HashSet<Territorio>();
	}
	
	//sets
	
	void setCor(Cor c) {
		cor = c;
	}
	void setNumEx(int n) {
		numExercito = n;
	}
	//gets
	
	Cor getCor() {
		return cor;
	}
	 Set<Territorio> getVizinhos(){
		return vizinhos;
	}
	int getNumExe() {
		return numExercito;
	}
	
	Continente getContinente() {
		return continente;
	}
	
	String getNome() {
		return nome;
	}
	
	//ações
	
	void perdeExe(int num) {
		numExercito -= num;
	}
	void adicionaExe() {
		numExercito += 1;
	}
	void conquista (Cor c, int n) {
		cor = c;
		numExercito = n;
	}
	
	void acrescentaVizinho(Territorio t) {
		vizinhos.add(t);
		
	}
}
