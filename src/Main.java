import java.util.ArrayList;

import algos.Algo;
import elements.Objet;

public class Main {

	public Main(){
		Objet obj1 = new Objet(4);
		Objet obj2 = new Objet(3);
		
		ArrayList<Objet>listeObj = new ArrayList<Objet>();
		listeObj.add(obj1);
		listeObj.add(obj2);
		
		
		// FRACTIONAL PACKING
		Algo algo = new Algo(Algo.FractionalPacking, listeObj, 8);
		System.out.println(algo.getResultat());
		
		//--
	}
	
	
	public static void main(String[] args){
		new Main();
	}
	
}