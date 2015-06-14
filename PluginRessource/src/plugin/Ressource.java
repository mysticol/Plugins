package plugin;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import interfaces.IDisplayPlugin;

import javax.swing.JPanel;

import jobs.Carte;
import jobs.Hero;
import core.Platform;

/**
 * Pugin permettant d'afficher les ressources du hero
 * @author Sébastien
 *
 */
public class Ressource extends JPanel implements IDisplayPlugin {
	
	/**
     * Cellule sélectionnée
     */
    private Hero hero;
    
	
	/**
	 * Serial généré pour serialisation de MapPlugin (Caract du JPanel)
	 */
	private static final long serialVersionUID = 5636031456462170937L;

	/**
     * Méthode pour charger le plugin
     */
	public void chargerPlugin() {
		System.out.println("Le plugin Ressource a été chargé !");	
		this.hero = Platform.getInstance().getLauncherPlugin().getObjectInstance(Hero.class);	
	}

	/**
	 * Afficher le plugin
	 */
	public void display() {
		Platform.getInstance().getLauncherPlugin().setAffichage(this);		
	}
	
	/**
     * Taille de la map en pixel
     */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }
	
	protected void paintComponent(Graphics g) {
    	//Initialisation
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
      
        g2d.drawString("Ressource du héros", 50, 30);
        g2d.drawString("Points de vie       : " + this.hero.getVie(), 50, 60);
        g2d.drawString("Stock d'or          : " + this.hero.getStockOr(), 50, 75);
        g2d.drawString("Stock de nourriture : " + this.hero.getStockNourriture(), 50, 90);
        g2d.dispose();
    }

	@Override
	public void recharger() {
		this.repaint();		
	}
	
	public Ressource()
	{
		
	}

}
