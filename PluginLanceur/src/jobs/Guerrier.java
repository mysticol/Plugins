package jobs;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Classe guerrier
 */
@Data
@EqualsAndHashCode(callSuper=false) 
public class Guerrier extends Personnage {
		
	/**
	 * Constructeur
	 * @param vie
	 * @param attaque
	 */
	public Guerrier(int vie, int attaque){
		super(vie, attaque, vie);
	}
}
