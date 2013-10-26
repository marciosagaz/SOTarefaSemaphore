package exec6Semaphore;


public class Main6Semaphore {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int maxNaSala = 10; // visitantes possíveis
		(new Portaria(new SalaExposicao(maxNaSala))).start();
	}
}
