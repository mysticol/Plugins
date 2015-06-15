package plugin;


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

	Hero hero;
	
	Carte carte;
	
	/**
	 * Chargement du plugin
	 */
	public void chargerPlugin() {
		hero  = Platform.getInstance().getLauncherPlugin().getObjectInstance(Hero.class);
		carte = Platform.getInstance().getLauncherPlugin().getObjectInstance(Carte.class);
		System.out.println("Le plugin Deplacer a été chargé !");
	}

	public boolean doAction() {
		boolean actionDone = false;
		if(carte.getSelectedCell()!=null){
			if(Math.abs(carte.getSelectedCell().getCoord().x-carte.getActualCell().getCoord().x)<=hero.getDeplacementMax() &&
					Math.abs(carte.getSelectedCell().getCoord().y-carte.getActualCell().getCoord().y)<=hero.getDeplacementMax()){
				if(carte.getSelectedCell().getPersonnage() == null){
					
					// ON set les nouvelles coordonnées du personnage et on le supprime de la cellule
					carte.getActualCell().setPersonnage(null);;
					carte.getSelectedCell().setPersonnage(hero);
					
					//On change la cellule courante					
					carte.setActualCell(carte.getSelectedCell());
					
					System.out.println("Le personnage est maintenant en " + (int) carte.getActualCell().getCoord().x + ":" + carte.getActualCell().getCoord().y);
					
					actionDone = true;
				} else {
					System.out.println("Un personnage est déjà présent sur cette case");
				}
			} else {
				System.out.println("Le personnage ne peut pas se déplacer aussi loin");
			}
		} else {
			System.out.println("Aucune case sélectionnée");
		}
		
		return actionDone;
	}

	

}
