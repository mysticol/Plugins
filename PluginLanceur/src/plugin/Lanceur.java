package plugin;

import java.awt.Component;
import java.util.List;

import core.Platform;
import core.PluginInfo;
import core.TypePlugin;
import interfaces.IPlugin;

/**
 * Plugin principal, appelé Lanceur
 * @author sheuze
 *
 */
public class Lanceur implements IPlugin{
	
	public void chargerPlugin()
	{
		System.out.println("Vous êtes dans le plugin Principal");
		GameUI gameUI = new GameUI();
		
		//On récupère la liste des plugins
		List<PluginInfo> pluginInfo = Platform.getInstance().getPluginsInfo(IPlugin.class, TypePlugin.AFFICHAGE);
		
		if(pluginInfo.size()>0){
			//Pour l'instant on prend le premier plugin (TODO : Gestion des priorités)
			PluginInfo plugin = pluginInfo.get(0);
			
			IPlugin pluginPrincipal = (IPlugin)Platform.getInstance().getPlugin(plugin);
			pluginPrincipal.chargerPlugin();
			gameUI.setAffichageFrame((Component) pluginPrincipal);
			
			System.out.println("Le plugin " + plugin.getNom() + " a été chargé !");
		} else {
			throw new RuntimeException("Aucun plugin Affichage n'est présent");
		}
	}
}
