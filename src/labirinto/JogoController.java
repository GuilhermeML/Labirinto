package labirinto;

public class JogoController {

    private long tempo;

    public void comecarJogo(){
        //Instanciar labirinto
        //Passar nome do arquivo do labirinto como parametro
        //Talvez escolher o mapa aleatoriamente ou criar um sistema de niveis,
        //onde a cada rodada o labirinto fica mais dificil
        Labirinto labirinto = new Labirinto("Arquivo X");

        //Instanciar Jogador,
        //Passar labirinto como parametro
        Jogador jogador =  new Jogador(labirinto);

        //Inicializar o contador de tempo
        tempo = System.currentTimeMillis();

        //Chamar metodo do jogador para iniciar jogo
        jogador.iniciar();

        //Quando jogador finalizar, mostrar o resultado
        //Com o tempo gasto e o caminho percorrido
        mostrarResultado();
    }

    public void mostrarResultado(){

        //TODO: Mostrar tempo do percurso
        tempo = System.currentTimeMillis() - tempo;

        //Converter de milisegundos para segundos
        tempo = tempo / 1000;

        System.out.println(tempo);

        //TODO: Mostrar o percurso com GUI

    }

}
