package exercicio12;

class Cozinheiro extends Thread { 
	private int id; 
	private Mesa m; 
	private int nunidades=0; 

	public Cozinheiro(int id,Mesa m){ 
		this.id=id; this.m=m; 
	}

	public void run(){ 
		Javali j; 
		while(nunidades!=20){ 
			j=new Javali(++nunidades,id); 
			System.out.println("Cozinheiro("+ id + ") coloca na mesa o seu javali"+j); 
			m.put(j); 
		} 
		System.out.println("Cozinheiro("+ id + ") parou de cozinhar e cozinhou "+ nunidades +" javalis"); 
	} 
} 