package jobs;

/**
 * Carte du jeu
 */
public class Carte {

	/**
	 * Liste des cellules qui composant la map
	 */
	private Cellule[][] cellules;

	/**
	 * nombre de lignes de la map
	 */
	private final int nbLignes;
	
	/**
	 * nombre de colonnes de la map
	 */
	private final int nbColonnes;
	
	/**
	 * Référence sur la cellule sélectionnée	
	 */
	private Cellule selectedCell;

	/**
	 * Référence sur la cellule actuelle
	 */
	private Cellule actualCell;

	/**
	 * Constructeur d'une map aux dimensions données en paramètre
	 * @param nbLignes nombre de lignes
	 * @param nbColonnes nombre de colonnes
	 */
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
	
	/**
	 * Récupère une cellule en x/y
	 * @param colonne X
	 * @param ligne Y
	 * @return la cellule
	 */
	public Cellule getCellule(int colonne, int ligne){
		return this.cellules[colonne][ligne];
	}
	
	/**
	 * Setter de cellule à un endroit spécifique
	 * @param colonne la colonne
	 * @param ligne ligne
	 * @param cell la cellule à set
	 */
	public void setCellule(int colonne, int ligne, Cellule cell){
		this.cellules[colonne][ligne] = cell;
	}

	/**
	 * @return the cellules
	 */
	public Cellule[][] getCellules() {
		return cellules;
	}

	/**
	 * @param cellules the cellules to set
	 */
	public void setCellules(Cellule[][] cellules) {
		this.cellules = cellules;
	}

	/**
	 * @return the selectedCell
	 */
	public Cellule getSelectedCell() {
		return selectedCell;
	}

	/**
	 * @param selectedCell the selectedCell to set
	 */
	public void setSelectedCell(Cellule selectedCell) {
		this.selectedCell = selectedCell;
	}

	/**
	 * @return the actualCell
	 */
	public Cellule getActualCell() {
		return actualCell;
	}

	/**
	 * @param actualCell the actualCell to set
	 */
	public void setActualCell(Cellule actualCell) {
		this.actualCell = actualCell;
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
	
	
}