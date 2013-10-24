package exec6thread;

public class SalaExposicao {

	Visitante[] sala;
	int vagaLivre;
	int tempoDeExposicao;
	int vagas;

	public SalaExposicao(int vagas, int tempoDeExposicao) {
		sala = new Visitante[vagas];
		if (tempoDeExposicao < 1)
			tempoDeExposicao = 1;
		vagaLivre = 0;
		this.vagas = vagas;
		(new Expositor(this, tempoDeExposicao)).start();
	}

	public synchronized boolean entrarNaExposicao(Visitante visitante)
			throws InterruptedException {
		wait();
		if (vagaLivre < sala.length) {
			sala[vagaLivre++] = visitante;
			System.out
					.println("% Entrei na Sala de Exposição. Sou o Visitante :"
							+ visitante.getId());
			return true;
		}
		return false;
	}

	public synchronized void openExposicao() {
		notifyAll();
	}

	public synchronized void encerrarExposicao() {
		for (Visitante visitante : sala) {
			if (visitante != null) {
				visitante.sai();
			}
		}
		sala = new Visitante[vagas];
		vagaLivre = 0;
	}

}
