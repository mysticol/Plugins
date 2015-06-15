package plugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import interfaces.IActionPlugin;
import jobs.Carte;
import jobs.Cellule;
import jobs.Guerrier;
import jobs.Hero;
import jobs.Or;
import core.Platform;

/**
 * Plugin Intelligence Artificielle 
 * @author SEB
 *
 */
public class AI implements IActionPlugin {

	Hero hero;
	
	Carte carte;
	
	/**
	 * Chargement du plugin
	 */
	public void chargerPlugin() {
		hero  = Platform.getInstance().getLauncherPlugin().getObjectInstance(Hero.class);
		carte = Platform.getInstance().getLauncherPlugin().getObjectInstance(Carte.class);
		System.out.println("Le plugin AI a �t� charg� !");
	}

	public boolean doAction() {
		int heroX = carte.getActualCell().getCoord().x;
		int heroY = carte.getActualCell().getCoord().y;
		
		Cellule[][] cellules = carte.getCellules();
		
		//Gestion des guerriers ayant d�j� effectu� un d�placement (�vite le bug ou un guerrier est retrait� apr�s s'�tre d�plac� dans le tableau)
		//L'autre solution de faire une Deep copy de l'array est d�conseill�e en java.
		List<Integer> guerriersTraites = new ArrayList<Integer>();
		
		for(int x = 0; x < cellules.length; x++){
			for(int y = 0; y < cellules[x].length; y++){
				
				if(cellules[x][y].getPersonnage() instanceof Guerrier
						&& !guerriersTraites.contains(System.identityHashCode(cellules[x][y].getPersonnage()))){
					//Si la distance avec le personnage est sup�rieure � 1 (le personnage n'est pas d�j� � cot�
					if(Math.abs(heroX - x) > 1 || Math.abs(heroY - y) > 1){
						//Trouver la direction, les valeurs de DirX et DirY ne peuvent �tre que -1, 0 ou 1
						int dirX = (heroX - x) == 0 ? 0 : (heroX - x)/ Math.abs(heroX - x); 
						int dirY = (heroY - y) == 0 ? 0 : (heroY - y)/ Math.abs(heroY - y);
						
						//On deplace le guerrier si il n'y a personne � cet endroit
						if(cellules[x+dirX][y+dirY].getPersonnage()==null){
							cellules[x+dirX][y+dirY].setPersonnage(cellules[x][y].getPersonnage());
							cellules[x][y].setPersonnage(null);
							guerriersTraites.add(System.identityHashCode(cellules[x+dirX][y+dirY].getPersonnage()));
						}
					} else { //Le personnage est � cot�, on tape
						System.out.println("Le hero se fait attaquer par un guerrier !");
						hero.blesser(cellules[x][y].getPersonnage().getAttaque());
						System.out.println("Vie du h�ro : " + hero.getVie());
					}
				}
			}
		}
		return true;
	}
}
