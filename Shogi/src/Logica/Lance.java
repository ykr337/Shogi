package Logica;

import Pecas.Peca;
import Pecas.Rei;
import Pecas.Bispo;
import Pecas.Torre;
import Pecas.Lanceiro;

public class Lance {
	protected int linha;
	protected int coluna;
	protected boolean temPecaNaPosicao;
	protected Tabuleiro tabuleiro;

	public Lance(int linha, int coluna, boolean temPecaNaPosicao,
			Tabuleiro tabuleiro) {
		this.linha = linha;
		this.coluna = coluna;
		this.temPecaNaPosicao = temPecaNaPosicao;
		this.tabuleiro = tabuleiro;
	}

	public boolean tratarLance() {
		Posicao posicao = tabuleiro.getPosicaoSelecionada();
		Peca peca = posicao.getPeca();
		boolean valida = peca.movimentacao(posicao.getLinha(),
				posicao.getColuna(), linha, coluna);
		if (valida) {
			if (peca instanceof Bispo) {
				valida = verificaPercursoBispo(posicao.getLinha(),
						posicao.getColuna());

			} else if (peca instanceof Torre) {
				valida = verificaPercursoTorre(posicao.getLinha(),
						posicao.getColuna());
			} else if (peca instanceof Lanceiro) {
				valida = verificaPercursoLanceiro(posicao.getLinha());
			}
		}

		if (valida) {
			mover();
		}

		return valida;
	}

	private boolean verificaPercursoLanceiro(int linhaInicial) {
		Posicao[][] posicoes = tabuleiro.getPosicoes();
		boolean percursoValido = true;
		for (int i = linhaInicial - 1; i > linha; i--) {
			if (posicoes[i][coluna].getPeca() != null) {
				percursoValido = false;
			}
		}
		return percursoValido;

	}

	private boolean verificaPercursoTorre(int linhaAtual, int colunaAtual) {
		Posicao[][] posicoes = tabuleiro.getPosicoes();
		boolean percursoValido = true;
		if (coluna == colunaAtual) {
			if (linha < linhaAtual) {
				percursoValido = verificaPercursoLanceiro(linhaAtual);

			} else {
				for (int i = linhaAtual + 1; i < linha; i++) {
					if (posicoes[i][coluna].getPeca() != null) {
						percursoValido = false;
					}
				}
			}
		} else {
			if (colunaAtual < coluna) {
				for (int i = colunaAtual + 1; i < coluna; i++) {
					if (posicoes[linha][i].getPeca() != null) {
						percursoValido = false;
					}
				}
			} else {
				for (int i = colunaAtual - 1; i > coluna; i--) {
					if (posicoes[linha][i].getPeca() != null) {
						percursoValido = false;
					}
				}

			}
		}
		return percursoValido;
	}

	private boolean verificaPercursoBispo(int linhaInicial, int colunaInicial) {
		boolean percursoValido = true;
		int linhaAux;
		int colunaAux;
		if (linhaInicial > linha && colunaInicial < coluna) {
			linhaAux = linhaInicial - 1;
			colunaAux = colunaInicial + 1;
			while (linhaAux != linha && colunaAux != coluna) {
				Peca peca = tabuleiro.GetPecaNaPosicao(linhaAux, colunaAux);
				if (peca != null) {
					percursoValido = false;
					break;
				}
				linhaAux--;
				colunaAux++;
			}
		} else if (linhaInicial > linha && colunaInicial > coluna) {
			linhaAux = linhaInicial - 1;
			colunaAux = colunaInicial - 1;
			while (linhaAux != linha && colunaAux != coluna) {
				Peca peca = tabuleiro.GetPecaNaPosicao(linhaAux, colunaAux);
				if (peca != null) {
					percursoValido = false;
					break;
				}
				linhaAux--;
				colunaAux--;
			}
		} else if (linhaInicial < linha && colunaInicial < coluna) {
			linhaAux = linhaInicial + 1;
			colunaAux = colunaInicial + 1;
			while (linhaAux != linha && colunaAux != coluna) {
				Peca peca = tabuleiro.GetPecaNaPosicao(linhaAux, colunaAux);
				if (peca != null) {
					percursoValido = false;
					break;
				}
				linhaAux++;
				colunaAux++;
			}
		} else {
			linhaAux = linhaInicial + 1;
			colunaAux = colunaInicial - 1;
			while (linhaAux != linha && colunaAux != coluna) {
				Peca peca = tabuleiro.GetPecaNaPosicao(linhaAux, colunaAux);
				if (peca != null) {
					percursoValido = false;
					break;
				}
				linhaAux++;
				colunaAux--;

			}
		}
		return percursoValido;
	}

	private void comerPeca() {
		Peca rei = tabuleiro.GetPecaNaPosicao(linha, coluna);
		Posicao selecionada = tabuleiro.getPosicaoSelecionada();
		tabuleiro.alocapeca(linha, coluna, selecionada.getPeca());
		tabuleiro.removePeca(selecionada.getLinha(), selecionada.getColuna());

		if (rei instanceof Rei) {
			tabuleiro.reiMorto();
		}
	}

	private void mover() {
		if (temPecaNaPosicao) {
			comerPeca();
		} else {
			Posicao selecionada = tabuleiro.getPosicaoSelecionada();
			tabuleiro.alocapeca(linha, coluna, selecionada.getPeca());
			tabuleiro.removePeca(selecionada.getLinha(),
					selecionada.getColuna());
		}
	}
}
