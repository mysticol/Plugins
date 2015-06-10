package jobs;

import java.awt.Point;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Classe guerrier
 */
@Data
@EqualsAndHashCode(callSuper=false) 
public class Guerrier extends Personnage {
	/**
	 * Attaque
	 */
	private int attaque;
	
	/**
	 * Constructeur
	 * @param point
	 * @param vie
	 * @param attaque
	 */
	public Guerrier(Point coord, int vie, int attaque){
		super(coord, vie);
		this.attaque=attaque;
	}
}
