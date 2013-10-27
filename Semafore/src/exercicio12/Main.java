package exercicio12;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args){ 
		Mesa m=new Mesa(); 
		Cozinheiro c1=new Cozinheiro(0,m);
		for (int i = 0; i < 10;i++){
			Selvagem g1= new Selvagem(1,m);
			g1.start();
		}
		c1.start();
	}

}
