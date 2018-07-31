package labirinto;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Jogador {

    private Posicao posAtual;
    private ArrayList<Posicao> caminho = new ArrayList<>();
    private Labirinto labirinto;
    private boolean acompanharJogador;

    public Jogador(Labirinto labirinto, boolean acompanharJogador){
        this.labirinto = labirinto;
        this.acompanharJogador = acompanharJogador;
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

        //Anda para a primeira posicao que ainda nao foi visitada
        for(int i = 0; i < posicoes.size(); i++){
            if(!caminho.contains(posicoes.get(i))){
                return posicoes.get(i);
            }
        }

        //Se todas ja foram visitadas, decide andar para a posicao visitada mais antiga
        Posicao posicao = posicoes.get(0);
        for(int i = 1; i < posicoes.size(); i++){
            if(posicoes.get(i).getVisitada() < posicao.getVisitada()){
                posicao = posicoes.get(i);
            }
        }

        return posicao;
    }

    private boolean mover(Posicao posicao){

        //Trocar a posicao atual
        posAtual = posicao;

        //Adicionar a posicao no Array do caminho percorrido
        caminho.add(posicao);

        //Modificar variavel 'visitada' da posicao para true
        posicao.setVisitada();

        //Imprimir labirinto
        labirinto.imprimirLabirinto(posAtual);

        //aguardar para a proxima jogada
        //
        if(acompanharJogador){
            try{
                TimeUnit.MILLISECONDS.sleep(700);
            }catch(Exception e){
                System.out.println(e.toString());
            }
        }


        //Verificar se a posicao eh a saida
        //Se sim, retorna true
        if(posicao.getTipo() == Posicao.SAIDA){
            return true;
        }
        return false;
    }
}