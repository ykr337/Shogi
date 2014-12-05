package Logica;

import GUI.JanelaJogo;
import Netgames.AtorNetgames;
import Netgames.Lance;

public class Controlador {
	protected JanelaJogo janela;
	protected Tabuleiro tabuleiro;
	protected Jogador jogador;
	protected AtorNetgames atorNetgames;

	public Controlador() {
	}

	public void iniciar() {
		janela = new JanelaJogo(this);
		tabuleiro = new Tabuleiro();
		janela.interaja();
		jogador = new Jogador();
	}

	public void conectar(String nome) {
		String problema;
		jogador.setNome(nome);
		atorNetgames = new AtorNetgames(this);
		problema = atorNetgames.conectar(nome, "venus.inf.ufsc.br");

		if (problema != null) {
			janela.alertaJogador(problema);
		} else {
			jogador.setConectado(true);
			janela.alertaJogador("conectado com sucesso");
		}
	}

	// metodo usado sempre que o usuario quiser iniciar a partida,enviando
	// convite para alguem
	public void iniciarPartidaServidor() {
		boolean conectado = jogador.conectado();
		boolean andamento = tabuleiro.getAndamento();
		
		if (conectado) {
			if(!andamento){
			atorNetgames.iniciarPartidaRede();
			tabuleiro.setAndamento(true);
			} else{
				janela.alertaJogador("Já há uma partida em andamento");
			}
			
		} else{
			janela.alertaJogador("você não está conectado");
		}
	}

	public void receberLance(Lance lance) {
		tabuleiro.receberLance(lance);
		jogador.desabilita();

	}

	public void desconectar() {
		boolean andamento = tabuleiro.getAndamento();
		if (andamento) {
			finalizaPartida();
		} else {
			String problema = atorNetgames.desconectar();
			if (problema != null) {
				janela.alertaJogador("você nao está conectado");
			}
		}
	}

	private void finalizaPartida() {
		tabuleiro.setAndamento(false);
	}

	// Metodo acionado quando o AtorNetGames recebe uma solicitacao de Inicio
	// chamado pelo metodo IniciarNovaPartida do ator.
	public void iniciarPartidaRede(int vez) {
		String nome;
		Jogador adversario;
		// De acordo com a vez, habilita ou desabilita jogador
		// Verificar, processo de criacao do tabuleiro e alocacao de pecas
		if (vez == 1) {
			jogador.habilita();
			nome = atorNetgames.obterNomeAdversario(2);
			adversario = new Jogador();

		} else {
			jogador.desabilita();
			nome = atorNetgames.obterNomeAdversario(1);
			adversario = new Jogador();
			adversario.setNome(nome);
		}

	}

	public void enviarJogada(Lance lance) {
		atorNetgames.enviarJogada(lance);
		jogador.desabilita();
	}

}
