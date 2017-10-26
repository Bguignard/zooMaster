package tests;
import fr.ynov.vincensini.zoo.stockage.DaoJPA;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DaoJpaTest {
    private DaoJPA jpa;
    public DaoJpaTest(){
        jpa = new DaoJPA();
    }
    @Test
    void testLireTous(){
        assertEquals(5,jpa.lireTous().size());
        assertEquals("clarence",jpa.lireTous().get(0).getNom());
    }
}
