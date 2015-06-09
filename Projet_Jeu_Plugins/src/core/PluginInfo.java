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
	
	public String getPath() {
		return path;
	}

	public String getInterf() {
		return interf;
	}

	public void setInterf(String interf) {
		this.interf = interf;
	}

	public void setType(TypePlugin type) {
		this.type = type;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public PluginInfo(String nomPlugin, String interf, String typePlugin, String pathPlugin)
	{
		this.nom = nomPlugin;
		this.interf = interf;
		this.type = TypePlugin.valueOf(typePlugin);
		this.path = pathPlugin;
	}

	public TypePlugin getType()
	{
		return type;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String toString()
	{
		return 
				"Nom du plugin : " + this.getNom()
				+ "\nInterface : " + this.getInterf()
				+ "\nType de plugin : " + this.getType()
				+ "\nChemin du plugin : " + this.getPath();
	}
}
