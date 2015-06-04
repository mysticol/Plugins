package core;

public class Or extends Ressource {

	public Or(){
		
	}
	
	public Or(int montant){
		super(montant);
	}
	
	@Override
	public String toString() {
		return "Or [montant=" +getMontant()+ "]";
	}

	
	
}
