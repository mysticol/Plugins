package core;

/**
 * Classe permettant d'obtenir les informations d'un Plugin
 * @author Sebastien
 *
 */
public class PluginInfo {
	
	private String nom;
	private String interf;	
	private TypePlugin type;
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
		switch(typePlugin)
		{
			case "LANCEUR" :
				this.type = TypePlugin.LANCEUR;
				break;
			case "AFFICHEUR":
				this.type = TypePlugin.AFFICHAGE;
				break;
			case "DEPLACEMENT":
				this.type = TypePlugin.DEPLACEMENT;
				break;
			case "RECOLTE":
				this.type = TypePlugin.RECOLTE;
				break;
			default :
				this.type = TypePlugin.AUTRE;
				break;
		}
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
