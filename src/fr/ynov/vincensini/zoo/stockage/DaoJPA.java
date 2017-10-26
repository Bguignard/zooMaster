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
        return  em.createQuery("SELECT cp FROM CagePOJO cp", CagePOJO.class).getResultList();
    }

    @Override
    public CagePOJO lire(int cle) {
        return em.find(CagePOJO.class, cle);
    }

    @Override
    public void inserer(CagePOJO elt) {
        em.getTransaction().begin();
        em.persist(elt);
        em.getTransaction().commit();
    }

    @Override
    public void update(int index, CagePOJO obj) {
        update(obj);
    }

    @Override
    public void update(CagePOJO obj) {
        em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit();
    }

    @Override
    public void effacer(int cle) {
        CagePOJO tmp = null;
        em.getTransaction().begin();
        tmp = em.find(CagePOJO.class, cle);
        em.remove(tmp);
        em.getTransaction().commit();;
    }
}
