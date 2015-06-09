package jobs;

public class Nourriture extends Ressource {
	
	public Nourriture(){
		
	}
	
	public Nourriture(int montant){
		super(montant);
	}
	
	@Override
	public String toString() {
		return "Nourriture [nourriture=" +getMontant()+ "]";
	}
	
}
