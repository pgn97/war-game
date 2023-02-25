package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.telas.TelaMapa;

public class TrataBotaoCarta implements ActionListener {

	int num;
	public TrataBotaoCarta (int n) {
		num = n;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(TelaMapa.ind_troca > 2) {
			TelaMapa.ind_troca = 0;
		}
		TelaMapa.troca[TelaMapa.ind_troca] = num;
		TelaMapa.ind_troca ++;
		System.out.println("Carta: " + num);
	}

}
