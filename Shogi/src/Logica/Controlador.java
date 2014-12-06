package Logica;

import GUI.JanelaJogo;
import Netgames.AtorNetgames;
import Netgames.JogadaValida;
import Pecas.Peca;

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
			janela.aguardandoInicio();
			} else{
				janela.alertaJogador("Já há uma partida em andamento");
			}
			
		} else{
			janela.alertaJogador("você não está conectado");
		}
	}

	public void receberLance(JogadaValida lance) {
		tabuleiro.receberLance(lance);
		jogador.habilita();
		janela.imprimeTabuleiro(tabuleiro.getPosicoes());
		janela.setMensagemPainel("sua vez!");

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
			janela.setMensagemPainel("sua vez!");

		} else {
			jogador.desabilita();
			nome = atorNetgames.obterNomeAdversario(1);
			adversario = new Jogador();
			adversario.setNome(nome);
			janela.setMensagemPainel("aguarde sua vez!");
		}
		janela.criaTabuleiro();
		tabuleiro.inicializar(jogador, adversario);
		tabuleiro.setAndamento(true);
		janela.setDadosJogadores(jogador.getNome(), adversario.getNome());
		Posicao[][] tabuleiroInterface = tabuleiro.getPosicoes();
		janela.imprimeTabuleiro(tabuleiroInterface);
	}

	public void enviarJogada(JogadaValida lance) {
		atorNetgames.enviarJogada(lance);
		jogador.desabilita();
	}

	public void posicaoClicada(int linha, int coluna) {
		boolean andamento = tabuleiro.getAndamento();
		boolean habilitado = jogador.ishabilitado();
		boolean temPecaNaPosicao = tabuleiro.temPecaNaPosicao(linha, coluna);
		boolean temPecaSelecionada = tabuleiro.getHaPecaSelecionada();
		boolean valido;
		if(andamento){
			if(habilitado){
				if(temPecaNaPosicao){
					boolean pertence = tabuleiro.pertenceAoJogador(jogador, linha,coluna);
					if(pertence){
						tabuleiro.selecionaPeca(linha, coluna);
					}else{
						if(temPecaSelecionada){
							valido = realizaJogada(linha, coluna, temPecaNaPosicao, tabuleiro);
								if(valido){
									Posicao atual = tabuleiro.getPosicaoSelecionada();
									JogadaValida jogada = new JogadaValida(atual.getLinha(), atual.getColuna(), linha, coluna);
									passarVez(jogada);
								}else{
									janela.alertaJogador("Jogada Invalida");
								}
						}else{
							janela.alertaJogador("Peca do Adversario");
						}
					}
				}else{
					if(temPecaSelecionada){
						valido = realizaJogada(linha, coluna, temPecaNaPosicao, tabuleiro);
						if(valido){
							Posicao atual = tabuleiro.getPosicaoSelecionada();
							JogadaValida jogada = new JogadaValida(atual.getLinha(), atual.getColuna(), linha, coluna);
							passarVez(jogada);
						}else{
							janela.alertaJogador("Jogada Invalida");
						}
					}else{
						janela.alertaJogador("voce ainda nao possui uma peca selecionada");
					}
				}
			}else{
				janela.alertaJogador("Não é a sua vez!");
			}
		}else{
			janela.alertaJogador("Não há uma partida em andamento");
		}
		
	}

	private void passarVez(JogadaValida jogada) {
		jogador.desabilita();
		boolean fim = verificaVencedor();
		if(fim){
			encerrarPartida();
			atorNetgames.enviarJogada(jogada);
			janela.alertaJogador("voce venceu");
		}else{
		atorNetgames.enviarJogada(jogada);
		janela.setMensagemPainel("Aguardando Adversario");
		janela.imprimeTabuleiro(tabuleiro.getPosicoes());
		}
		
		
	}

	private void encerrarPartida() {
		tabuleiro.setAndamento(false);
		
	}

	private boolean verificaVencedor() {
		boolean vencedor = tabuleiro.getReiMorto();
		return vencedor;
	}

	private boolean realizaJogada(int linha, int coluna, boolean temPecaNaPosicao,
				Tabuleiro tabuleiro) {
		boolean valido;	
		Lance lance = new Lance(linha, coluna, temPecaNaPosicao, tabuleiro);
			valido = lance.tratarLance();
			return valido;
	}

}
