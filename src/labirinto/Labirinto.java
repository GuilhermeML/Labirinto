package labirinto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

        int linha = posAtual.getLinha();
        int coluna = posAtual.getColuna();

        //Verificar se pode andar para cima
        if(linha - 1 >= 0 && linha - 1 < posicoes.length){
            if(posicoes[posAtual.getLinha() - 1][posAtual.getColuna()].getTipo() == Posicao.CAMINHO){
                posPossiveis.add(posicoes[posAtual.getLinha() - 1][posAtual.getColuna()]);
            }
        }

        //Verificar se pode andar para a direita
        if(coluna + 1 >= 0 && coluna + 1 < posicoes[0].length){
            if(posicoes[posAtual.getLinha()][posAtual.getColuna() + 1].getTipo() == Posicao.CAMINHO){
                posPossiveis.add(posicoes[posAtual.getLinha()][posAtual.getColuna() + 1]);
            }
        }

        //Verificar se pode andar para baixo
        if(linha + 1 >= 0 && linha + 1 < posicoes.length){
            if(posicoes[posAtual.getLinha() + 1][posAtual.getColuna()].getTipo() == Posicao.CAMINHO){
                posPossiveis.add(posicoes[posAtual.getLinha() + 1][posAtual.getColuna()]);
            }
        }

        //Verificar se pode andar para a esquerda
        if(coluna - 1 >= 0 && coluna - 1 < posicoes[0].length){
            if(posicoes[posAtual.getLinha()][posAtual.getColuna() - 1].getTipo() == Posicao.CAMINHO){
                posPossiveis.add(posicoes[posAtual.getLinha()][posAtual.getColuna() - 1]);
            }
        }

        //DEV: Imprimir posicoes possiveis
        System.out.println();
        System.out.println("Posicoes Possiveis: ");
        for(int i = 0; i < posPossiveis.size(); i++){
            System.out.println(posPossiveis.get(i).getLinha() + " " + posPossiveis.get(i).getColuna());
        }

        return posPossiveis;
    }

    //Metodo utilizado para ler o arquivo .csv e transforma-lo
    //em uma matriz de objetos Posicao
    private void parseCsv(String nomeArquivo){

        String arquivo = "res/" + nomeArquivo;
        String linha = "";

        try {

            BufferedReader br = new BufferedReader(new FileReader(arquivo));

            //Obter numero de linhas
            //Obter numero de colunas
            int linhas = 0;
            int colunas = 0;
            while ((linha = br.readLine()) != null) {
                if(colunas == 0){
                    linhas = linha.split(",").length;
                }
                colunas++;
            }

            System.out.println("Linhas: " + linhas);
            System.out.println("Colunas: " + colunas);

            //Matriz do labirinto
            posicoes = new Posicao[linhas][colunas];

            //Resetar Buffered Reader
            br = new BufferedReader(new FileReader(arquivo));

            //Preencher matriz de Posicao
            int indexLinha = 0;
            while ((linha = br.readLine()) != null) {

                String[] leituras = linha.split(",");

                for(int i = 0; i < leituras.length; i++){
                    if(leituras[i].equals("")){
                        posicoes[indexLinha][i] = new Posicao(indexLinha, i, Posicao.CAMINHO);
                    }else if(leituras[i].equals("x")){
                        posicoes[indexLinha][i] = new Posicao(indexLinha, i, Posicao.PAREDE);
                    }else if(leituras[i].equals("e")){
                        posicoes[indexLinha][i] = new Posicao(indexLinha, i, Posicao.ENTRADA);
                    }else if(leituras[i].equals("s")){
                        posicoes[indexLinha][i] = new Posicao(indexLinha, i, Posicao.SAIDA);
                    }
                }
                indexLinha++;
            }

            //DEV: Imprimir Labirinto
            for(int i = 0; i < posicoes.length; i++){
                for(int j = 0; j < posicoes[0].length; j++){
                    System.out.print(posicoes[i][j].getTipo() + " ");
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
