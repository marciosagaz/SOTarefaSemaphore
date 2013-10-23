package exec3;

import java.util.concurrent.Semaphore;

public class Tratador2 extends Thread{

	Semaphore semaObs;
	Semaphore semaTr2;
	int count = 0;
	public Tratador2(Semaphore semaTr2, Semaphore semaObs) {
		this.semaObs = semaObs;
		this.semaTr2 = semaTr2;
	}

	@Override
	public void run() {
		while (true) {
			try {
				semaTr2.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count++;
			if (count == 10){
				count = 0;
				System.out.println("Tratador 2");
			}
			semaObs.release();
		}
	}

}
