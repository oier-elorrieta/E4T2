package testak;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import master.Bezeroa.Hizkuntza;
import master.Free;


public class FreeTest {

    Free fr1;
    Date eguna = new Date(2024, 04, 18);

    @Before
    public void setUp() throws Exception {
        fr1 = new Free("hegoi", "vazquez", eguna, "haia", Hizkuntza.EU, "hvazquez");
    }
    
    @Test
    public void testGetIzena() {
        Free fr1 = new Free("hegoi", "vazquez", eguna, "haia", Hizkuntza.EU, "hvazquez");
        assertEquals("hegoi", fr1.getIzena());
    }
    
    @Test
    public void testSetIzena() {
        Free fr1 = new Free("hegoi", "vazquez", eguna, "haia", Hizkuntza.EU, "hvazquez");
        fr1.setIzena("hegoi");
        assertEquals("hegoi", fr1.getIzena());
    }
    
    @Test
    public void testGetAbizena() {
        Free fr1 = new Free("hegoi", "vazquez", eguna, "haia", Hizkuntza.EU, "hvazquez");
        assertEquals("vazquez", fr1.getAbizena());
    }
    
    @Test
    public void testSetAbizena() {
        Free fr1 = new Free("hegoi", "vazquez", eguna, "haia", Hizkuntza.EU, "hvazquez");
        fr1.setAbizena("vazquez");
        assertEquals("vazquez", fr1.getAbizena());
    }
    
    @Test
    public void testGetJdata() {
        Date eguna = new Date(2024, 04, 18);
        Free fr1 = new Free("hegoi", "vazquez", eguna, "haia", Hizkuntza.EU, "hvazquez");
        assertEquals(eguna, fr1.getJdata());
    }
    
    @Test
    public void testSetJdata() {
        Date eguna = new Date(2024, 04, 18);
        Date eguna1 = new Date(2024, 05, 20);
        Free fr1 = new Free("hegoi", "vazquez", eguna, "haia", Hizkuntza.EU, "hvazquez");
        fr1.setJdata(eguna1);
        assertEquals(eguna1, fr1.getJdata());
    }
    
    @Test
    public void testGetPasahitza() {
        Free fr1 = new Free("hegoi", "vazquez", eguna, "haia", Hizkuntza.EU, "hvazquez");
        assertEquals("haia", fr1.getPasahitza());
    }
    
    @Test
    public void testSetPasahitza() {
        Free fr1 = new Free("hegoi", "vazquez", eguna, "haia", Hizkuntza.EU, "hvazquez");
        fr1.setPasahitza("haia");
        assertEquals("haia", fr1.getPasahitza());
    }
    
    @Test
    public void testGetHizkuntza() {
        Free fr1 = new Free("hegoi", "vazquez", eguna, "haia", Hizkuntza.EU, "hvazquez");
        assertEquals(Hizkuntza.EU, fr1.getHizkuntza());
    }
    
    @Test
    public void testSetHizkuntza() {
        Free fr1 = new Free("hegoi", "vazquez", eguna, "haia", Hizkuntza.EU, "hvazquez");
        fr1.setHizkuntza(Hizkuntza.EU);
        assertEquals(Hizkuntza.EU, fr1.getHizkuntza());
    }
    
    @Test
    public void testGetErabiltzailea() {
        Free fr1 = new Free("hegoi", "vazquez", eguna, "haia", Hizkuntza.EU, "hvazquez");
        assertEquals("hvazquez", fr1.getErabiltzailea());
    }
    
    @Test
    public void testSetErabiltzailea() {
        Free fr1 = new Free("hegoi", "vazquez", eguna, "haia", Hizkuntza.EU, "hvazquez");
        fr1.setErabiltzailea("hvazquez");
        assertEquals("hvazquez", fr1.getErabiltzailea());
    }
    
    @Test
    public void testEquals() {
        Free free1 = new Free("hegoi", "vazquez", eguna, "haia", Hizkuntza.EU, "hvazquez");
        Free free2 = new Free("hegoi", "vazquez", eguna, "haia", Hizkuntza.EU, "hvazquez");
        
        assertTrue(free1.equals(free1));
        assertTrue(free1.equals(free2) && free2.equals(free1));
        assertFalse(free1.equals(null));
        assertFalse(free1.equals("hegoi"));
        
 }
}
