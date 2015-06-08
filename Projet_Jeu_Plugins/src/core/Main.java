package core;

import java.net.MalformedURLException;
import java.util.List;

import gui.GameUI;
import interfaces.IPlugin;

public class Main {
	
	static IPlugin pluginPrincipal;
	static Platform plateforme;

	public static void main(String[] args) throws MalformedURLException {
		
		plateforme = new Platform();
		List<PluginInfo> pluginInfo = plateforme.getPluginsInfo(IPlugin.class);
		for (PluginInfo a : pluginInfo)
		{
			// Appel du plugin Lanceur			
			if(a.getType() == TypePlugin.LANCEUR)
			{
				pluginPrincipal = (IPlugin)plateforme.getPlugin(IPlugin.class);				
				pluginPrincipal.chargerPlugin();
				System.out.println("Le plugin " + a.getNom() + " a été chargé !");
			}
		}
		
		GameUI gameUI = new GameUI();

	}

}
