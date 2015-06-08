package plugin;

import core.Platform;
import interfaces.IPlugin;

public class Lanceur implements IPlugin{
	
	public void chargerPlugin()
	{
		System.out.println("Vous êtes dans le plugin Principal");
		Platform plateforme = Platform.getInstance();
		/*
		 * Appel de la création de la map
		 * Récupération des Producer 
		 */
		
		/*
		 * Appel de la plateforme et affichage des plugin disponibles
		 */
	}
}
