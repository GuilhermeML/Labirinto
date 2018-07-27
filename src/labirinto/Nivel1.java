package labirinto;

import java.util.ArrayList;

public class Nivel1 extends Labirinto implements Labirintos {
	
	private Posicao posicoes;
	private ArrayList<Posicao> posPossiveis;
	
	public Nivel1(){
		//Passar o nome do csv de nivel1 
		//(Isso altera o momento de instanciar o labirinto no JogoController
		super("lab1.csv");
	}
	
	public Posicao getPosicaoInicial(){
		posicoes = super.getPosicaoInicial();
		return posicoes;
	}
	
	public ArrayList<Posicao> getPosicoesPossiveis(Posicao posAtual){
		posPossiveis = new ArrayList<>();
		posPossiveis = super.getPosicoesPossiveis(posAtual);
		return posPossiveis;
	}

}