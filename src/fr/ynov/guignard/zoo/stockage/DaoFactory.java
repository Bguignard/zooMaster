package fr.ynov.guignard.zoo.stockage;

import fr.ynov.guignard.zoo.service.CagePojo;

public class DaoFactory {
    private static DaoFactory ourInstance = new DaoFactory();

    public static DaoFactory getInstance() {
        return ourInstance;
    }

    private DaoFactory() {
    }
    public Dao<CagePojo> getDao(){
        return new DaoDur();
    }
}
