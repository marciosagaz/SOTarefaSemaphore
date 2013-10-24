package exec3;

import java.util.concurrent.Semaphore;

public class Observador extends Thread {

	Semaphore semaObs;
	Semaphore semaTr1;
	Semaphore semaTr2;
	CertoDispositivo dis;

	public Observador(CertoDispositivo dis, Semaphore semaObs,
			Semaphore semaTr1, Semaphore semaTr2) {
		this.semaObs = semaObs;
		this.semaTr1 = semaTr1;
		this.semaTr2 = semaTr2;
		this.dis = dis;
	}

	@Override
	public void run() {
		int temp;
		while (true) {
			try {
				semaObs.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			temp = dis.getTemperatura();
			if (temp <= 40) {
				semaTr1.release();
			} else if (temp > 50) {
				semaTr2.release();
			} else {
				semaObs.release();
			}
		}
	}

}
