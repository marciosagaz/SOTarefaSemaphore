package exercicio12;

class Selvagem extends Thread{ 
	private int id; 
	private Mesa m; 
	private int nunidades=0; 
	
	public Selvagem(int id,Mesa m){ 
		this.id=id; this.m=m; 
	} 

	public void run(){ 
		Javali j; 
		while(true){ 
			j=m.get(); 
			System.out.println("Selvagem()"+this.getId()); 
			nunidades++; 
		} 
//		System.out.println("Selvagem(" + id + ") parou de comer e comeu "+ nunidades +" javalis"); 
	}
}