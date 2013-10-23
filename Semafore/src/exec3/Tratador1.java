package exec3;

import java.util.concurrent.Semaphore;

public class Tratador1 extends Thread{

	Semaphore semaObs;
	Semaphore semaTr1;
	int count = 0;
	public Tratador1(Semaphore semaTr1, Semaphore semaObs) {
		this.semaObs = semaObs;
		this.semaTr1 = semaTr1;
	}

	@Override
	public void run() {
		while (true) {
			try {
				semaTr1.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count++;
			if (count == 10){
				count = 0;
				System.out.println("Tratador 1");
			}
			semaObs.release();
		}
	}


}
