package Pecas;

import javax.swing.ImageIcon;

import Logica.Jogador;

public class Lanceiro extends Peca {

	public Lanceiro(Jogador jogador) {
		super(jogador);
		icone = new ImageIcon(cl.getResource("lanceiro.png"));
	}

	@Override
	boolean movimentacao(int linhaAtual, int colunaAtual, int linhaFinal,
			int colunaFinal) {
		boolean validade;
		if (!(linhaFinal > linhaAtual)) {
			if (colunaAtual == colunaFinal) {
				validade = true;
			} else {
				validade = false;
			}
		} else {
			validade = false;
		}
		return validade;
	}

}
