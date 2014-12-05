package Pecas;

import Logica.Jogador;

public abstract class Peca {
	protected Jogador jogador;
	
	public Peca(Jogador jogador){
		this.jogador=jogador;
	}
	
	abstract boolean movimentacao(int linhaAtual, int colunaAtual, int linhaFinal, int colunaFinal);
	
}
