package view.telas;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;
import javax.swing.*;

import controller.Controller;
import view.components.BotaoTerritorio;
import view.components.LabelDistribui;
import view.components.LabelObjetivo;
import view.components.PainelImagem;
import view.listeners.TrataBotaoCarta;
import view.listeners.TrataMostraCartas;
import view.listeners.TrataNovaJogada;
import view.listeners.TrataNovoLancamento;
import view.listeners.TrataPararDistribuir;
import view.listeners.TrataTerritorio;
import view.listeners.TrataTroca;

public class TelaMapa extends JFrame  {

	public static String atual = null;
	public static JLabel defensor = null;
	public static BotaoTerritorio[] btn_territorios = null;
	public static boolean primeiraRodada = true;
	public static boolean faseDistribuir = true;
	public static String territorioAta = null;
	public static String territorioDef = null;
	public static ImageIcon[] dados = null;
	public static ImageIcon[] icon_cartas = null;
	public static JButton [] btn_cartas = null;
	public static int[] troca = {-1,-1,-1};
	public static int ind_troca = 0;
	private static String[] cores;
	private static TelaMapa telaMapa = null;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TelaMapa() {
		super("MAPA");
	}
	static public TelaMapa getTelaMapa() {
		if(telaMapa == null) {
			telaMapa = new TelaMapa();
		}
		return telaMapa;
	}
	public  void constroiMapa(String[] n, String [] c) {
		
		cores = c;
		Controller.getController().ComecaJogo(n, c);
		constroiJogo();
		this.setVisible(true);
	}
	public void constroiMapaComArquivo(String arq) {
		
		cores = Controller.getController().comecaJogoSalvo(arq);
		constroiJogo();
		this.setVisible(true);
	}
	public void fechaTela () {
		this.dispose();
	}
	private void constroiJogo () {
		try {
			BufferedImage fundo = ImageIO.read(new File("./images/war_tabuleiro_fundo.png"));
			Graphics2D graphics = fundo.createGraphics();
			JPanel pfundo = new PainelImagem(fundo,0,0);
			
			BufferedImage mapa = ImageIO.read(new File("./images/war_tabuleiro_mapa copy.png"));
			int w_mapa = mapa.getWidth();
			int h_mapa = mapa.getHeight();
			graphics.drawImage(mapa, 0,0,w_mapa,h_mapa,null);
			
			
			
			LabelDistribui exercito = new LabelDistribui("<html><FONT COLOR=BLACK>Exercito para distribuir: 30</html>");
			Controller.getController().colocaObservadorDistribui(exercito);
			exercito.setBounds(25,25,100,100);
			getContentPane().add(exercito);

			
			JLabel ataque = new JLabel("<html><FONT COLOR=RED>Dados de Ataque:</html>");
			ataque.setBounds(25,25,120,25);
			getContentPane().add(ataque);
			
			ImageIcon da1 = new ImageIcon("./images/dado_desativado.png");
			JButton dado_ataque1 = new JButton("",da1);
			dado_ataque1.setOpaque(false);
			dado_ataque1.setContentAreaFilled(false);
			dado_ataque1.setBorderPainted(false);
			dado_ataque1.setBounds(130, 20, da1.getIconWidth(), da1.getIconHeight());
			getContentPane().add(dado_ataque1);
			
			ImageIcon da2 = new ImageIcon("./images/dado_desativado.png");
			JButton dado_ataque2 = new JButton("",da2);
			dado_ataque2.setOpaque(false);
			dado_ataque2.setContentAreaFilled(false);
			dado_ataque2.setBorderPainted(false);
			dado_ataque2.setBounds(170, 20, da2.getIconWidth(), da2.getIconHeight());
			getContentPane().add(dado_ataque2);
			
			ImageIcon da3 = new ImageIcon("./images/dado_desativado.png");
			JButton dado_ataque3 = new JButton("",da3);
			dado_ataque3.setOpaque(false);
			dado_ataque3.setContentAreaFilled(false);
			dado_ataque3.setBorderPainted(false);
			dado_ataque3.setBounds(210, 20, da3.getIconWidth(), da3.getIconHeight());
			getContentPane().add(dado_ataque3);
			
			
			JLabel defesa = new JLabel("<html><FONT COLOR=YELLOW>Dados de Defesa:</html>");
			defesa.setBounds(250,25,100,25);
			getContentPane().add(defesa);
			
			ImageIcon dd1 = new ImageIcon("./images/dado_desativado.png");
			JButton dado_defesa1 = new JButton("",dd1);
			dado_defesa1.setOpaque(false);
			dado_defesa1.setContentAreaFilled(false);
			dado_defesa1.setBorderPainted(false);
			dado_defesa1.setBounds(360, 20, dd1.getIconWidth(), dd1.getIconHeight());
			getContentPane().add(dado_defesa1);
			
			ImageIcon dd2 = new ImageIcon("./images/dado_desativado.png");
			JButton dado_defesa2 = new JButton("",dd2);
			dado_defesa2.setOpaque(false);
			dado_defesa2.setContentAreaFilled(false);
			dado_defesa2.setBorderPainted(false);
			dado_defesa2.setBounds(400, 20, dd2.getIconWidth(), dd2.getIconHeight());
			getContentPane().add(dado_defesa2);
			
			ImageIcon dd3 = new ImageIcon("./images/dado_desativado.png");
			JButton dado_defesa3 = new JButton("",dd3);
			dado_defesa3.setOpaque(false);
			dado_defesa3.setContentAreaFilled(false);
			dado_defesa3.setBorderPainted(false);
			dado_defesa3.setBounds(440, 20, dd3.getIconWidth(), da3.getIconHeight());
			getContentPane().add(dado_defesa3);
			
			ImageIcon c1 = new ImageIcon("./images/war_carta_verso.png");
			JButton carta1 = new JButton("",c1);
			carta1.setVisible(false);
			carta1.setOpaque(false);
			carta1.setContentAreaFilled(false);
			carta1.setBounds(50,150, c1.getIconWidth(), c1.getIconHeight());
			carta1.addActionListener(new TrataBotaoCarta(0));
			carta1.setEnabled(false);
			getContentPane().add(carta1);
			
			ImageIcon c2 = new ImageIcon("./images/war_carta_verso.png");
			JButton carta2 = new JButton("",c2);
			carta2.setVisible(false);
			carta2.setOpaque(false);
			carta2.setContentAreaFilled(false);
			carta2.setBounds(200,150, c2.getIconWidth(), c2.getIconHeight());
			carta2.addActionListener(new TrataBotaoCarta(1));
			carta2.setEnabled(false);
			getContentPane().add(carta2);
			
			ImageIcon c3 = new ImageIcon("./images/war_carta_verso.png");
			JButton carta3 = new JButton("",c3);
			carta3.setVisible(false);
			carta3.setOpaque(false);
			carta3.setContentAreaFilled(false);
			carta3.setBounds(350,150, c3.getIconWidth(), c3.getIconHeight());
			carta3.addActionListener(new TrataBotaoCarta(2));
			carta3.setEnabled(false);
			getContentPane().add(carta3);
			
			ImageIcon c4 = new ImageIcon("./images/war_carta_verso.png");
			JButton carta4 = new JButton("",c4);
			carta4.setVisible(false);
			carta4.setOpaque(false);
			carta4.setContentAreaFilled(false);
			carta4.setBounds(500,150, c4.getIconWidth(), c4.getIconHeight());
			carta4.addActionListener(new TrataBotaoCarta(3));
			carta4.setEnabled(false);
			getContentPane().add(carta4);
			
			ImageIcon c5 = new ImageIcon("./images/war_carta_verso.png");
			JButton carta5 = new JButton("",c5);
			carta5.setVisible(false);
			carta5.setOpaque(false);
			carta5.setContentAreaFilled(false);
			carta5.setBounds(650,150, c5.getIconWidth(), c5.getIconHeight());
			carta5.addActionListener(new TrataBotaoCarta(4));
			carta5.setEnabled(false);
			getContentPane().add(carta5);
			
			LabelObjetivo objetivo_label = new LabelObjetivo("<html><FONT COLOR=BLACK>Exemplo de objetivo</html>");
			Controller.getController().colocaObservadorObjetivo(objetivo_label);
			
			objetivo_label.setBounds(820,100,100,300);
			getContentPane().add(objetivo_label);
			objetivo_label.setVisible(false);
			
			ImageIcon o1 = new ImageIcon("./images/war_carta_objetivo.png");
			JButton objetivo = new JButton("",o1);
			objetivo.setVisible(false);
			objetivo.setOpaque(false);
			objetivo.setContentAreaFilled(false);
			objetivo.setBorderPainted(false);
			objetivo.setBounds(800,150, o1.getIconWidth(), o1.getIconHeight());
			getContentPane().add(objetivo);
			
			
			
			ImageIcon[] icones = {c1,c2,c3,c4,c5,o1};
			icon_cartas = icones;
			JButton[] cartas = {carta1,carta2,carta3,carta4,carta5,objetivo};
			btn_cartas = cartas;
			JLabel atacante = new JLabel ("<html><FONT COLOR=RED>Atacante: ---- </html>");
			atacante.setBounds(480, 25, 100, 25);
			getContentPane().add(atacante);
			
			defensor = new JLabel ("<html><FONT COLOR=YELLOW>Defensor: ---- </html>");
			defensor.setBounds(600, 25, 100, 25);
			getContentPane().add(defensor);
			

			atual = cores[0];
			BotaoTerritorio[]array = {
			 colocaTerritorio(getContentPane(),"África do Sul", "AS",550,550),
			 colocaTerritorio(getContentPane(),"Angola", "AG",530,500),
			 colocaTerritorio(getContentPane(),"Argélia", "AG",450,350),
			 colocaTerritorio(getContentPane(),"Egito", "EG",550,380),
			 colocaTerritorio(getContentPane(),"Nigéria", "NI",450,420),
			 colocaTerritorio(getContentPane(),"Somália" , "SO",600,500),
			 colocaTerritorio(getContentPane(),"Alasca" , "AL",70,130),
			 colocaTerritorio(getContentPane(),"Calgary" , "CA",150,130),
			 colocaTerritorio(getContentPane(),"California", "CA",90,250),
			 colocaTerritorio(getContentPane(),"Groelândia", "GL",290,90),
			 colocaTerritorio(getContentPane(),"México", "ME",90,350),
			 colocaTerritorio(getContentPane(),"Nova York", "NY",200,250),
			 colocaTerritorio(getContentPane(),"Quebec", "QU",290,170),
			 colocaTerritorio(getContentPane(),"Texas", "TE",150,230),
			 colocaTerritorio(getContentPane(),"Vancouver", "VA",150,170),
			 colocaTerritorio(getContentPane(),"Arábia Saudita", "AS",650,400),
			 colocaTerritorio(getContentPane(),"Bangladesh", "BA",850,400),
			 colocaTerritorio(getContentPane(),"Cazaquistão", "CA",850,200),
			 colocaTerritorio(getContentPane(),"China", "CI",780,280),
			 colocaTerritorio(getContentPane(),"Coreia do Norte", "CN",850,300),
			 colocaTerritorio(getContentPane(),"Coreia do Sul", "CS",850,320),
			 colocaTerritorio(getContentPane(),"Estônia", "ET",650,120),
			 colocaTerritorio(getContentPane(),"Índia", "IN",780,400),
			 colocaTerritorio(getContentPane(),"Irã", "IR",700,320),
			 colocaTerritorio(getContentPane(),"Iraque", "IQ",650,320),
			 colocaTerritorio(getContentPane(),"Japão", "JP",930,270),
			 colocaTerritorio(getContentPane(),"Jordânia", "JO",600,320),
			 colocaTerritorio(getContentPane(),"Letônia", "LT",650,180),
			 colocaTerritorio(getContentPane(),"Mongólia", "MO",850,240),
			 colocaTerritorio(getContentPane(),"Paquistão", "PA",700,280),
			 colocaTerritorio(getContentPane(),"Rússia", "RU",800,120),
			 colocaTerritorio(getContentPane(),"Sibéria", "SI",870,120),
			 colocaTerritorio(getContentPane(),"Síria", "SI",630,280),
			 colocaTerritorio(getContentPane(),"Tailândia", "TA",850,360),
			 colocaTerritorio(getContentPane(),"Turquia", "TU",700,240),
			 colocaTerritorio(getContentPane(),"Argentina", "AG",260,550),
			 colocaTerritorio(getContentPane(),"Brasil", "BR",260,450),
			 colocaTerritorio(getContentPane(),"Peru", "PE",230,500),
			 colocaTerritorio(getContentPane(),"Venezuela", "VE",180,420),
			 colocaTerritorio(getContentPane(),"Espanha", "ES",410,280),
			 colocaTerritorio(getContentPane(),"França", "FA",450,230),
			 colocaTerritorio(getContentPane(),"Itália", "IT",510,230),
			 colocaTerritorio(getContentPane(),"Polônia", "PO",550,180),
			 colocaTerritorio(getContentPane(),"Reino Unido", "RU",450,120),
			 colocaTerritorio(getContentPane(),"Romênia", "RO",560,280),
			 colocaTerritorio(getContentPane(),"Suécia", "SU",510,120),
			 colocaTerritorio(getContentPane(),"Ucrânia", "UC",600,230),
			 colocaTerritorio(getContentPane(),"Austrália", "AU",850,600),
			 colocaTerritorio(getContentPane(),"Indonésia", "ID",850,500),
			 colocaTerritorio(getContentPane(),"Nova Zelândia", "NZ",900,630),
			 colocaTerritorio(getContentPane(),"Perth", "PE",750,600)
			};
			btn_territorios = array;
			atual = null;
			

			ImageIcon jogaDadosImagem = new ImageIcon("./images/war_btnJogarDados.png");
			JButton jogaDados = new JButton ("", jogaDadosImagem);
			jogaDados.setBounds(840, 23, jogaDadosImagem.getIconWidth(), jogaDadosImagem.getIconHeight());
			jogaDados.setOpaque(false);
			jogaDados.setContentAreaFilled(false);
			jogaDados.setToolTipText("Jogar Dados");
			ImageIcon[] darray = {da1,da2,da3,dd1,dd2,dd3};
			dados = darray;
			jogaDados.addActionListener(new TrataNovoLancamento( ));
			getContentPane().add(jogaDados);
			
			ImageIcon mostraCartasImagem = new ImageIcon("./images/war_iconeCartas.png");
			JButton mostraCartas = new JButton ("", mostraCartasImagem);
			mostraCartas.setBounds(740, 3, mostraCartasImagem.getIconWidth(), mostraCartasImagem.getIconHeight());
			mostraCartas.setOpaque(false);
			mostraCartas.setContentAreaFilled(false);
			mostraCartas.setToolTipText("Mostrar Cartas");
			mostraCartas.addActionListener(new TrataMostraCartas(objetivo_label));
			getContentPane().add(mostraCartas);
			
			JButton btn_acabouDis = new JButton("Parar Distribuir");
			btn_acabouDis.setBounds(120,65,130,20);
			btn_acabouDis.addActionListener(new TrataPararDistribuir ());
			getContentPane().add(btn_acabouDis);
			
			JButton btn_troca = new JButton("Trocar Cartas");
			btn_troca.setBounds(600,65,130,20);
			btn_troca.addActionListener(new TrataTroca ());
			getContentPane().add(btn_troca);
			
			ImageIcon proximoImagem = new ImageIcon("./images/war_btnProxJogada.png");
			JButton proximo = new JButton ("", proximoImagem);
			proximo.setBounds(910, 20, proximoImagem.getIconWidth(), proximoImagem.getIconHeight());
			proximo.setOpaque(false);
			proximo.setContentAreaFilled(false);
			proximo.setToolTipText("Proxima Jogada");
			TrataNovaJogada tnj = new TrataNovaJogada(atacante,cores,objetivo_label);
			proximo.addActionListener(tnj);
			getContentPane().add(proximo);
			
			graphics.dispose();
			getContentPane().add(pfundo);
			

			setSize(1000,730);
		} catch (IOException e) {
			System.out.println(e);
			System.exit(1);
		}
		
	}
	private static BotaoTerritorio colocaTerritorio (Container c, String nome,String sigla, int cord_x, int cord_y) {
		BotaoTerritorio territorio = new BotaoTerritorio(nome,sigla);
		territorio.setBounds(cord_x, cord_y, 70, 25);
		territorio.addActionListener(new TrataTerritorio(nome));
		//territorio.setOpaque(false);
		//territorio.setContentAreaFilled(false);
		Controller.getController().colocaObservadorTerritorio(territorio);
		Controller.getController().pegaCaracsTerritorio(nome);
		c.add(territorio);
		return territorio;
	}
	/*Area para Testes
	public static void main(String[] args) {
		String [] jogadores = {"Test1","Test2","Test3","Test4","Test5","Test6"};
		String [] cores = {"azul","vermelho","verde","preto","branco","amarelo"};
		TelaMapa tm = new TelaMapa(jogadores,cores);
		tm.setVisible(true);
	}
	*/
	
}
