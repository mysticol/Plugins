package plugin;

import java.awt.Point;

import interfaces.IActionPlugin;
import jobs.Carte;
import jobs.Hero;
import core.Platform;

/**
 * Plugin Deplacer
 * @author SEB
 *
 */
public class Deplacer implements IActionPlugin {

	/**
	 * Chargement du plugin
	 */
	public void chargerPlugin() {
		System.out.println("Le plugin Deplacer a �t� charg� !");
	}

	public void doAction() {
		Hero hero  = Platform.getInstance().getLauncherPlugin().getHero();
		Carte carte = Platform.getInstance().getLauncherPlugin().getCarte();

		if(carte.getSelectedCell()!=null){
			if(Math.abs(carte.getSelectedCell().getCoord().x-carte.getActualCell().getCoord().x)<=hero.getDeplacementMax() &&
					Math.abs(carte.getSelectedCell().getCoord().y-carte.getActualCell().getCoord().y)<=hero.getDeplacementMax()){
				if(carte.getSelectedCell().getPersonnage() == null){
					
					// ON set les nouvelles coordonn�es du personnage et on le supprime de la cellule
					carte.getActualCell().setPersonnage(null);;
					carte.getSelectedCell().setPersonnage(hero);
					
					//On change la cellule courante					
					carte.setActualCell(carte.getSelectedCell());
					
					System.out.println("Le personnage est maintenant en " + (int) carte.getActualCell().getCoord().x + ":" + carte.getActualCell().getCoord().y);
				} else {
					System.out.println("Un personnage est d�j� pr�sent sur cette case");
				}
			} else {
				System.out.println("Le personnage ne peut pas se d�placer aussi loin");
			}
		} else {
			System.out.println("Aucune case s�lectionn�e");
		}
		
	}

	

}
