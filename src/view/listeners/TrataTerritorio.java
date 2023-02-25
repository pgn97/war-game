package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.text.Document;

import controller.Controller;
import view.components.BotaoTerritorio;
import view.telas.TelaMapa;

public class TrataTerritorio implements ActionListener {

	String territorio;
	public TrataTerritorio (String t) {
		territorio = t;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(TelaMapa.faseDistribuir) {
			Controller.getController().exercitoDistribuido(TelaMapa.atual, territorio);
			
		}
		else {
			
			for(int i = 0; i < TelaMapa.btn_territorios.length; i++) {
				BotaoTerritorio botao = TelaMapa.btn_territorios[i];
				if(territorio.equals(botao.getToolTipText())) {
					
					if(botao.getCor().equals(TelaMapa.atual)) {
						TelaMapa.territorioAta = TelaMapa.btn_territorios[i].getToolTipText();
					}
					else {
						TelaMapa.territorioDef = TelaMapa.btn_territorios[i].getToolTipText();
						TelaMapa.defensor.setText("<html><FONT COLOR=YELLOW>Defensor:" + botao.getCor() +"</html>");
					}
					
				}
			}
			if(TelaMapa.territorioAta != null && TelaMapa.territorioDef != null) {
				if(Controller.getController().podeAtacar(TelaMapa.territorioAta, TelaMapa.territorioDef))
					JOptionPane.showMessageDialog(null,TelaMapa.territorioAta + "--->" + TelaMapa.territorioDef );
				else
					JOptionPane.showMessageDialog(null,"Ataque invalido!, selecione outro territorio");
			}
		}
		
		

	}


}
