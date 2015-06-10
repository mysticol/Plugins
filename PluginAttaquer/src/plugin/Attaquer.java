package plugin;

import interfaces.IActionPlugin;
import jobs.Carte;
import jobs.Hero;
import jobs.Or;
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
		Carte carte = Platform.getInstance().getLauncherPlugin().getCarte();
		
		if(carte.getSelectedCell().getPersonnage()!=null)
		{
			carte.getSelectedCell().getPersonnage().blesser(hero.getAttaque());
			hero.blesser(carte.getSelectedCell().getPersonnage().getAttaque());
			if(carte.getSelectedCell().getPersonnage().getVie() <= 0) //On supprime le guerrier
			{
				carte.getSelectedCell().setPersonnage(null);
				Or orGain = new Or(25);
				carte.getSelectedCell().setRessource(orGain);				
			}
			else
			{
				System.out.println("Vie du guerrier : " + carte.getSelectedCell().getPersonnage().getVie());
			}
		} else {
			System.out.println("Aucune ressource à récupérer");
		}
		System.out.println("Vie du hero : " + hero.getVie());
	}
}
