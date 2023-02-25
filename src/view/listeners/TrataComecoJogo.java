package view.listeners;

import java.awt.Component;
import controller.Controller;
import view.telas.TelaMapa;
import view.telas.TelaPrincipal;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TrataComecoJogo implements ActionListener {

	JTextField[] jogadores;
	JList[] cores;
	
	public TrataComecoJogo(JTextField[] j,JList[] c ) {
		jogadores = j;
		cores = c;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Set<String> c;
		c = fazSetCores(cores);
		Component parentComponent = null;
		if (c == null) {
			JOptionPane.showMessageDialog(parentComponent, "A cores precisam ser diferentes");
		}
		else {
			String[] parametro_cores = new String[c.size()];
			String[] parametro_jogadores = new String[c.size()];
			int i = 0;
			int index;
			for(String s: c) {
				index = busca(cores,s);
				if(index > -1) {
					parametro_cores[i] = s;
					parametro_jogadores[i] = jogadores[index].getText();
					
					i++;
				}
			}
			if(parametro_cores.length > 2) {
				TelaMapa.getTelaMapa().constroiMapa(parametro_jogadores, parametro_cores);
				TelaPrincipal.getTelaPrincipal().dispose();
			}
			else {
				JOptionPane.showMessageDialog(parentComponent, "Minimo 3 jogadores");
			}

				



		}
	}
	private static Set<String> fazSetCores (JList[] cores) {
		Set<String> c = new HashSet<String>();
		String val;
		for (int i = 0; i < cores.length; i++) {
			val = (String)cores[i].getSelectedValue();
			
			if(val != null) {
				if(c.contains(val)) return null;
				
				c.add(val);
			}
		}
		if(c.size() == 0) {
			return null;
		}
		return c;
	}
	private static int busca (JList[] cores, String c) {
		for(int i =0; i < cores.length; i++) {
			String val = (String)cores[i].getSelectedValue();
			if(c.contentEquals(val)) {
				return i;
			}
		}
		return -1;
	}
	

}
