package jobs;


public class Cellule {
	
	protected int coordX;
	protected int coordY;
	protected Carte carte;
	protected Ressource ressource;
	protected Personnage personnage;
	
	
	
	public Carte getCarte() {
		return carte;
	}
	public void setCarte(Carte carte) {
		this.carte = carte;
	}
	public int getCoordX() {
		return coordX;
	}
	
	public Cellule() {
		super();
	}
	public Cellule(int coordX, int coordY) {
		super();
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
	
	

}
