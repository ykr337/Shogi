package GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Logica.Controlador;
import Logica.Posicao;

public class JanelaJogo extends JFrame implements ActionListener {

	protected Controlador controlador;
	protected PainelJanelaJogo painel;
	protected Menu menu;
	

	public JanelaJogo(Controlador controlador) {
		this.controlador = controlador;
		menu = new Menu(this);
		setJMenuBar(menu);
		painel = new PainelJanelaJogo(this);
		setContentPane(painel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(600, 600));
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
	}

	public void interaja() {
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Conectar":
			solicitaConexao();
			break;

		case "Jogar":
			solicitaInicio();
			break;
		case "Desconectar":
			solicitaDesconexao();
			break;
		case "Sair":
			controlador.desconectar();
			this.dispose();
		}

	}

	private void solicitaDesconexao() {
		controlador.desconectar();
		
	}

	private void solicitaConexao() {
		String nome = JOptionPane.showInputDialog(this, "Insira seu nome");
		if (nome != null) {
			if (!(nome.trim().equals(""))) {
				controlador.conectar(nome);
			} else {
				alertaJogador("insira um nome");
			}
		}

	}
	
	private void solicitaInicio(){
		controlador.iniciarPartidaServidor();
	}

	public void alertaJogador(String mensagem) {
		JOptionPane.showMessageDialog(this, mensagem);
	}
	
	public void aguardandoInicio() {
		painel.aguardandoInicio();
			
	}

	public void imprimeTabuleiro(Posicao[][] tabuleiro) {
		   painel.imprimeTabuleiro(tabuleiro);
       remove(painel);
       this.setContentPane(painel);
	}
	
	public void posicaoClicada(int linha, int coluna) {
        controlador.posicaoClicada(linha, coluna);
		
	}
	
	public void criaTabuleiro() {
		painel.criaTabuleiro();
		
	}
	
	public void setMensagemPainel(String mensagem) {
		painel.setMensagem(mensagem);
		
	}

	
}
