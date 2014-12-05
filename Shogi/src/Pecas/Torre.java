package Pecas;

import Logica.Jogador;

public class Torre extends Peca{

	public Torre(Jogador jogador) {
		super(jogador);
		// TODO Auto-generated constructor stub
	}

	@Override
	boolean movimentacao(int linhaAtual, int colunaAtual, int linhaFinal,
			int colunaFinal) {
		boolean validade;
		if(linhaFinal == linhaAtual || colunaFinal == colunaAtual){
			validade = true;
		}else{
		
			validade = false;
		}
		return validade;
	}

}
