package fr.ynov.guignard.zoo.model.metier;

public class Visiteur implements Mangeable {
	private static int nbVisiteur;

	@Override
	public double getPoids() {
		return 60;
	}

	public static Visiteur addVisiteur(Visiteur visiteur){
		if(nbVisiteur <= 10){
			nbVisiteur++;
			return new Visiteur();
		}
		else{
			return null;
		}
	}

	public static Visiteur withdrawVisiteur(){
		if(nbVisiteur > 0){
			nbVisiteur++;
			return new Visiteur();
		}
		else{
			return null;
		}
	}

}
