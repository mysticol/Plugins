package core;

import java.util.List;

import interfaces.IPlugin;

public class Main {

	public static void main(String[] args) {
		
		Platform p = new Platform();
		List<PluginInfo> pluginInfo = p.getPluginsInfo(IPlugin.class);
		for (PluginInfo a : pluginInfo)
		{
			// Appel du plugin Lanceur
			System.out.println(a.toString());
		}

	}

}
