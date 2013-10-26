package exercicio12;

class Javali{ 
	int id; 
	int id_coz; 
	public Javali(int id,int id_coz){ 
		this.id=id; 
		this.id_coz=id_coz; 
	} 

	public String toString(){
		return "(Javali"+id+", Cozinheiro"+id_coz+")"; 
	} 
}