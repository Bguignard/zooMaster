package fr.ynov.guignard.zoo.model.metier;

import fr.ynov.guignard.zoo.model.technique.BeurkException;

/**
 * 
 * @author vincensini
 * @version 1.0
 * Interface de base du mod�le.
 * C'est le contrat de base
 *
 */
public interface Individu {
	public void manger();
	public String crier();
	public void manger(Mangeable m)  throws BeurkException;
	public void sauter();
	public void courir();
	public void dormir();
}
