package testak;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import master.Abestiak;

public class AbestiakTest {

    @Test
    public void testConstructorAndGetters() {
        Abestiak abestiak = new Abestiak("Izenburua", 3.5, "Kolaboratzaileak", 100);
        assertEquals("Izenburua", abestiak.getIzenburua());
        assertEquals(3.5, abestiak.getIraupena(), 0.01); // Delta es 0.01 para comparación de double
        assertEquals("Kolaboratzaileak", abestiak.getKolaboratzaileak());
        assertEquals(100, abestiak.getErreprodukzioak());
    }

    @Test
    public void testSetters() {
        Abestiak abestiak = new Abestiak("Izenburua", 3.5, "Kolaboratzaileak", 100);
        abestiak.setIzenburua("New Izenburua");
        abestiak.setIraupena(4.2);
        abestiak.setKolaboratzaileak("New Kolaboratzaileak");
        abestiak.setErreprodukzioak(200);
        assertEquals("New Izenburua", abestiak.getIzenburua());
        assertEquals(4.2, abestiak.getIraupena(), 0.01);
        assertEquals("New Kolaboratzaileak", abestiak.getKolaboratzaileak());
        assertEquals(200, abestiak.getErreprodukzioak());
    }
    
    @Test
    public void testToString() {
        Abestiak abestiak = new Abestiak("Izenburua", 3.5, "Kolaboratzaileak", 100);
        String expectedString = "Audio [Izenburua=Izenburua, Iraupena=3.5, Kolaboratzaileak=Kolaboratzaileak, Erreprodukzioak=100]";
        assertEquals(expectedString, abestiak.toString());
    }

    @Test
    public void testEquals() {
        Abestiak abestiak1 = new Abestiak("Izenburua", 3.5, "Kolaboratzaileak", 100);
        Abestiak abestiak2 = new Abestiak("Izenburua", 3.5, "Kolaboratzaileak", 100);
        Abestiak abestiak3 = new Abestiak("Beste Izenburua", 4.2, "Beste Kolaboratzaileak", 200);

        assertEquals(abestiak1, abestiak2);
        assertEquals(abestiak1.hashCode(), abestiak2.hashCode());

        assertEquals(false, abestiak1.equals(abestiak3));
    }
}