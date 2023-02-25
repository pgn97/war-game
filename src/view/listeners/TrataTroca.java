package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import controller.Controller;
import view.telas.TelaMapa;

public class TrataTroca implements ActionListener {

	public TrataTroca () {
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		// TODO Auto-generated method stub
		boolean testa = true;
		for(int i = 0;i < TelaMapa.troca.length; i++) {
			System.out.println(TelaMapa.troca[i]);
			if(TelaMapa.troca[i] == -1) {
				testa = false;
			}
		}
		if(testa) {
			System.out.println("Pode Trocar");
			Controller.getController().trocaCartas(TelaMapa.troca[0], TelaMapa.troca[1], TelaMapa.troca[2], TelaMapa.atual);
			Controller.getController().pegaExercito(TelaMapa.atual);
			try {
				TelaMapa.icon_cartas[TelaMapa.troca[0]].setImage(ImageIO.read(new File("./images/war_carta_verso.png")));
				TelaMapa.btn_cartas[TelaMapa.troca[0]].setEnabled(false);
				TelaMapa.icon_cartas[TelaMapa.troca[1]].setImage(ImageIO.read(new File("./images/war_carta_verso.png")));
				TelaMapa.btn_cartas[TelaMapa.troca[1]].setEnabled(false);
				TelaMapa.icon_cartas[TelaMapa.troca[2]].setImage(ImageIO.read(new File("./images/war_carta_verso.png")));
				TelaMapa.btn_cartas[TelaMapa.troca[2]].setEnabled(false);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}
		
		

	}

}
