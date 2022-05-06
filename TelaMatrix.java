package com.aed.soft.codex;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TelaMatrix extends JFrame {

	private static final long serialVersionUID = 1L;

	/** esta classe representa a janela que vai apresentar a chuva de codigos */
	public static void removeThis(JPanel panel) {
		
		
	}
	public TelaMatrix() {
		Random r  =  new Random();
		Dimension din = getToolkit().getScreenSize();
		Container c = this.getContentPane();
		c.setLayout(new GridLayout(1, 1));
		c.setBackground(Color.BLACK);
		setBackground(Color.BLACK);
		// as linhas serão adcionadas de forma dinamica

		setVisible(true);
		for (int i = 0; i < 50; i++) {
      
			c.add(new Linha(1000,r.nextInt()));
			repaint();

		}
		c.add(new Linha(1000,r.nextInt()));

		setSize(din.width, din.height);
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	
	}
	public static void main(String[] args) {
		new TelaMatrix();

	}

}
