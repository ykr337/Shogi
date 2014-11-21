package Netgames;

import Logica.Controlador;
import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.OuvidorProxy;
import br.ufsc.inf.leobr.cliente.Proxy;
import br.ufsc.inf.leobr.cliente.exception.ArquivoMultiplayerException;
import br.ufsc.inf.leobr.cliente.exception.JahConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoPossivelConectarException;

public class AtorNetgames implements OuvidorProxy {
	
	protected Controlador controlador;
	protected Proxy proxy;
	
	public AtorNetgames(Controlador controlador){
		super();
		this.controlador = controlador;
		proxy = Proxy.getInstance();
	}
	// método usado para solicitar conexão ao servidor
	// retorna uma string com a descriçao do problema encontrado, caso haja algum, ou com valor nulo caso tenha conectado com sucesso
	public String conectar(String nome, String ipServidor){
		String problema =null;
		
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
	public void iniciaNovaPartidaServidor(){
		try {
			proxy.iniciarPartida(new Integer(2));
		} catch (NaoConectadoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void iniciarNovaPartida(Integer posicao) {
		// TODO Auto-generated method stub

	}

	public void finalizarPartidaComErro(String message) {
		// TODO Auto-generated method stub

	}

	public void receberMensagem(String msg) {
		// TODO Auto-generated method stub

	}

	public void receberJogada(Jogada jogada) {
		// TODO Auto-generated method stub

	}

	public void tratarConexaoPerdida() {
		// TODO Auto-generated method stub

	}

	public void tratarPartidaNaoIniciada(String message) {
		// TODO Auto-generated method stub

	}

}
