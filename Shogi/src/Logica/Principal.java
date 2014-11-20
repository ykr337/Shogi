package Logica;
import GUI.JanelaJogo;
public class Principal {
	
	
	public static void main(String[]args){
		Controlador controlador = new Controlador();
		JanelaJogo janela = new JanelaJogo(controlador);
		janela.interaja();
		//comentario
	
	}
	
}
