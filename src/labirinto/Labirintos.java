package labirinto;

import java.util.ArrayList;

public interface Labirintos {
	
	public Posicao getPosicaoInicial();
	public ArrayList<Posicao> getPosicoesPossiveis(Posicao posAtual);

}