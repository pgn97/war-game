package view.components;

import javax.swing.JLabel;

import controller.Observado;

public class LabelDistribui extends JLabel implements Observador {

	public LabelDistribui (String texto){
		this.setText(texto);
	}
	@Override
	public void request(Observado o) {
		// TODO Auto-generated method stub
		this.setText("<html><FONT COLOR=BLACK>Exercito para distribuir: " + o.getDados() +"</html>");
	}

}
