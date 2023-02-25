package view.components;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class PainelImagem extends JPanel{
	private static final long serialVersionUID = 1L;
	public Image i;//imagem de fundo
	public int CORD_X;
	public int CORD_Y;
	
	public PainelImagem (Image imagem, int x, int y) {
		i = imagem;
		CORD_X = x;
		CORD_Y = y;
	}
	
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		g.drawImage(i,CORD_X,CORD_Y, null);
	}
}
