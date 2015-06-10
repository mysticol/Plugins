package plugin;

import interfaces.IActionPlugin;
import jobs.Carte;
import jobs.Cellule;
import jobs.Hero;
import jobs.Nourriture;
import core.Platform;

/**
 * Plugin Recolter
 * @author SEB
 *
 */
public class Recolter implements IActionPlugin {

	/**
	 * Chargement du plugin
	 */
	public void chargerPlugin() {
		System.out.println("Le plugin Recolter a �t� charg� !");
	}

	public void doAction() {
		Hero hero  = Platform.getInstance().getLauncherPlugin().getHero();
		Carte carte = Platform.getInstance().getLauncherPlugin().getCarte();
		
		if(carte.getActualCell().getRessource()!=null){
			hero.recolter(carte.getActualCell().getRessource()); //Passer la cellule en param�tre
			carte.getActualCell().setRessource(null);
		} else {
			System.out.println("Aucune ressource � r�cup�rer");
		}
		

		
	}

	
}
