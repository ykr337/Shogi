package Pecas;

import Logica.Jogador;

public class GeneralOuro extends Peca{

	public GeneralOuro(Jogador jogador) {
		super(jogador);
		// TODO Auto-generated constructor stub
	}

	@Override
	boolean movimentacao(int linhaAtual, int colunaAtual, int linhaFinal,
			int colunaFinal) {
		boolean validade = true;
		if (linhaFinal > linhaAtual + 1 || linhaFinal < linhaAtual - 1
				|| colunaFinal > colunaAtual + 1
				|| colunaFinal < colunaAtual - 1) {
			validade = false;
		}else{
			if(linhaFinal>linhaAtual && (colunaFinal > colunaAtual ||colunaFinal<colunaAtual)){
				validade = false;
			}
		}				
		return validade;
	}

	

}
