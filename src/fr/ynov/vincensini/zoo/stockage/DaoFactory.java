package fr.ynov.vincensini.zoo.stockage;

import fr.ynov.vincensini.zoo.service.CagePOJO;

public class DaoFactory {
	private static DaoFactory instance = new DaoFactory();
	private DaoFactory() {

	}
	public static DaoFactory getInstance() {
		return instance;
	}
	public Dao<CagePOJO> getDao(){
//		return new DaoDur();
		return new DaoJDBCImpl();
	}
}