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


	public Hero(int vie, int stockNourriture,int stockOr, int deplacementMax, int attaque){
		super(vie, attaque);
		
		this.stockNourriture=stockNourriture;
		
		this.stockOr=stockOr;
		
		this.deplacementMax = deplacementMax;
	}


	public void recolter(Ressource ressource){
		if (ressource.getClass().equals(Or.class)){
			stockOr+=100;
			System.out.println("Stock Or du hero : " + this.getStockOr());
			ressource.setMontant(ressource.getMontant()-100);
		} else if (ressource.getClass().equals(Nourriture.class)){
			stockNourriture+=100;
			ressource.setMontant(ressource.getMontant()-100);
			System.out.println("Stock Nourriture du hero : " + this.getStockNourriture());
		}	
	}
	



}
