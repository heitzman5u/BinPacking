import java.util.ArrayList;

import algos.Algo;

public class Main {

	public Main(){
		
		ArrayList<Integer>listeObj = new ArrayList<Integer>();
		listeObj.add(5);
		listeObj.add(4);
		listeObj.add(2);
		
		// FRACTIONAL PACKING
		System.out.println("FractionalPacking");
		Algo algo = new Algo(Algo.FractionalPacking, listeObj, 8);
		System.out.println(algo.getResultat());
		System.out.println("\n");
		
		// FRACTIONAL PACKING
		System.out.println("FirstFitPacking");
		Algo algo1 = new Algo(Algo.FirstFitPacking, listeObj, 8);
		System.out.println(algo1.getResultat());
		System.out.println("\n");

		// FRACTIONAL PACKING
		System.out.println("BestFitPacking");
		Algo algo2 = new Algo(Algo.BestFitPacking, listeObj, 8);
		System.out.println(algo2.getResultat());
		System.out.println("\n");
		
		//--
	}
	
	
	public static void main(String[] args){
		new Main();
	}
	
}