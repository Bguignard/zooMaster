package stockage;

import fr.ynov.vincensini.zoo.service.CagePOJO;
import fr.ynov.vincensini.zoo.stockage.Dao;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface DaoRemote extends Dao<CagePOJO> {

    public List<CagePOJO> lireTous();
    public CagePOJO lire(int cle);
    public void inserer(CagePOJO elt);
    public void update(int index, CagePOJO obj);
    public default void  update(CagePOJO Obj){}
    public void effacer(int cle);

}
