package jobs;


/**
 * Classe ressource
 */
public abstract class Ressource {
	/**
	 * Montant 
	 */
	private int montant;

	
	/**
	 * @param montant
	 */
	public Ressource(int montant) {
		super();
		this.montant = montant;
	}

	/**
	 * @return the montant
	 */
	public int getMontant() {
		return montant;
	}

	/**
	 * @param montant the montant to set
	 */
	public void setMontant(int montant) {
		this.montant = montant;
	}
	
	
	
}
