package jobs;

import java.awt.Point;


/**
 * Personnage
 * @author sheuze
 *
 */
public abstract class Personnage {
	
	/** 
	 * Vie du personnage
	 */	
	private Integer vie;
	/**
	 * Attaque
	 */
	private Integer attaque;
	
	/**
	 * Vie initiale (max)
	 */
	private final int vieMax;
	
	
	/***
	 * Constructeur de personnage
	 * @param vie
	 * @param attaque
	 * @param vieMax
	 */
	public Personnage(Integer vie, Integer attaque, int vieMax) {
		super();
		this.vie = vie;
		this.attaque = attaque;
		this.vieMax = vieMax;
	}

	public void blesser(int degats){
		this.vie = this.vie - degats;
		
		if(this.vie < 0){
			this.vie = 0;
		}
	}

	/**
	 * @return the vie
	 */
	public Integer getVie() {
		return vie;
	}

	/**
	 * @param vie the vie to set
	 */
	public void setVie(Integer vie) {
		this.vie = vie;
	}

	/**
	 * @return the attaque
	 */
	public Integer getAttaque() {
		return attaque;
	}

	/**
	 * @param attaque the attaque to set
	 */
	public void setAttaque(Integer attaque) {
		this.attaque = attaque;
	}

	/**
	 * @return the vieMax
	 */
	public int getVieMax() {
		return vieMax;
	}
	
	
}
