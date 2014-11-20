package GUI;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar{
	protected JMenu menuJogo;
	protected JMenuItem conectar,desconectar,iniciarPartida,sair;
	
	public Menu(JanelaJogo janela){
		menuJogo = new JMenu("Opções");
		
		conectar = new JMenuItem("Conectar");
		conectar.addActionListener(janela);
		
		iniciarPartida= new JMenuItem("Jogar");
		iniciarPartida.addActionListener(janela);
		
		desconectar = new JMenuItem("Desconectar");
		desconectar.addActionListener(janela);
		
		sair = new JMenuItem("Sair");
		sair.addActionListener(janela);
		
		menuJogo.add(conectar);
		menuJogo.add(iniciarPartida);
		menuJogo.add(desconectar);
		menuJogo.add(sair);
		add(menuJogo);
	}
}
