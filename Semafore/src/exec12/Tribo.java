package exec12;

public class Tribo extends Thread {

	Mesa mesa;
	int numberSelvagem;
	public Tribo(Mesa mesa,int numberSelvagem) {
		this.mesa = mesa;
		this.numberSelvagem = numberSelvagem;
	}

	@Override
	public void run() {
		for(int i = 0;i<numberSelvagem;i++){
			(new Selvagem(mesa)).start();
		}
	}

}
