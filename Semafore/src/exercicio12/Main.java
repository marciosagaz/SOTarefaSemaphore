package exercicio12;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args){ 
		Mesa m=new Mesa(); 
		Cozinheiro c1=new Cozinheiro(1,m), c2=new Cozinheiro(2,m); 
		Selvagem g1= new Selvagem(1,m), g2= new Selvagem(2,m); 
		g1.start();g2.start();
		c1.start();c2.start(); 	
	}

}
