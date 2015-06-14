package interfaces;


/**
 * Interface des plugins de lancement
 * @author sheuze
 *
 */
public interface ILauncherPlugin extends IPlugin {
	/**
	 * On lance le plugin (principal)
	 */
	public void launch();
	
	/**
	 * On set le plugin d'affichage
	 */
	public void setAffichage(IDisplayPlugin pluginPrincipal);
	
	/**
	 * Récupérer un objet du lanceur
	 */
	public <T> T getObjectInstance(Class<T> clazz);
	
}
