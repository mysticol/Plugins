package plugin;

import core.Platform;
import interfaces.IPlugin;

public class Lanceur implements IPlugin{
	
	public void chargerPlugin()
	{
		System.out.println("Vous �tes dans le plugin Principal");
		Platform plateforme = Platform.getInstance();
		/*
		 * Appel de la cr�ation de la map
		 * R�cup�ration des Producer 
		 */
		
		/*
		 * Appel de la plateforme et affichage des plugin disponibles
		 */
	}
}
