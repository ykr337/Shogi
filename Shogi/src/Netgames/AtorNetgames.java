package Netgames;

import Logica.Controlador;
import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.OuvidorProxy;
import br.ufsc.inf.leobr.cliente.Proxy;
import br.ufsc.inf.leobr.cliente.exception.ArquivoMultiplayerException;
import br.ufsc.inf.leobr.cliente.exception.JahConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoJogandoException;
import br.ufsc.inf.leobr.cliente.exception.NaoPossivelConectarException;

public class AtorNetgames implements OuvidorProxy {

	protected Controlador controlador;
	protected Proxy proxy;

	public AtorNetgames(Controlador controlador) {
		super();
		this.controlador = controlador;
		proxy = Proxy.getInstance();
		proxy.addOuvinte(this);
	}

	// método usado para solicitar conexão ao servidor
	// retorna uma string com a descriçao do problema encontrado, caso haja
	// algum, ou com valor nulo caso tenha conectado com sucesso
	public String conectar(String nome, String ipServidor) {
		String problema = null;

		try {
			proxy.conectar(ipServidor, nome);

		} catch (JahConectadoException e) {
			problema = e.getLocalizedMessage();

		} catch (NaoPossivelConectarException e) {
			problema = e.getLocalizedMessage();

		} catch (ArquivoMultiplayerException e) {
			problema = e.getLocalizedMessage();
		}

		return problema;
	}

	// método responsável por solicitar o inicio de uma partida ao servidor
	// determina a quantidade de jogadores que podem participar
	// quando este metodo e chamado no seervidor, um outro jogador eh sorteado
	// para ser inserido na sala. este jogador recebe uma mensagem
	public void iniciarPartidaRede() {
		try {
			proxy.iniciarPartida(new Integer(2));
		} catch (NaoConectadoException e) {
			
		}
	}

	// metodo que envia a jogada para o outro jogador
	public void enviarJogada(Lance lance) {
		try {
			proxy.enviaJogada(lance);
		} catch (NaoJogandoException e) {

		}
	}

	// recebe a jogada enviada pelo outro jogador e manda para o controlador.
	public void receberJogada(Jogada jogada) {
		Lance lance = (Lance) jogada;
		controlador.receberLance(lance);

	}

	public String desconectar() {
		String problema = null;
		try {
			proxy.desconectar();
		} catch (NaoConectadoException e) {
			problema = e.getLocalizedMessage();
		}
		return problema;
	}

	// Metodo que recebe a mensagem de inicio do metodo IniciarPartidaRede()
	// Recebe uma posicao de inicio. se receber 1, começa jogando, se receber 2
	// o adversario começa
	public void iniciarNovaPartida(Integer posicao) {
		controlador.iniciarPartidaRede(posicao);

	}

	public void finalizarPartidaComErro(String message) {
		// TODO Auto-generated method stub

	}

	public void receberMensagem(String msg) {
		// TODO Auto-generated method stub

	}

	public void tratarConexaoPerdida() {
		// TODO Auto-generated method stub

	}

	public void tratarPartidaNaoIniciada(String message) {
		// TODO Auto-generated method stub

	}

	public String obterNomeAdversario(int vez) {
		String nome = proxy.obterNomeAdversario(vez);
		return nome;
	}

}
