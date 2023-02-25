package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.telas.TelaMapa;
import view.telas.TelaPrincipal;

public class TrataComecoJogoSalvo implements ActionListener {

	String nomeArq;
	public TrataComecoJogoSalvo (String arq) {
		nomeArq = arq;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		TelaMapa.getTelaMapa().constroiMapaComArquivo(nomeArq);
		TelaPrincipal.getTelaPrincipal().dispose();
		
	}

}
