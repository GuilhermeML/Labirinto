package labirinto;

import java.util.ArrayList;

public class Labirinto {

    private Posicao[][] posicoes;

    //Recebe o nome do arquivo do labirinto
    public Labirinto(String nomeArquivo){
        parseCsv(nomeArquivo);
    }

    // Metodo chamado pelo JogoController
    //Obtem a posicao inicial em que o jogador deve iniciar
    public Posicao getPosicaoInicial(){
        //TODO: Percorrer matriz, encontrar posicao inicial e retornar

        //Retorno temporario apenas para o codigo compilar
        return new Posicao(0,0, Posicao.ENTRADA);
    }

    //Metodo chamado pelo jogador
    //Retorna todas as posicoes para as quais o
    //jogador pode se movimentar, dado sua posicao atual
    public ArrayList<Posicao> getPosicoesPossiveis(Posicao posAtual){
        ArrayList<Posicao> posPossiveis = new ArrayList<>();

        //TODO: Construir logica para obter possiveis posicoes que o jogador pode se movimentar

        return posPossiveis;
    }

    //Metodo utilizado para ler o arquivo .csv e transforma-lo
    //em uma matriz de objetos Posicao
    private void parseCsv(String nomeArquivo){
        //TODO: Parse CSV
    }

}
