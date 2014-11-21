package Logica;

public class Jogador {
	protected String nome;
	protected boolean habilitado;
	protected boolean vencedor;
	protected boolean conectado;
	
	public Jogador(String nome){
		this.nome = nome;		
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public boolean habilitado() {
		return habilitado;
	}
	
	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	
	public boolean vencedor() {
		return vencedor;
	}
	
	public void setVencedor(boolean vencedor) {
		this.vencedor = vencedor;
	}
	
	public boolean conectado() {
		return conectado;
	}
	
	public void setConectado(boolean conectado) {
		this.conectado = conectado;
	}

}
