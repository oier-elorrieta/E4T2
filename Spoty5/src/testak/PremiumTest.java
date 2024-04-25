package testak;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Bezeroak.Free;
import Bezeroak.Premium;
import Bezeroak.Bezeroa.Hizkuntza;

public class PremiumTest {

    Premium p1, p2, p3;
    Date eguna = new Date(2024, 04, 18);
    Date iraungitzeD = new Date(2025, 04, 18);

    @Before
    public void setUp() throws Exception {
    	String izena = "june";
    	String abizena = "gomez";
    	String erabiltzailea = "jgomez";
    	String pasahitza = "haia";
    	Hizkuntza hizkuntza = Hizkuntza.ES;
    	
    	ArrayList<String> playListZerrenda = new ArrayList<>();
        playListZerrenda.add("Clocks");
        
        p1 = new Premium(izena, abizena, eguna, erabiltzailea, pasahitza, hizkuntza, playListZerrenda, iraungitzeD);
        
    }

    // ***** Izena TEST *****
    @Test
    public void getIzenatest() {
    	assertEquals("june", p1.getIzena());
    }

    @Test
    public void setIzenaTest() {
        p1.setIzena("june");
        assertEquals("june", p1.getIzena());
    }

    // ***** Abizena TEST *****
    @Test
    public void getAbizenatest() {
        assertEquals("gomez", p1.getAbizena());
    }

    @Test
    public void setAbizenaTest() {
        p1.setAbizena("gomez");
        assertEquals("gomez", p1.getAbizena());
    }

    // ***** Erabiltzailea TEST *****
    @Test
    public void getErabiltzaileatest() {
        assertEquals("jgomez", p1.getErabiltzailea());
    }

    @Test
    public void setErabiltzaileaTest() {
        p1.setIzena("jgomez");
        assertEquals("jgomez", p1.getErabiltzailea());
    }

    // ***** Pasahitza TEST *****
    @Test
    public void getPasahitzatest() {
        assertEquals("haia", p1.getPasahitza());
    }

    @Test
    public void setPasahitzaTest() {
        p1.setPasahitza("haia");
        assertEquals("haia", p1.getPasahitza());
    }

    // ***** Hizkuntza TEST *****
    @Test
    public void getHizkuntzatest() {
        assertEquals(Hizkuntza.ES, p1.getHizkuntza());
    }

    @Test
    public void setHizkuntzaTest() {
        p1.setHizkuntza(Hizkuntza.ES);
        assertEquals(Hizkuntza.ES, p1.getHizkuntza());
    }

    // ***** Data TEST *****
    @Test
    public void getDatatest() {
        assertEquals(eguna, p1.getJdata());
    }

    @Test
    public void setDataTest() {
        Date eguna1 = new Date(2024, 05, 20);
        p1.setJdata(eguna1);
        assertEquals(eguna1, p1.getJdata());
    }
    
    // ***** IraungitzeData TEST *****
    @Test
    public void getIraungitzeDataTest() {
    	assertEquals(iraungitzeD, p1.getIraungitzeData());
    }
    
    @Test
    public void setIraungitzeDataTest() {
    	Date iraungiData1 = new Date(2025, 06, 22);
    	p1.setIraungitzeData(iraungiData1);
    	assertEquals(iraungiData1, p1.getIraungitzeData());
    }

     @Test
        public void testEquals() {
        ArrayList<String> playListEjemplo = new ArrayList<>();
        playListEjemplo.add("CLocks");            
        
        p1 = new Premium("june", "gomez", eguna, "jgomez", "haia", Hizkuntza.ES, new ArrayList<>(), iraungitzeD);
        p2 = new Premium("june", "gomez", eguna, "jgomez", "haia", Hizkuntza.ES, new ArrayList<>(), iraungitzeD);
        p3 = new Premium("Pedro", "aguirrezabala", eguna, "paguirrezabala", "haia", Hizkuntza.AR, new ArrayList<>(), iraungitzeD);
        
        assertTrue(p1.equals(p2));
        assertTrue(p1.equals(p1));
        assertFalse(p1.equals(p3));
        
     }
     
     
}
