package exercicio12;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class Mesa {
	final static int NMAXJAVALIS=10; 
	private LinkedList<Javali> javalis = new LinkedList<Javali>(); 
	private Semaphore cozinheiro = new Semaphore(1);
	private Semaphore selvagem = new Semaphore(0);
	

	public void put(Javali j) { 
		while(javalis.size()==NMAXJAVALIS){ 
			try{ 
				System.out.println( "Um cozinheiro inicia espera! " + "Mesa cheia"); 
				cozinheiro.acquire(); 
				System.out.println("Um cozinheiro finda espera!"); } 
			catch(InterruptedException e){e.printStackTrace();} 

		} 

		javalis.add(j); 
		selvagem.release();
	} 

	public synchronized Javali get(){ 
		while(javalis.isEmpty()){ 
			try{ 
				System.out.println( "Um Selvagem inicia espera! " + "Mesa vazia"); 
				selvagem.acquire();
				System.out.println("Um Selvagem finda espera!"); 
			} catch(InterruptedException e){
				e.printStackTrace();} 
			} 
		cozinheiro.release();
		return javalis.removeFirst();
	}

}
