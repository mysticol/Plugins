package plugin;

import interfaces.IActionPlugin;

import jobs.Hero;
import core.Platform;

/**
 * Plugin attaquer
 * @author SEB
 *
 */
public class Attaquer implements IActionPlugin {

	/**
	 * Chargement du plugin
	 */
	public void chargerPlugin() {
		System.out.println("Le plugin Attaquer a été chargé !");
	}

	public void doAction() {
		Hero hero  = Platform.getInstance().getLauncherPlugin().getHero();
		hero.blesser(10);

		System.out.println("Vie du hero : " + hero.getVie());
	}

	

}
