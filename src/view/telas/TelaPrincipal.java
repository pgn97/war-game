package view.telas;


import java.awt.*;
import java.io.*;

import javax.imageio.*;
import javax.swing.*;

import controller.Controller;
import view.components.Background;
import view.listeners.TrataComecoJogo;
import view.listeners.TrataComecoJogoSalvo;
//Classe responsavel pela construcao da Tela principal
public class TelaPrincipal extends JFrame{
	private static TelaPrincipal telaPrincipal = null;
	
	private TelaPrincipal () {
		super("NOVO JOGO");
	}
	public static TelaPrincipal getTelaPrincipal () {
		if (telaPrincipal == null)
			telaPrincipal = new TelaPrincipal();
		return telaPrincipal;
	}
	public void constroiTela(){
		
		try {
			
			/*---------------PARTE DA IMAGEM DE FUNDO DA TELA--------------*/
			Image i = ImageIO.read(new File ("./images/bgconfiguracao.png"));
			JComponent p = new Background(i,0,0);
			this.setContentPane(p);

			/*-----------------------------------------------------------------------*/
			
			/*-------------------------------Parte Form e botao---------------------*/
			int altura = 175;
			JLabel lj;
			JLabel lc;
			JTextField jogador[] = {new JTextField(),new JTextField(),new JTextField(),new JTextField(),new JTextField(),new JTextField()};
			String[] cores = {"vermelho","azul","amarelo","preto","branco","verde"};
			JList[] cor = {new JList(cores),new JList(cores),new JList(cores),new JList(cores),new JList(cores),new JList(cores)};
			JScrollPane sp;
			JButton comecar = new JButton("Comecar");
			
			JButton salvo1 = new JButton ("J1");
			JButton salvo2 = new JButton ("J2");
			JButton salvo3 = new JButton ("J3");
			JButton salvo4 = new JButton ("J4");
			for (int cont = 0; cont < 6; cont++) {
				
				lj = new JLabel ("<html><FONT COLOR=WHITE>Jogador" + (cont+1) +":</html>");
				lj.setBounds(25,altura,100,25);
				getContentPane().add(lj);
				
				lc = new JLabel ("<html><FONT COLOR=RED>Cor" + (cont+1) +":</html>");
				lc.setBounds(198,altura,100,25);
				getContentPane().add(lc);
				
				
				jogador[cont].setBounds(85,altura,100,25);
				getContentPane().add(jogador[cont]);
				
				cor[cont].setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				sp = new JScrollPane();
				sp.setViewportView(cor[cont]);
				sp.setBounds(230,altura,100,25);
				getContentPane().add(sp);
				
				altura += 50;
			}
			
			salvo1.setBounds(10,110,50,30);
			salvo2.setBounds(70,110,50,30);
			salvo3.setBounds(130,110,50,30);
			salvo4.setBounds(190,110,50,30);
			salvo1.addActionListener(new TrataComecoJogoSalvo("./salvamento/J1_numTerritorios_territorios24_Egito_Nigeria.txt"));
			salvo2.addActionListener(new TrataComecoJogoSalvo("./salvamento/J1_eliminaCor_azuis_California_Mexico.txt"));
			salvo3.addActionListener(new TrataComecoJogoSalvo("./salvamento/J1_continente_AfricaAsia_AfricaSul_Angola.txt"));
			salvo4.addActionListener(new TrataComecoJogoSalvo("./salvamento/Troca_cartas_J1_J2_J3.txt"));
			
			comecar.setBounds(130,500,100,30);
			comecar.addActionListener(new TrataComecoJogo(jogador,cor));
			getContentPane().add(salvo1);
			getContentPane().add(salvo2);
			getContentPane().add(salvo3);
			getContentPane().add(salvo4);
			getContentPane().add(comecar);
			/*---------------------------------------------------------------------------------*/
			
			
			
			
			
			
			setSize(395,600);
			this.setVisible(true);
			
		} catch (IOException e) {
			System.out.println(e);
			System.exit(1);
		}
		
	}
	public void fechaTela () {
		this.dispose();
	}

	public static void main(String[] args) {
		 TelaPrincipal.getTelaPrincipal ().constroiTela();
		 
		
	}
	

	
}
