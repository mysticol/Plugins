package plugin;

import interfaces.IActionPlugin;
import jobs.Carte;
import jobs.Cellule;
import jobs.Guerrier;
import jobs.Hero;
import jobs.Or;
import core.Platform;

/**
 * Plugin de RegenerationVie (regénère la vie petit à petit)
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
		System.out.println("Le plugin RegenerationVie a été chargé !");
	}

	public boolean doAction() {
		if(hero.getVie() < hero.getVieMax() && hero.getVie()>0) //Si le hero a été touché
		{
			hero.setVie(hero.getVie()+REGEN_VIE);
			if(hero.getVie() > hero.getVieMax()){
				hero.setVie(hero.getVieMax());
			}
			System.out.println("Vie regénérée à : " + hero.getVie());
		}
		return true;
	}
}
