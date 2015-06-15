package plugin;

import interfaces.IActionPlugin;
import jobs.Carte;
import jobs.Cellule;
import jobs.Guerrier;
import jobs.Hero;
import jobs.Or;
import core.Platform;

/**
 * Plugin de Game Over (gère tous les cas de GameOver)
 * @author SEB
 *
 */
public class GameOver implements IActionPlugin {

	Hero hero;
	
	Carte carte;
	/**
	 * Chargement du plugin
	 */
	public void chargerPlugin() {
		hero  = Platform.getInstance().getLauncherPlugin().getObjectInstance(Hero.class);
		carte  = Platform.getInstance().getLauncherPlugin().getObjectInstance(Carte.class);
		System.out.println("Le plugin GameOver a été chargé !");
	}

	public boolean doAction() {
		if(hero.getVie() <= 0) //On supprime le hero si il n'a plus de vie
		{
			carte.getActualCell().setPersonnage(null);		
			Platform.getInstance().getLauncherPlugin().gameOver("Votre hero n'a plus de vie");
		}
		return true;
	}
}
