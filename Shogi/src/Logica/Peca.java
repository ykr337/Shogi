package Logica;

public abstract class Peca {
	protected Jogador jogador;
	
	public Peca(Jogador jogador){
		this.jogador=jogador;
	}
	
	abstract boolean movimentacao();
	
}
