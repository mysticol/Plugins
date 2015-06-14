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

	Hero hero;
	
	Carte carte;
	
	/**
	 * Chargement du plugin
	 */
	public void chargerPlugin() {
		hero  = Platform.getInstance().getLauncherPlugin().getObjectInstance(Hero.class);
		carte = Platform.getInstance().getLauncherPlugin().getObjectInstance(Carte.class);
		System.out.println("Le plugin Recolter a été chargé !");
	}

	public void doAction() {
		
		
		if(carte.getActualCell().getRessource()!=null){
			hero.recolter(carte.getActualCell().getRessource()); //Passer la cellule en paramètre
			carte.getActualCell().setRessource(null);
		} else {
			System.out.println("Aucune ressource à récupérer");
		}
		

		
	}

	
}
