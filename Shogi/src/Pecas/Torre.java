package Pecas;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Logica.Jogador;

public class Torre extends Peca{



	public Torre(Jogador jogador) {
		super(jogador);
		icone = new ImageIcon(cl.getResource("torre.png"));
	}

	@Override
	public boolean movimentacao(int linhaAtual, int colunaAtual, int linhaFinal,
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
