package testak;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Bezeroak.Free;
import Bezeroak.Bezeroa.Hizkuntza;


public class FreeTest {

    Free fr1, fr2, fr3;
    Date eguna = new Date(2024, 04, 18);

    @Before
    public void setUp() throws Exception {
    	//Datuak sortu
    	String izena = "alaitz";
    	String abizena = "garcia";
    	String erabiltzailea = "algarcia";
    	String pasahitza = "haia";
    	Hizkuntza hizkuntza = Hizkuntza.EU;
    	ArrayList<String> playListZerrenda = new ArrayList<>();
        playListZerrenda.add("Viva la Vida");
        
        fr1 = new Free(izena, abizena, eguna, erabiltzailea, pasahitza, hizkuntza, playListZerrenda);
        
    }
    
    @Test
    public void testGetIzena() {
        assertEquals("alaitz", fr1.getIzena());
    }
    
    @Test
    public void testSetIzena() {
    	fr1.setIzena("alaitz");
        assertEquals("alaitz", fr1.getIzena());
    }
    
    @Test
    public void testGetAbizena() {
    	assertEquals("garcia", fr1.getAbizena());
    }
    
    @Test
    public void testSetAbizena() {
    	fr1.setAbizena("garcia");
        assertEquals("garcia", fr1.getAbizena());
    }
    
    @Test
    public void testGetJdata() {
        Date eguna = new Date(2024, 04, 18);
        assertEquals(eguna, fr1.getJdata());
    }
    
    @Test
    public void testSetJdata() {
        Date eguna1 = new Date(2024, 05, 20);
        fr1.setJdata(eguna1);
        assertEquals(eguna1, fr1.getJdata());
    }
    
    @Test
    public void testGetPasahitza() {
        assertEquals("haia", fr1.getPasahitza());
    }
    
    @Test
    public void testSetPasahitza() {
        fr1.setPasahitza("haia");
        assertEquals("haia", fr1.getPasahitza());
    }
    
    @Test
    public void testGetHizkuntza() {
    	assertEquals(Hizkuntza.EU, fr1.getHizkuntza());
    }
    
    @Test
    public void testSetHizkuntza() {
        fr1.setHizkuntza(Hizkuntza.EU);
        assertEquals(Hizkuntza.EU, fr1.getHizkuntza());
    }
    
    @Test
    public void testGetErabiltzailea() {
        assertEquals("algarcia", fr1.getErabiltzailea());
    }
    
    @Test
    public void testSetErabiltzailea() {
        fr1.setErabiltzailea("algarcia");
        assertEquals("algarcia", fr1.getErabiltzailea());
    }
    
    @Test
    public void testEquals() {
    	ArrayList<String> playListEjemplo = new ArrayList<>();
        playListEjemplo.add("Viva la Vida");
        
        fr1 = new Free("alaitz", "garcia", eguna, "algarcia", "haia", Hizkuntza.EU, new ArrayList<>());
        fr2 = new Free("alaitz", "garcia", eguna, "algarcia", "haia", Hizkuntza.EU, new ArrayList<>());
        fr3 = new Free("juan", "perez", eguna, "jperez", "haia", Hizkuntza.EN, new ArrayList<>());

        assertTrue(fr1.equals(fr2));
        assertTrue(fr1.equals(fr1));
        assertFalse(fr1.equals(fr3));
        
 }
}
