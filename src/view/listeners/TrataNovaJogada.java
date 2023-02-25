package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controller.Controller;
import view.telas.TelaMapa;

public class TrataNovaJogada implements ActionListener {

	JLabel atacante;
	String[] jogadores;
	int index = 0;
	int limite = 0;
	JLabel objetivo;

	public TrataNovaJogada (JLabel a,String[] j,JLabel o) {
		
		atacante = a;
		jogadores = j;
		TelaMapa.atual = jogadores[index];
		
		atacante.setText("<html><FONT COLOR=RED>Atacante:" + TelaMapa.atual + " </html>");
		
		for(int i = 0; i < jogadores.length;i++) {
			if(!jogadores[i].isEmpty()) {
				limite++;
			}
		}
		Controller.getController().pegaObjetivo(TelaMapa.atual);
		Controller.getController().pegaExercito(TelaMapa.atual);
		
		Set<String> urls = Controller.getController().getCartas(TelaMapa.atual);
		if(urls != null) {
			System.out.println("Tem Cartas");
			int i = 0;
			for(String url: urls) {
				
				try {
					TelaMapa.icon_cartas[i].setImage(ImageIO.read(new File(url)));
					TelaMapa.btn_cartas[i].setEnabled(true);
					i++;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(urls.size() > 4) {
				JOptionPane.showMessageDialog(null,"Por favor troque as suas cartas");
			}
		}



		
		

	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		TelaMapa.territorioAta = null;
		TelaMapa.territorioDef = null;
		TelaMapa.faseDistribuir = true;
		Controller.getController().compraCarta(TelaMapa.atual);
		index++;
		if (index >= limite) {
			TelaMapa.primeiraRodada = false;
			index = 0;
		}
		TelaMapa.troca[0] = -1;
		TelaMapa.troca[1] = -1;
		TelaMapa.troca[2] = -1;
		TelaMapa.ind_troca = 0;
		TelaMapa.atual = jogadores[index];
		atacante.setText("<html><FONT COLOR=RED>Atacante:" + TelaMapa.atual + " </html>");
		TelaMapa.defensor.setText("<html><FONT COLOR=YELLOW>Defensor: ---- </html>");
		//Controller.getController().reinicia();
		Controller.getController().pegaObjetivo(TelaMapa.atual);
		Controller.getController().pegaExercito(TelaMapa.atual);
		for (int i = 0; i<TelaMapa.dados.length; i++) {
			try {
				TelaMapa.dados[i].setImage(ImageIO.read(new File("./images/dado_desativado.png")));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		for (int i = 0; i < TelaMapa.btn_territorios.length; i++) {
			Controller.getController().pegaCaracsTerritorio(TelaMapa.btn_territorios[i].getToolTipText());
			
		}
		
		Set<String> urls = Controller.getController().getCartas(TelaMapa.atual);
		if(urls != null) {
			System.out.println("Tem Cartas");
			int i = 0;
			for(String url: urls) {
				
				try {
					TelaMapa.icon_cartas[i].setImage(ImageIO.read(new File(url)));
					TelaMapa.btn_cartas[i].setEnabled(true);
					i++;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(urls.size() > 4) {
				JOptionPane.showMessageDialog(null,"Por favor troque as suas cartas");
			}
		}
		else {
			for(int i = 0; i < TelaMapa.icon_cartas.length-1; i++) {
				try {
					TelaMapa.icon_cartas[i].setImage(ImageIO.read(new File("./images/war_carta_verso.png")));
					TelaMapa.btn_cartas[i].setEnabled(false);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		
		


	}

}
