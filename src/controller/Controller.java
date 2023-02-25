package controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import model.Armazenamento;
import view.components.Observador;



public class Controller {
	private  Armazenamento armazena;
	private static Controller controller = null;
	private  Controller ( ) {

	}
	public static Controller getController () {
		if(controller == null) {
			controller = new Controller();
		}
		return controller;
	}
	public  void ComecaJogo (String[] nomes, String[] cores) {
		if(controller != null) {
			armazena = new Armazenamento(nomes,cores);
		}
	}
	public String[] comecaJogoSalvo (String arq) {
		armazena = new Armazenamento(arq);
		return armazena.getCoresJogadores();
	}
	public void acabaJogo () {
		controller = null;
		armazena = null;
	}
	public void colocaObservadorTerritorio (Observador o) {
		ObservadoTerritorio.getObservadoTerritorio().add(o);
	}
	public void colocaObservadorDistribui (Observador o) {
		ObservaDistribui.getObservaDistribui().add(o);
	}
	public void colocaObservadorObjetivo (Observador o) {
		ObservadoObjetivo.getObservadoObjetivo().add(o);
	}
	public void pegaCaracsTerritorio (String nome) {
		String [] array = armazena.buscaCaracTerritorio(nome);
		String dados = nome + ";" + array[0] + ";"+array[1];
		ObservadoTerritorio.getObservadoTerritorio().setDados(dados);
		ObservadoTerritorio.getObservadoTerritorio().sendRequest();
	}
	public void exercitoDistribuido (String cor,String territorio) {
		armazena.distribui_1(cor,territorio);
		pegaCaracsTerritorio(territorio);
		ObservaDistribui.getObservaDistribui().setDados(Integer.toString(armazena.buscaDistribui(cor)));
		ObservaDistribui.getObservaDistribui().sendRequest();
	}
	//Somente V1
	public void ativaVizinhos ( String cor) {
		for(String v: armazena.buscaVizinhos(cor)) {
			pegaCaracsTerritorio(v);
		}
	}
	public void pegaObjetivo (String cor) {
		
		ObservadoObjetivo.getObservadoObjetivo().setDados(armazena.pegaObjetivo(cor));
		ObservadoObjetivo.getObservadoObjetivo().sendRequest();
	}
	public void pegaExercito (String cor) {
		armazena.numeroDistribuirTer(cor);
		ObservaDistribui.getObservaDistribui().setDados(Integer.toString(armazena.buscaDistribui(cor)));
		ObservaDistribui.getObservaDistribui().sendRequest();
		
	}
	public int[] ataca( String origem, String destino) {
		return armazena.ataque( origem, destino);
	}
	public boolean podeAtacar (String atacante, String defensor) {
		return armazena.autorizaAtaque(atacante, defensor);
	}
	
	
	public String[] vitoria() {
		return armazena.testaVencedor();
	}	
	public Set<String> getCartas (String cor) {
		return armazena.buscaCartas(cor);
	}
	


	public String[] pegaCaracTerritorio (String nome) {
		return armazena.buscaCaracTerritorio(nome);
	}
	
	public void compraCarta (String cor) {
		armazena.compraCarta(cor);
	}
	public void trocaCartas (int i1,int i2, int i3, String cor) {
		 armazena.recebeTroca(i1, i2, i3, cor);
	}

}
