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

	Hero hero;
	
	Carte carte;
	
	/**
	 * Chargement du plugin
	 */
	public void chargerPlugin() {
		hero  = Platform.getInstance().getLauncherPlugin().getObjectInstance(Hero.class);
		carte = Platform.getInstance().getLauncherPlugin().getObjectInstance(Carte.class);
		System.out.println("Le plugin Attaquer a été chargé !");
	}

	public boolean doAction() {
		
		boolean actionDone = false;
		if(carte.getSelectedCell() != null
				&& carte.getSelectedCell().getPersonnage()!=null
				&& carte.getSelectedCell()!= carte.getActualCell()
				&&  Math.abs(carte.getSelectedCell().getCoord().x-carte.getActualCell().getCoord().x)<=hero.getDeplacementMax()
				&& 	Math.abs(carte.getSelectedCell().getCoord().y-carte.getActualCell().getCoord().y)<=hero.getDeplacementMax())
		{
			carte.getSelectedCell().getPersonnage().blesser(hero.getAttaque());
			System.out.println("Vie du guerrier : " + carte.getSelectedCell().getPersonnage().getVie());
			if(carte.getSelectedCell().getPersonnage().getVie() <= 0) //On supprime le guerrier
			{
				carte.getSelectedCell().setPersonnage(null);
				Or orGain = new Or(25);
				carte.getSelectedCell().setRessource(orGain);				
			}
			
			actionDone = true;		
			
		} else {
			System.out.println("Aucun guerrier à attaquer");
		}
		
		return actionDone;
	}
}
