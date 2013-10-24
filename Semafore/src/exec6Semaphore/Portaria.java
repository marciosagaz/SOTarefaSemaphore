package exec6Semaphore;

import java.util.Random;

public class Portaria extends Thread {

	private SalaExposicao sala;
	private Random timeOfCheckin;
	int maxTime;

	public Portaria(SalaExposicao sala, int maxTime) {
		this.sala = sala;
		if (maxTime < 1)
			maxTime = 1;
		timeOfCheckin = new Random();
		this.maxTime = maxTime;
	}

	public void run() {
		while (true) {
			// System.out.println("Estou em looping sou Portaria");
			(new Visitante(sala)).start();
			int tempo = timeOfCheckin.nextInt(maxTime);
			if (tempo < 0)
				tempo = 1;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
