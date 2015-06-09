package interfaces;

/**
 * Interface des plugins d'affichage
 * @author sheuze
 *
 */
public interface IDisplayPlugin extends IPlugin {
	/**
	 * On retourne un component qui va être affiché
	 * @return le composant à afficher
	 */
	public void display();
}
