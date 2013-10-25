package exec6Semaphore;

import java.util.concurrent.Semaphore;

public class Expositor extends Thread {

	SalaExposicao salaExposicao;
	int tempoExposicao;
	Semaphore semaphore;
	public Expositor(SalaExposicao salaExposicao, Semaphore semaphore) {
		this.salaExposicao = salaExposicao;
		this.semaphore = semaphore;
		
	}

	@Override
	public void run() {
		while (true) {
			// System.out.println("Estou em looping sou Expositor");
			try {
				salaExposicao.openExposicao();
				semaphore.acquire();
				//sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			salaExposicao.sairDaExposicao();
		}
	}

}
