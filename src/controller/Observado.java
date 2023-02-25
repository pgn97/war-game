package controller;

import view.components.Observador;

public interface Observado {

	public void add(Observador o);
	public void sendRequest ();
	public String getDados ();
	public void setDados (String dados);
}
