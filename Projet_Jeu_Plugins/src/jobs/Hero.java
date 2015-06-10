package jobs;

import java.awt.Point;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Classe hero
 */
@Data
@EqualsAndHashCode(callSuper=false) 
public class Hero extends Personnage {

	// Attributs
	private int stockOr;
	
	private int stockNourriture;

	private final int deplacementMax;


	public Hero(Point coord, int vie, int stockNourriture,int stockOr, int deplacementMax){
		super(coord, vie);
		this.stockNourriture=stockNourriture;
		this.stockOr=stockOr;
		this.deplacementMax = deplacementMax;
	}


	public void recolter(Ressource ressource){
		if (ressource.getClass().equals(Or.class)){
			stockOr+=100;
			ressource.setMontant(ressource.getMontant()-100);
		} else if (ressource.getClass().equals(Nourriture.class)){
			stockNourriture+=100;
			ressource.setMontant(ressource.getMontant()-100);
		}	
	}
	



}
