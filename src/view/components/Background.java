package view.components;

import java.awt.*;

import javax.swing.*;

//Classe responsavel por paineis com imagens de fundo
public class Background extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Image i;//imagem de fundo
	public int CORD_X;
	public int CORD_Y;
	
	public Background (Image imagem, int x, int y) {
		i = imagem;
		CORD_X = x;
		CORD_Y = y;
	}
	
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		g.drawImage(i,CORD_X,CORD_Y, null);
	}
}
