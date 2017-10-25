package fr.ynov.guignard.zoo.model.metier;

import fr.ynov.guignard.zoo.model.technique.VisiteurException;

public class Visiteur implements Mangeable {
	private static int nbVisiteur;

	@Override
	public double getPoids() {
		return 60;
	}

	public static Visiteur addVisiteur(Visiteur visiteur) throws VisiteurException {
		if(nbVisiteur <= 10){
			nbVisiteur++;
			return new Visiteur();
		}
		else {
			throw new VisiteurException();
		}
	}

	public static Visiteur withdrawVisiteur() throws VisiteurException {
		if(nbVisiteur > 0){
			nbVisiteur--;
			return null;
		}
		else{
			throw new VisiteurException();
		}
	}

}
