package Logica;

import GUI.JanelaJogo;
import Netgames.AtorNetgames;

public class Controlador {
	protected JanelaJogo janela;
	protected Tabuleiro tabuleiro;
	protected Jogador jogador;
	protected AtorNetgames ator;
	public Controlador( ){
		
	}
	
	public void iniciar(){
		janela = new JanelaJogo(this);
		tabuleiro = new Tabuleiro();
		janela.interaja();
	}

	public void conectar(String nome) {
		String problema;
		jogador = new Jogador(nome);
		ator = new AtorNetgames(this);
		problema = ator.conectar(nome, "venus.inf.ufsc.br");
		
		if (problema != null){
			janela.alertaJogador(problema);
		}else{
			jogador.setConectado(true);
			janela.alertaJogador("conectado com sucesso");
		}
	}
	

}
