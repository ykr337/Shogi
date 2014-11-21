package GUI;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Logica.Controlador;

public class JanelaJogo extends JFrame implements ActionListener{
	
	protected Controlador controlador;
	protected PainelJanelaJogo painel;
	protected Menu menu;
	
	public JanelaJogo(Controlador controlador){
		this.controlador = controlador;
		menu = new Menu(this);
		setJMenuBar(menu);
		//painel = new PainelJanelaJogo();
		//setContentPane(painel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(500, 550));
		setResizable(false); 
		pack();
		setLocationRelativeTo(null);
	}
	
	public void interaja(){
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		switch (e.getActionCommand()){
		case "Conectar":
			System.out.print("certo");
			String nome = solicitaNome();
			controlador.conectar(nome);
			System.out.println("conctado");
			break;
		}
	}
	

	private String solicitaNome(){
		String nome = JOptionPane.showInputDialog(this, "Insira seu nome");
		return nome;	
	}

	public void iniciar(){
		String jogadorUm = JOptionPane.showInputDialog("Qual o seu nome?");
		
		
	}
	public void alertaJogador(String mensagem){
		JOptionPane.showMessageDialog(this, mensagem);
	}
}
