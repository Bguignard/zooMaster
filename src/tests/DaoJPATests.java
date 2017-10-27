package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fr.ynov.vincensini.zoo.stockage.DaoJPA;

class DaoJPATests {
private DaoJPA jpa;
	public DaoJPATests ()
{
	jpa = new DaoJPA();
}
	@Test
	void testLireTous() {
		assertEquals(5, jpa.lireTous().size());
		assertEquals( "clarence", jpa.lireTous().get(0).getNom());
	}

	@Test
	void testLire() {
		assertTrue(true);
	}

}
