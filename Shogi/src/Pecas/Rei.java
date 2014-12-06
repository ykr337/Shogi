package Pecas;

import javax.swing.ImageIcon;

import Logica.Jogador;

public class Rei extends Peca {

	public Rei(Jogador jogador) {
		super(jogador);
		icone = new ImageIcon(cl.getResource("rei.png"));
	}

	@Override
	public boolean movimentacao(int linhaAtual, int colunaAtual, int linhaFinal,
			int colunaFinal) {
		boolean validade;
		if ((linhaFinal >= linhaAtual - 1 && linhaFinal <= linhaAtual + 1)
				&& (colunaFinal >= colunaAtual - 1 && colunaFinal <= colunaAtual + 1)) {
			
			validade = true;
		
		} else {
		
			validade = false;
		
		}

		return validade;
	}

}
