package labirinto;

import java.util.ArrayList;

public class Jogador {

    private Posicao posAtual;
    private ArrayList<Posicao> caminho = new ArrayList<>();
    private Labirinto labirinto;

    public Jogador(Labirinto labirinto){
        this.labirinto = labirinto;
    }

    //Metodo chamado quando o jogador deve iniciar o jogo
    public void iniciar(){

        //Faz o setup inicial e move o jogador para a posicao inicial
        mover(labirinto.getPosicaoInicial());

        boolean jogadorSaiu = false;

        //Loop
        //Jogador decide a proxima posicao e move-se ate ela
        //Quando a posicao for do tipo SAIDA, finaliza o loop
        while(!jogadorSaiu){
            Posicao proxima = decidirProximoMovimento(labirinto.getPosicoesPossiveis(posAtual));
            jogadorSaiu = mover(proxima);
        }

        //Retorna para o JogoController
    }

    private Posicao decidirProximoMovimento(ArrayList<Posicao> posicoes){

        //TODO: Logica para decisao de proxima posicao

        //Retorno temporario para o codigo compilar
        return new Posicao(0,0, Posicao.CAMINHO);
    }

    private boolean mover(Posicao posicao){

        //Trocar a posicao atual
        posAtual = posicao;

        //Adicionar a posicao no Array do caminho percorrido
        caminho.add(posicao);

        //Verificar se a posicao eh a saida
        //Se sim, retorna true
        if(posicao.getTipo() == Posicao.SAIDA){
            return true;
        }
        return false;
    }
}