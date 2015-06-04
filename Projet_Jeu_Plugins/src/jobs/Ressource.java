package jobs;

public abstract class Ressource {
	
	private int montant;
	protected Cellule cellule;

	public Ressource(){
		
	}
	
	
	
	public Ressource(int montant){
		this.montant=montant;
	}
	
	
	
	public Cellule getCellule() {
		return cellule;
	}



	public void setCellule(Cellule cellule) {
		this.cellule = cellule;
	}



	@Override
	public abstract String toString();

	public int getMontant() {
		return montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}
		

	
}
