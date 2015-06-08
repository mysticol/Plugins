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
 * Le lanceur va appeler notre plugin de Product Carte (donc r�cup�ration de l'objet carte)
 * Lorsque l'utilisateur souhaite afficher la Map, appel de la plateforme avec "Afficheur"
 * Lecture des pluginInfo "Afficheur", si plusieurs alors demander � l'utilisateur ...
 * Dans l'appli, on a autant d'interface qu'on a de focntionnalit�s
 * Par exemple, on a IProducerMap qui a la fonctionnalit� getMap
 * Cette interface est impl�ment�e dans le Plugin ProducerMap.
 * Le lanceur va demander les Producer disponibles. Les afficher. 
 * L'utilisateur choisit par la suite lequel.
 * Une fois la Map r�cup�r�e, boucle sur les d�placements et Affichage et Recolte. 
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
	 * Propri�t�s du fichier de config
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
	 * Lecture du fichier de configuration et cr�ation d'une liste de Plugin Info
	 * Retourne la liste de Plugin Info
	 * @param interf
	 * @return
	 */
	public List<PluginInfo> getPluginsInfo(Class<?> interf) {
		List<PluginInfo> listePluginsInfo = new ArrayList<PluginInfo>();
		PluginInfo pluginInfo = null;
		
		for(Object key : config.keySet()) {
			String info = (String)config.get(key);
			String[] infos = info.split(";");
			if(("interfaces." + infos[0]).equals(interf.getName())) {
				pluginInfo = new PluginInfo((String)key, infos[0],infos[1],infos[2]);
				pluginInfo.setNom((String)key);
				pluginInfo.setInterf(infos[0]);			
				pluginInfo.setType(getType(infos[1]));
				pluginInfo.setPath(infos[2]);

				listePluginsInfo.add(pluginInfo);
			}
		}
		
		return listePluginsInfo;
	}
	
	/**
	 * Lecture du fichier de configuration et cr�ation d'une liste de Plugin Info
	 * en fonction d'un type de Plugin
	 * Retourne la liste de Plugin Info
	 * @param interf
	 * @return
	 */
	public List<PluginInfo> getPluginsInfo(TypePlugin type) {
		List<PluginInfo> listePluginsInfo = new ArrayList<PluginInfo>();
		
		PluginInfo pluginInfo = null;
		
		for(Object key : config.keySet()) {
			String info = (String)config.get(key);
			String[] infos = info.split(";");
			if(infos[1].equals(type)) {
				pluginInfo = new PluginInfo((String)key, infos[0],infos[1],infos[2]);
				pluginInfo.setNom((String)key);
				pluginInfo.setInterf(infos[0]);			
				pluginInfo.setType(type);
				pluginInfo.setPath(infos[2]);

				listePluginsInfo.add(pluginInfo);
			}
		}		
		return listePluginsInfo;
	}
	
	/**
	 * R�cup�ration d'une instance d'unne classe en fonction d'un nom de classe
	 * @param className
	 * @return
	 * @throws MalformedURLException 
	 */
	public Object getPlugin(Class<?> className) throws MalformedURLException {
		
		List<PluginInfo> liste = getInstance().getPluginsInfo(className);
			System.out.println("Chargement du Plugin " +liste.get(0).getNom());
			System.out.println(liste.get(0).toString());
			//Instanciation de la classe en fonction de son chemin 
			//pr�sent dans le fichier de configuration
			URL url = new URL(liste.get(0).getPath());
			URL[] urls = { url };			
			try
			{				
				ClassLoader cl = new URLClassLoader(urls);
				Class cls = cl.loadClass("plugin." +liste.get(0).getNom());
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
	
	public static TypePlugin getType(String type)
	{
		TypePlugin result = null;
		switch (type)
		{
			case "AFFICHAGE" :
				result = TypePlugin.AFFICHAGE;
				break;
			case "LANCEUR" :
				result = TypePlugin.LANCEUR;
		}
		return result;
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
