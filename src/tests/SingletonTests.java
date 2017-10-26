package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fr.ynov.vincensini.zoo.controleur.Singleton;

class SingletonTests {

	@Test
	void testGetInstance() {
		Singleton ad = null;
		ad = Singleton.getInstance();
		assertEquals(ad,Singleton.getInstance());
		assertEquals(ad,Singleton.getInstance());
		assertEquals(ad,Singleton.getInstance());
		assertEquals(ad,Singleton.getInstance());
		assertEquals(ad,Singleton.getInstance());
		assertEquals(ad,Singleton.getInstance());
	}

}
