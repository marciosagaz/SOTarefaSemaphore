package exec12;

public class Main12 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Mesa mesa = new Mesa(10);
		(new Cozinheiro(mesa)).start();
		(new Tribo(mesa,10)).start();
	}

}
