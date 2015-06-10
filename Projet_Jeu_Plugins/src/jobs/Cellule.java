package jobs;


public class Cellule {
	
	protected int coordX;
	protected int coordY;


	protected Ressource ressource;
	protected Personnage personnage;
	
	
	public int getCoordX() {
		return coordX;
	}
	
	public Cellule() {
	}
	
	public Cellule(int coordX, int coordY) {
		this.coordX = coordX;
		this.coordY = coordY;
	}
	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}
	public int getCoordY() {
		return coordY;
	}
	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}
	
	@Override
	public String toString() {
		return "Cellule [coordX=" + coordX + ", coordY=" + coordY + "]";
	}
	
	/**
	 * @param ressource the ressource to set
	 */
	public void setRessource(Ressource ressource) {
		this.ressource = ressource;
	}
	/**
	 * @param personnage the personnage to set
	 */
	public void setPersonnage(Personnage personnage) {
		this.personnage = personnage;
	}

	/**
	 * @return the ressource
	 */
	public Ressource getRessource() {
		return ressource;
	}

	/**
	 * @return the personnage
	 */
	public Personnage getPersonnage() {
		return personnage;
	}
	
	

}
