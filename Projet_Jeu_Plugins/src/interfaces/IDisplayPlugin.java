package interfaces;

/**
 * Interface des plugins d'affichage
 * @author sheuze
 *
 */
public interface IDisplayPlugin extends IPlugin {
	/**
	 * On retourne un component qui va �tre affich�
	 * @return le composant � afficher
	 */
	public void display();
}
