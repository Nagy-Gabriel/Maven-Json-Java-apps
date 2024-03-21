package teste;

import exercitiul2.PerecheNumere;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PerecheNumereTest {

    @Test
    public void testSuntConsecutiveInFibonacci() {
        PerecheNumere p1 = new PerecheNumere(1, 2);
        PerecheNumere p2 = new PerecheNumere(3, 5);
        PerecheNumere p3 = new PerecheNumere(5, 8);

        assertTrue(p1.suntConsecutiveInFibonacci());
        assertFalse(p2.suntConsecutiveInFibonacci());
        assertFalse(p3.suntConsecutiveInFibonacci());
    }

    @Test
    public void testCelMicMultipluComun() {
        PerecheNumere p1 = new PerecheNumere(12, 15);
        PerecheNumere p2 = new PerecheNumere(18, 27);
        PerecheNumere p3 = new PerecheNumere(7, 9);

        assertEquals(60, p1.celMicMultipluComun());
        assertEquals(54, p2.celMicMultipluComun());
        assertEquals(63, p3.celMicMultipluComun());
    }

    @Test
    public void testSumaCifrelorEgala() {
        PerecheNumere p1 = new PerecheNumere(123, 321);
        PerecheNumere p2 = new PerecheNumere(456, 654);
        PerecheNumere p3 = new PerecheNumere(789, 987);

        assertTrue(p1.sumaCifrelorEgala());
        assertTrue(p2.sumaCifrelorEgala());
        assertTrue(p3.sumaCifrelorEgala());
    }

    @Test
    public void testNumarCifrePareEgale() {
        PerecheNumere p1 = new PerecheNumere(246, 468);
        PerecheNumere p2 = new PerecheNumere(135, 753);
        PerecheNumere p3 = new PerecheNumere(2468, 4682);

        assertTrue(p1.numarCifrePareEgale());
        assertTrue(p2.numarCifrePareEgale());
        assertTrue(p3.numarCifrePareEgale());
    }
}
