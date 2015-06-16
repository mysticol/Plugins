package jobs;


/**
 * Classe guerrier
 */
public class Guerrier extends Personnage {
		
	/**
	 * Constructeur
	 * @param vie
	 * @param attaque
	 */
	public Guerrier(int vie, int attaque){
		super(vie, attaque, vie);
	}
	
}
