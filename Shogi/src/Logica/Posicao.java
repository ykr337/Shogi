package Logica;

public class Posicao {
	protected int linha;
	protected int coluna;
	protected Peca peca;
	
	public int getLinha() {
		return linha;
	}
	
	
	public int getColuna() {
		return coluna;
	}
		
	public Peca getPeca() {
		return peca;
	}
	
	public void setPeca(Peca peca) {
		this.peca = peca;
	}
		
}
