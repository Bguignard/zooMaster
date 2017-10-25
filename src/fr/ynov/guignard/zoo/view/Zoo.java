package fr.ynov.guignard.zoo.view;

import fr.ynov.guignard.zoo.controller.Manager;
import fr.ynov.guignard.zoo.model.metier.*;
import fr.ynov.guignard.zoo.model.technique.BeurkException;

import java.util.List;
import java.util.Vector;

public class Zoo {

	public Zoo() {

	}

	public void afficher()
	{
	    for (String s : Manager.getInstance().getAnimaux()){
	        System.out.println(s);
        }
	}
	public void nourrir ()
	{
        Manager.getInstance().nourrir();
	}
	public void devorer(int mangeur, int mange) throws BeurkException {
        Manager.getInstance().devorer(mangeur, mange);
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
