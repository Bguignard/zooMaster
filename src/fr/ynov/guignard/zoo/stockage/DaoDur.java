package fr.ynov.guignard.zoo.stockage;
import fr.ynov.guignard.zoo.service.CagePojo;
import fr.ynov.guignard.zoo.service.GazellePojo;

import java.util.List;
import java.util.Vector;

public class DaoDur implements Dao<CagePojo> {
    private List<CagePojo> elts;
    private int ids[] = {1,2,3,4};
    private String noms[]= {"Léo", "Gazz", null, "Ging Kong"};
    private int x[] = {100,200,300,400};
    private int y[] = {100,200,300,400};
    private int ages[] = {12,3,0,300};
    private double poids[] = {151.4,60,0,3567};
    private String codeAnimal[] = {"Lion","Gazelle",null,"Singe"};



    public DaoDur(){
        elts = new Vector<CagePojo>();
        init();
    }
    private void init(){
        CagePojo cp = null;
        GazellePojo g = null;
        for (int i = 0; i<ages.length; i++){
            cp = new CagePojo();
            cp.setAge(ages[i]);
            cp.setCodeAnimal(codeAnimal[i]);
            cp.setIdAnimal(ids[i]);
            cp.setNom(noms[i]);
            cp.setPoids(poids[i]);
            cp.setX(x[i]);
            cp.setY(y[i]);
            if(cp.getCodeAnimal().equals("Gazelle")){
                g = new GazellePojo();
                g.setId(1);
                g.setIdAnimal(2);
                g.setLgCornes(14);
                cp.setGaz(g);
            }
            elts.add(cp);
        }
    }

    @Override
    public List<CagePojo> lireTous() {
        return elts;
    }

    @Override
    public CagePojo lire(int cle) {
        return elts.get(cle);
    }

    @Override
    public void inserer(CagePojo elt) {
        elts.add(elt);
    }

    @Override
    public void update(int index, CagePojo obj) {
        elts.set(index, obj);
    }

    @Override
    public void effacer(int cle) {
        elts.remove(cle);
    }
}
