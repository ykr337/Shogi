package Logica;

import Pecas.Peca;
import Pecas.Rei;

public class Lance {
	protected int linha;
	protected int coluna;
	protected boolean temPecaNaPosicao;
	protected Tabuleiro tabuleiro;
	
	public Lance(int linha, int coluna, boolean temPecaNaPosicao,
			Tabuleiro tabuleiro){
		this.linha = linha;
		this.coluna = coluna;
		this.temPecaNaPosicao = temPecaNaPosicao;
		this.tabuleiro=tabuleiro;
	}
	
	public boolean tratarLance(){
		Posicao posicao = tabuleiro.getPosicaoSelecionada();
		Peca peca = posicao.getPeca();
		boolean valida = peca.movimentacao(posicao.getLinha(), posicao.getColuna(), linha, coluna);
		
		if(valida && temPecaNaPosicao){
			comerPeca();
		}else if(valida){
			Posicao selecionada = tabuleiro.getPosicaoSelecionada();
			tabuleiro.alocapeca(linha, coluna, selecionada.getPeca());
			tabuleiro.removePeca(selecionada.getLinha(), selecionada.getColuna());
		}
		return valida;
	}

	private void comerPeca() {
		Peca rei = tabuleiro.GetPecaNaPosicao(linha, coluna);
		Posicao selecionada = tabuleiro.getPosicaoSelecionada();
		tabuleiro.alocapeca(linha, coluna, selecionada.getPeca());
		tabuleiro.removePeca(selecionada.getLinha(), selecionada.getColuna());
		
		if(rei instanceof Rei){
			tabuleiro.reiMorto();
		}
	}
}
