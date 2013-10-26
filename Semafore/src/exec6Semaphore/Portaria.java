package exec6Semaphore;


public class Portaria extends Thread {

	private SalaExposicao sala;
	int numVisitantes;
	
	public Portaria(SalaExposicao sala) {
		this.sala = sala;
		this.numVisitantes = sala.getVagas();
	}

	public void run() {
		while (true) {
			try {
				sala.getSemaPortaria().acquire();
				Visitante vis = new Visitante();
				sala.entrarNaExposicao(vis);
				sala.getSemaExpositor().release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
