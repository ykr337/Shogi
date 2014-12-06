package Pecas;

import javax.swing.ImageIcon;

import Logica.Jogador;

public class Peao extends Peca{

	public Peao(Jogador jogador) {
		super(jogador);
		icone = new ImageIcon(cl.getResource("peao.png"));
	}

	@Override
	public boolean movimentacao(int linhaAtual, int colunaAtual, int linhaFinal, int colunaFinal) {
		boolean validade;
		if(linhaFinal==linhaAtual-1 && colunaFinal==colunaAtual){
			validade = true;
		}else{
			validade = false;
		}
		return validade;
	}

}
