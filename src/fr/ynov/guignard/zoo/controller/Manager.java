package fr.ynov.guignard.zoo.controller;

import fr.ynov.guignard.zoo.model.metier.*;
import fr.ynov.guignard.zoo.model.technique.BeurkException;
import fr.ynov.guignard.zoo.model.technique.OccupantException;
import fr.ynov.guignard.zoo.service.CagePojo;
import fr.ynov.guignard.zoo.stockage.DaoFactory;

import java.util.List;
import java.util.Vector;

public final class Manager {
    private static Manager ourInstance = new Manager();
    private Vector<Cage> lesCages;
    private Visiteur[] lesVisiteurs;


    private Manager() {
        lesCages = new Vector<>();
        lesVisiteurs = new Visiteur[10];
        init();
    }
    public static Manager getInstance() {
        return ourInstance;
    }
    private void init()
    {
        List<CagePojo> tmp = null;
        tmp = DaoFactory.getInstance().getDao().lireTous();

    }
    public List<String> getAnimaux()
    {
        List<String> ret = null;
        ret = new Vector<>();
        for (Cage a: this.lesCages
             ) {
            ret.add(a.toString());
        }
        return ret;
    }
    public void nourrir ()
    {
        for (Cage a : lesCages) {
            try {
                a.donnerAManger();
            } catch (OccupantException e) {
                e.printStackTrace();
            }
        }
    }
    public void devorer(int cageDuMangeur, int mange) throws BeurkException {
        if (!(lesCages.get(mange) instanceof Mangeable)) {
            throw new BeurkException();
        }
        try {
            lesCages.get(cageDuMangeur).donnerAManger(((Mangeable) lesCages.get(mange)));
        } catch (OccupantException e) {
            e.printStackTrace();
        }
        lesCages.remove(mange);
        System.gc();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
