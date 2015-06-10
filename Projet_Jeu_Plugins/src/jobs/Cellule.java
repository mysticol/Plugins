package jobs;

import java.awt.Point;

import lombok.Data;

/**
 * Classe cellule
 *
 */
@Data
public class Cellule {
	
	/**
	 * Coordonnée de la cellule
	 */
	private Point coord;

	/**
	 * Ressource contenue sur la cellule
	 */
	private Ressource ressource;
	
	/**
	 * Personnage présent sur la cellule
	 */
	private Personnage personnage;
	
	
	/**
	 * Constructeur de cellule selon x et y
	 * @param coordX
	 * @param coordY
	 */
	public Cellule(int coordX, int coordY) {
		this.coord = new Point(coordX, coordY);
	}
	

}
