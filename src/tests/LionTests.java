package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.ynov.vincensini.zoo.modele.metier.Lion;
import fr.ynov.vincensini.zoo.modele.metier.Visiteur;

class LionTests {
private Lion l;
	@BeforeEach
	void setUp() throws Exception {
		l = new Lion("Léo", 12, 143);
	}

	@Test
	void testCrier() {
		assertEquals("Je rugis rhoaaaa",l.crier());
	}

	@Test
	void testMangerMangeable() {
		double poidsAvant = 0;
		poidsAvant = l.getPoids();
		l.manger(new Visiteur());
		assertEquals(poidsAvant+20, l.getPoids());
	}

	@Test
	void testSauter() {
		double poidsAvant = 0;
		poidsAvant = l.getPoids();
		l.sauter();
		assertEquals(poidsAvant-0.7, l.getPoids());
	}

	@Test
	void testManger() {
		double poidsAvant = 0;
		poidsAvant = l.getPoids();
		l.manger();
		assertEquals(poidsAvant+2.1, l.getPoids());
	}

	@Test
	void testDormir() {
		double poidsAvant = 0;
		poidsAvant = l.getPoids();
		l.dormir();
		assertEquals(poidsAvant-1, l.getPoids());
	}

}
