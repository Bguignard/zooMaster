package fr.ynov.vincensini.zoo.vue;

import java.util.List;
import java.util.Vector;

import fr.ynov.vincensini.zoo.controleur.Manager;
import fr.ynov.vincensini.zoo.modele.metier.Animal;
import fr.ynov.vincensini.zoo.modele.metier.Gazelle;
import fr.ynov.vincensini.zoo.modele.metier.Lion;
import fr.ynov.vincensini.zoo.modele.metier.Mangeable;
import fr.ynov.vincensini.zoo.modele.metier.Singe;
import fr.ynov.vincensini.zoo.modele.metier.Visiteur;
import fr.ynov.vincensini.zoo.modele.technique.BeurkException;

public class Zoo {
	public Zoo() {
	}
	public void afficher()
	{
		for (String s : Manager.getInstance().getAnimaux()) {
			System.out.println(s);
		}
	}
	public void nourrir ()
	{
		Manager.getInstance().nourrir();
	}
	public void devorer(int mangeur, int mange) throws BeurkException {

	}
	public static void main(String[] args) {
		Zoo z = null;
		z = new Zoo();
					
		System.out.println("-----------------------------");
		z.afficher();
		System.out.println("-----------------------------");
		z.nourrir();
		z.afficher();
		System.out.println("-----------------------------");
		
		
	}

}
