package labirinto;

import java.util.ArrayList;

public interface Labirintos {
	Posicao getPosicaoInicial();
	ArrayList<Posicao> getPosicoesPossiveis(Posicao posAtual);
	void imprimirLabirinto(Posicao posAtual);
}