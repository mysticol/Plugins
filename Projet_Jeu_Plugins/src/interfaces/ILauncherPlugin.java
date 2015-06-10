package interfaces;

import jobs.Carte;
import jobs.Hero;

/**
 * Interface des plugins de lancement
 * @author sheuze
 *
 */
public interface ILauncherPlugin extends IPlugin {
	/**
	 * On lance le plugin (principal)
	 */
	public void launch();
	
	/**
	 * On set le plugin d'affichage
	 */
	public void setAffichage(IDisplayPlugin pluginPrincipal);
	
	/**
	 * On récupère le personnage
	 */
	public Hero getHero();
	
	/**
	 * On récupère la carte
	 */
	public Carte getCarte();

}
