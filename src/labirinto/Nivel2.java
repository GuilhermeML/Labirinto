package labirinto;

public class Nivel2 extends Labirinto {
	
	public Nivel2(){
		super("lab2.csv");
	}

	@Override
	public void imprimirLabirinto(Posicao posAtual) {
		System.out.println("");
		System.out.println("Nível 2 - Fácil");
		super.imprimirLabirinto(posAtual);
	}

}