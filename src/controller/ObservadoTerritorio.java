package controller;

import java.util.HashSet;
import java.util.Set;

import view.components.Observador;

 class ObservadoTerritorio implements Observado {

	private String dados = null;
	
	private Set<Observador> set = new HashSet<Observador>(); 
	static private ObservadoTerritorio ot = null;
	
	private ObservadoTerritorio (){
	}
	
	static ObservadoTerritorio getObservadoTerritorio () {
		if(ot == null) {
			ot = new ObservadoTerritorio();
		}
		return ot;
	}
	@Override
	public void sendRequest() {
		// TODO Auto-generated method stub
		for(Observador o: set) {
			o.request(this);
		}
	}

	@Override
	public String getDados() {
		// TODO Auto-generated method stub
		return dados;
	}
	@Override
	public void setDados(String dados) {
		// TODO Auto-generated method stub
		this.dados = dados;
	}

	@Override
	public void add(Observador o) {
		// TODO Auto-generated method stub
		set.add(o);
	}

}
