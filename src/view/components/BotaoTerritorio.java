package view.components;

import java.awt.Color;

import javax.swing.JButton;

import controller.Observado;
import view.telas.TelaMapa;

public class BotaoTerritorio extends JButton implements Observador {

	String nome;
	String sigla;
	String cor =  null;;
	 public BotaoTerritorio(String n, String s) {
		nome = n;
		sigla = s;
		this.setText(sigla);
		this.setToolTipText(nome);
		
	}
	@Override
	public void request(Observado o) {
		String dados = o.getDados();
		String[] array = dados.split(";");
		if(nome.equals(array[0])) {
			
			this.setText("<html><FONT COLOR=" + array[1] + ">" + sigla + ": "+ array[2] + "</html>");
			cor = traduzIngles(array[1]);
			if(TelaMapa.faseDistribuir) {	
				if(cor.equals(TelaMapa.atual)) {
					this.setEnabled(true);
				}
				else {
					
					this.setEnabled(false);
				}
			}
			else {
				this.setEnabled(true);
			}

		}
		




	}
	public String getCor () {
		return cor;
	}
	private String traduzIngles (String s) {
		if(s.equals("ORANGE") ) {
			return "amarelo";
		}
		else if (s.equals("BLACK") ) {
			return "preto";
		}
		else if( s.equals("BLUE")) {
			return "azul";
		}
		else if(s.equals("RED")) {
			return "vermelho";
		}
		else if(s.equals("PURPLE")) {
			return "branco";
		}
		else {
			return "verde";
		}
	}
	public String getNome () {
		return nome;
	}

}
