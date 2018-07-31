package labirinto;

public class Nivel4 extends Labirinto {
	
	public Nivel4(){
		super("lab4.csv");
	}

	@Override
	public void imprimirLabirinto(Posicao posAtual) {
		System.out.println("");
		System.out.println("Nível 4 - Difícil");
		super.imprimirLabirinto(posAtual);
	}

}