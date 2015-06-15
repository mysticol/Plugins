package plugin;

import interfaces.IActionPlugin;
import jobs.Carte;
import jobs.Cellule;
import jobs.Guerrier;
import jobs.Hero;
import jobs.Or;
import core.Platform;

/**
 * Plugin de RegenerationVie (reg�n�re la vie petit � petit)
 * @author SEB
 *
 */
public class RegenerationVie implements IActionPlugin {

	private static final int REGEN_VIE = 5;
	
	Hero hero;
	
	Carte carte;
	/**
	 * Chargement du plugin
	 */
	public void chargerPlugin() {
		hero  = Platform.getInstance().getLauncherPlugin().getObjectInstance(Hero.class);
		carte  = Platform.getInstance().getLauncherPlugin().getObjectInstance(Carte.class);
		System.out.println("Le plugin RegenerationVie a �t� charg� !");
	}

	public boolean doAction() {
		if(hero.getVie() < hero.getVieMax() && hero.getVie()>0) //Si le hero a �t� touch�
		{
			hero.setVie(hero.getVie()+REGEN_VIE);
			if(hero.getVie() > hero.getVieMax()){
				hero.setVie(hero.getVieMax());
			}
			System.out.println("Vie reg�n�r�e � : " + hero.getVie());
		}
		return true;
	}
}
