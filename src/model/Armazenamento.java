package model;

import java.util.Random;// para poder rolar os dados
import java.util.Set;
import java.util.TreeSet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Armazenamento {

	static Jogador[] jogadores;
	static Objetivo [] objetivos = {Objetivo.EuropaOceaniaTerceiro, Objetivo.AsiaAmericaDoSul, Objetivo.EuropaAmericaDoSulTerceiro, 
			Objetivo.dezoitoTerritoriosDoisExericitos, Objetivo.AsiaAfrica, Objetivo.AmericaDoNorteAfrica,
			Objetivo.territorios24, Objetivo.AmericaDoNorteOceania, 
			Objetivo.azuis, Objetivo.amarelos, Objetivo.vermelhos, Objetivo.pretos, Objetivo.brancos, Objetivo.verdes
	};
	Continente [] continentes = {
			Continente.AmericaDoNorte, 
			Continente.Europa, 
			Continente.Asia, 
			Continente.AmericaDoSul, 
			Continente.Africa, 
			Continente.Oceania
			};
	static Territorio[] territorios = {
			new Territorio ("África do Sul",Continente.Africa), 
			new Territorio ("Angola",Continente.Africa),
			new Territorio ("Argélia",Continente.Africa),
			new Territorio ("Egito",Continente.Africa),
			new Territorio ("Nigéria",Continente.Africa),
			new Territorio ("Somália",Continente.Africa),
			new Territorio ("Alasca",Continente.AmericaDoNorte),
			new Territorio ("Calgary",Continente.AmericaDoNorte),
			new Territorio ("California",Continente.AmericaDoNorte),
			new Territorio ("Groelândia",Continente.AmericaDoNorte),
			new Territorio ("México",Continente.AmericaDoNorte),
			new Territorio ("Nova York",Continente.AmericaDoNorte),
			new Territorio ("Quebec",Continente.AmericaDoNorte),
			new Territorio ("Texas",Continente.AmericaDoNorte),
			new Territorio ("Vancouver",Continente.AmericaDoNorte),
			new Territorio ("Arábia Saudita",Continente.Asia),
			new Territorio ("Bangladesh",Continente.Asia),
			new Territorio ("Cazaquistão",Continente.Asia),
			new Territorio ("China",Continente.Asia),
			new Territorio ("Coreia do Norte",Continente.Asia),
			new Territorio ("Coreia do Sul",Continente.Asia),
			new Territorio ("Estônia",Continente.Asia),
			new Territorio ("Índia",Continente.Asia),
			new Territorio ("Irã",Continente.Asia),
			new Territorio ("Iraque",Continente.Asia),
			new Territorio ("Japão",Continente.Asia),
			new Territorio ("Jordânia",Continente.Asia),
			new Territorio ("Letônia",Continente.Asia),
			new Territorio ("Mongólia",Continente.Asia),
			new Territorio ("Paquistão",Continente.Asia),
			new Territorio ("Rússia",Continente.Asia),
			new Territorio ("Sibéria",Continente.Asia),
			new Territorio ("Síria",Continente.Asia),
			new Territorio ("Tailândia",Continente.Asia),
			new Territorio ("Turquia",Continente.Asia),
			new Territorio ("Argentina",Continente.AmericaDoSul),
			new Territorio ("Brasil",Continente.AmericaDoSul),
			new Territorio ("Peru",Continente.AmericaDoSul),
			new Territorio ("Venezuela",Continente.AmericaDoSul),
			new Territorio ("Espanha", Continente.Europa),
			new Territorio ("França", Continente.Europa),
			new Territorio ("Itália", Continente.Europa),
			new Territorio ("Polônia", Continente.Europa),
			new Territorio ("Reino Unido", Continente.Europa),
			new Territorio ("Romênia", Continente.Europa),
			new Territorio ("Suécia", Continente.Europa),
			new Territorio ("Ucrânia", Continente.Europa),
			new Territorio ("Austrália", Continente.Oceania),
			new Territorio ("Indonésia", Continente.Oceania),
			new Territorio ("Nova Zelândia", Continente.Oceania),
			new Territorio ("Perth", Continente.Oceania)
			} ;
	Carta[] temp = {
			new Carta (Geometria.triangulo, territorios[0],"./images/war_carta_af_africadosul.png"),
			new Carta (Geometria.retangulo, territorios[1],"./images/war_carta_af_angola.png"),
			new Carta (Geometria.circulo, territorios[2],"./images/war_carta_af_argelia.png"),
			new Carta (Geometria.triangulo, territorios[3],"./images/war_carta_af_egito.png"),
			new Carta (Geometria.circulo, territorios[4],"./images/war_carta_af_nigeria.png"),
			new Carta (Geometria.retangulo, territorios[5],"./images/war_carta_af_somalia.png"),
			new Carta (Geometria.triangulo, territorios[6],"./images/war_carta_an_alasca.png"),
			new Carta (Geometria.circulo, territorios[7],"./images/war_carta_an_calgary.png"),
			new Carta (Geometria.retangulo, territorios[8],"./images/war_carta_an_california.png"),
			new Carta (Geometria.circulo, territorios[9],"./images/war_carta_an_groelandia.png"),
			new Carta (Geometria.retangulo, territorios[10],"./images/war_carta_an_mexico.png"),
			new Carta (Geometria.retangulo, territorios[11],"./images/war_carta_an_novayork.png"),
			new Carta (Geometria.circulo, territorios[12],"./images/war_carta_an_quebec.png"),
			new Carta (Geometria.triangulo, territorios[13],"./images/war_carta_an_texas.png"),
			new Carta (Geometria.triangulo, territorios[14],"./images/war_carta_an_vancouver.png"),
			new Carta (Geometria.circulo, territorios[15],"./images/war_carta_as_arabiasaudita.png"),
			new Carta (Geometria.circulo, territorios[16],"./images/war_carta_as_bangladesh.png"),
			new Carta (Geometria.circulo, territorios[17],"./images/war_carta_as_cazaquistao.png"),
			new Carta (Geometria.retangulo, territorios[18],"./images/war_carta_as_china.png"),
			new Carta (Geometria.retangulo, territorios[19],"./images/war_carta_as_coreiadonorte.png"),
			new Carta (Geometria.triangulo, territorios[20],"./images/war_carta_as_coreiadosul.png"),
			new Carta (Geometria.circulo, territorios[21],"./images/war_carta_as_estonia.png"),
			new Carta (Geometria.triangulo, territorios[22],"./images/war_carta_as_india.png"),
			new Carta (Geometria.retangulo, territorios[23],"./images/war_carta_as_ira.png"),
			new Carta (Geometria.triangulo, territorios[24],"./images/war_carta_as_iraque.png"),
			new Carta (Geometria.circulo, territorios[25],"./images/war_carta_as_japao.png"),
			new Carta (Geometria.retangulo, territorios[26],"./images/war_carta_as_jordania.png"),
			new Carta (Geometria.retangulo, territorios[27],"./images/war_carta_as_letonia.png"),
			new Carta (Geometria.triangulo, territorios[28],"./images/war_carta_as_mongolia.png"),
			new Carta (Geometria.circulo, territorios[29],"./images/war_carta_as_paquistao.png"),
			new Carta (Geometria.triangulo, territorios[30],"./images/war_carta_as_russia.png"),
			new Carta (Geometria.retangulo, territorios[31],"./images/war_carta_as_siberia.png"),
			new Carta (Geometria.retangulo, territorios[32],"./images/war_carta_as_siria.png"),
			new Carta (Geometria.triangulo, territorios[33],"./images/war_carta_as_tailandia.png"),
			new Carta (Geometria.triangulo, territorios[34],"./images/war_carta_as_turquia.png"),
			new Carta (Geometria.retangulo, territorios[35],"./images/war_carta_asl_argentina.png"),
			new Carta (Geometria.circulo, territorios[36],"./images/war_carta_asl_brasil.png"),
			new Carta (Geometria.triangulo, territorios[37],"./images/war_carta_asl_peru.png"),
			new Carta (Geometria.triangulo, territorios[38],"./images/war_carta_asl_venezuela.png"),
			new Carta (Geometria.coringa, null,"./images/war_carta_coringa.png"),//coringa
			new Carta (Geometria.circulo, territorios[39],"./images/war_carta_eu_espanha.png"),
			new Carta (Geometria.triangulo, territorios[40],"./images/war_carta_eu_franca.png"),
			new Carta (Geometria.retangulo, territorios[41],"./images/war_carta_eu_italia.png"),
			new Carta (Geometria.triangulo, territorios[42],"./images/war_carta_eu_polonia.png"),
			new Carta (Geometria.circulo, territorios[43],"./images/war_carta_eu_reinounido.png"),
			new Carta (Geometria.triangulo, territorios[44],"./images/war_carta_eu_romenia.png"),
			new Carta (Geometria.retangulo, territorios[45],"./images/war_carta_eu_suecia.png"),
			new Carta (Geometria.circulo, territorios[46],"./images/war_carta_eu_ucrania.png"),
			new Carta (Geometria.triangulo, territorios[47],"./images/war_carta_oc_australia.png"),
			new Carta (Geometria.triangulo, territorios[48],"./images/war_carta_oc_indonesia.png"),
			new Carta (Geometria.retangulo, territorios[49],"./images/war_carta_oc_novazelandia.png"),
			new Carta (Geometria.coringa, null,"./images/war_carta_coringa.png"),//coringa
			new Carta (Geometria.circulo, territorios[50],"./images/war_carta_oc_perth.png")
	};
	Map<String,Carta> cartas = transformaSet(temp);
	static Territorio []ADN = {
			new Territorio ("Alasca",Continente.AmericaDoNorte),
			new Territorio ("Calgary",Continente.AmericaDoNorte),
			new Territorio ("California",Continente.AmericaDoNorte),
			new Territorio ("Groelândia",Continente.AmericaDoNorte),
			new Territorio ("México",Continente.AmericaDoNorte),
			new Territorio ("Nova York",Continente.AmericaDoNorte),
			new Territorio ("Quebec",Continente.AmericaDoNorte),
			new Territorio ("Texas",Continente.AmericaDoNorte),
			new Territorio ("Vancouver",Continente.AmericaDoNorte)};
	static Territorio []EUR = {
			new Territorio ("Espanha", Continente.Europa),
			new Territorio ("França", Continente.Europa),
			new Territorio ("Itália", Continente.Europa),
			new Territorio ("Polônia", Continente.Europa),
			new Territorio ("Reino Unido", Continente.Europa),
			new Territorio ("Romênia", Continente.Europa),
			new Territorio ("Suécia", Continente.Europa),
			new Territorio ("Ucrânia", Continente.Europa)};
	static Territorio []ADS = {
			new Territorio ("Argentina",Continente.AmericaDoSul),
			new Territorio ("Brasil",Continente.AmericaDoSul),
			new Territorio ("Peru",Continente.AmericaDoSul),
			new Territorio ("Venezuela",Continente.AmericaDoSul)
			};
	static Territorio []AFR = {
			new Territorio ("África do Sul",Continente.Africa), 
			new Territorio ("Angola",Continente.Africa),
			new Territorio ("Argélia",Continente.Africa),
			new Territorio ("Egito",Continente.Africa),
			new Territorio ("Nigéria",Continente.Africa),
			new Territorio ("Somália",Continente.Africa)
			};
	static Territorio []ASI = {
			new Territorio ("Arábia Saudita",Continente.Asia),
			new Territorio ("Bangladesh",Continente.Asia),
			new Territorio ("Cazaquistão",Continente.Asia),
			new Territorio ("China",Continente.Asia),
			new Territorio ("Coreia do Norte",Continente.Asia),
			new Territorio ("Coreia do Sul",Continente.Asia),
			new Territorio ("Estônia",Continente.Asia),
			new Territorio ("Índia",Continente.Asia),
			new Territorio ("Irã",Continente.Asia),
			new Territorio ("Iraque",Continente.Asia),
			new Territorio ("Japão",Continente.Asia),
			new Territorio ("Jordânia",Continente.Asia),
			new Territorio ("Letônia",Continente.Asia),
			new Territorio ("Mongólia",Continente.Asia),
			new Territorio ("Paquistão",Continente.Asia),
			new Territorio ("Rússia",Continente.Asia),
			new Territorio ("Sibéria",Continente.Asia),
			new Territorio ("Síria",Continente.Asia),
			new Territorio ("Tailândia",Continente.Asia),
			new Territorio ("Turquia",Continente.Asia)
			};
	static Territorio []OCE = {
			new Territorio ("Austrália", Continente.Oceania),
			new Territorio ("Indonésia", Continente.Oceania),
			new Territorio ("Nova Zelândia", Continente.Oceania),
			new Territorio ("Perth", Continente.Oceania)
			};
	int numTrocas = 0;
	
	public Armazenamento (  String[] nomes, String[]  cores) {
		Cor [] cor = new Cor [cores.length];
		for (int i = 0; i < cores.length; i++){
			cor[i] = strToCor(cores[i]);
		}
		if (verificaJogo(cor, nomes)) {
			jogadores = criaJogadores ( nomes, cor);
			escolheObjetivos();
			distribuiCartas( );
			setTodosVizinhos();
			}
		else 
			System.out.println("ERRO: Número de jogadores e cores são diferentes");
	}
	public Armazenamento (String nomeDoSave) {
		try {
		      FileReader arq = new FileReader(nomeDoSave);
		      BufferedReader lerArq = new BufferedReader(arq);
		 
		      String linha = lerArq.readLine(); // lê a primeira linha
		// a variável "linha" recebe o valor "null" quando o processo
		// de repetição atingir o final do arquivo texto
		      if (linha != null) {
		    	  int numJogadores = Integer.parseInt(linha);//numero de jogadores no jogo salvo
		    	  int []numTerritorios = new int[numJogadores];//para salvar dps de criar os jogadores
		    	  int []numCartas = new int[numJogadores];
		    	  String []auxJoga = new String[4];//para guardar o array de strings ao usar o split
		    	  String[]nome = new String[numJogadores] ;//para guardar os nomes
		    	  String[]cores = new String[numJogadores];//para guardar as cores
		    	  String[]obj = new String[numJogadores];//para guardar os objetivos
		    	  int i;//pra n criar toda hora a variável
		    	  //Leitura do arquivo ==> parte dos jogadores
		    	  for (i = 0; i < numJogadores; i++) {
		    		  linha = lerArq.readLine();
		    		  auxJoga = linha.split(";");
		    		  nome[i] = auxJoga[0];
		    		  cores[i] = auxJoga[1];
		    		  obj[i] = auxJoga[2];
		    		  numTerritorios[i] = Integer.parseInt(auxJoga[3]);
		    		  numCartas[i] = Integer.parseInt(auxJoga[4]);
		    	  }
		    	  //Criação dos jogadores
		    	  jogadores = resumeJogadores(nome,cores,obj,numTerritorios);
		    	  for (i = 0; i < numJogadores; i++) {
		    		  for (int j = 0; j < numCartas[i]; j++) {
		    			  jogadores[i].podeComprar();
		    			  compraCarta(cores[i]);
		    		  }
		    	  }
		    	  //Obs.: talvez se faça necessário resetar os jogadores atuais caso o jogo esteja rodando
		    	  setTodosVizinhos();
		    	 
		    	  linha = lerArq.readLine();
		    	  setNumTrocas(Integer.parseInt(linha));
		    	  String[] novoAux = new String[2];
		    	  for (i = 0; i < territorios.length; i++) {
		    		  linha = lerArq.readLine();
		    		  novoAux = linha.split(";");
		    		  territorios[i].setCor(strToCor(novoAux[0]));
		    		  territorios[i].setNumEx(Integer.parseInt(novoAux[1]));
		    		  
		    	  }
		    	  for (int j = 0; j < numJogadores; j++) 
		    		  conquistouContinente(territorios[0], j);
		    	  for (int j = 0; j < numJogadores; j++) 
		    		  conquistouContinente(territorios[6], j);
		    	  for (int j = 0; j < numJogadores; j++) 
		    		  conquistouContinente(territorios[15], j);
		    	  for (int j = 0; j < numJogadores; j++) 
		    		  conquistouContinente(territorios[35], j);
		    	  for (int j = 0; j < numJogadores; j++) 
		    		  conquistouContinente(territorios[39], j);
		    	  for (int j = 0; j < numJogadores; j++) 
		    		  conquistouContinente(territorios[47], j);
		    	  
		    		  
		      }
		      
		 
		      arq.close();
		      }
		      catch (IOException e) {
		        System.err.printf("Erro na abertura do arquivo: %s.\n",
		          e.getMessage());
		    }
	}
	//Funcao para a tela saber quais cores tem no salvamento
	public String [] getCoresJogadores () {
		
		String[] cores = new String[jogadores.length];
		for(int i = 0; i < cores.length; i++) {
			cores[i] = jogadores[i].getCor().toString();
		}
		return cores;

	}
	private Cor strToCor(String string) {
		if (string.equals("vermelho"))
			return Cor.vermelho;
		else if (string.equals("verde"))
			return Cor.verde;
		else if (string.equals("azul"))
			return Cor.azul;
		else if (string.equals("amarelo"))
			return Cor.amarelo;
		else if (string.equals("preto"))
			return Cor.preto;
		else if (string.equals("branco"))
			return Cor.branco;
		else return null;
	}

	//Funcionalidade nova -- atualizada para aumentar a distribui do jogador por conta do numero de territorios
		public void numeroDistribuirTer(String corJogador){
			int indJog = indexJog(corJogador);
			jogadores[indJog].aumentaExe(jogadores[indJog].getNumTerritorio()/2);
			Continente []aux = jogadores[indJog].getContinente();
			for(int i = 0; i < aux.length; i++) {
				if (aux[i].equals(Continente.Africa))
					jogadores[indJog].aumentaExe(3,i);
				else if (aux[i].equals(Continente.AmericaDoNorte))
					jogadores[indJog].aumentaExe(5,i);
				else if (aux[i].equals(Continente.Asia))
					jogadores[indJog].aumentaExe(7,i);
				else if (aux[i].equals(Continente.AmericaDoSul))
					jogadores[indJog].aumentaExe(2,i);
				else if (aux[i].equals(Continente.Europa))
					jogadores[indJog].aumentaExe(5,i);
				else if (aux[i].equals(Continente.Oceania))
					jogadores[indJog].aumentaExe(2,i);
			}
		}
		
		
		//Funcionalidade nova
		public boolean distribui_1(String corJogador, String nomeTerritorio){
			int indJog = indexJog(corJogador);
			int indTer = indexTer(nomeTerritorio);
			int numExeAntes = territorios[indTer].getNumExe();
			if (territorios[indTer].getCor().equals(jogadores[indJog].getCor())) {
				Continente []aux = jogadores[indJog].getContinente();
				if (jogadores[indJog].getDistribuiExe() > 0) {
					if(aux.length > 0) {
						int []exeAux = jogadores[indJog].getDistribuiCont();
						for (int i = 0; i < aux.length; i++) {
							if (territorios[indTer].getContinente().equals(aux[i])) {
								if (exeAux[i] > 0) {
									territorios[indTer].adicionaExe();
									jogadores[indJog].distribuiu(i);
									if (territorios[indTer].getNumExe() == (numExeAntes + 1))
										return true;
								}
							}
						}
					}
					territorios[indTer].adicionaExe();
					jogadores[indJog].distribuiu();
				}
			}
				
			if (territorios[indTer].getNumExe() == (numExeAntes + 1))
				return true;
			return false;
		}
	
	//Funcionalidade nova
	public String[] caracTerritorio(String nomeTerritorio) {
		int i = indexTer(nomeTerritorio);
		if (i > -1) {
			String [] end = {territorios[i].getCor().toString(), Integer.toString(territorios[i].getNumExe())};
			return end;	
		}
		return null;
	}
	
	//Funcionalidade nova
	public boolean autorizaAtaque(String atacante, String defensor) {
		int indAtaque = indexTer(atacante);
		for (Territorio ter : territorios[indAtaque].getVizinhos()) {
			if (defensor.equals(ter.getNome()))
				return true;
		}
		return false;
	}
	
	//Funcionalidade nova
	public String[] testaVencedor() {
		boolean teste = false;
		String [] resposta = {"NÃO",""};
		for (int i = 0; i < jogadores.length; i++) {
			Objetivo obj = jogadores[i].getObjetivo();
			if (obj.equals(Objetivo.EuropaOceaniaTerceiro)) {
				Continente []cont = jogadores[i].getContinente();
				int qtd = 0;
				for(int j = 0; j < cont.length; j++) {
					if (cont[j].equals(Continente.Europa) || cont[j].equals(Continente.Oceania))
						qtd++;
				}
				if (qtd == 2 && cont.length == 3)
					teste = true;
				
			}
			else if (obj.equals(Objetivo.AsiaAmericaDoSul)) {
				Continente []cont = jogadores[i].getContinente();
				int qtd = 0;
				for(int j = 0; j < cont.length; j++) {
					if (cont[j].equals(Continente.Asia) || cont[j].equals(Continente.AmericaDoSul))
						qtd++;
				}
				if (qtd == 2)
					teste = true;
				
			}
			else if (obj.equals(Objetivo.EuropaAmericaDoSulTerceiro)) {
				Continente []cont = jogadores[i].getContinente();
				int qtd = 0;
				for(int j = 0; j < cont.length; j++) {
					if (cont[j].equals(Continente.Europa) || cont[j].equals(Continente.AmericaDoSul))
						qtd++;
				}
				if (qtd == 2 && cont.length >= 3)
					teste = true;
				
			}
			else if (obj.equals(Objetivo.dezoitoTerritoriosDoisExericitos)) {
				if (jogadores[i].getNumTerritorio() >= 18) {
					Territorio []territorio = territorios;
					int qtd = 0;
					Cor c = jogadores[i].getCor();
					for (int j = 0; j < territorio.length; j++) {
						if (c.equals(territorio[j].getCor()))
							if (territorio[j].getNumExe() >= 2)
								qtd++;
					}
					if (qtd >= 18)
						teste = true;
				}
				
			}
			else if (obj.equals(Objetivo.AsiaAfrica)) {
				Continente []cont = jogadores[i].getContinente();
				int qtd = 0;
				for(int j = 0; j < cont.length; j++) {
					if (cont[j].equals(Continente.Asia) || cont[j].equals(Continente.Africa))
						qtd++;
				}
				if (qtd == 2)
					teste = true;
				
			}
			else if (obj.equals(Objetivo.AmericaDoNorteAfrica)) {
				Continente []cont = jogadores[i].getContinente();
				int qtd = 0;
				for(int j = 0; j < cont.length; j++) {
					if (cont[j].equals(Continente.AmericaDoNorte) || cont[j].equals(Continente.Africa))
						qtd++;
				}
				if (qtd == 2)
					teste = true;
				
			}
			
			else if (obj.equals(Objetivo.territorios24)) {
				if (jogadores[i].getNumTerritorio() >= 24)
					teste = true;
				
			}
			
			else if (obj.equals(Objetivo.AmericaDoNorteOceania)) {
				Continente []cont = jogadores[i].getContinente();
				int qtd = 0;
				for(int j = 0; j < cont.length; j++) {
					if (cont[j].equals(Continente.AmericaDoNorte) || cont[j].equals(Continente.Oceania))
						qtd++;
				}
				if (qtd == 2)
					teste = true;
				
			}
			else if (obj.equals(Objetivo.azuis)) {
				Cor c = Cor.azul;
				for (int j = 0; j < jogadores.length; j++) {
					if (jogadores[j].getCor() == c && jogadores[j].getNumTerritorio() == 0)
						teste = true;
				}
				
			}
			else if (obj.equals(Objetivo.amarelos)) {
				Cor c = Cor.amarelo;
				for (int j = 0; j < jogadores.length; j++) {
					if (jogadores[j].getCor() == c && jogadores[j].getNumTerritorio() == 0)
						teste = true;
				}
				
			}
			else if (obj.equals(Objetivo.vermelhos)) {
				Cor c = Cor.vermelho;
				for (int j = 0; j < jogadores.length; j++) {
					if (jogadores[j].getCor() == c && jogadores[j].getNumTerritorio() == 0)
						teste = true;
				}
				
			}
			else if (obj.equals(Objetivo.pretos)) {
				Cor c = Cor.preto;
				for (int j = 0; j < jogadores.length; j++) {
					if (jogadores[j].getCor() == c && jogadores[j].getNumTerritorio() == 0)
						teste = true;
				}
				
			}
			else if (obj.equals(Objetivo.brancos)) {
				Cor c = Cor.branco;
				for (int j = 0; j < jogadores.length; j++) {
					if (jogadores[j].getCor() == c && jogadores[j].getNumTerritorio() == 0)
						teste = true;
				}
				
			}
			else {
				Cor c = Cor.verde;
				for (int j = 0; j < jogadores.length; j++) {
					if (jogadores[j].getCor() == c && jogadores[j].getNumTerritorio() == 0)
						teste = true;
				}
	
			}
			if (teste == true) {
				resposta[0] = "SIM";
				resposta[1] = jogadores[i].getNome();
				return resposta;
			}
		}
		return resposta;
	}
	
	//Testar
	public String pegaObjetivo(String c) {
		for (int i = 0; i < jogadores.length; i++) {
			if (jogadores[i].getCor().toString().equals(c)) 
				return ObjToStr(jogadores[i].getObjetivo());
		}
		return null;
	}
	
	static String ObjToStr(Objetivo obj) {
		if (obj.equals(Objetivo.amarelos))
			return "Destrua todos os exércitos amarelos";
		else if (obj.equals(Objetivo.vermelhos))
			return "Destrua todos os exércitos vermelhos";
		else if (obj.equals(Objetivo.azuis))
			return "Destrua todos os exércitos azuis";
		else if (obj.equals(Objetivo.verdes))
			return "Destrua todos os exércitos verdes";
		else if (obj.equals(Objetivo.brancos))
			return "Destrua todos os exércitos brancos";
		else if (obj.equals(Objetivo.pretos))
			return "Destrua todos os exércitos pretos";
		else if (obj.equals(Objetivo.AmericaDoNorteOceania))
			return "Conquiste a América do Norte e a Oceania";
		else if (obj.equals(Objetivo.EuropaOceaniaTerceiro))
			return "Conquiste a Europa, a Oceania e um terceiro continente";
		else if (obj.equals(Objetivo.AsiaAmericaDoSul))
			return "Conquiste a Ásia e a AmericaDoSul";
		else if (obj.equals(Objetivo.EuropaAmericaDoSulTerceiro))
			return "Conquiste a Europa, a America do Sul e um terceiro continente";
		else if (obj.equals(Objetivo.AsiaAfrica))
			return "Conquiste a Ásia e a África";
		else if (obj.equals(Objetivo.AmericaDoNorteAfrica))
			return "Conquiste a América do Norte e a África";
		else if (obj.equals(Objetivo.territorios24))
			return "Conquiste 24 territórios a sua escolha";
		else if (obj.equals(Objetivo.dezoitoTerritoriosDoisExericitos))
			return "Conquiste 18 territórios a sua escolha com cada um deles com pelo menos 2 exércitos";
		return "";
	}
	private static void setTodosVizinhos() {

		//Africa do Sul
		territorios[0].acrescentaVizinho(territorios[1]);
		territorios[0].acrescentaVizinho(territorios[5]);
		//Angola
		territorios[1].acrescentaVizinho(territorios[0]);
		territorios[1].acrescentaVizinho(territorios[4]);
		territorios[1].acrescentaVizinho(territorios[5]);
		//Argelia
		territorios[2].acrescentaVizinho(territorios[3]);
		territorios[2].acrescentaVizinho(territorios[4]);
		territorios[2].acrescentaVizinho(territorios[39]);
		territorios[2].acrescentaVizinho(territorios[41]);
		//Egito
		territorios[3].acrescentaVizinho(territorios[3]);
		territorios[3].acrescentaVizinho(territorios[4]);
		territorios[3].acrescentaVizinho(territorios[5]);
		territorios[3].acrescentaVizinho(territorios[26]);
		territorios[3].acrescentaVizinho(territorios[44]);
		//Nigeria
		territorios[4].acrescentaVizinho(territorios[1]);
		territorios[4].acrescentaVizinho(territorios[2]);
		territorios[4].acrescentaVizinho(territorios[3]);
		territorios[4].acrescentaVizinho(territorios[5]);
		territorios[4].acrescentaVizinho(territorios[36]);
		//Somalia
		territorios[5].acrescentaVizinho(territorios[0]);
		territorios[5].acrescentaVizinho(territorios[1]);
		territorios[5].acrescentaVizinho(territorios[3]);
		territorios[5].acrescentaVizinho(territorios[4]);
		//Alasca
		territorios[6].acrescentaVizinho(territorios[7]);
		territorios[6].acrescentaVizinho(territorios[14]);
		territorios[6].acrescentaVizinho(territorios[31]);
		//Calgary
		territorios[7].acrescentaVizinho(territorios[6]);
		territorios[7].acrescentaVizinho(territorios[9]);
		territorios[7].acrescentaVizinho(territorios[14]);
		//California
		territorios[8].acrescentaVizinho(territorios[10]);
		territorios[8].acrescentaVizinho(territorios[13]);
		territorios[8].acrescentaVizinho(territorios[14]);
		//Groelandia
		territorios[9].acrescentaVizinho(territorios[7]);
		territorios[9].acrescentaVizinho(territorios[43]);
		//México
		territorios[10].acrescentaVizinho(territorios[8]);
		territorios[10].acrescentaVizinho(territorios[13]);
		territorios[10].acrescentaVizinho(territorios[38]);
		//Nova York
		territorios[11].acrescentaVizinho(territorios[12]);
		territorios[11].acrescentaVizinho(territorios[13]);
		//Quebec
		territorios[12].acrescentaVizinho(territorios[11]);
		territorios[12].acrescentaVizinho(territorios[13]);
		territorios[12].acrescentaVizinho(territorios[14]);
		territorios[12].acrescentaVizinho(territorios[43]);
		//Texas
		territorios[13].acrescentaVizinho(territorios[8]);
		territorios[13].acrescentaVizinho(territorios[10]);
		territorios[13].acrescentaVizinho(territorios[11]);
		territorios[13].acrescentaVizinho(territorios[12]);
		territorios[13].acrescentaVizinho(territorios[14]);
		//Van Couver
		territorios[14].acrescentaVizinho(territorios[6]);
		territorios[14].acrescentaVizinho(territorios[7]);
		territorios[14].acrescentaVizinho(territorios[8]);
		territorios[14].acrescentaVizinho(territorios[12]);
		territorios[14].acrescentaVizinho(territorios[13]);
		//Arábia Saudita
		territorios[15].acrescentaVizinho(territorios[24]);
		territorios[15].acrescentaVizinho(territorios[26]);
		//Bangladesh
		territorios[16].acrescentaVizinho(territorios[20]);
		territorios[16].acrescentaVizinho(territorios[22]);
		territorios[16].acrescentaVizinho(territorios[33]);
		territorios[16].acrescentaVizinho(territorios[48]);
		//Cazaquistão
		territorios[17].acrescentaVizinho(territorios[18]);
		territorios[17].acrescentaVizinho(territorios[25]);
		territorios[17].acrescentaVizinho(territorios[27]);
		territorios[17].acrescentaVizinho(territorios[28]);
		territorios[17].acrescentaVizinho(territorios[30]);
		territorios[17].acrescentaVizinho(territorios[31]);
		territorios[17].acrescentaVizinho(territorios[34]);
		//China
		territorios[18].acrescentaVizinho(territorios[17]);
		territorios[18].acrescentaVizinho(territorios[19]);
		territorios[18].acrescentaVizinho(territorios[20]);
		territorios[18].acrescentaVizinho(territorios[22]);
		territorios[18].acrescentaVizinho(territorios[28]);
		territorios[18].acrescentaVizinho(territorios[29]);
		territorios[18].acrescentaVizinho(territorios[34]);
		//Coreia do Norte
		territorios[19].acrescentaVizinho(territorios[18]);
		territorios[19].acrescentaVizinho(territorios[20]);
		territorios[19].acrescentaVizinho(territorios[25]);
		//Coreia do Sul
		territorios[20].acrescentaVizinho(territorios[16]);
		territorios[20].acrescentaVizinho(territorios[18]);
		territorios[20].acrescentaVizinho(territorios[19]);
		territorios[20].acrescentaVizinho(territorios[22]);
		territorios[20].acrescentaVizinho(territorios[33]);
		//Estônia
		territorios[21].acrescentaVizinho(territorios[27]);
		territorios[21].acrescentaVizinho(territorios[30]);
		territorios[21].acrescentaVizinho(territorios[45]);
		//Índia
		territorios[22].acrescentaVizinho(territorios[16]);
		territorios[22].acrescentaVizinho(territorios[18]);
		territorios[22].acrescentaVizinho(territorios[20]);
		territorios[22].acrescentaVizinho(territorios[29]);
		//Irã
		territorios[23].acrescentaVizinho(territorios[24]);
		territorios[23].acrescentaVizinho(territorios[29]);
		territorios[23].acrescentaVizinho(territorios[32]);
		//Iraque
		territorios[24].acrescentaVizinho(territorios[15]);
		territorios[24].acrescentaVizinho(territorios[23]);
		territorios[24].acrescentaVizinho(territorios[26]);
		territorios[24].acrescentaVizinho(territorios[32]);
		//Japão
		territorios[25].acrescentaVizinho(territorios[17]);
		territorios[25].acrescentaVizinho(territorios[28]);
		//Jordânia
		territorios[26].acrescentaVizinho(territorios[15]);
		territorios[26].acrescentaVizinho(territorios[24]);
		territorios[26].acrescentaVizinho(territorios[32]);
		//Letônia
		territorios[27].acrescentaVizinho(territorios[17]);
		territorios[27].acrescentaVizinho(territorios[21]);
		territorios[27].acrescentaVizinho(territorios[30]);
		territorios[27].acrescentaVizinho(territorios[34]);
		territorios[27].acrescentaVizinho(territorios[42]);
		territorios[27].acrescentaVizinho(territorios[45]);
		territorios[27].acrescentaVizinho(territorios[46]);
		//Mongólia
		territorios[28].acrescentaVizinho(territorios[17]);
		territorios[28].acrescentaVizinho(territorios[18]);
		territorios[28].acrescentaVizinho(territorios[25]);
		//Paquistão
		territorios[29].acrescentaVizinho(territorios[18]);
		territorios[29].acrescentaVizinho(territorios[22]);
		territorios[29].acrescentaVizinho(territorios[23]);
		territorios[29].acrescentaVizinho(territorios[32]);
		territorios[29].acrescentaVizinho(territorios[34]);
		//Rússia
		territorios[30].acrescentaVizinho(territorios[17]);
		territorios[30].acrescentaVizinho(territorios[21]);
		territorios[30].acrescentaVizinho(territorios[27]);
		territorios[30].acrescentaVizinho(territorios[31]);
		//Sibéria
		territorios[31].acrescentaVizinho(territorios[17]);
		territorios[31].acrescentaVizinho(territorios[30]);
		territorios[31].acrescentaVizinho(territorios[6]);
		//Síria
		territorios[32].acrescentaVizinho(territorios[23]);
		territorios[32].acrescentaVizinho(territorios[24]);
		territorios[32].acrescentaVizinho(territorios[26]);
		territorios[32].acrescentaVizinho(territorios[29]);
		territorios[32].acrescentaVizinho(territorios[34]);
		//Tailândia
		territorios[33].acrescentaVizinho(territorios[16]);
		territorios[33].acrescentaVizinho(territorios[20]);
		//Turquia
		territorios[34].acrescentaVizinho(territorios[17]);
		territorios[34].acrescentaVizinho(territorios[18]);
		territorios[34].acrescentaVizinho(territorios[27]);
		territorios[34].acrescentaVizinho(territorios[29]);
		territorios[34].acrescentaVizinho(territorios[32]);
		territorios[34].acrescentaVizinho(territorios[46]);
		//Argentina
		territorios[35].acrescentaVizinho(territorios[36]);
		territorios[35].acrescentaVizinho(territorios[37]);
		//Brasil
		territorios[36].acrescentaVizinho(territorios[35]);
		territorios[36].acrescentaVizinho(territorios[37]);
		territorios[36].acrescentaVizinho(territorios[38]);
		territorios[36].acrescentaVizinho(territorios[39]);
		territorios[36].acrescentaVizinho(territorios[4]);
		//Peru
		territorios[37].acrescentaVizinho(territorios[35]);
		territorios[37].acrescentaVizinho(territorios[36]);
		territorios[37].acrescentaVizinho(territorios[38]);
		//Venezuela
		territorios[38].acrescentaVizinho(territorios[10]);
		territorios[38].acrescentaVizinho(territorios[36]);
		territorios[38].acrescentaVizinho(territorios[37]);
		//Espanha
		territorios[39].acrescentaVizinho(territorios[2]);
		territorios[39].acrescentaVizinho(territorios[36]);
		territorios[39].acrescentaVizinho(territorios[40]);
		//França
		territorios[40].acrescentaVizinho(territorios[39]);
		territorios[40].acrescentaVizinho(territorios[41]);
		territorios[40].acrescentaVizinho(territorios[43]);
		territorios[40].acrescentaVizinho(territorios[45]);
		//Itália
		territorios[41].acrescentaVizinho(territorios[40]);
		territorios[41].acrescentaVizinho(territorios[42]);
		territorios[41].acrescentaVizinho(territorios[44]);
		//Polônia
		territorios[42].acrescentaVizinho(territorios[27]);
		territorios[42].acrescentaVizinho(territorios[41]);
		territorios[42].acrescentaVizinho(territorios[44]);
		territorios[42].acrescentaVizinho(territorios[45]);
		territorios[42].acrescentaVizinho(territorios[46]);
		//Reino Unido
		territorios[43].acrescentaVizinho(territorios[9]);
		territorios[43].acrescentaVizinho(territorios[12]);
		territorios[43].acrescentaVizinho(territorios[40]);
		territorios[43].acrescentaVizinho(territorios[45]);
		//Romênia
		territorios[44].acrescentaVizinho(territorios[41]);
		territorios[44].acrescentaVizinho(territorios[42]);
		territorios[44].acrescentaVizinho(territorios[46]);
		territorios[44].acrescentaVizinho(territorios[2]);
		//Suécia
		territorios[45].acrescentaVizinho(territorios[21]);
		territorios[45].acrescentaVizinho(territorios[27]);
		territorios[45].acrescentaVizinho(territorios[40]);
		territorios[45].acrescentaVizinho(territorios[42]);
		territorios[45].acrescentaVizinho(territorios[43]);
		//Ucrânia
		territorios[46].acrescentaVizinho(territorios[27]);
		territorios[46].acrescentaVizinho(territorios[34]);
		territorios[46].acrescentaVizinho(territorios[42]);
		territorios[46].acrescentaVizinho(territorios[44]);
		//Austrália
		territorios[47].acrescentaVizinho(territorios[48]);
		territorios[47].acrescentaVizinho(territorios[49]);
		territorios[47].acrescentaVizinho(territorios[50]);
		//Indonésia
		territorios[48].acrescentaVizinho(territorios[16]);
		territorios[48].acrescentaVizinho(territorios[47]);
		territorios[48].acrescentaVizinho(territorios[49]);
		territorios[48].acrescentaVizinho(territorios[50]);
		//Nova Zelândia
		territorios[49].acrescentaVizinho(territorios[48]);
		territorios[49].acrescentaVizinho(territorios[50]);
		//Perth
		territorios[50].acrescentaVizinho(territorios[47]);
	}
	

	String []cartaToStr(Carta []cartas){
		String []cart = new String [cartas.length];
		for (int i = 0; i < cartas.length; i++) {
			if (cartas[i].getGeometria().equals(Geometria.retangulo))
				cart[i] = cartas[i].getTerritorio().getNome() + " com retângulo";
			else if (cartas[i].getGeometria().equals(Geometria.triangulo))
				cart[i] = cartas[i].getTerritorio().getNome() + " com triângulo";
			else if (cartas[i].getGeometria().equals(Geometria.circulo))
				cart[i] = cartas[i].getTerritorio().getNome() + " com circulo";
			else
				cart[i] = "Coringa";
		}
		return cart;
	}

	private static void distribuiCartas() {
		int i = 0;
		
		for (int j = 0; j < territorios.length; j++) {
			territorios[j].conquista(jogadores[i].getCor(),1);
			i++;
			if(i >= jogadores.length) {
				i = 0;
			}
		}
	}
	
	//Funcionalidade nova
	private boolean verificaJogo(Cor []cores, String [] nomes) {
		if (nomes.length == cores.length && nomes.length > 2) {
			
			int [] c = {0,0,0,0,0,0}; 
			for (int i = 0; i < cores.length; i++) {
				if (cores[i].equals(Cor.vermelho))
					c[0]+=1;
				else if (cores[i].equals(Cor.amarelo))
					c[1]+=1;
				else if (cores[i].equals(Cor.azul))
					c[2]+=1;
				else if (cores[i].equals(Cor.verde))
					c[3]+=1;
				else if (cores[i].equals(Cor.preto))
					c[4]+=1;
				else if (cores[i].equals(Cor.branco))
					c[5]+=1;
				else
					return false;
			}
			for (int i = 0; i < 6; i++)
				if (c[i] > 1)
					return false;
			return true;
		}
		
		return false;
	}
	
	private static boolean repeticao (Jogador [] jogadores, int tamanho, Objetivo num) {
		for(int i = 0; i < tamanho; i++) {
			if (jogadores[i].getObjetivo().equals(num))
				return true;
		}
		return false;
	}

	private static Jogador[] criaJogadores (String[] nomes, Cor [] cores) {
		Jogador []jogadores = new Jogador[cores.length];
		int numJog = nomes.length;
		int resto = territorios.length%numJog;
		for (int i = 0; i < numJog;  i++) {
			jogadores[i] = new Jogador(nomes[i], cores[i]);
			jogadores[i].setNumTerritorio(territorios.length/nomes.length);
		}
		for (int i = 0; i < resto; i++) {
			jogadores[i].aumentaTer();
		}
		return jogadores;
	}

	private static boolean verificaCor(Cor c, Objetivo obj) {

		if (c.equals(Cor.azul))
			if (obj.equals(Objetivo.azuis))
				return true;
		if (c.equals(Cor.amarelo))
			if (obj.equals(Objetivo.amarelos))
				return true;
		if (c.equals(Cor.vermelho))
			if (obj.equals(Objetivo.vermelhos))
				return true;
		if (c.equals(Cor.verde))
			if (obj.equals(Objetivo.verdes))
				return true;
		if (c.equals(Cor.branco))
			if (obj.equals(Objetivo.brancos))
				return true;
		if (c.equals(Cor.preto))
			if (obj.equals(Objetivo.pretos))
				return true;

		return false;
	}
	
	//Testar
	private static void escolheObjetivos () {
		Random gerador = new Random();
		int indice;
		boolean repetido;
		for (int i = 0; i < jogadores.length; i++) {
			repetido = false;
			indice = gerador.nextInt(14);
			jogadores[i].setObjetivo(objetivos[indice]);
			repetido = repeticao(jogadores, i, objetivos[indice]);
			if (verificaCor(jogadores[i].getCor(), objetivos[indice]))
				repetido = true;
			while(repetido) {
				indice = gerador.nextInt(14);
				jogadores[i].setObjetivo(objetivos[indice]);
				repetido = repeticao(jogadores, i, objetivos[indice]);
				if (verificaCor(jogadores[i].getCor(), objetivos[indice]))
					repetido = true;
			}
		}
	}
	
	//Testar
	boolean aprovaTroca(Carta c1, Carta c2, Carta c3) {
		
		Geometria g1 = c1.getGeometria();
		Geometria g2 = c2.getGeometria();
		Geometria g3 = c3.getGeometria();
		
		if (g1.equals(Geometria.coringa) || g2.equals(Geometria.coringa))
			return true;
		if (g3.equals(Geometria.coringa))
			return true;
		if (g1.equals(g2) && g1.equals(g3))
			return true;
		if (!g1.equals(g2) && !g1.equals(g3)) {
			if (!g2.equals(g3))
				return true;
		}
		return false;
	}
	
	//Testar, verificar e revisar se será feita dessa forma
	public void salvaJogo(String nomeDoSave) {
		try {
			// Cria arquivo
		    File file = new File(nomeDoSave + ".txt");

		    // Se o arquivo nao existir, ele gera
		    if (!file.exists()) {
		        file.createNewFile();
		    }
			
			FileWriter arq = new FileWriter(file.getAbsoluteFile());
		    PrintWriter gravarArq = new PrintWriter(arq);
		    
		    //Número de cores totais no jogo
		    gravarArq.printf("%d\n", jogadores.length);
		    //Variáveis que vamos usar para preencher o arquivo
		    String nome, cor, objetivo;
		    
		    //Nome do jogador, cor, objetivo, número de territórios e cartas ==> todas as informações separadas por ";"
		    for (int i = 0; i < jogadores.length; i++) {
		    	nome = jogadores[i].getNome();
		    	cor = jogadores[i].getCor().toString();
		    	objetivo = jogadores[i].getObjetivo().toString();
		    	gravarArq.printf("%s;%s;%s;%d;%d\n", nome, cor, objetivo, jogadores[i].getNumTerritorio(),jogadores[i].getArrayCartas().length);
		    }
		    gravarArq.printf("%d\n", getNumTrocas());
		    //Cor no territorio [i], número de exércitos ==> todas as informações separadas por ";"
		    for (int i = 0; i < territorios.length; i++) {
		    	cor = territorios[i].getCor().toString();
		    	gravarArq.printf("%s;%d\n", cor, territorios[i].getNumExe());
		    }
		    arq.close();
		
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private int getNumTrocas() {
		return numTrocas;
		
	}
	
	private void setNumTrocas(int n) {
		numTrocas = n;
	}
	
	//Funcionalidade nova
	Jogador[] resumeJogadores(String[] nomes, String[]cores, String[]objetivos, int[]numTerritorios) {
		Jogador []jogadores = new Jogador[cores.length];
		for (int i = 0; i < nomes.length;  i++) {
			jogadores[i] = new Jogador(nomes[i], strToCor(cores[i]));
			jogadores[i].setNumTerritorio(numTerritorios[i]);
			jogadores[i].setObjetivo(strToObj(objetivos[i]));
			
		}
		return jogadores;
	}
	
	//Testar
	Geometria strToGeo(String geo) {
		if (geo.equals("retangulo"))
			return Geometria.retangulo;
		else if(geo.equals("circulo"))
			return Geometria.circulo;
		else if(geo.equals("triangulo"))
			return Geometria.triangulo;
		else 
			return Geometria.coringa;
	}
	
	//Testar
	static Objetivo strToObj(String obj) {
		if (obj.equals("EuropaOceaniaTerceiro"))
			return Objetivo.EuropaOceaniaTerceiro;
		else if (obj.equals("AsiaAmericaDoSul"))
			return Objetivo.AsiaAmericaDoSul;
		else if (obj.equals("EuropaAmericaDoSulTerceiro"))
			return Objetivo.EuropaAmericaDoSulTerceiro;
		else if (obj.equals("dezoitoTerritoriosDoisExericitos"))
			return Objetivo.dezoitoTerritoriosDoisExericitos;
		else if (obj.equals("AsiaAfrica"))
			return Objetivo.AsiaAfrica;
		else if (obj.equals("AmericaDoNorteAfrica"))
			return Objetivo.AmericaDoNorteAfrica;
		else if (obj.equals("territorios24"))
			return Objetivo.territorios24;
		else if (obj.equals("AmericaDoNorteOceania"))
			return Objetivo.AmericaDoNorteOceania;
		else if (obj.equals("azuis"))
			return Objetivo.azuis;
		else if (obj.equals("amarelos"))
			return Objetivo.amarelos;
		else if (obj.equals("vermelhos"))
			return Objetivo.vermelhos;
		else if (obj.equals("pretos"))
			return Objetivo.pretos;
		else if (obj.equals("brancos"))
			return Objetivo.brancos;
		else if (obj.equals("verdes"))
			return Objetivo.verdes;
		else 
			return null;
	}
	
	//Testar
	private int trocaCarta(Carta c1, Carta c2, Carta c3, String corJogador, Carta []carta) {
		int indJog = indexJog(corJogador);
		int numExercitos = 0;
		if (aprovaTroca(c1,c2,c3)) {
			int j = 0;
			Carta[] temp = new Carta [carta.length - 3];
			for (int i = 0; i < carta.length; i++) {
				if (!carta[i].equals(c1) && !carta[i].equals(c2)) {
					if(!carta[i].equals(c3)) {
						temp[j] = carta[i];
						j++;
					}
				}
			}
			jogadores[indJog].setCartas(temp);
			numTrocas++;
			if (numTrocas < 6) {
				numExercitos = numTrocas * 2 + 2;
			}
			else {
				numExercitos = (numTrocas - 3) * 5;
			}
			Cor cor = jogadores[indJog].getCor();
			
			Geometria g1 = c1.getGeometria();
			Geometria g2 = c2.getGeometria();
			Geometria g3 = c3.getGeometria();
			
			if (!g1.equals(Geometria.coringa)) {
				Territorio t1 = c1.getTerritorio();
				if (t1.getCor().equals(cor)) {
					t1.adicionaExe();
					t1.adicionaExe();
				}
			}
			if (!g2.equals(Geometria.coringa)) {
				Territorio t2 = c2.getTerritorio();
				if (t2.getCor().equals(cor)) {
					t2.adicionaExe();
					t2.adicionaExe();
				}
			}
			if (!g3.equals(Geometria.coringa)) {
				Territorio t3 = c3.getTerritorio();
				if (t3.getCor().equals(cor)) {
					t3.adicionaExe();
					t3.adicionaExe();
				}
			}
		}
		return numExercitos;
	}

	//Funcionalidade nova
	private static int indexJog(String joga) {
		for (int i = 0; i < jogadores.length; i++) {
			if (joga.equals(jogadores[i].getCor().toString()))
				return i;
		}
		return -1;
	}
	
	//Testar
	private void conquistouContinente(Territorio destino, int ind) {
		Continente c = destino.getContinente();
		int qtd = 0, i, j;
		Cor cor = jogadores[ind].getCor();
		if (c.equals(Continente.Africa)) {
			for (i = 0; i < AFR.length; i++) {
				AFR[i] = territorios[i];
				if (AFR[i].getCor().equals(cor))
					qtd++;
			}
			if (qtd == AFR.length)
				jogadores[ind].novoContinente(c);
		}
		else if (c.equals(Continente.AmericaDoNorte)) {
			j = AFR.length;
			for (i = 0; i < ADN.length; i++) {
				ADN[i] = territorios[j];
				if (ADN[i].getCor().equals(cor))
						qtd++;
				j++;
			}
			if (qtd == ADN.length)
				jogadores[ind].novoContinente(c);
		}
		else if (c.equals(Continente.Asia)) {
			j = AFR.length + ADN.length;
			for (i = 0; i < ASI.length; i++) {
				ASI[i] = territorios[j];
				if (ASI[i].getCor().equals(cor))
					qtd++;
				j++;
			}
			if (qtd == ASI.length)
				jogadores[ind].novoContinente(c);
		}
		else if (c.equals(Continente.AmericaDoSul)) {
			j = AFR.length + ADN.length + ASI.length;
			for (i = 0; i < ADS.length; i++) {
				ADS[i] = territorios[j];
				
				if (ADS[i].getCor().equals(cor))
					qtd++;
				j++;
			}
			if (qtd == ADS.length)
				jogadores[ind].novoContinente(c);
		}
		else if (c.equals(Continente.Europa)) {
			j = AFR.length + ADN.length + ASI.length + ADS.length;
			for (i = 0; i < EUR.length; i++) {
				EUR[i] = territorios[j];
				j++;
				if (EUR[i].getCor().equals(cor))
					qtd++;
			}
			if (qtd == EUR.length)
				jogadores[ind].novoContinente(c);
		}
		else if (c.equals(Continente.Oceania)) {
			j = AFR.length + ADN.length + ASI.length + ADS.length + EUR.length;
			for (i = 0; i < OCE.length; i++) {
				OCE[i] = territorios[j];
				j++;
				if (OCE[i].getCor().equals(cor))
					qtd++;
			}
			if (qtd == OCE.length)
				jogadores[ind].novoContinente(c);
		}
	}

	//Funcionalidade nova
	int indexTer(String ter) {
		for (int i = 0; i < territorios.length; i++) {
			if (ter.equals(territorios[i].getNome()))
				return i;
		}
		return -1;
	}

	//Funcionalidade nova
	private int []rolaDado(String atacante, String defensor){
		if (autorizaAtaque(atacante, defensor)) {
			int []dados = {0, 0, 0, 0, 0, 0};
			int i = 0;
			int indAtaque = indexTer(atacante);
			int indDefesa = indexTer(defensor);
			int numExeAtaque = territorios[indAtaque].getNumExe() - 1;
			int numExeDefesa = territorios[indDefesa].getNumExe();
			
			Random gerador = new Random();
			
			if (numExeAtaque > 3)
				numExeAtaque = 3;
			if (numExeDefesa > 3)
				numExeDefesa = 3;
			for (i = 0; i < numExeAtaque; i++)
				dados[i] = gerador.nextInt(6) + 1;
			for (i = 0; i < numExeDefesa; i++)
				dados[i+3] = gerador.nextInt(6) + 1;
			return dados;
		}
		return null;
	}

	//Testar
	public int [] ataque(String origem, String destino) {
		
		int indOr = indexTer(origem);
		int indDe = indexTer(destino);
		Cor cor = territorios[indOr].getCor();
		int indJog = indexJog(cor.toString());
		
		int []dados = rolaDado(origem, destino);
		
		int numVit = 0, numDer = 0, i = 0, aux;
		
		if (dados[1] != 0) {
			if (dados[2] != 0) {
				if (dados[2] > dados[0]) {
					aux = dados[0];
					dados[0] = dados[2];
					dados[2] = aux;
				}
				if (dados[2] > dados[1]) {
					aux = dados[0];
					dados[0] = dados[2];
					dados[2] = aux;
				}
			}
			else if (dados[1] > dados[0]) {
				aux = dados[0];
				dados[0] = dados[1];
				dados[1] = aux;
			}
		}
		if (dados[4] != 0) {
			if (dados[5] != 0) {
				if (dados[5] > dados[3]) {
					aux = dados[3];
					dados[3] = dados[5];
					dados[5] = aux;
				}
				if (dados[5] > dados[4]) {
					aux = dados[3];
					dados[3] = dados[5];
					dados[5] = aux;
				}
			}
			else if (dados[4] > dados[3]) {
				aux = dados[3];
				dados[3] = dados[4];
				dados[4] = aux;
			}
		}
		
		while (i < 3) {
			if (dados[i] != 0 && dados[i+3] != 0) {
				if (dados[i] > dados[i+3])
					numVit++;
				else
					numDer++;
			}
			i++;
		}
		
		territorios[indOr].perdeExe(numDer);
		territorios[indDe].perdeExe(numVit);
		
		if (territorios[indDe].getNumExe() < 1){ 
			String corDerrota = territorios[indDe].getCor().toString();
			int indDerrota = indexJog(corDerrota);
			jogadores[indDerrota].perdeTer();
			int numNovo = territorios[indOr].getNumExe()/2;
			territorios[indOr].perdeExe(numNovo);
			territorios[indDe].conquista(cor, numNovo);
			jogadores[indJog].aumentaTer();
			jogadores[indJog].podeComprar();
			System.out.println("Jogador Pode comprar");
			conquistouContinente(territorios[indDe], indJog);
						
		}
		return dados;
	}
	
	public Territorio[] getTerritorios() {
		return territorios;
	}
	
	//Funcionalidade nova
	public Set<String> buscaCartas(String cor) {
		Set<String> s = new HashSet<String>();
		int indJog = indexJog(cor);
		if (indJog > -1) {
			Carta[] c = jogadores[indJog].getArrayCartas();
			if(c.length > 0) {
				
				for(int j = 0; j < c.length; j++) {
					s.add(c[j].getUrl());
				}
				return s;
			}
		}
		return null;
	}
	
	//verificar necessidade
	public int buscaDistribui (String cor) {
		int indJog = indexJog(cor);
		if (indJog > -1)
				return jogadores[indJog].getDistribuiExe();
		return -1;
	}
	
	//Fazer alteração -- Feita
	public void distribuiExercito (String cor, String territorio) {
		int indJog = indexJog(cor);
		if (indJog > -1)
			 jogadores[indJog].distribuiu();
		
		int indTer = indexTer(territorio);
		if (indTer > -1)
			territorios[indTer].adicionaExe();
	}
	
	//De onde veio isso? -- perguntar ao nobrega
	public String[] buscaCaracTerritorio (String nome) {
		int indTer = indexTer(nome);
		if (indTer > -1) {
			String [] array = {transformaCorIngles(territorios[indTer].getCor()),Integer.toString(territorios[indTer].getNumExe())};
			return array;
		}
		return null;
	}
	//Funcao para a cor do html
	private String transformaCorIngles (Cor c) {
		if(c == Cor.amarelo) {
			return "ORANGE";
		}
		else if(c == Cor.azul) {
			return "BLUE";
		}
		else if(c == Cor.branco) {
			return "PURPLE";
		}
		else if(c == Cor.preto) {
			return "BLACK";
		}
		else if(c == Cor.verde) {
			return "GREEN";
		}
		else {
			return "RED";
		}
	}
	//De onde veio isso? -- perguntar ao nobrega
	public boolean temVizinhos (String nome, String cor){
		int indTer = indexTer(nome);
		if (indTer > -1) {
			for(Territorio t: territorios[indTer].getVizinhos()) {
				if(t.getCor().toString().equals(cor)) {
					return true;
				}
			}
		}
		return false;
	}
	

	//Fazer alterações -- feito pelo nobrega
	public void compraCarta (String cor) {
		int indJog = indexJog(cor);
		if (indJog > -1) {
			if(jogadores[indJog].getCompra()) {
				Random r = new Random();
				List<String> keysAsArray = new ArrayList<String>(cartas.keySet());
				int index = r.nextInt(keysAsArray.size());
				jogadores[indJog].adicionaCarta(cartas.get(keysAsArray.get(index)));
				System.out.println("Jogador comprou");
				jogadores[indJog].jaComprou();
			}
		}
	}
	
	private static Map<String, Carta>transformaSet (Carta[] temp) {
		Map<String,Carta> map = new HashMap<String,Carta>();
		for (int i = 0; i < temp.length; i++) {
			map.put(temp[i].getUrl(), temp[i]);
		}
		return map;
	}
	
	private Jogador []getJogadores () {
		return jogadores;
	}
	
	//Fazer alterações -- Feita
	public void recebeTroca (int i1,int i2, int i3, String cor) {
		int indJog = indexJog(cor);
		if (indJog > -1) {
			Carta[] array = jogadores[indJog].getArrayCartas();
			int num = trocaCarta(array[i1],array[i2],array[i3],cor,array);
			jogadores[indJog].aumentaExe(num);
		}
	}
	//Somente para V1
	public Set<String> buscaVizinhos(String cor){
		Set<String> vizinhos = new HashSet<String>();
		for(int i = 0; i < territorios.length; i++) {
			if(territorios[i].getCor().toString().equals(cor)) {
				for(Territorio v: territorios[i].getVizinhos()) {
					vizinhos.add(v.getNome());
				}
			}
		}
		return vizinhos;
	}
	public static void main(String[] args) {
		String []nomes = {"teste1", "teste2", "teste3", "teste4"};
		String []cores = {"vermelho","amarelo","azul","preto"};
		Armazenamento a = new Armazenamento ("testandoSalva.txt");
		System.out.printf("Jogador 1 - numero de cartas = %d\nJogador 2 - numero de cartas = %d\n", a.getJogadores()[0].getArrayCartas().length, a.getJogadores()[1].getArrayCartas().length);
		a.salvaJogo("testandoSalva");
	}
	
	

	
	


}
