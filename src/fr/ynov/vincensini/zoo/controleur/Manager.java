package fr.ynov.vincensini.zoo.controleur;

import java.util.List;
import java.util.Vector;

import fr.ynov.vincensini.zoo.modele.metier.Mangeable;
import fr.ynov.vincensini.zoo.modele.metier.Visiteur;
import fr.ynov.vincensini.zoo.modele.technique.BeurkException;
import fr.ynov.vincensini.zoo.modele.technique.CageException;
import fr.ynov.vincensini.zoo.modele.technique.CageManagee;
import fr.ynov.vincensini.zoo.modele.technique.PorteException;
import fr.ynov.vincensini.zoo.service.CagePOJO;
import fr.ynov.vincensini.zoo.stockage.DaoFactory;

public final class Manager {
	private static Manager instance = new Manager();
	private Vector<CageManagee> lesCages;
	private Visiteur[] lesVisiteurs;
	
	private Manager()
	{
		lesCages = new Vector<>();
		lesVisiteurs = new Visiteur[10];
		init();
		
	}
	private void init()
	{
		List<CagePOJO> tmp = null;
		tmp = DaoFactory.getInstance().getDao().lireTous();
		for (CagePOJO cp : tmp) {
			lesCages.add(new CageManagee(cp, DaoFactory.getInstance().getDao()));
		}
	}
	public List<String> getAnimaux()
	{
		List<String> ret =null;
		ret = new Vector<>();
		for (CageManagee a : lesCages) {
			ret.add(a.toString());
		}
		return ret;
	}
	public void nourrir ()
	{
		for (CageManagee c : lesCages) {
			if(c.estPleine()) {
				c.nourrir();
			}
		}
	}
	public void devorer(int mangeur, int mange) throws BeurkException, PorteException, CageException {
		Mangeable tmp = null;
		if(lesCages.get(mangeur).estPleine())
		{
				lesCages.get(mange).ouvrir();
				if(lesCages.get(mange).getOccupant() instanceof Mangeable)
				{
					tmp = (Mangeable)lesCages.elementAt(mange).sortir();
					lesCages.elementAt(mangeur).getOccupant().manger(tmp);
					tmp = null;
					System.gc();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
		}
		else
		{
			throw new CageException("La cage N° "+mangeur+" est vide!");
		}
	}	
	
	public static Manager getInstance() {
		return instance;
	}
}
