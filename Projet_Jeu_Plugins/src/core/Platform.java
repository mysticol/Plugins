package core;

import java.io.FileReader;
import java.io.IOException;
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
		
		PluginInfo pluginInfo = null;
		
		for(Object key : config.keySet()) {
			String info = (String)config.get(key);
			String[] infos = info.split(";");
			if(("interfaces." + infos[0]).equals(interf.getName())) {
				pluginInfo = new PluginInfo((String)key, infos[0],infos[1],infos[2]);
				pluginInfo.setNom((String)key);
				pluginInfo.setInterf(infos[0]);			
				pluginInfo.setType(TypePlugin.AFFICHAGE);
				pluginInfo.setPath(infos[2]);

				listePluginsInfo.add(pluginInfo);
			}
		}
		
		System.out.println(listePluginsInfo.size());
		
		return listePluginsInfo;
	}
	
	/**
	 * Récupération d'une instance d'unne classe en fonction d'un nom de classe
	 * @param className
	 * @return
	 */
	public Object getPlugin(Class<?> className) {
		
		List<PluginInfo> liste = getPluginsInfo(className);
		Class<?> clazz;
		try {
			clazz = Class.forName((String)liste.get(0).getNom());
			return clazz.newInstance();
		} catch (Exception e) {
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
