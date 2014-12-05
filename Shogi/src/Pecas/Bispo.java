package Pecas;

import Logica.Jogador;

public class Bispo extends Peca {

	public Bispo(Jogador jogador) {
		super(jogador);
		// TODO Auto-generated constructor stub
	}

	@Override
	boolean movimentacao(int linhaAtual, int colunaAtual, int linhaFinal,
			int colunaFinal) {
		boolean validade;

		if (linhaAtual == linhaFinal || colunaAtual == colunaFinal) {
			validade = false;
		} else {
			int linhas = linhaAtual - linhaFinal;
			int colunas = colunaAtual - colunaFinal;
			if ((linhas + colunas) == 0 || linhas == colunas) {
				validade = true;
			} else {
				validade = false;
			}
		}

		return validade;
	}
}
