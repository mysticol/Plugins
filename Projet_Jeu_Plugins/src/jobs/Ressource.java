package jobs;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Classe ressource
 */
@Data
@AllArgsConstructor
public abstract class Ressource {
	/**
	 * Montant 
	 */
	private int montant;
	
	/**
	 * Cellule
	 */
	private Cellule cellule;

}
