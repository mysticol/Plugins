package plugin;

import interfaces.IDisplayPlugin;
import interfaces.IPlugin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import core.Platform;

/**
 * Pas vraiment un plugin pour l'instant mais cela sert d'exemple
 * @author SEB
 *
 */
public class Map extends JPanel implements IDisplayPlugin {

	
	/**
	 * Serial généré pour serialisation de MapPlugin (Caract du JPanel)
	 */
	private static final long serialVersionUID = 5636031456462170936L;
	
	/**
	 * Nombre de colonne
	 */
	private static int COLUMN_COUNT = 10;
	
	/**
	 * Nombre de lignes
	 */
    private static int ROW_COUNT = 10;
    
    /**
     * Taille d'une cellule en pixel
     */
    private static int CELL_SIZE = 40;
    
    /**
     * Cellules
     */
    private Rectangle[][] mapCells;
    
    /**
     * Cellule sélectionnée
     */
    private Point selectedCell;

    /**
     * Méthode pour charger le plugin
     */
	public void chargerPlugin() {
		System.out.println("Le plugin Map a été chargé !");
	}
	
	/**
	 * Affichage
	 */
	public void display() {
		Platform.getInstance().getLauncherPlugin().setAffichage(this);
	}
	
    /**
     * Constructeur du plugin
     */
    public Map() {
    	mapCells = new Rectangle[ROW_COUNT][COLUMN_COUNT];
    	
    	/**
    	 * Gestion de la souris
    	 */
        MouseAdapter mouseHandler;
        mouseHandler = new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {

                int width = getWidth();
                int height = getHeight();

                int cellWidth = width / COLUMN_COUNT;
                int cellHeight = height / ROW_COUNT;

                //Calcul de la colonne
                int column = e.getX() / cellWidth;
                if(column >= COLUMN_COUNT){
                	column = COLUMN_COUNT-1;
                } else if (column < 0){
                	column = 0;
                }
                
                //Calcul de la ligne
                int row = e.getY() / cellHeight;
                if(row >= ROW_COUNT){
                	row = ROW_COUNT-1;
                } else if (row < 0){
                	row = 0;
                }
                
                //Cellule sélectionnée
                selectedCell = new Point(column, row);
                repaint();

            }
        };
        //On ajoute le listener crée
        addMouseMotionListener(mouseHandler);
    }


	
    /**
     * Taille de la map en pixel
     */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(CELL_SIZE * ROW_COUNT, CELL_SIZE * COLUMN_COUNT);
    }



    /**
     * Affichage du JPANEL
     */
    @Override
    protected void paintComponent(Graphics g) {
    	//Initialisation
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        int width = getWidth();
        int height = getHeight();

        int cellWidth = width / COLUMN_COUNT;
        int cellHeight = height / ROW_COUNT;

        int xOffset = (width - (COLUMN_COUNT * cellWidth)) / 2;
        int yOffset = (height - (ROW_COUNT * cellHeight)) / 2;

        //Si la map n'est pas initialisée, le faire
        if (mapCells[0][0] == null) {
        	System.out.println("Initialisation de la MAP");
            for (int row = 0; row < ROW_COUNT; row++) {
                for (int col = 0; col < COLUMN_COUNT; col++) {
                    Rectangle cell = new Rectangle(
                            xOffset + (col * cellWidth),
                            yOffset + (row * cellHeight),
                            cellWidth,
                            cellHeight);
                    mapCells[col][row] = cell;
                }
            }
        }

        //Si une cellule est sélectionnée, la peindre en gris
        if (selectedCell != null) {
            Rectangle cell = mapCells[selectedCell.x][selectedCell.y];
            g2d.setColor(Color.LIGHT_GRAY);
            g2d.fill(cell);

        }

        //Dessiner l'interface graphique (Background + cellules)
        g2d.setColor(Color.GRAY);
        for (Rectangle[] colCells : mapCells) {
        	for (Rectangle cell : colCells) {
        		g2d.draw(cell);
        	}
        }

        
        g2d.dispose();
    }

}
