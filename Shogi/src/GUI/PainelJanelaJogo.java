package GUI;

import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Logica.Posicao;
import Pecas.Peca;

public class PainelJanelaJogo extends JPanel {
	protected JLabel lNomeJogadorUm;
	protected JLabel lNomeJogadorDois;
	protected JLabel lMensagem;
	protected JLabel tabuleiro[][] = new JLabel[9][9];
	protected JanelaJogo janelaJogo;
	protected ClassLoader cl = this.getClass().getClassLoader();
	protected Icon vazio = new ImageIcon(cl.getResource("vazio.png"));

	public PainelJanelaJogo(JanelaJogo janelaJogo) {
		setBorder(BorderFactory.createTitledBorder("Shogi"));
		setSize(500, 500);
		this.janelaJogo = janelaJogo;
		this.setLayout(null);
		incializaComponentes();
	}

	private void incializaComponentes() {
		lMensagem = new JLabel();
		lMensagem.setBounds(new Rectangle(10, 0, 200, 60));
		this.add(lMensagem);

		lNomeJogadorUm = new JLabel();
		lNomeJogadorUm.setBounds(new Rectangle(30, 0, 200, 100));
		this.add(lNomeJogadorUm);

		lNomeJogadorDois = new JLabel();
		lNomeJogadorDois.setBounds(new Rectangle(320, 420, 200, 60));
		this.add(lNomeJogadorDois);
	}

	public void criaTabuleiro() {
		int y = 70;

		for (int linha = 0; linha < 9; linha++) {
			int x = 55;
			for (int coluna = 0; coluna < 9; coluna++) {
				final Integer auxLinha = linha;
				final Integer auxColuna = coluna;
				tabuleiro[linha][coluna] = new JLabel();
				tabuleiro[linha][coluna].setBounds(new Rectangle(x, y, 50, 50));
				//tabuleiro[linha][coluna].setIcon(vazio);
				x += 50;
				this.add(tabuleiro[linha][coluna]);
				tabuleiro[linha][coluna]
						.addMouseListener(new java.awt.event.MouseAdapter() {
							public void mouseClicked(java.awt.event.MouseEvent e) {
								selecionaPosicao(auxLinha, auxColuna);
							}
						});
			}
			y += 50;

		}
	}

	private void selecionaPosicao(int linha, int coluna) {
		System.out.println("ta funfando carai");

	}

	public void aguardandoInicio() {
		setMensagem("Aguardando adversario");
	}

	public void imprimeTabuleiro(Posicao[][] tabuleiroInterface) {
		for(int linha = 0; linha < 9; linha++){
			for(int coluna = 0; coluna < 9; coluna++){
				if(tabuleiroInterface[linha][coluna].getPeca() == null){
					tabuleiro[linha][coluna].setIcon(vazio);
				}else{
					Icon icone = tabuleiroInterface[linha][coluna].getPeca().getIcone();
					tabuleiro[linha][coluna].setIcon(icone);
				}
			}
		}

	}

	public void setMensagem(String mensagem) {
		lMensagem.setText(mensagem);

	}

	public void setDadosJogadores(String nomeJogador1, String nomeJogador2) {
		lNomeJogadorUm.setText(nomeJogador1);
		lNomeJogadorDois.setText(nomeJogador2);
		
	}
}
