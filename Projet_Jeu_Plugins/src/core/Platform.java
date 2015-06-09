package core;

import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
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
	 * Lecture du fichier de configuration et création d'une liste de Plugin Info
	 * Retourne la liste de Plugin Info
	 * @param interf
	 * @return
	 */
	public List<PluginInfo> getPluginsInfo(Class<?> interf) {
		List<PluginInfo> listePluginsInfo = new ArrayList<PluginInfo>();
		
		// Pour chaque entrée dans le fichier de config
		for(Object key : config.keySet()) {
			String info = (String)config.get(key);
			String[] infos = info.split(";");
			if(("interfaces." + infos[0]).equals(interf.getName())  && Boolean.valueOf(infos[3])) {
				PluginInfo pluginInfo = new PluginInfo((String)key, infos[0],infos[1],infos[2]);
				listePluginsInfo.add(pluginInfo);
			}
		}
		
		return listePluginsInfo;
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
				PluginInfo pluginInfo = new PluginInfo((String)key, infos[0],infos[1],infos[2]);
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
	public Object getPlugin(PluginInfo pluginInfo) {
		
		
		System.out.println("Chargement du Plugin " + pluginInfo.getNom());
		System.out.println(pluginInfo.toString());
		
		//Instanciation de la classe en fonction de son chemin 
		//présent dans le fichier de configuration
		URL[] urls = null;
		try {
			urls = new URL[]{ new URL(pluginInfo.getPath()) };
		} catch (MalformedURLException e1) {
			System.out.println("Erreur lors du chargement du plugin " +pluginInfo.getNom() + " PATH Incorrect");
			e1.printStackTrace();
		}
			
		try
		{				
			ClassLoader cl = new URLClassLoader(urls);
			Class<?> cls = cl.loadClass("plugin." +pluginInfo.getNom());
			return cls.newInstance();
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	/**
	 * Instanciation de Platform
	 * @return
	 */
	public static Platform getInstance() {
		if(plateforme == null) {
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
	public Properties getConfig() {
		return config;
	}
	public void setConfig(Properties config) {
		this.config = config;
	}
	public String getFILECONFIGPATH() {
		return FILECONFIGPATH;
	}	
}
