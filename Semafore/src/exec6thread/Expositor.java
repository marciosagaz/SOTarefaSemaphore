package exec6thread;

public class Expositor extends Thread {

	SalaExposicao salaExposicao;

	public Expositor(SalaExposicao salaExposicao) {
		this.salaExposicao = salaExposicao;
	}

	@Override
	public void run() {
		while (true) {
			try {
				//sleep(5000);
				salaExposicao.abrirOuEncerrarExposicao();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
