package exec6Semaphore;

import java.util.concurrent.Semaphore;

public class SalaExposicao {

	private Visitante[] sala;
	private int vagaLivre;
	private int vagas;
	private Semaphore portaria;
	private Semaphore expositor;
	private Semaphore salaExposicao;

	public SalaExposicao(int vagas) {
		sala = new Visitante[vagas];
		vagaLivre = 0;
		this.vagas = vagas;
		portaria = new Semaphore(0);
		expositor = new Semaphore(0);
		salaExposicao = new Semaphore(1);
		(new Expositor(this,expositor)).start();
	}

	public void entrarNaExposicao(Visitante visitante) throws InterruptedException{
			sala[vagaLivre++] = visitante;
			System.out.println("% Entrei na Sala de Exposição. Sou o Visitante :"+ visitante.hashCode());
	}

	public void openExposicao() {
		portaria.release();
	}

	public void sairDaExposicao() {
		if (vagaLivre < vagas) {
			return;
		}
		for (Visitante visitante : sala) {
			if (visitante != null) {
				visitante.sai();
			}
		}
		vagaLivre = 0;
		sala = new Visitante[vagas];
	}

	public int getVagas() {
		return vagas;
	}

	public Semaphore getSemaPortaria() {
		return portaria;
	}
	
	public Semaphore getSemaExpositor() {
		return expositor;
	}

	public Semaphore getSemaSalaExpositor() {
		return salaExposicao;
	}

}
