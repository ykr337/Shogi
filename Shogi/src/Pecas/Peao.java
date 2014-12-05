package Pecas;

import Logica.Jogador;

public class Peao extends Peca{

	public Peao(Jogador jogador) {
		super(jogador);
		// TODO Auto-generated constructor stub
	}

	@Override
	boolean movimentacao(int linhaAtual, int colunaAtual, int linhaFinal, int colunaFinal) {
		boolean validade;
		if(linhaFinal==linhaAtual-1 && colunaFinal==colunaAtual){
			validade = true;
		}else{
			validade = false;
		}
		return validade;
	}

}
