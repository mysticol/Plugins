package jobs;

import java.awt.Point;

public abstract class Personnage {
	
	// Attributs
	protected Point coord;
	private int vie;
	

	//Constructeurs
	
	public Personnage(){
		
	}
	
	public Personnage(int vie){
		this.vie=vie;
	}
	
	
	
	//Getters and Setters
	
	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}

	public void blesser(int nbVie) {
		this.vie = this.vie - nbVie;
	}
	
	@Override
	public abstract String toString();

	public Point getCoord() {
		return coord;
	}

	public void setCoord(Point coord) {
		this.coord = coord;
	}
	

	
	
}
