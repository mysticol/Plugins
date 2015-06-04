package core;

public class Paysan extends Personnage {

	// Attributs
	int stockOr;
	int stockNourriture;


	// Constucteurs
	public Paysan(){

	}

	public Paysan(int vie, int stockNourriture,int stockOr){
		super(vie);
		this.stockNourriture=stockNourriture;
		this.stockOr=stockOr;
	}


	// Getters and
	public int getStockNourriture() {
		return stockNourriture;
	}



	public void setStockNourriture(int stockNourriture) {
		this.stockNourriture = stockNourriture;
	}



	@Override
	public String toString() {
		return "Paysan [vie=" +getVie()+ ", stock de nourriture=" + stockNourriture + ", stock d'or=" + stockOr + "]";
	}

	public void Recolter(Ressource ressource){
		if (ressource.getClass().equals(Or.class)){
			stockOr+=100;
			ressource.setMontant(ressource.getMontant()-100);
		} else if (ressource.getClass().equals(Nourriture.class)){
			stockNourriture+=100;
			ressource.setMontant(ressource.getMontant()-100);
		}	
	}

}
