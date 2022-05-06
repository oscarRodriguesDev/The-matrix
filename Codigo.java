
package com.aed.soft.codex;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

public class Codigo {

	/** configurações de posição e movimento do codigo */
	@SuppressWarnings("unused")
	// variaveis para localização e velocidade dos codigos
	private int x, y, v;
	protected Codex cod;
	boolean pintar = false;

	// escolha randomica do tempo
	Random rnd = new Random();

	/**
	 * o construtor vai definir os caracteres bem como sua posição na hora de ser
	 * desenhado na tela
	 */
	public Codigo(int x, int y, Graphics graphics) {

		this.y = y;
		
		// codex, local de onde vem os codigos
		cod = new Codex();
		Font font = new Font("Arial", Font.PLAIN, 12);

		// cores rgb
		int g = 5;
		int r = 8;
		int b = 0;

		boolean fim = false;
         
		v =rnd.nextInt(11);
		//fazer com que o v sempre fique entre 8 e 11
		if(v<8) {
			v=8;
		}
		if(v>11) {
			v=11;
		}
		System.out.println(v);
		long l = (long) rnd.nextInt(5);
		try {
			Thread.sleep(l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < 50; i++) {
			// limitação das cores
			if (r > 255) {
				r = 255;
			}

			if (g > 255) {
				g = 255;
			}
			if (b > 255) {
				b = 255;
			}

			// incrementando a cor verde
			g += 5;
			
			// definição das cores do codigo
			Color color = new Color(r, g, b);
			graphics.setFont(font);
			graphics.setColor(color);
			// pintura do codigo
			graphics.drawString(selectCode(cod.getCode()), x, y += v);
			// pintura da borracha que vai retornar à cor de fundo da tela
			graphics.drawString(selectCode(cod.getCode()), x, y += v);
			graphics.setColor(Color.black);
			graphics.fillRect(x, y -= 10, 30, 10);
	
			// teste pra saber se está finalizando o codigo para clarear a cor padrão
			if (i == 40) {
				fim = true;
				r = 150;
				b = 150;
			}
			// incremento caso o codigo já esteja finalizando
			if (fim) {
				r++;
				b++;
			}
		}

	}

	/** este metodo vai retornar o caractere que será pintado na tela */
	@SuppressWarnings("unused")
	private String selectCode(String str) {
		Random r = new Random();
		char caractere = str.charAt(r.nextInt(str.length()));

		return String.valueOf(caractere);

	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
