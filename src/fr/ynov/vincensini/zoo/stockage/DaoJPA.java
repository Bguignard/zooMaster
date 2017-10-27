package fr.ynov.vincensini.zoo.stockage;

import fr.ynov.vincensini.zoo.service.CagePOJO;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class DaoJPA implements Dao<CagePOJO> {
    private EntityManager em;
    public DaoJPA(){
        em = Persistence.createEntityManagerFactory("zoo").createEntityManager();
    }

    @Override
    public List<CagePOJO> lireTous() {
        return  em.createNamedQuery("lireTous", CagePOJO.class).getResultList();
    }

    @Override
    public CagePOJO lire(int cle) {
        return em.find(CagePOJO.class, cle);
    }

    @Override
    public void inserer(CagePOJO elt) {
        em.persist(elt);
    }

    @Override
    public void update(int index, CagePOJO obj) {
        update(obj);
    }

    @Override
    public void update(CagePOJO obj) {
        em.merge(obj);
    }

    @Override
    public void effacer(int cle) {
        CagePOJO tmp = null;
        tmp = em.find(CagePOJO.class, cle);
        em.remove(tmp);
    }
}
