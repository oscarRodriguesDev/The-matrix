package com.aed.soft.codex;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Linha extends JPanel {
	private int x, y, posIni;

	@SuppressWarnings("unused")
	private Graphics g;

	private static final long serialVersionUID = 1L;
	/** Esta classe vai receber a linha dos codigos */ // Codex codex = new Codex();
	Random r = new Random();
	Codigo codigo;

	public void paintComponent(Graphics g) {
		this.g = g;
		codigo = new Codigo(x, y, g);
		g.dispose();

		// controla a velocidade da caida da chuva
		y += 15;
		repaint();

		// quando o codigo chegar ao valor y informado, ele deverá receber um valor
		// negativo randomico para recomeçar
		if (y > 800) {
			y = -1 * r.nextInt(posIni);


			repaint();

		}

		repaint();
	}

	public Linha(int posIni, int posY) {

		this.posIni = posIni;
		x = 0;// x inicial
		y = posY - 700;// y inicial
		repaint();

		this.setVisible(true);

	}

}
