package fr.ynov.vincensini.zoo.modele.technique;

import fr.ynov.vincensini.zoo.modele.metier.Animal;
import fr.ynov.vincensini.zoo.modele.metier.Cage;
import fr.ynov.vincensini.zoo.service.CagePOJO;
import fr.ynov.vincensini.zoo.stockage.Dao;
import fr.ynov.vincensini.zoo.utilitaire.Conversion;

public class CageManagee {
    private Cage cage;
    private int cle;
    private Dao <CagePOJO>dao;
    private CagePOJO cp;

    public CageManagee(){
        cle = -1;
        cage = null;
        cp = null;
        dao = null;
    }
    public CageManagee(int cle, Dao<CagePOJO> d){
        this.cle = cle;
        this.dao = d;
        init();
    }
    private void init(){
        cp = dao.lire(cle);
        cage = Conversion.pojoToCage(cp);
    }
    public CageManagee(CagePOJO p, Dao<CagePOJO> d){
        cp = p;
        cle = p.getIdAnimal();
        dao = d;
        cage = Conversion.pojoToCage(p);
    }
    public void nourrir(){
        if(cage.getOccupant() != null){
            cage.getOccupant().manger();
            cp.setPoids(cage.getOccupant().getPoids());
            dao.update(cle, cp);
        }
        //maj pojo, demander au DAo, update le pojo
    }
    public boolean estPleine(){
        return cage.getOccupant()!=null;
    }

    @Override
    public String toString() {
        return "id:"+cle+""+cage.toString();
    }
    public void ouvrir(){
        cage.ouvrir();
    }
    public Animal getOccupant(){
        return cage.getOccupant();
    }
    public Animal sortir() throws PorteException {
        return cage.sortir();
    }
}
