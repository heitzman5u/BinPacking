package algos;

import java.util.ArrayList;

import elements.Objet;
import elements.Sac;

public class Algo {

	public static final int FractionalPacking = 0;
	
	private int tailleSac;
	private ArrayList<Objet> listeObj;
	
	private int resultat;
	
	public Algo(int algo, ArrayList<Objet> lObj, int tSac){
		tailleSac = tSac;
		listeObj = lObj;
		if (algo == FractionalPacking){
			resultat = fractionalPacking();
		}
	}
	
	
	
	
	private int fractionalPacking(){
		int res = 0;
		if (listeObj.size() != 0){
			int totalTailleObj = 0;
			for (int i = 0 ; i < listeObj.size() ; i ++){
				totalTailleObj += listeObj.get(i).getTaille();
			}
			res = totalTailleObj / tailleSac;
			if (totalTailleObj % tailleSac != 0){
				res +=1;
			}
		}
		return res;
	}




	public int getResultat() {
		return resultat;
	}

	
}
