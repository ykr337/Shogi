package Logica;

public class Jogador {
	protected String nome;
	protected boolean habilitado;
	protected boolean vencedor;
	protected boolean conectado;
	
	public Jogador(){
		
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public boolean ishabilitado() {
		return habilitado;
	}
	
	public void habilita() {
		this.habilitado = true;
	}
	
	public void desabilita(){
		this.habilitado = false;
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
