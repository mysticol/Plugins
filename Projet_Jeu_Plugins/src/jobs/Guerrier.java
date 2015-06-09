package jobs;

public class Guerrier extends Personnage {
	
	// Attributs
		int degats;
		


		// Constucteurs
		public Guerrier(){

		}

		public Guerrier(int vie, int degats){
			super(vie);
			this.degats=degats;
		}


		// Getters and
		public int getDegats() {
			return degats;
		}



		public void setDegats(int degats) {
			this.degats = degats;
		}



		@Override
		public String toString() {
			return "Guerrier [vie=" +getVie()+ ", degats=" + degats + "]";
		}



	}
