package testak;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import master.Bezeroa.Hizkuntza;
import master.Premium;

public class PremiumTest {

    Premium p1;
    Date eguna = new Date(2024, 04, 18);

    @Before
    public void setUp() throws Exception {
        p1 = new Premium("hegoi", "vazquez", eguna, "haia", Hizkuntza.EU, "hvazquez");
    }

    // ***** Izena TEST *****
    @Test
    public void getIzenatest() {
        Premium p1 = new Premium("hegoi", "vazquez", eguna, "haia", Hizkuntza.EU, "hvazquez");
        assertEquals("hegoi", p1.getIzena());
    }

    @Test
    public void setIzenaTest() {
        Premium p1 = new Premium("hegoi", "vazquez", eguna, "haia", Hizkuntza.EU, "hvazquez");
        p1.setIzena("hegoi");
        assertEquals("hegoi", p1.getIzena());
    }

    // ***** Abizena TEST *****
    @Test
    public void getAbizenatest() {
        Premium p1 = new Premium("hegoi", "vazquez", eguna, "haia", Hizkuntza.EU, "hvazquez");
        assertEquals("vazquez", p1.getAbizena());
    }

    @Test
    public void setAbizenaTest() {
        Premium p1 = new Premium("hegoi", "vazquez", eguna, "haia", Hizkuntza.EU, "hvazquez");
        p1.setAbizena("vazquez");
        assertEquals("vazquez", p1.getAbizena());
    }

    // ***** Erabiltzailea TEST *****
    @Test
    public void getErabiltzaileatest() {
        Premium p1 = new Premium("hegoi", "vazquez", eguna, "haia", Hizkuntza.EU, "hvazquez");
        assertEquals("hvazquez", p1.getErabiltzailea());
    }

    @Test
    public void setErabiltzaileaTest() {
        Premium p1 = new Premium("hegoi", "vazquez", eguna, "haia", Hizkuntza.EU, "hvazquez");
        p1.setIzena("hvazquez");
        assertEquals("hvazquez", p1.getErabiltzailea());
    }

    // ***** Pasahitza TEST *****
    @Test
    public void getPasahitzatest() {
        Premium p1 = new Premium("hegoi", "vazquez", eguna, "haia", Hizkuntza.EU, "hvazquez");
        assertEquals("haia", p1.getPasahitza());
    }

    @Test
    public void setPasahitzaTest() {
        Premium p1 = new Premium("hegoi", "vazquez", eguna, "haia", Hizkuntza.EU, "hvazquez");
        p1.setPasahitza("haia");
        assertEquals("haia", p1.getPasahitza());
    }

    // ***** Hizkuntza TEST *****
    @Test
    public void getHizkuntzatest() {
        Premium p1 = new Premium("hegoi", "vazquez", eguna, "haia", Hizkuntza.EU, "hvazquez");
        assertEquals(Hizkuntza.EU, p1.getHizkuntza());
    }

    @Test
    public void setHizkuntzaTest() {
        Premium p1 = new Premium("hegoi", "vazquez", eguna, "haia", Hizkuntza.EU, "hvazquez");
        p1.setHizkuntza(Hizkuntza.EU);
        assertEquals(Hizkuntza.EU, p1.getHizkuntza());
    }

    // ***** Data TEST *****
    @Test
    public void getDatatest() {
        Date eguna = new Date(2024, 04, 18);
        Premium p1 = new Premium("hegoi", "vazquez", eguna, "haia", Hizkuntza.EU, "hvazquez");
        assertEquals(eguna, p1.getJdata());
    }

    @Test
    public void setDataTest() {
        Date eguna = new Date(2024, 04, 18);
        Date eguna1 = new Date(2024, 05, 20);
        Premium p1 = new Premium("hegoi", "vazquez", eguna, "haia", Hizkuntza.EU, "hvazquez");
        p1.setJdata(eguna1);
        assertEquals(eguna1, p1.getJdata());
    }

     @Test
        public void testEquals() {
            Premium premium1 = new Premium("hegoi", "vazquez", eguna, "haia", Hizkuntza.EU, "hvazquez");
            Premium premium2 = new Premium("hegoi", "vazquez", eguna, "haia", Hizkuntza.EU, "hvazquez");
            
            assertTrue(premium1.equals(premium1));
            assertTrue(premium1.equals(premium2) && premium2.equals(premium1));
            assertFalse(premium1.equals(null));
            assertFalse(premium1.equals("hegoi"));
            
     }
     
     
}
