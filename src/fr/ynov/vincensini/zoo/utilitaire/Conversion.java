package fr.ynov.vincensini.zoo.utilitaire;

import fr.ynov.vincensini.zoo.modele.metier.Animal;
import fr.ynov.vincensini.zoo.modele.metier.Cage;
import fr.ynov.vincensini.zoo.modele.metier.Gazelle;
import fr.ynov.vincensini.zoo.modele.technique.CageException;
import fr.ynov.vincensini.zoo.modele.technique.PorteException;
import fr.ynov.vincensini.zoo.service.CagePOJO;

public class Conversion {
	public final static String CHEMIN = "fr.ynov.vincensini.zoo.modele.metier.";
	public static Cage pojoToCage(CagePOJO pojo) {
		Cage ret = null;
		Class<?> laClasse = null;
		Animal tmp = null;
		
		ret = new Cage(pojo.getX(),pojo.getY());
		try {
			if(pojo.getCodeAnimal() != null)
			{
				laClasse = Class.forName(CHEMIN+pojo.getCodeAnimal());
				tmp = (Animal) laClasse.newInstance();
				tmp.setNom(pojo.getNom());
				tmp.setAge(pojo.getAge());
				tmp.setPoids(pojo.getPoids());
				if(pojo.getCodeAnimal().equals("Gazelle"))
				{
					((Gazelle)tmp).setLgCornes(pojo.getGaz().getLgCornes());
				}
				ret.ouvrir();
				ret.entrer(tmp);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PorteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
}
