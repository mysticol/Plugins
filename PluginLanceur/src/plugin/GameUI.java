package plugin;

import interfaces.IActionPlugin;
import interfaces.IDisplayPlugin;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;

import core.Platform;
import core.PluginInfo;
import core.TypePlugin;

/**
 * Classe de chargement initial de l'interface graphique du jeu
 */
public class GameUI {

	
	/**
	 * Interface principale (Lanceur)
	 */
	private JFrame frame;
	
	/**
	 * Affichage actuel
	 */
	private Component affichage;
	
	/**
	 * Panel pour les plugins affichage
	 */
	private JPanel displayButtons;
	
	/**
	 * Panel pour les plugins actions
	 */
	private JPanel actionButtons;
	
	/**
	 * Constructeur 
	 */
    public GameUI() {
    	// On charge le SlashScreen
    	this.loadSpashScreen();
    	
    	//On charge le lanceur
    	this.loadLanceurPlugin();
    	
    	//On affiche les plugins affichage
    	this.loadAffichagePlugins();
    	
    	//On affiche les plugins actions
    	this.loadActionPlugins();
    	
    	// on demande d'attribuer une taille minimale à la fenêtre
        //  (juste assez pour voir tous les composants)
    	frame.pack();
    	
    	// on centre la fenêtre
        frame.setLocationRelativeTo(null);
        
        // on rend la fenêtre visible
        frame.setVisible(true);
        
    }

	/**
	 * Charger le Splash Screen
	 * Inutile mais tellement classe :D
	 */
	private void loadSpashScreen() {
		//Création de la fenêtre
    	JWindow window = new JWindow();
    	
    	try {
			window.getContentPane().add(
			    new JLabel("", new ImageIcon(new URL("https://media.licdn.com/mpr/mpr/shrinknp_400_400/p/3/000/0e4/133/0bfe0e9.jpg")), SwingConstants.CENTER));
		} catch (MalformedURLException e1) {
			System.out.println("URL du splashscreen invalide");
			e1.printStackTrace();
		}
    	
    	//Chargement au milieu de l'écran
    	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    	window.setSize(300, 200);
    	int x = (int) ((d.getWidth() - window.getWidth())/ 2);
    	int y = (int) ((d.getHeight() - window.getHeight())/ 2);
    	window.setLocation(x, y);
    	window.setVisible(true);
    	
    	//On attend 2 secondes pour la fermeture du splashscreen
    	try {
    	    Thread.sleep(100);
    	} catch (InterruptedException e) {
    	    e.printStackTrace();
    	}
    	
    	//On ferme le slashScreen
    	window.setVisible(false);
    	window.dispose();		
	}
	
	
	/**
	 * Charger le lanceur principal
	 */
	private void loadLanceurPlugin() {
    	//On change le style de l'interface graphique pour éviter le style moche JAVA
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
        }

        //Création de la fenêtre principale
        frame = new JFrame("Age of Mottu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout()); 
	}
	
	/**
	 * On affiche tel ou tel plugin Affichage
	 * @param comp
	 */
	public void setAffichageFrame(Component comp){
		if(affichage != null){
			frame.remove(affichage);
		}
		frame.add(comp);
		this.affichage = comp;
		frame.pack();
	}
	
	
    /**
     * Charger les plugins actions
     */
    private void loadActionPlugins() {
    	//On initialise le panel 
    	Border paneEdge = BorderFactory.createEmptyBorder(10,10,10,10);
        actionButtons = new JPanel();
        actionButtons.setBorder(paneEdge);
        actionButtons.setSize(10, 10);
        actionButtons.setLayout(new BoxLayout(actionButtons, BoxLayout.X_AXIS));
        
        //On crée un bouton par plugin action
      	List<PluginInfo> pluginInfo = Platform.getInstance().getPluginsInfo(IActionPlugin.class, TypePlugin.ACTION);
        for(PluginInfo plugin : pluginInfo){
        	JButton button = new JButton(plugin.getNom());
        	button.addActionListener(new ActionActionListener(plugin));
        	actionButtons.add(button);
        }
        
        //On ajoute à la Frame principale
        frame.add(actionButtons, BorderLayout.SOUTH);		
	}

    /**
     * Charger les plugins affichage
     */
	private void loadAffichagePlugins() {
		//On initialise le panel
        Border paneEdge = BorderFactory.createEmptyBorder(10,10,10,10);
        displayButtons = new JPanel();
        displayButtons.setBorder(paneEdge);
        displayButtons.setSize(10, 10);
        displayButtons.setLayout(new BoxLayout(displayButtons, BoxLayout.Y_AXIS));
        
        //On crée un bouton par plugin affichage
      	List<PluginInfo> pluginInfo = Platform.getInstance().getPluginsInfo(IDisplayPlugin.class, TypePlugin.AFFICHAGE);
        for(PluginInfo plugin : pluginInfo){
        	JButton button = new JButton(plugin.getNom());
        	button.addActionListener(new AffichageActionListener(plugin));
        	displayButtons.add(button);
        }
        
        //On ajoute à la Frame principale
        frame.add(displayButtons, BorderLayout.EAST);		
	}
	
	
	private class AffichageActionListener implements ActionListener {

		PluginInfo plugin;

        public AffichageActionListener(PluginInfo plugin) {
            this.plugin = plugin;
        }

        public void actionPerformed(ActionEvent e) {
            System.out.println("Affichage du plugin "+plugin.getNom());
            
            IDisplayPlugin pluginPrincipal = (IDisplayPlugin) Platform.getInstance().getPlugin(plugin);
            pluginPrincipal.display();
        }
    }
	
	private class ActionActionListener implements ActionListener {

		PluginInfo plugin;

        public ActionActionListener(PluginInfo plugin) {
            this.plugin = plugin;
        }

        public void actionPerformed(ActionEvent e) {
            System.out.println("Action du plugin "+plugin.getNom());
            
            IActionPlugin pluginPrincipal = (IActionPlugin) Platform.getInstance().getPlugin(plugin);
            pluginPrincipal.doAction();
            
            /*
             * On raffraichit chaque plugin affichage 
             */
            List<PluginInfo> pluginInfo = Platform.getInstance().getPluginsInfo(IDisplayPlugin.class, TypePlugin.AFFICHAGE);
            for(PluginInfo plugin : pluginInfo){
            	IDisplayPlugin pluginDisplay = (IDisplayPlugin) Platform.getInstance().getPlugin(plugin);
            	pluginDisplay.recharger();
            }
            
        }
    }	

    
}