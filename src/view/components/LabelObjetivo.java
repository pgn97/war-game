package view.components;

import javax.swing.JLabel;

import controller.Observado;

public class LabelObjetivo extends JLabel implements Observador {

	public LabelObjetivo (String t) {
		this.setText(t);
	}
	@Override
	public void request(Observado o) {
		// TODO Auto-generated method stub
		
		this.setText("<html><FONT COLOR=RED>Atacante:" + o.getDados() + " </html>");
	}

}
