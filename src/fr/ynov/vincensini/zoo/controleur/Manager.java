package fr.ynov.vincensini.zoo.controleur;

import java.util.List;
import java.util.Properties;
import java.util.Vector;

import fr.ynov.vincensini.zoo.modele.metier.Animal;
import fr.ynov.vincensini.zoo.modele.metier.Cage;
import fr.ynov.vincensini.zoo.modele.metier.Gazelle;
import fr.ynov.vincensini.zoo.modele.metier.Lion;
import fr.ynov.vincensini.zoo.modele.metier.Mangeable;
import fr.ynov.vincensini.zoo.modele.metier.Singe;
import fr.ynov.vincensini.zoo.modele.metier.Visiteur;
import fr.ynov.vincensini.zoo.modele.technique.BeurkException;
import fr.ynov.vincensini.zoo.modele.technique.CageException;
import fr.ynov.vincensini.zoo.modele.technique.CageManagee;
import fr.ynov.vincensini.zoo.modele.technique.PorteException;
import fr.ynov.vincensini.zoo.service.CagePOJO;
import fr.ynov.vincensini.zoo.stockage.Dao;
import fr.ynov.vincensini.zoo.stockage.DaoFactory;
import fr.ynov.vincensini.zoo.utilitaire.Conversion;
import stockage.DaoRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public final class Manager {
	private static Manager instance = new Manager();
	private Vector<CageManagee> lesCages;
	private Visiteur[] lesVisiteurs;
	
	private Manager()
	{
		lesCages = new Vector<>();
		lesVisiteurs = new Visiteur[10];
		init();
		initEJB();
		
	}
	private void init()
	{
		List<CagePOJO> tmp = null;
		tmp = DaoFactory.getInstance().getDao().lireTous();
		for (CagePOJO cp : tmp) {
			lesCages.add(new CageManagee(cp, DaoFactory.getInstance().getDao()));
		}
	}
	private void initEJB(){
		List<CagePOJO> tmp = null;
		InitialContext contextWildFLy = null;
		Properties env = null;
		DaoRemote daoLocal = null;

		env.put("jboss.naming.client.ejb.context", true);
		env.put("INITIAL_CONTEXT_FACTORY", "org.jboss.naming.remote.client.InitialContextFactory");
		env.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");

		try {
			contextWildFLy = new InitialContext(env);
			daoLocal = (DaoRemote) contextWildFLy.lookup("//ferme/DaoJPA!fr.ynov.vencensini.ferme.stockage.DaoRemote");

		} catch (NamingException e) {
			e.printStackTrace();
		}

		tmp = DaoFactory.getInstance().getDao().lireTous();

		for(CagePOJO cp:tmp){
			lesCages.add(new CageManagee(cp, daoLocal));
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
			throw new CageException("La cage N "+mangeur+" est vide!");
		}
	}	
	
	public static Manager getInstance() {
		return instance;
	}
}
