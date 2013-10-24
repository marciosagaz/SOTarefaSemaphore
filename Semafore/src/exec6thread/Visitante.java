package exec6thread;

public class Visitante extends Thread {
	
	SalaExposicao sala;
	boolean saiu;
	public Visitante(SalaExposicao sala) {
		this.sala = sala;
	}
	
	@Override
	public void run() {
		entra();
	}
	
	private void entra(){
		try {
			while (!sala.entrarNaExposicao(this)){
				System.out.println("# Esperando para entrar. Sou o Visitante :"+this.getId());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void sai() {
		System.out.println("$ Saindo da Exposição. Sou o Visitante :"+this.getId());
	}
}
