package labirinto;

public class Nivel1 extends Labirinto {

	public Nivel1(){
		super("lab1.csv");
	}

	@Override
	public void imprimirLabirinto(Posicao posAtual) {
		System.out.println("");
		System.out.println("Nível 1 - Muito Fácil");
		super.imprimirLabirinto(posAtual);
	}
}