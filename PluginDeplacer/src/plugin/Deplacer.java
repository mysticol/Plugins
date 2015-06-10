package plugin;

import java.awt.Point;

import interfaces.IActionPlugin;
import jobs.Carte;
import jobs.Hero;
import core.Platform;

/**
 * Plugin Deplacer
 * @author SEB
 *
 */
public class Deplacer implements IActionPlugin {

	/**
	 * Chargement du plugin
	 */
	public void chargerPlugin() {
		System.out.println("Le plugin Deplacer a �t� charg� !");
	}

	public void doAction() {
		Hero hero  = Platform.getInstance().getLauncherPlugin().getHero();
		Carte carte = Platform.getInstance().getLauncherPlugin().getCarte();

		if(carte.getSelectedCell()!=null){
			if(Math.abs(carte.getSelectedCell().getCoordX()-hero.getCoord().x)<=hero.getDeplacementMax() &&
					Math.abs(carte.getSelectedCell().getCoordY()-hero.getCoord().y)<=hero.getDeplacementMax()){
				// ON set les nouvelles coordonn�es du personnage
				hero.setCoord(new Point(carte.getSelectedCell().getCoordX(),carte.getSelectedCell().getCoordY()));
				System.out.println("Le personnage est maintenant en " + (int) hero.getCoord().x + ":" + hero.getCoord().y);
			} else {
				System.out.println("Le personnage ne peut pas se d�placer aussi loin");
			}
		} else {
			System.out.println("Aucune case s�lectionn�e");
		}
		
	}

	

}
