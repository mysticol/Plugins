package plugin;

import interfaces.IPlugin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JPanel;

/**
 * Pas vraiment un plugin pour l'instant mais cela sert d'exemple
 * @author SEB
 *
 */
public class Credits extends JPanel implements IPlugin {

	
	/**
	 * Serial g�n�r� pour serialisation de MapPlugin (Caract du JPanel)
	 */
	private static final long serialVersionUID = 5636031456462170937L;
	
    /**
     * M�thode pour charger le plugin
     */
	public void chargerPlugin() {
		
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
        return new Dimension(200, 200);
    }



    /**
     * Affichage du JPANEL
     */
    @Override
    protected void paintComponent(Graphics g) {
    	//Initialisation
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
      
        Rectangle cell = new Rectangle(0,0,100,100);

        g2d.setColor(Color.BLUE);
        g2d.drawString("Page de cr�dits", 150, 150);
        g2d.fill(cell);
        g2d.dispose();
    }


}