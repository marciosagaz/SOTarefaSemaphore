package exec6thread;


public class Main6thread {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int tempoDeChegada = 1000; //tempo maximo que leva para chegar algum visitante.
		int tempoDeNaSalaDeExposicao = 5000; //tempo maximo que leva para chegar algum visitante.
		int maxNaSala = 10; //tempo maximo que leva para chegar algum visitante.
		(new Portaria(new SalaExposicao(maxNaSala,tempoDeNaSalaDeExposicao),tempoDeChegada)).start();
	}
}
