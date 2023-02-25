package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;

import controller.Controller;
import view.telas.TelaMapa;

public class TrataPararDistribuir implements ActionListener {

	public TrataPararDistribuir (){
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		TelaMapa.faseDistribuir = false;
		Controller.getController().ativaVizinhos(TelaMapa.atual);
		
		
		
	}



}
