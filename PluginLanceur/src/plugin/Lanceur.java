package plugin;

import java.awt.Component;
import java.util.List;

import core.Platform;
import core.PluginInfo;
import core.TypePlugin;
import interfaces.IPlugin;

/**
 * Plugin principal, appel� Lanceur
 * @author sheuze
 *
 */
public class Lanceur implements IPlugin{
	
	public void chargerPlugin()
	{
		System.out.println("Vous �tes dans le plugin Principal");
		GameUI gameUI = new GameUI();
		
		//On r�cup�re la liste des plugins
		List<PluginInfo> pluginInfo = Platform.getInstance().getPluginsInfo(IPlugin.class, TypePlugin.AFFICHAGE);
		
		if(pluginInfo.size()>0){
			//Pour l'instant on prend le premier plugin (TODO : Gestion des priorit�s)
			PluginInfo plugin = pluginInfo.get(0);
			
			IPlugin pluginPrincipal = (IPlugin)Platform.getInstance().getPlugin(plugin);
			pluginPrincipal.chargerPlugin();
			gameUI.setAffichageFrame((Component) pluginPrincipal);
			
			System.out.println("Le plugin " + plugin.getNom() + " a �t� charg� !");
		} else {
			throw new RuntimeException("Aucun plugin Affichage n'est pr�sent");
		}
	}
}
