package Pecas;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Logica.Jogador;
import javax.swing.ImageIcon;

public abstract class Peca {
	protected Jogador jogador;
	protected Icon icone;
	ClassLoader cl = this.getClass().getClassLoader();	
	
	public Peca(Jogador jogador){
		this.jogador=jogador;
		
	}
	
	public abstract boolean movimentacao(int linhaAtual, int colunaAtual, int linhaFinal, int colunaFinal);
	
	
	
	public Icon getIcone(){
	return this.icone;
	}
	
	public Jogador getJogador(){
		return this.jogador;
	}
	
}