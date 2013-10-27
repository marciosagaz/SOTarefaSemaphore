package exercicio12;

class Selvagem extends Thread{ 
	private Mesa m; 
	
	public Selvagem(Mesa m){ 
		this.m=m; 
	} 

	public void run(){ 
		while(true){ 
			m.get(); 
			System.out.println("Selvagem()"+this.getId()); 
		} 
	}
}