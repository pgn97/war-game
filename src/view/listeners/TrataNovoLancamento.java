package view.listeners;



import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import controller.Controller;
import view.telas.TelaMapa;
import view.telas.TelaPrincipal;


public class TrataNovoLancamento implements ActionListener {


	public TrataNovoLancamento () {
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(TelaMapa.atual!= null && TelaMapa.territorioAta!= null && TelaMapa.territorioDef != null) {
			
			int [] resultados = Controller.getController().ataca( TelaMapa.territorioAta, TelaMapa.territorioDef);
			
			for(int i = 0; i < resultados.length; i++) {
				try {
					if(resultados[i] != 0) {
						if(i<3) {
							TelaMapa.dados[i].setImage(ImageIO.read(new File("./images/dado_ataque_" + resultados[i] + ".png")));
						}
						else {
							TelaMapa.dados[i].setImage(ImageIO.read(new File("./images/dado_defesa_" + resultados[i] + ".png")));
						}
					}
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			Controller.getController().pegaCaracsTerritorio(TelaMapa.territorioAta);
			Controller.getController().pegaCaracsTerritorio(TelaMapa.territorioDef);
			if(Controller.getController().vitoria()[0] == "SIM") {
				JOptionPane.showMessageDialog(null,"VENCEDOR DO JOGO: " + Controller.getController().vitoria()[1]);
				TelaMapa.getTelaMapa().fechaTela();
				
			}
			
		}
		else {
			JOptionPane.showMessageDialog(null,"Escolha os territorios por favor");
		}


		
		

	}

}
