package labirinto;

public class Nivel5 extends Labirinto {
	
	public Nivel5(){
		super("lab5.csv");
	}

	@Override
	public void imprimirLabirinto(Posicao posAtual) {
		System.out.println("");
		System.out.println("Nível 5 - Muito Difícil");
		super.imprimirLabirinto(posAtual);
	}

}