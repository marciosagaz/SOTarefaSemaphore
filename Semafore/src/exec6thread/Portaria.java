package exec6thread;

public class Portaria extends Thread {

	private SalaExposicao sala;

	public Portaria(SalaExposicao sala) {
		this.sala = sala;
	}

	public void run() {
		while (true) {
			try {
				sala.entrarNaExposicao(new Visitante());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}
