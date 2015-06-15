package jobs;

import java.awt.Point;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Personnage
 * @author sheuze
 *
 */
@Data
@RequiredArgsConstructor
public abstract class Personnage {
	
	/** 
	 * Vie du personnage
	 */	
	@NonNull
	private Integer vie;
	/**
	 * Attaque
	 */
	@NonNull
	private Integer attaque;
		
	public void blesser(int degats){
		this.vie = this.vie - degats;
		
		if(this.vie < 0){
			this.vie = 0;
		}
	}
}
