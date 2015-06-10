package core;

import lombok.AllArgsConstructor;
import lombok.Data;
/**
 * Classe permettant d'obtenir les informations d'un Plugin
 * @author Sebastien
 *
 */

@AllArgsConstructor
@Data
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
	

}
