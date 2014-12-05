package GUI;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PainelJanelaJogo extends JPanel{
	protected JLabel lNomeJogadorUm;
	protected JLabel lNomeJogadorDois;
	protected JLabel lMensagem;
	protected JLabel tabuleiro[][] = new JLabel[9][9];
	protected JanelaJogo janelaJogo;
	
	public PainelJanelaJogo(JanelaJogo janelaJogo){
		setBorder(BorderFactory.createTitledBorder("Shogi"));
		setSize(500, 500);
		this.janelaJogo = janelaJogo;
		this.setLayout(null);
		incializaComponentes();
	}

	private void incializaComponentes() {
		
		
	}
}
