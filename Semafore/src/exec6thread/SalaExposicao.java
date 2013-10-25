package exec6thread;

public class SalaExposicao {

	private Visitante[] sala;
	private int vagaLivre;
	private int vagas;
	private Expositor expositor;

	public SalaExposicao(int vagas) {
		sala = new Visitante[vagas];
		vagaLivre = 0;
		this.vagas = vagas;
		expositor = new Expositor(this);
	}

	public synchronized void entrarNaExposicao(Visitante visitante)
			throws InterruptedException {
		wait();
		sala[vagaLivre++] = visitante;
		System.out.println("% Entrei na Sala de Exposição. Sou o Visitante :"
				+ visitante.hashCode());
		//notify();
	}

	public synchronized void openExposicao() {
		notify();
	}

	public synchronized void encerrarExposicao() throws InterruptedException {
		//wait();
		if (vagaLivre < vagas) {
			return;
		}
		for (Visitante visitante : sala) {
			if (visitante != null) {
				visitante.sai();
			}
		}
		sala = new Visitante[vagas];
		vagaLivre = 0;
	}

	public Expositor getThreadExpositor() {
		return expositor;
	}

	public void startExposicao() {
		expositor.start();
	}

}
