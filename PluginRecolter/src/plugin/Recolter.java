package plugin;

import interfaces.IActionPlugin;
import jobs.Hero;
import jobs.Nourriture;
import jobs.Ressource;
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
		System.out.println("Le plugin Recolter a été chargé !");
	}

	public void doAction() {
		Hero hero  = Platform.getInstance().getLauncherPlugin().getHero();
		hero.Recolter(new Nourriture(100));

		System.out.println("Stock Nourriture du hero : " + hero.getStockNourriture());
	}

	

}
