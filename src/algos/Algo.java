package algos;

import java.util.ArrayList;

import elements.Sac;

public class Algo {

	public static final int FractionalPacking = 0;
	public static final int FirstFitPacking = 1;
	public static final int BestFitPacking = 2;
	
	private int tailleSac;
	private ArrayList<Integer> listeObj;
	
	private int resultat;
	
	public Algo(int algo, ArrayList<Integer> lObj, int tSac){
		tailleSac = tSac;
		listeObj = lObj;
		if (algo == FractionalPacking){
			resultat = fractionalPacking();
		}
		if (algo == FirstFitPacking){
			resultat = firstFitPacking();
		}
		if (algo == BestFitPacking){
			resultat = bestFitPacking();
		}
	}
	
	
	
	
	private int fractionalPacking(){
		int res = 0;
		if (listeObj.size() != 0){
			int totalTailleObj = 0;
			for (int i = 0 ; i < listeObj.size() ; i ++){
				totalTailleObj += listeObj.get(i);
			}
			res = totalTailleObj / tailleSac;
			if (totalTailleObj % tailleSac != 0){
				res +=1;
			}
		}
		return res;
	}


	private int firstFitPacking(){
		ArrayList<Sac> listeSacs = new ArrayList<Sac>();
		
		for(int cptObj = 0 ; cptObj < listeObj.size() ; cptObj ++){
			if (listeObj.get(cptObj) <= tailleSac){
				
				// Si on a des objets dans notre liste et que nous n'avons pas encore de sac, on en créé un.
				if(listeSacs.size() == 0){
					Sac sac = new Sac(tailleSac);
					listeSacs.add(sac);
				}

				// on recherche le 1er sac deja existant ayant une capa assez grande pour accueillir l'objet.
				boolean sacTrouve = false;

				for (int i = 0 ; i < listeSacs.size() ; i++){
					int capaDispoSac = listeSacs.get(i).getCapaciteMax() - listeSacs.get(i).getTailleOccupee();
				
					if (sacTrouve == false && capaDispoSac >= listeObj.get(cptObj)){
						listeSacs.get(i).ajouterObj(listeObj.get(cptObj));
						sacTrouve = true;
					}
				}
				
				// si l'obj ne rentre dans aucun sac existant, on créer un nouveau sac et on le met dedans.
				if (sacTrouve == false){
					Sac sac = new Sac(tailleSac);
					sac.ajouterObj(listeObj.get(cptObj));
					listeSacs.add(sac);
				}
			} else {
				System.out.println("l'Objet est de taille superieure a la capacite max d'un sac (>"+tailleSac+")");
				return -1;
			}
		}	
		
		for (int i = 0 ; i < listeSacs.size() ; i++){
			System.out.println("sac " + i + " : "+ listeSacs.get(i).getTailleOccupee());
		}	
		
		return listeSacs.size();	
	}

	
	
	
	
	
	
	private int bestFitPacking(){
		ArrayList<Sac> listeSacs = new ArrayList<Sac>();
		
		for(int cptObj = 0 ; cptObj < listeObj.size() ; cptObj ++){
			if (listeObj.get(cptObj) <= tailleSac){
				
				// Si on a des objets dans notre liste et que nous n'avons pas encore de sac, on en créé un.
				if(listeSacs.size() == 0){
					Sac sac = new Sac(tailleSac);
					listeSacs.add(sac);
				}
				
				// on recherche le 1er sac existant dont la capacité, apres l'ajout du sac, sera la plus grande.
				boolean sacTrouve = false;
				int maxCapaDispoSac = -1;
				Sac sacMaxCapa = null;
				
				for (int i = 0 ; i < listeSacs.size() ; i++){
					int capaDispoSac = listeSacs.get(i).getCapaciteMax() - listeSacs.get(i).getTailleOccupee();
					
					if (capaDispoSac >= listeObj.get(cptObj)){ //si l'obj rentre dans le sac alors ...
						if(capaDispoSac - listeObj.get(cptObj) > maxCapaDispoSac ){ // je regarde si la capacité apres ajout est la plus gande parmis tous les sacs
							
							maxCapaDispoSac = capaDispoSac - listeObj.get(cptObj);
							sacMaxCapa = listeSacs.get(i); 
							
						}
					}
				}
				// si on a trouve un capable d'accueillir l'objet, on l'ajoute
				if (maxCapaDispoSac != -1){
					sacMaxCapa.ajouterObj(listeObj.get(cptObj));
					sacTrouve = true;
				}
				
				// si l'obj ne rentre dans aucun sac existant, on créer un nouveau sac et on le met dedans.
				if (sacTrouve == false){
					Sac sac = new Sac(tailleSac);
					sac.ajouterObj(listeObj.get(cptObj));
					listeSacs.add(sac);
				}
				
			} else {
				System.out.println("l'Objet est de taille superieure a la capacite max d'un sac (>"+tailleSac+")");
				return -1;
			}
		}
		
		for (int i = 0 ; i < listeSacs.size() ; i++){
			System.out.println("sac " + i + " : "+ listeSacs.get(i).getTailleOccupee());
		}	
		
		return listeSacs.size();
	}
	

	public int getResultat() {
		return resultat;
	}

	
}
