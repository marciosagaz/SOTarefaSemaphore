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
	}

	public synchronized void abrirOuEncerrarExposicao() throws InterruptedException {
		if (vagaLivre < vagas) {
			notify();
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
