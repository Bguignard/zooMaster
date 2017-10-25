package fr.ynov.guignard.zoo.stockage;

import java.util.List;

public interface Dao<T> {
    public List<T> lireTous();
    public T lire(int cle);
    public void inserer(T elt);
    public void update(int index, T obj);
    public void effacer(int cle);
}

