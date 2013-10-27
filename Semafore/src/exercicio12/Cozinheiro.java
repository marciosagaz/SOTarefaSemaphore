package exercicio12;

class Cozinheiro extends Thread { 
	private Mesa m; 

	public Cozinheiro(Mesa m){ 
		this.m=m; 
	}

	public void run(){ 
		Javali j; 
		while(true){ 
			j=new Javali(); 
			System.out.println("Cozinheiro()"+this.getId()); 
			m.put(j); 
		} 
	} 
} 