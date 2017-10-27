package fr.ynov.vincensini.zoo.modele.technique;

import fr.ynov.vincensini.zoo.modele.metier.Animal;
import fr.ynov.vincensini.zoo.modele.metier.Cage;
import fr.ynov.vincensini.zoo.modele.metier.Mangeable;
import fr.ynov.vincensini.zoo.service.CagePOJO;
import fr.ynov.vincensini.zoo.stockage.Dao;
import fr.ynov.vincensini.zoo.utilitaire.Conversion;

public class CageManagee {
	private Cage cage;
	private CagePOJO cp;
	private Dao<CagePOJO> dao;
	private int cle;
	public CageManagee() {
		cle = -1;
		cage= null;
		cp = null;
		dao = null;
	}

	public CageManagee(int clef, Dao<CagePOJO> d)
	{
		cle = clef;
		dao = d;
		init();
	}
	public CageManagee(CagePOJO p,  Dao<CagePOJO> d)
	{
		cle = p.getIdAnimal();
		cp = p;
		dao = d;
		cage = Conversion.pojoToCage(p);
	}
	
	private void init()
	{
		cp = dao.lire(cle);
		cage = Conversion.pojoToCage(cp);
	}
	public void nourrir()
	{
		if(cage.getOccupant() != null)
		{
			cage.getOccupant().manger();
			cp.setPoids(cage.getOccupant().getPoids());
			dao.update(cle, cp);
		}
	}

	@Override
	public String toString() {
		return String.join(" ", "id:",(""+cle),cage.toString());
	}

	public boolean estPleine() {
		return cage.getOccupant() != null;
	}

	public void ouvrir() {
		 cage.ouvrir();
	}

	public Animal getOccupant() {
	
		return cage.getOccupant();
	}

	public Animal sortir() throws PorteException {
		return cage.sortir();
	}

}
