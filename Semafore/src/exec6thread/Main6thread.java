package exec6thread;

public class Main6thread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int maxNaSala = 10; // visitantes possíveis
		SalaExposicao sala = new SalaExposicao(maxNaSala);
		(new Portaria(sala)).start();
		sala.startExposicao();
	}
}
