package labirinto;

import java.util.Scanner;

public class JogoController {

    private long tempo;
    private boolean executar = true, acompanharJogador = false;
    private Scanner scanner = new Scanner(System.in);

    public void comecarJogo(){

		System.out.println("LABIRINTO");

		System.out.println("Deseja acompanhar o jogador durante o percurso? (S/N)");

		String acompanhar = scanner.next();
		acompanhar = acompanhar.toLowerCase();

		if(acompanhar.equals("s")){
			acompanharJogador = true;
		}

		while(executar){

			Labirinto labirinto;
			Jogador jogador;

			System.out.println("Selecione o nível que deseja jogar:");

			System.out.println("Nível 1 - Muito Fácil");
			System.out.println("Nível 2 - Fácil");
			System.out.println("Nível 3 - Normal");
			System.out.println("Nível 4 - Difícil");
			System.out.println("Nível 5 - Muito Difícil");

			int escolha = scanner.nextInt();

			// Instanciar Labirinto
			switch(escolha){
				case 1: labirinto = new Nivel1();
					break;
				case 2: labirinto = new Nivel2();
					break;
				case 3: labirinto = new Nivel3();
					break;
				case 4: labirinto = new Nivel4();
					break;
				case 5: labirinto = new Nivel5();
					break;
				default: labirinto = new Nivel1();
					break;
			}

			//Instanciar Jogador,
			//Passar labirinto como parametro
			jogador =  new Jogador(labirinto, acompanharJogador);

			//Inicializar o contador de tempo
			tempo = System.currentTimeMillis();

			//Chamar metodo do jogador para iniciar jogo
			jogador.iniciar();
			System.out.println("FIM");

			//Quando jogador finalizar, mostrar o resultado
			//Com o tempo gasto e o caminho percorrido
			tempo = System.currentTimeMillis() - tempo;

			System.out.println("Tempo do percurso: "+ tempo + " ms");

			System.out.println("");
			System.out.println("Deseja voltar ao menu? (S/N)");

			String resposta = scanner.next();
			resposta = resposta.toLowerCase();

			if(!resposta.equals("s")){
				executar = false;
			}

		}
    }

}