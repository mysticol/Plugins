package core;

import java.util.List;

import interfaces.IPlugin;

/**
 * Classe principale
 * @author sheuze
 *
 */
public class Main {
	

	/**
	 * D�marrage de l'appli
	 * @param args
	 */
	public static void main(String[] args) {
		
		//On r�cup�re la liste des plugins
		List<PluginInfo> pluginInfo = Platform.getInstance().getPluginsInfo(IPlugin.class, TypePlugin.LANCEUR);
		
		if(pluginInfo.size() > 0) {
			PluginInfo plugin = pluginInfo.get(0);
			
			IPlugin pluginPrincipal = (IPlugin)Platform.getInstance().getPlugin(plugin);				
			pluginPrincipal.chargerPlugin();
			System.out.println("Le plugin " + plugin.getNom() + " a �t� charg� !");
		} else {
			throw new RuntimeException("Aucun plugin lanceur n'est pr�sent");
		}
	}


}
