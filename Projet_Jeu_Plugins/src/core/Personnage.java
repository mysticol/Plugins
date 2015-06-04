package core;

public abstract class Personnage {
	
	// Attributs
	protected Cellule cellule;
	private int vie;
	

	//Constructeurs
	
	public Personnage(){
		
	}
	
	public Personnage(int vie){
		this.vie=vie;
	}
	
	
	public void setCellule(Cellule cellule) {
		this.cellule = cellule;
	}

	public Cellule getCellule(){
		return cellule;
	}
	
	//Getters and Setters
	
	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}

	
	@Override
	public abstract String toString();
	

	
	
}
