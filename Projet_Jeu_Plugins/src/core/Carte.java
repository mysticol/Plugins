package core;

import java.util.ArrayList;

public class Carte {
	
	// Attributs
	
		private ArrayList <Cellule> carte;
	
		private int nbLig;
		private int nbCol;
		
		// Constructeurs
		
		public Carte(){
		}
		
		public Carte(int nbLig, int nbCol){
			this.nbLig=nbLig;
			this.nbCol=nbCol;
			carte = new ArrayList <Cellule>();
			
			for(int i=0;i<this.nbLig;i++){
				for(int j=0;j<this.nbCol;j++){	
					carte.add(new Cellule(i,j));
				}
				
			}
		}
		
		public void Afficher(){
			System.out.println();
			for(Cellule i : carte){
				if (nbCol-1<=i.getCoordY()){
					System.out.println('x');
				} else {
					System.out.print('x');
				}
				
				
				
			}
			}
				

	
}
