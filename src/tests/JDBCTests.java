package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import fr.ynov.vincensini.zoo.service.CagePOJO;
import fr.ynov.vincensini.zoo.stockage.DaoJDBCImpl;

class JDBCTests {
	private DaoJDBCImpl dao;
	public JDBCTests() {
		dao = new DaoJDBCImpl();
	}

	@Test
	void testLireTous() {
		List<CagePOJO> res = null;
		res = dao.lireTous();
		assertEquals(5,res.size());
		assertEquals("clarence", res.get(0).getNom());
	}

	@Test
	void testLire() {
		CagePOJO res = dao.lire(1);
		assertEquals("clarence", res.getNom());
	}

	@Test
	void testInsererUpdateEffacer() {
		int cleInseree = -1;
		List<CagePOJO> res = null;
		CagePOJO tmp = new CagePOJO();
		tmp.setCodeAnimal(null);
		tmp.setX(123);
		tmp.setY(321);
		res = dao.lireTous();
		assertEquals(5,res.size());
//INSERER
		dao.inserer(tmp);
		res = dao.lireTous();
		assertEquals(6,res.size());
		assertEquals(123, res.get(5).getX());
		assertEquals(321, res.get(5).getY());
		cleInseree = res.get(5).getIdAnimal();
		tmp = dao.lire(cleInseree);
// UPDATE
		tmp.setX(999);
		dao.update(cleInseree,tmp);
		res = dao.lireTous();
		assertEquals(6,res.size());
		assertEquals(999, res.get(5).getX());
		assertEquals(321, res.get(5).getY());
//EFFACER
		dao.effacer(cleInseree);
		res = dao.lireTous();
		assertEquals(5,res.size());
	}
}
