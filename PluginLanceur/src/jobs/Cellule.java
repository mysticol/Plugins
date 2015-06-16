package jobs;

import java.awt.Point;


/**
 * Classe cellule
 *
 */
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


	/**
	 * @return the coord
	 */
	public Point getCoord() {
		return coord;
	}


	/**
	 * @param coord the coord to set
	 */
	public void setCoord(Point coord) {
		this.coord = coord;
	}


	/**
	 * @return the ressource
	 */
	public Ressource getRessource() {
		return ressource;
	}


	/**
	 * @param ressource the ressource to set
	 */
	public void setRessource(Ressource ressource) {
		this.ressource = ressource;
	}


	/**
	 * @return the personnage
	 */
	public Personnage getPersonnage() {
		return personnage;
	}


	/**
	 * @param personnage the personnage to set
	 */
	public void setPersonnage(Personnage personnage) {
		this.personnage = personnage;
	}
	

}
