package jobs;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * Classe Or
 */
@Data
@EqualsAndHashCode(callSuper=false) 
public class Or extends Ressource {
	
	
	public Or(int montant){
		super(montant);				
	}
	
}
