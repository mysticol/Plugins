package core;

import java.util.List;

import gui.GameUI;
import interfaces.IPlugin;

/**
 * Classe principale
 * @author sheuze
 *
 */
public class Main {
	

	/**
	 * Démarrage de l'appli
	 * @param args
	 */
	public static void main(String[] args) {
		
		//On récupère la liste des plugins
		List<PluginInfo> pluginInfo = Platform.getInstance().getPluginsInfo(IPlugin.class);
		for (PluginInfo plugin : pluginInfo)
		{
			// Appel du plugin Lanceur			
			if(plugin.getType() == TypePlugin.LANCEUR)
			{
				IPlugin pluginPrincipal = (IPlugin)Platform.getInstance().getPlugin(plugin);				
				pluginPrincipal.chargerPlugin();
				System.out.println("Le plugin " + plugin.getNom() + " a été chargé !");
			}
		}
		
		//Initialisation du jeu
		new GameUI();

	}

}
