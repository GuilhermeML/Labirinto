package labirinto;

public class Nivel3 extends Labirinto {
	
	public Nivel3(){
		super("lab3.csv");
	}

	@Override
	public void imprimirLabirinto(Posicao posAtual) {
		System.out.println("");
		System.out.println("Nível 3 - Normal");
		super.imprimirLabirinto(posAtual);
	}

}