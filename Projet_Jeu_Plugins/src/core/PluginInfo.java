package core;

/**
 * Classe permettant d'obtenir les informations d'un Plugin
 * @author Sebastien
 *
 */


public class PluginInfo {
	
	/**
	 * Nom du plugin
	 */
	private String nom;
	
	/**
	 * Nom de l'interface du plugin
	 */
	private String interf;	
	
	/**
	 * Type du plugin
	 */
	private TypePlugin type;
	
	/**
	 * Path du plugin
	 */
	private String path;

	
	/**
	 * Constructeur PluginInfo
	 * @param nom
	 * @param interf
	 * @param type
	 * @param path
	 */
	public PluginInfo(String nom, String interf, TypePlugin type, String path) {
		super();
		this.nom = nom;
		this.interf = interf;
		this.type = type;
		this.path = path;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the interf
	 */
	public String getInterf() {
		return interf;
	}

	/**
	 * @param interf the interf to set
	 */
	public void setInterf(String interf) {
		this.interf = interf;
	}

	/**
	 * @return the type
	 */
	public TypePlugin getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(TypePlugin type) {
		this.type = type;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
	
	
	
}
