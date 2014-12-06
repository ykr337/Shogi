package Netgames;

import br.ufsc.inf.leobr.cliente.Jogada;


public class JogadaValida implements Jogada {

	protected int linhaInicio;
	protected int colunaInicio;
	protected int linhaFim;
	protected int colunaFim;
	protected boolean reiAdversarioMorto;
	
	public JogadaValida(int linhaInicio, int colunaInicio, int linhaFim, int colunaFim){
		this.linhaInicio = linhaInicio;
		this.colunaInicio = colunaInicio;
		this.linhaFim = linhaFim;
		this.colunaFim = colunaFim;
	}

	public int getLinhaInicio() {
		return linhaInicio;
	}

	public void setLinhaInicio(int linhaInicio) {
		this.linhaInicio = linhaInicio;
	}

	public int getColunaInicio() {
		return colunaInicio;
	}

	public void setColunaInicio(int colunaInicio) {
		this.colunaInicio = colunaInicio;
	}

	public int getLinhaFim() {
		return linhaFim;
	}

	public void setLinhaFim(int linhaFim) {
		this.linhaFim = linhaFim;
	}

	public int getColunaFim() {
		return colunaFim;
	}

	public void setColunaFim(int colunaFim) {
		this.colunaFim = colunaFim;
	}
	
	public boolean getReiMorto(){
		return reiAdversarioMorto;
	}
}
