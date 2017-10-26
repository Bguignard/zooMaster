package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.ynov.vincensini.zoo.modele.technique.BeurkException;
import fr.ynov.vincensini.zoo.vue.Zoo;

class ZooTests {
private Zoo z;
	@BeforeEach
	void setUp() throws Exception {
		z = new Zoo();
	}

	@Test
	void testDevorer() {
		try {
			z.devorer(0, 0);
			fail("aurait du jeter une BeurkException");
		} catch (BeurkException e) {
			assertEquals("ce n'est pas bon",e.getMessage());
		}
		try {
			z.devorer(0, 1);
			assertTrue(true);
		} catch (BeurkException e) {
			fail("n'aurait pas du jeter d'exception");
		}
		try {
			z.devorer(0, 2);
			fail("aurait du jeter une BeurkException");
		} catch (BeurkException e) {
			assertEquals("ce n'est pas bon",e.getMessage());
		}
	}

}
