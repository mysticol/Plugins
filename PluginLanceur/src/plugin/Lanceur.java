package plugin;

import java.awt.Component;
import java.util.List;

import jobs.Hero;
import core.Platform;
import core.PluginInfo;
import core.TypePlugin;
import interfaces.IDisplayPlugin;
import interfaces.ILauncherPlugin;

/**
 * Plugin principal, appel� Lanceur
 * @author sheuze
 *
 */
public class Lanceur implements ILauncherPlugin{
	
	private GameUI gameUI;
	
	private Hero hero;
	
	public void chargerPlugin()
	{
		System.out.println("Le plugin Lanceur a �t� charg� !");
		hero = new Hero(100, 0, 0);
	}
	
	public void launch(){
		this.gameUI = new GameUI();
		
		//On r�cup�re la liste des plugins
		List<PluginInfo> pluginInfo = Platform.getInstance().getPluginsInfo(IDisplayPlugin.class, TypePlugin.AFFICHAGE);
		
		if(pluginInfo.size()>0){
			//Pour l'instant on prend le premier plugin (TODO : Gestion des priorit�s)
			PluginInfo plugin = pluginInfo.get(0);
			
			IDisplayPlugin pluginPrincipal = (IDisplayPlugin)Platform.getInstance().getPlugin(plugin);
			pluginPrincipal.display();
			
		} else {
			throw new RuntimeException("Aucun plugin Affichage n'est pr�sent");
		}
	}
	
	public void setAffichage(IDisplayPlugin pluginPrincipal){
		gameUI.setAffichageFrame((Component) pluginPrincipal);
	}

	@Override
	public Hero getHero() {
		return hero;
	}
}
