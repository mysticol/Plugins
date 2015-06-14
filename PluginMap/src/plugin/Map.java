package plugin;

import interfaces.IDisplayPlugin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import jobs.Carte;
import jobs.Cellule;
import jobs.Guerrier;
import jobs.Hero;
import jobs.Nourriture;
import jobs.Or;
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
     * Taille d'une cellule en pixel
     */
    private static int CELL_SIZE = 40;
    
    /**
     * Nombre de lignes
     */
    private int rowCount;
    
    /**
     * Nombre de colonnes
     */
    private int columnCount;
    
    /**
     * Cellules
     */
    private Rectangle[][] mapCells;
    
    /**
     * Cellule sélectionnée
     */
    private Point selectedCell;
    
    /**
     * La carte
     */
    private Carte carte;
    

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
    	this.carte = Platform.getInstance().getLauncherPlugin().getObjectInstance(Carte.class);
    	rowCount = carte.getNbLignes();
		columnCount = carte.getNbColonnes();
		
    	mapCells = new Rectangle[rowCount][columnCount];
    	
    	/**
    	 * Gestion de la souris
    	 */
        MouseAdapter mouseHandler;
        mouseHandler = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                //Calcul de la colonne
                int column = e.getX() / CELL_SIZE;
                if(column >= columnCount){
                	column = columnCount-1;
                } else if (column < 0){
                	column = 0;
                }
                
                //Calcul de la ligne
                int row = e.getY() / CELL_SIZE;
                if(row >= rowCount){
                	row = rowCount-1;
                } else if (row < 0){
                	row = 0;
                }
                
                //Cellule sélectionnée
                selectedCell = new Point(column, row);
                
                //On sélectionne la cellule dans la classe métier
                carte.setSelectedCell(carte.getCellule(column, row));
                
                repaint();

            }
        };
        //On ajoute le listener crée
        addMouseListener(mouseHandler);
    }


	
    /**
     * Taille de la map en pixel
     */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(CELL_SIZE * rowCount, CELL_SIZE * columnCount);
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

        int cellWidth = width / columnCount;
        int cellHeight = height / rowCount;

        int xOffset = (width - (columnCount * cellWidth)) / 2;
        int yOffset = (height - (rowCount * cellHeight)) / 2;

        //Si la map n'est pas initialisée, le faire
        if (mapCells[0][0] == null) {
        	System.out.println("Initialisation de la MAP");
            for (int row = 0; row < rowCount; row++) {
                for (int col = 0; col < columnCount; col++) {
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
        
        for (Rectangle[] colCells : mapCells) {
        	for (Rectangle cell : colCells) {
        		int column = cell.x / CELL_SIZE;
        		int row = cell.y / CELL_SIZE;
        		Cellule gameCell = carte.getCellule(column, row);
        		
        		g2d.setColor(Color.GRAY);
            	g2d.draw(cell);
            	
            	/**
        		 * Si il y a une ressource
        		 */
        		if(gameCell.getRessource()!=null){
        			URL imagerURL = null;
        			if(gameCell.getRessource() instanceof Or){
        				imagerURL = getClass().getResource("/bourse.png");
        			} else if(gameCell.getRessource() instanceof Nourriture){
        				imagerURL = getClass().getResource("/food.png");
        			}
        			
        			Image img = null;
					try {
						
						img = ImageIO.read(imagerURL);
					} catch (IOException e) {
						System.out.println("Erreur lors du chargement de l'image de la ressource");
						e.printStackTrace();
					}
        			g2d.drawImage(img, (int)cell.getX() , (int)cell.getY(), (int)cell.getWidth(), (int)cell.getHeight(), null);
        			
        		} 
        		
        		/**
        		 * Si il y a un personnage
        		 */
        		if(gameCell.getPersonnage()!=null){
        			URL imagerURL = null;
        			if(gameCell.getPersonnage() instanceof Hero){
        				imagerURL = getClass().getResource("/perso.png");
        			} else if(gameCell.getPersonnage() instanceof Guerrier){
        				imagerURL = getClass().getResource("/guerrier.png");
        			}
        			
        			Image img = null;
					try {
						
						img = ImageIO.read(imagerURL);
					} catch (IOException e) {
						System.out.println("Erreur lors du chargement de l'image du Hero");
						e.printStackTrace();
					}
        			g2d.drawImage(img, (int)cell.getX() , (int)cell.getY(), (int)cell.getWidth(), (int)cell.getHeight(), null);
        			
        		} 
        		
        		
            	/*if(gameCell.getRessource() instanceof Guerrier){
        				imagerURL = getClass().getResource("/guerrier.png");
        			}*/
        		
        	}
        }

        
        g2d.dispose();
    }
    
    @Override
    public void recharger(){
    	this.repaint();
    }

}
