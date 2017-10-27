package fr.ynov.vincensini.zoo.stockage;

import java.util.List;
import java.util.Vector;

import fr.ynov.vincensini.zoo.service.CagePOJO;
import fr.ynov.vincensini.zoo.service.GazellePOJO;

public class DaoDur implements Dao<CagePOJO> {
	private List<CagePOJO> elts;
	private int ids[] = {1,2,3,4};
	private String noms[]= {"L�o", "Gazz",null,"king Kong"};
	private int x[] = {100,200,134,52};
	private int y[] = {45,66,56,67};
	private int ages[] = {12,3,0,300};
	private double poids[] = {151.4,60,0,3567};
	private String codeAnimals[] = {"Lion","Gazelle",null,"Singe"};
	
	public DaoDur() {
		elts = new Vector<CagePOJO>();
		init();
	}
	private void init() {
		CagePOJO tmp = null;
		GazellePOJO g = null;
		for (int i = 0; i < ages.length; i++) {
			tmp = new CagePOJO();
			tmp.setAge(ages[i]);
			tmp.setCodeAnimal(codeAnimals[i]);
			tmp.setIdAnimal(ids[i]);
			tmp.setNom(noms[i]);
			tmp.setPoids(poids[i]);
			tmp.setX(x[i]);
			tmp.setY(y[i]);
			if((tmp.getCodeAnimal() != null) &&tmp.getCodeAnimal().equals("Gazelle")) {
				g = new GazellePOJO();
				g.setId(1);
				g.setIdAnimal(2);
				g.setLgCornes(14);
				tmp.setGaz(g);
			}
			elts.add(tmp);
		}
	}
	@Override
	public List<CagePOJO> lireTous() {
		return elts;
	}
	@Override
	public CagePOJO lire(int cle) {
		return elts.get(cle);
	}
	@Override
	public void inserer(CagePOJO elt) {
		elts.add(elt);
	}
	@Override
	public void update(int index, CagePOJO obj) {
		elts.set(index, obj);
	}
	@Override
	public void effacer(int cle) {
		elts.remove(cle);
	}

}
