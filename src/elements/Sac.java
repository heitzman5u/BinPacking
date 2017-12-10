package elements;

import java.util.ArrayList;

public class Sac {
	private int capaciteMax;
	private int tailleOccupee;
	private ArrayList<Integer> listeObj;
	
	public Sac(int c){
		capaciteMax = c;
		tailleOccupee = 0;
		listeObj = new ArrayList<Integer>();
		
	}

	public int getCapaciteMax() {
		return capaciteMax;
	}

	public void setCapaciteMax(int capacite) {
		this.capaciteMax = capacite;
	}
	
	public void ajouterObj(int obj){
		listeObj.add(obj);
		tailleOccupee += obj; 
	}

	public int getTailleOccupee() {
		return tailleOccupee;
	}
	
	
}
