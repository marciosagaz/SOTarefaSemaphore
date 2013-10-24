package exec6Semaphore;

import java.util.concurrent.Semaphore;


public class SalaExposicao {

	Visitante [] sala;
	int vagaLivre;
	int tempoDeExposicao;
	int vagas;
	Semaphore semaphore;
	public SalaExposicao(int vagas,int tempoDeExposicao) {
		sala = new Visitante[vagas];
		if (tempoDeExposicao < 1) tempoDeExposicao = 1;
		vagaLivre = 0;
		this.vagas = vagas;
		semaphore = new Semaphore(vagas);
		(new Expositor(this,tempoDeExposicao)).start();
	}
	
	public boolean entrarNaExposicao(Visitante visitante) throws InterruptedException {
		if (vagaLivre < sala.length){
			sala[vagaLivre++] = visitante;
			System.out.println("% Entrei na Sala de Exposição. Sou o Visitante :"+visitante.getId());
			semaphore.acquire();
			return true;
		}else{
			System.out.println("# Esperando para entrar. Sou o Visitante :"+visitante.getId());			
		}
		semaphore.acquire();
		return false;
	}
	
	public void openExposicao() {
			semaphore.release(vagaLivre);
			vagaLivre = 0;
	}
	
	public void encerrarExposicao() {
		for(Visitante visitante: sala){
			if (visitante != null){
				visitante.sai();
			}
		}
		sala = new Visitante[vagas];
	}

}
