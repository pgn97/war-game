package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import view.telas.TelaMapa;

public class TrataMostraCartas implements ActionListener {

	JLabel objetivo;
	private static boolean apertou = false;
	public TrataMostraCartas (JLabel o) {
		objetivo = o;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(apertou) {
			for (int i = 0; i<TelaMapa.btn_cartas.length;i++) {
				TelaMapa.btn_cartas[i].setVisible(false);
				objetivo.setVisible(false);
			}
		}
		else {
			for (int i = 0; i<TelaMapa.btn_cartas.length;i++) {
				TelaMapa.btn_cartas[i].setVisible(true);
				objetivo.setVisible(true);
			}
		}
		
		apertou = !apertou;
		
	}

}
