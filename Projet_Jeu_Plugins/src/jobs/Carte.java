package jobs;


public class Carte {

	// Attributs

	private Cellule[][] cellules;

	private int nbLignes;
	
	private int nbColonnes;
	
	private Cellule selectedCell;

	// Constructeurs

	public Carte(){
	}

	public Carte(int nbLignes, int nbColonnes){
		this.nbLignes=nbLignes;
		this.nbColonnes=nbColonnes;
		cellules = new Cellule[nbColonnes][nbLignes];

		for(int i=0;i<this.nbColonnes;i++){
			for(int j=0;j<this.nbLignes;j++){	
				cellules[i][j] = new Cellule(i,j);
			}

		}
	}
	
	public Cellule getCellule(int colonne, int ligne){
		return this.cellules[colonne][ligne];
	}
	
	public void setCellule(int colonne, int ligne, Cellule cell){
		this.cellules[colonne][ligne] = cell;
	}

	/**
	 * @return the nbLignes
	 */
	public int getNbLignes() {
		return nbLignes;
	}

	/**
	 * @return the nbColonnes
	 */
	public int getNbColonnes() {
		return nbColonnes;
	}

	public Cellule getSelectedCell() {
		return selectedCell;
	}

	public void setSelectedCell(Cellule selectedCell) {
		this.selectedCell = selectedCell;
	}


}
