package exec3;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class CertoDispositivo {

	Random temp;

	public void start() {
		temp = new Random(12);
		Semaphore semaObs = new Semaphore(1);
		Semaphore semaTr1 = new Semaphore(0);
		Semaphore semaTr2 = new Semaphore(0);
		(new Observador(this, semaObs, semaTr1, semaTr2)).start();
		(new Tratador1(semaTr1, semaObs)).start();
		(new Tratador2(semaTr2, semaObs)).start();
	}

	public int getTemperatura() {
		return temp.nextInt() + 39;
	}

}
