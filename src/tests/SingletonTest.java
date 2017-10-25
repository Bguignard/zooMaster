package tests;
import static org.junit.jupiter.api.Assertions.*;
import fr.ynov.guignard.zoo.controller.Singleton;
import org.junit.jupiter.api.Test;


public class SingletonTest {

    @Test
    void testSingletonInstance() {
        assertEquals(Singleton.getInstance(), Singleton.getInstance());
    }
}
