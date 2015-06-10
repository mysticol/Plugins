package jobs;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * Classe Nourriture
 */
@Data
@EqualsAndHashCode(callSuper=false) 
public class Nourriture extends Ressource {
	
	
	public Nourriture(int montant, Cellule cellule){
		super(montant, cellule);				
	}
	
}
