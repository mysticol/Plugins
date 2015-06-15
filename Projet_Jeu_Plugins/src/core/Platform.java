package core;

import interfaces.IActionPlugin;
import interfaces.IDisplayPlugin;
import interfaces.ILauncherPlugin;
import interfaces.IPlugin;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Programme principal => Lanceur
 * Le lanceur va appeler notre plugin de Product Carte (donc récupération de l'objet carte)
 * Lorsque l'utilisateur souhaite afficher la Map, appel de la plateforme avec "Afficheur"
 * Lecture des pluginInfo "Afficheur", si plusieurs alors demander à l'utilisateur ...
 * Dans l'appli, on a autant d'interface qu'on a de focntionnalités
 * Par exemple, on a IProducerMap qui a la fonctionnalité getMap
 * Cette interface est implémentée dans le Plugin ProducerMap.
 * Le lanceur va demander les Producer disponibles. Les afficher. 
 * L'utilisateur choisit par la suite lequel.
 * Une fois la Map récupérée, boucle sur les déplacements et Affichage et Recolte. 
 */


/**
 * Classe permettant de charger les divers plugins en fonction du fichier de config
 * @author Sebastien
 *
 */
public final class Platform {

	/**
	 * Objet plateforme
	 */
	private static Platform plateforme;
	
	/**
	 * Plugin Launcher (1 seul)
	 */
	private ILauncherPlugin launcherPlugin;
	
	/**
	 * Liste de plugins actions
	 */
	private Map<String,IActionPlugin> actionPluginsList;
	
	/**
	 * Liste de plugins d'affichage
	 */
	private Map<String,IDisplayPlugin> displayPluginsList;
	
	
	/**
	 * Propriétés du fichier de config
	 */
	private Properties config;
	
	/**
	 * Chemin du fichier de configuration
	 */
	private String FILECONFIGPATH = "config.txt";
	
	/**
	 * Constructeur
	 * Appel du Chargement du fichier de configuration
	 */
	public Platform()
	{
		actionPluginsList = new HashMap<String, IActionPlugin>();
		displayPluginsList = new HashMap<String, IDisplayPlugin>();
		
		this.loadConfig();
	}
	
	/**
	 * Chargement du fichier de configuration
	 */
	private void loadConfig() {
		try {
			config = new Properties();
			config.load(new FileReader(FILECONFIGPATH));
		} catch (IOException e) {
			System.out.println("Erreur dans la lecture du fichier");
		}
	}
	
	/**
	 * Charger un plugin
	 */
	public void chargerPlugin(IPlugin plugin){
		if (plugin instanceof IActionPlugin){
			actionPluginsList.put(plugin.getClass().getName(), (IActionPlugin) plugin);
		} else if (plugin instanceof IDisplayPlugin){
			displayPluginsList.put(plugin.getClass().getName(), (IDisplayPlugin) plugin);
		} else if (plugin instanceof ILauncherPlugin){
			launcherPlugin = (ILauncherPlugin) plugin;
		}
	}
	
	/**
	 * Décharger les plugins
	 */
	public void unloadPlugins(){
		actionPluginsList = new HashMap<String, IActionPlugin>();
		displayPluginsList = new HashMap<String, IDisplayPlugin>();
	}
	
	/**
	 * Plugin Exist ?
	 */
	public IPlugin getPluginInstance(PluginInfo pluginInfo){
		if ("IActionPlugin".equals(pluginInfo.getInterf())){
			return actionPluginsList.get("plugin."+pluginInfo.getNom());
		} else if ("IDisplayPlugin".equals(pluginInfo.getInterf())){
			return displayPluginsList.get("plugin."+pluginInfo.getNom());
		} else if ("ILauncherPlugin".equals(pluginInfo.getInterf())){
			return launcherPlugin;
		} else {
			throw new RuntimeException("Type de Plugin incompatible");
		}
	}
	
	
	/**
	 * Lecture du fichier de configuration et création d'une liste de Plugin Info
	 * en fonction d'un type de Plugin
	 * Retourne la liste de Plugin Info
	 * @param interf
	 * @return
	 */
	public List<PluginInfo> getPluginsInfo(Class<?> interf, TypePlugin type) {
		List<PluginInfo> listePluginsInfo = new ArrayList<PluginInfo>();
		
		for(Object key : config.keySet()) {
			String info = (String)config.get(key);
			String[] infos = info.split(";");
			if(infos[1].equals(type.name()) && ("interfaces." + infos[0]).equals(interf.getName()) && Boolean.valueOf(infos[3])) {
				PluginInfo pluginInfo = new PluginInfo((String)key, infos[0],TypePlugin.valueOf(infos[1]),infos[2]);
				listePluginsInfo.add(pluginInfo);
			}
		}		
		return listePluginsInfo;
	}
	
	/**
	 * Récupération d'une instance d'unne classe en fonction d'un nom de classe
	 * @param className
	 * @return
	 * @throws MalformedURLException 
	 */
	public IPlugin getPlugin(PluginInfo pluginInfo) {
		
		//On check si le plugin existe déjà ou pas
		IPlugin pluginInstance = this.getPluginInstance(pluginInfo);
		
		//Si le plugin n'a jamais été chargé on le charge
		if(pluginInstance == null){
			System.out.println("Chargement du Plugin " + pluginInfo.getNom());
			
			//Instanciation de la classe en fonction de son chemin 
			//présent dans le fichier de configuration
			URL[] urls = null;
			try {
				File classFolder = new File(System.getProperty("user.dir") + "/mods/"+pluginInfo.getPath()+".jar");
				URL url = classFolder.toURI().toURL();
				System.out.println("Chargement du plugin situé à : " + url);
				urls = new URL[]{ url};
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			} 
					
			URLClassLoader cl = new URLClassLoader(urls);
			
			Class<?> cls;
			
			try {
				cls = cl.loadClass("plugin." +pluginInfo.getNom());
				pluginInstance =  (IPlugin) cls.newInstance();
				pluginInstance.chargerPlugin();
				//On le charge pour des utilisations futures
				this.chargerPlugin(pluginInstance);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				System.out.println("Erreur lors du chargement du plugin " +pluginInfo.getNom() + " au chargement de la classe");
				e.printStackTrace();
			}
			
		}
		
		return pluginInstance;
	}
	
	/**
	 * Instanciation de Platform
	 * @return
	 */
	public static Platform getInstance() {
		if(plateforme == null) {
			System.out.println("Initialisation de la Plateforme");
			plateforme = new Platform();
		}
		
		return plateforme;
	}
	
	
	/**
	 * Getters et Setters
	 */
	public static Platform getPlateforme() {
		return plateforme;
	}
	public static void setPlateforme(Platform plateforme) {
		Platform.plateforme = plateforme;
	}
	public ILauncherPlugin getLauncherPlugin() {
		return launcherPlugin;
	}
	public void setLauncherPlugin(ILauncherPlugin launcher) {
		this.launcherPlugin = launcher;
	}
	public Properties getConfig() {
		return config;
	}
	public void setConfig(Properties config) {
		this.config = config;
	}
	public String getFILECONFIGPATH() {
		return FILECONFIGPATH;
	}

	/**
	 * @return the actionPluginsList
	 */
	public Map<String, IActionPlugin> getActionPluginsList() {
		return this.actionPluginsList;
	}

	/**
	 * @param actionPluginsList the actionPluginsList to set
	 */
	public void setActionPluginsList(
			Map<String, IActionPlugin> actionPluginsList) {
		this.actionPluginsList = actionPluginsList;
	}

	/**
	 * @return the displayPluginsList
	 */
	public Map<String, IDisplayPlugin> getDisplayPluginsList() {
		return this.displayPluginsList;
	}

	/**
	 * @param displayPluginsList the displayPluginsList to set
	 */
	public void setDisplayPluginsList(
			Map<String, IDisplayPlugin> displayPluginsList) {
		this.displayPluginsList = displayPluginsList;
	}	
}
