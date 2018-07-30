package labirinto;

public class Posicao {

    //Constantes
    public static final int PAREDE = 0, CAMINHO = 1, ENTRADA = 2, SAIDA = 3;

    private int linha, coluna;
    private int tipo;
    private long visitada = -1;

    public Posicao(int linha, int coluna, int tipo){
        this.linha = linha;
        this.coluna = coluna;
        this.tipo = tipo;
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    public int getTipo() {
        return tipo;
    }

    public long getVisitada() {
        return visitada;
    }

    public void setVisitada() {
        this.visitada = System.currentTimeMillis();
    }
}