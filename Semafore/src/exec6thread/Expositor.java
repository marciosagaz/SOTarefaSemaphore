package exec6thread;

public class Expositor extends Thread {

	SalaExposicao salaExposicao;
	int tempoExposicao;
	
	public Expositor(SalaExposicao salaExposicao, int tempoExposicao) {
		this.salaExposicao = salaExposicao;
		this.tempoExposicao = tempoExposicao;
	}
	
	@Override
	public void run() {
		while(true){
			//System.out.println("Estou em looping sou Expositor");
			salaExposicao.openExposicao();
			try {
				sleep(tempoExposicao);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			salaExposicao.encerrarExposicao();
		}
	}

}
