package plugin;

import java.awt.Component;
import java.util.List;
import java.util.Random;

import jobs.Carte;
import jobs.Hero;
import core.Platform;
import core.PluginInfo;
import core.TypePlugin;
import interfaces.IDisplayPlugin;
import interfaces.ILauncherPlugin;

/**
 * Plugin principal, appelé Lanceur
 * @author sheuze
 *
 */
public class Lanceur implements ILauncherPlugin{
	
	/**
	 * Nombre de colonne
	 */
	private static int COLUMN_COUNT = 10;
	
	/**
	 * Nombre de lignes
	 */
    private static int ROW_COUNT = 10;
    
	/**
	 * L'interface de jeu
	 */
	private GameUI gameUI;
	
	/**
	 * Le hero
	 */
	private Hero hero;
	
	/**
	 * La carte
	 */
	private Carte carte;
	
	public void chargerPlugin()
	{
		System.out.println("Le plugin Lanceur a été chargé !");
	}
	
	public void launch(){
		hero = new Hero(100, 0, 0);
		
		carte = new Carte(COLUMN_COUNT, ROW_COUNT);
		this.randomMap();
		this.gameUI = new GameUI();
		
		//On récupère la liste des plugins
		List<PluginInfo> pluginInfo = Platform.getInstance().getPluginsInfo(IDisplayPlugin.class, TypePlugin.AFFICHAGE);
		
		if(pluginInfo.size()>0){
			//Pour l'instant on prend le premier plugin (TODO : Gestion des priorités)
			PluginInfo plugin = pluginInfo.get(0);
			
			IDisplayPlugin pluginPrincipal = (IDisplayPlugin)Platform.getInstance().getPlugin(plugin);
			pluginPrincipal.display();
			
		} else {
			throw new RuntimeException("Aucun plugin Affichage n'est présent");
		}
	}
	
	/**
	 * Random de la map
	 */
	public void randomMap(){
		Random random = new Random();
		//Placement du Hero
		int x = random.nextInt(COLUMN_COUNT);
		int y = random.nextInt(ROW_COUNT);
		
		System.out.println("Placement du hero sur la map à " + x + ":" + y);
		carte.getCellule(x, y).setPersonnage(hero);
	}
	
	public void setAffichage(IDisplayPlugin pluginPrincipal){
		gameUI.setAffichageFrame((Component) pluginPrincipal);
	}

	@Override
	public Hero getHero() {
		return hero;
	}

	@Override
	public Carte getCarte() {
		return carte;
	}
}
