package Pecas;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Logica.Jogador;

public class GeneralOuro extends Peca{


	

	public GeneralOuro(Jogador jogador) {
		super(jogador);
		icone = new ImageIcon(cl.getResource("general_ouro.png"));
	}

	@Override
	public boolean movimentacao(int linhaAtual, int colunaAtual, int linhaFinal,
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
