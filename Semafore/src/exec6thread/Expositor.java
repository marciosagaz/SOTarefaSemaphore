package exec6thread;

public class Expositor extends Thread {

	SalaExposicao salaExposicao;

	public Expositor(SalaExposicao salaExposicao) {
		this.salaExposicao = salaExposicao;
	}

	@Override
	public void run() {
		while (true) {
			salaExposicao.openExposicao();
			try {
				salaExposicao.encerrarExposicao();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
