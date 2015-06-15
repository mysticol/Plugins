package plugin;

import interfaces.IDisplayPlugin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JPanel;

import jobs.Carte;
import core.Platform;

/**
 * Pas vraiment un plugin pour l'instant mais cela sert d'exemple
 * @author SEB
 *
 */
public class Credits extends JPanel implements IDisplayPlugin {

	
	/**
	 * Serial généré pour serialisation de MapPlugin (Caract du JPanel)
	 */
	private static final long serialVersionUID = 5636031456462170937L;
	
    /**
     * Méthode pour charger le plugin
     */
	public void chargerPlugin() {
		Platform.getInstance().getLauncherPlugin().getObjectInstance(Lanceur.class);
		System.out.println("Le plugin Credits a été chargé !");
	}
	
	/**
	 * Afficher le plugin
	 */
	public void display() {
		Platform.getInstance().getLauncherPlugin().setAffichage(this);
	}
	
    /**
     * Constructeur du plugin
     */
    public Credits() {
    	
    }

    /**
     * Taille de la map en pixel
     */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }



    /**
     * Affichage du JPANEL
     */
    @Override
    protected void paintComponent(Graphics g) {
    	//Initialisation
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setColor(Color.BLUE);
        g2d.drawString("Développeurs", 150, 140);
        g2d.setColor(Color.BLACK);
        g2d.drawString("DUBOIS Sébastien", 150, 175);
        g2d.drawString("HEUZE Sébastien", 150, 190);
        g2d.drawString("ROLLAND Baptiste", 150, 205);
        g2d.drawString("NASSIRI Khalid", 150, 220);
        g2d.dispose();
    }

    @Override
    public void recharger(){
    	this.repaint();
    }



}
