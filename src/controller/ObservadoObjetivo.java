package controller;

import java.util.HashSet;
import java.util.Set;

import view.components.Observador;

public class ObservadoObjetivo implements Observado {

	private Set<Observador> set = new HashSet<Observador>(); 
	static private ObservadoObjetivo oo = null;
	private String dados = null;
	
	private ObservadoObjetivo (){
	}
	public static ObservadoObjetivo getObservadoObjetivo () {
		if(oo == null)
			oo = new ObservadoObjetivo();
		return oo;
	}
	@Override
	public void add(Observador o) {
		// TODO Auto-generated method stub
		set.add(o);
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
		this.dados= dados;
	}

}
