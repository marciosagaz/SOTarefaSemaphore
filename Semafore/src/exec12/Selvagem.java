package exec12;

public class Selvagem extends Thread {
	
	Mesa mesa;
	public Selvagem(Mesa mesa) {
		this.mesa = mesa;
	}
	
	@Override
	public void run() {
		while(true) {
			Javali j = mesa.retiraJavali();
			comeJavali(j);
		}
	}

	private void comeJavali(Javali j) {
		System.out.println("O Selvagem "+this.getId()+" comeu o Javali "+j.whoIsIt());		
	}
}
