package core;

import interfaces.ILauncherPlugin;

import java.util.List;

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
		List<PluginInfo> pluginInfo = Platform.getInstance().getPluginsInfo(ILauncherPlugin.class, TypePlugin.LANCEUR);
		
		if(pluginInfo.size() > 0) {
			PluginInfo plugin = pluginInfo.get(0);
			
			ILauncherPlugin pluginPrincipal = (ILauncherPlugin)Platform.getInstance().getPlugin(plugin);				
			pluginPrincipal.launch();
			
		} else {
			throw new RuntimeException("Aucun plugin lanceur n'est présent");
		}
	}


}
