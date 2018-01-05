import java.util.ArrayList;
import java.util.Scanner;

import algos.Algo;

public class Main {

	public Main(){
		
		System.out.println("Combien d'objets voulez vous ranger ?");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		float moy = 0, moy1 = 0, moy2 = 0, moy3 = 0, moy4 = 0;
		
		for (int i = 0 ; i < 20 ; i++) {
			ArrayList<Integer>listeObj = new ArrayList<Integer>();
		
			for (int j = 0 ; j < n ; j++) {
				int obj = (int) (Math.random() * (0.8*n - 0.2*n) + 0.2*n);
				listeObj.add(obj);
			}
		
			Algo algo = new Algo(Algo.FractionalPacking, listeObj, (int) (1.5*n));
			moy += algo.getResultat();
		
			Algo algo1 = new Algo(Algo.FirstFitPacking, listeObj, (int) (1.5*n));
			moy1 += algo1.getResultat();
			
			Algo algo2 = new Algo(Algo.BestFitPacking, listeObj, (int) (1.5*n));
			moy2 += algo2.getResultat();
	
			Algo algo3 = new Algo(Algo.FirstFitDecreasingPacking, listeObj, (int) (1.5*n));
			moy3 += algo3.getResultat();
			
			Algo algo4 = new Algo(Algo.BestFitDecreasingPacking, listeObj, (int) (1.5*n));
			moy4 += algo4.getResultat();
		}
		
		
		// FRACTIONAL PACKING
		System.out.println("FractionalPacking");
		System.out.println("Nombre de sacs moyens sur les 20 test : " + moy/20.);
		System.out.println("\n");
		
		// FIRST FIT PACKING
		System.out.println("FirstFitPacking");
		System.out.println("Nombre de sacs moyens sur les 20 test : " + moy1/20.);
		System.out.println("\n");

		// BEST FIT PACKING
		System.out.println("BestFitPacking");
		System.out.println("Nombre de sacs moyens sur les 20 test : " + moy2/20.);
		System.out.println("\n");
		
		// FIRST FIT DECREASING PACKING
		System.out.println("FirstFitDecreasingPacking");
		System.out.println("Nombre de sacs moyens sur les 20 test : " + moy3/20.);
		System.out.println("\n");

		// BEST FIT DECREASING PACKING
		System.out.println("BestFitDecreasingPacking");
		System.out.println("Nombre de sacs moyens sur les 20 test : " + moy4/20.);
		System.out.println("\n");
		
		//--
	}
	
	
	public static void main(String[] args){
		new Main();
	}
	
}