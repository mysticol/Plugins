package plugin;

import interfaces.IActionPlugin;
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
		
		hero.recolter(new Nourriture(100, new Cellule(0, 0))); //Passer la cellule en param�tre

		System.out.println("Stock Nourriture du hero : " + hero.getStockNourriture());
	}

	
}
