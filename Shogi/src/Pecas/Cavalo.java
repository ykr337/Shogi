package Pecas;

import Logica.Jogador;

public class Cavalo extends Peca {

	public Cavalo(Jogador jogador) {
		super(jogador);
		// TODO Auto-generated constructor stub
	}

	@Override
	boolean movimentacao(int linhaAtual, int colunaAtual, int linhaFinal,
			int colunaFinal) {
		boolean validade;
		
		if(linhaFinal == linhaAtual-2 &&(colunaFinal == colunaAtual+1 || colunaFinal == colunaAtual-1)){
			validade = true;
		}else{
			validade = true;
		}
		return validade;
	}


}
