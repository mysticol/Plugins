package plugin;

import interfaces.IDisplayPlugin;
import interfaces.ILauncherPlugin;

import java.awt.Component;
import java.awt.Point;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Random;

import jobs.Carte;
import jobs.Guerrier;
import jobs.Hero;
import jobs.Nourriture;
import core.Platform;
import core.PluginInfo;
import core.TypePlugin;

/**
 * Plugin principal, appelé Lanceur
 * @author sheuze
 *
 */
public class Lanceur implements ILauncherPlugin{
	
	/**
	 * Nombre de colonne
	 */
	private static final int COLUMN_COUNT = 10;
	
	/**
	 * Nombre de lignes
	 */
    private static final int ROW_COUNT = 10;
    
    /**
     * Déplacement max Hero
     */
    private static final int DEPLACEMENT_MAX = 1;
    
    /**
     * Nombre ennemis max
     */
    private static final int NB_ENNEMIS = 5;
    
    /**
     * Nombre ennemis max
     */
    private static final int NB_NOURRITURE = 4;
    
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
		hero = new Hero(100,0,0,DEPLACEMENT_MAX,20);
		carte.getCellule(x, y).setPersonnage(hero);
		carte.setActualCell(carte.getCellule(x, y));
		
		int nbEnnemisMap = 0;
		while (nbEnnemisMap < NB_ENNEMIS){
			//Random
			x = random.nextInt(COLUMN_COUNT);
			y = random.nextInt(ROW_COUNT);
			if (carte.getCellule(x, y).getPersonnage() == null){
				System.out.println("Placement d'un guerrier sur la map à " + x + ":" + y);
				Guerrier guerrier = new Guerrier(100,10);
				carte.getCellule(x, y).setPersonnage(guerrier);
				nbEnnemisMap++;
			}
		}
		
		int nbNourritureMap = 0;
		while (nbNourritureMap < NB_NOURRITURE){
			//Random
			x = random.nextInt(COLUMN_COUNT);
			y = random.nextInt(ROW_COUNT);
			//ON vérifie si il n'y a pas de personnage sur la cellule
			if (carte.getCellule(x, y).getPersonnage() == null && carte.getCellule(x, y).getRessource() == null){
				System.out.println("Placement de nourriture sur la map à " + x + ":" + y);
				Nourriture nourriture = new Nourriture(100);
				carte.getCellule(x, y).setRessource(nourriture);
				nbNourritureMap++;
			}
		}
	}
	
	public void setAffichage(IDisplayPlugin pluginPrincipal){
		gameUI.setAffichageFrame((Component) pluginPrincipal);
	}



	@Override
	public <T> T getObjectInstance(Class<T> clazz) {
		Field[] fieldsList = this.getClass().getDeclaredFields();
		for(Field field : fieldsList){
			if(field.getType().equals(clazz)){
				try {
					return (T) field.get(this);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					System.out.println("Erreur lors de la récupération de l'objet");
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public void gameOver(String message) {
		this.gameUI.gameOver(message);	
		Platform.getInstance().unloadPlugins();
		this.launch();
	}
}
