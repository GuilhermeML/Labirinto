package labirinto;

public class JogoController {

    private long tempo;

    public void comecarJogo(){
        //Instanciar labirinto
        //Passar nome do arquivo do labirinto como parametro
        //Talvez escolher o mapa aleatoriamente ou criar um sistema de niveis,
        //onde a cada rodada o labirinto fica mais dificil
        
    	//Alterei para fazer por niveis
    	//A ideia inicial que eu tive : São 5 niveis, concluiu o nivel com sucesso avança para o proximo (apenas instanciar um novo tipo de nivel)
    	//O legal é que dá para comparar o tempo de duração em cada nível por questão de dificuldade
    	//Codigo anterior : Labirinto labirinto = new Labirinto("lab1.csv");
    	
    	Labirinto labirinto1 = new Nivel1();

        //Instanciar Jogador,
        //Passar labirinto como parametro
        Jogador jogador1 =  new Jogador((Labirinto)labirinto1);
//
//        //Inicializar o contador de tempo
//        tempo = System.currentTimeMillis();
//
//        //Chamar metodo do jogador para iniciar jogo
//        jogador.iniciar();
//
//        //Quando jogador finalizar, mostrar o resultado
//        //Com o tempo gasto e o caminho percorrido
//        
        //Mudei passando o labirinto como parametro, assim trabalha a questão do instanceof, e printa diferente para cada nivel
        //mostrarResultado();
        
        //Concluiu o nivel1 com sucesso, instancia o nivel2
        Labirinto labirinto2 = new Nivel2();
        Jogador jogador2 = new Jogador((Labirinto)labirinto2);
    }

    public void mostrarResultado(Labirinto labirinto){

        //Alterei para receber o labirinto para trabalhar a questão do instanceof, assim ele printa diferente o resultado para cada nivel
    	if(labirinto instanceof Nivel1){
    		System.out.println("Tempo e percurso do Nível1 :");
    	} else if(labirinto instanceof Nivel2){
    		System.out.println("Tempo e percurso do Nível2 :");
    	} else if(labirinto instanceof Nivel3){
    		System.out.println("Tempo e percurso do Nível3 :");
    	} else if(labirinto instanceof Nivel4){
    		System.out.println("Tempo e percurso do Nível4 :");
    	} else if(labirinto instanceof Nivel5){
    		System.out.println("Tempo e percurso do Nível5 :");
    	}
    	
    	//TODO: Mostrar tempo do percurso
        tempo = System.currentTimeMillis() - tempo;

        //Converter de milisegundos para segundos
        tempo = tempo / 1000;

        System.out.println("Tempo : "+ tempo);

        //TODO: Mostrar o percurso com GUI

    }

}