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
		System.out.println("Le plugin Attaquer a �t� charg� !");
	}

	public void doAction() {
		
		
		if(carte.getSelectedCell().getPersonnage()!=null && Math.abs(carte.getSelectedCell().getCoord().x-carte.getActualCell().getCoord().x)<=hero.getDeplacementMax() &&
				Math.abs(carte.getSelectedCell().getCoord().y-carte.getActualCell().getCoord().y)<=hero.getDeplacementMax())
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
			System.out.println("Aucun guerrier � attaquer");
		}
		System.out.println("Vie du hero : " + hero.getVie());
	}
}
