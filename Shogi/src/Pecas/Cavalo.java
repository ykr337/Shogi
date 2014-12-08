package Pecas;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Logica.Jogador;

public class Cavalo extends Peca {

	

	

	public Cavalo(Jogador jogador) {
		super(jogador);
		icone = new ImageIcon(cl.getResource("cavalo.png"));
	}

	@Override
	public boolean movimentacao(int linhaAtual, int colunaAtual, int linhaFinal,
			int colunaFinal) {
		boolean validade;
		
		if(linhaFinal == linhaAtual-2 &&(colunaFinal == colunaAtual+1 || colunaFinal == colunaAtual-1)){
			validade = true;
		}else{
			validade = false;
		}
		return validade;
	}


}
