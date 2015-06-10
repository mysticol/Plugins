package jobs;

public class Hero extends Personnage {

	// Attributs
	int stockOr;
	int stockNourriture;

	int deplacementMax;

	// Constucteurs
	public Hero(){

	}

	public Hero(int vie, int stockNourriture,int stockOr, int deplacementMax){
		super(vie);
		this.stockNourriture=stockNourriture;
		this.stockOr=stockOr;
		this.deplacementMax = deplacementMax;
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
		return "Hero [vie=" +getVie()+ ", stock de nourriture=" + stockNourriture + ", stock d'or=" + stockOr + "]";
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

	public int getStockOr() {
		return stockOr;
	}

	public void setStockOr(int stockOr) {
		this.stockOr = stockOr;
	}

	public int getDeplacementMax() {
		return deplacementMax;
	}

	public void setDeplacementMax(int deplacementMax) {
		this.deplacementMax = deplacementMax;
	}

}
