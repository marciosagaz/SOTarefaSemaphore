package exercicio12;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

import exec6Semaphore.Visitante;

public class Mesa {
	final static int NMAXJAVALIS=10; 
	private LinkedList<Javali> javalis = new LinkedList<Javali>(); 
	private Semaphore cozinheiro = new Semaphore(0);
	private Semaphore selvagem = new Semaphore(0);
	

	public void put(Javali j) {
		for (int i = 0; i<NMAXJAVALIS;i++){
			javalis.add(j);			
		}
		selvagem.release();
		try {
			cozinheiro.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 

	public Javali get(){ 
		
		Javali j = null;
		try {
			selvagem.acquire();
			j = javalis.removeLast();
			isEmpty();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return j;
	}
	
	private void isEmpty(){
		if (javalis.isEmpty()) {
			System.out.println("Cozinheiro repõe!");
			cozinheiro.release();
		}else{
			System.out.println("Um Selvagem comeu!");
			selvagem.release();
		}
	}
}
