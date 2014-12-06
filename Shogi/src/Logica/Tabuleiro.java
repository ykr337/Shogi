package Logica;

import java.awt.geom.GeneralPath;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Netgames.Lance;
import Pecas.*;

public class Tabuleiro {
	protected Posicao[][] posicoes;
	protected boolean andamento;
	protected boolean posicaoSelecionada;
	protected boolean pecaSelecionada;
	protected Jogador jogadorLocal;
	protected Jogador jogadorRemoto;
	
	public Tabuleiro(){
//		jogadorLocal= jogador1;
//		jogadorRemoto = jogador2;
		posicoes = new Posicao[9][9];
		for (int linha = 0;linha<9; linha++ ){
			for(int coluna = 0; coluna<9; coluna++){
				posicoes[linha][coluna] = new Posicao(linha, coluna);
			}
		}
	}
	
	public void inicializar(Jogador jogador1, Jogador jogador2){
		jogadorLocal = jogador1;
		jogadorRemoto = jogador2;
		alocarPecasIniciais();
	}
	
	private void posicionaPecaLocal() {
		posicoes[8][0].setPeca(new Lanceiro(jogadorLocal)); 
		posicoes[8][8].setPeca(new Lanceiro(jogadorLocal));
		posicoes[8][1].setPeca(new Cavalo(jogadorLocal));
		posicoes[8][7].setPeca(new Cavalo(jogadorLocal));
		posicoes[8][2].setPeca(new GeneralPrata(jogadorLocal));
		posicoes[8][6].setPeca(new GeneralPrata(jogadorLocal));
		posicoes[8][3].setPeca(new GeneralOuro(jogadorLocal));
		posicoes[8][5].setPeca(new GeneralOuro(jogadorLocal));
		posicoes[8][4].setPeca(new Rei(jogadorLocal));
		posicoes[7][1].setPeca(new Bispo(jogadorLocal));
		posicoes[7][7].setPeca(new Torre(jogadorLocal));
		for(int coluna = 0; coluna<9; coluna ++){
			posicoes[6][coluna].setPeca(new Peao(jogadorLocal));
		}
	}

	private void posicionaPecaRemoto() {
		posicoes[0][0].setPeca(new Lanceiro(jogadorRemoto)); 
		posicoes[0][8].setPeca(new Lanceiro(jogadorRemoto)); 
		posicoes[0][1].setPeca(new Cavalo(jogadorRemoto));
		posicoes[0][7].setPeca(new Cavalo(jogadorRemoto));
		posicoes[0][2].setPeca(new GeneralPrata(jogadorRemoto));
		posicoes[0][6].setPeca(new GeneralPrata(jogadorRemoto));
		posicoes[0][3].setPeca(new GeneralOuro(jogadorRemoto));
		posicoes[0][5].setPeca(new GeneralOuro(jogadorRemoto));
		posicoes[0][4].setPeca(new Rei(jogadorRemoto));
		posicoes[1][1].setPeca(new Bispo(jogadorRemoto));
		posicoes[1][7].setPeca(new Torre(jogadorRemoto));
		for(int coluna = 0; coluna<9; coluna ++){
			posicoes[2][coluna].setPeca(new Peao(jogadorRemoto));
		}
		
	}

	private void alocarPecasIniciais() {
		posicionaPecaRemoto();
		posicionaPecaLocal();
				
	}

	public boolean getAndamento(){
		return andamento;
	}
	
	public void setAndamento(boolean andamento){
		this.andamento = andamento;
	}

	public void receberLance(Lance lance) {
		// TODO Auto-generated method stub
		
	}
	
	public Posicao[][] getPosicoes(){
		return posicoes;
	}
	
	
	}
	
	