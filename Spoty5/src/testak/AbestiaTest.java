package testak;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Time;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Audioak.Abestia;
import Bezeroak.Premium;


public class AbestiaTest {
	
	private static Abestia a1;
	private static Abestia a2;
	
	@Before
	public void setUp() throws Exception {
		a1 = new Abestia(1, "blink", new Time(3), null, "andoni", 5);
	}

//----------------------------------------- Id_audio --------------------------------------

	@Test
	public void testGetId_audio() {
		assertEquals(1, a1.getId_audio());
	}
		
	@Test
	public void testGetId_audioTxarto() {
		assertNotEquals(2, a1.getId_audio());
	}
		
	@Test
	public void setId_audio() {
		a1.setId_audio(3);
		assertEquals(3, a1.getId_audio());
	}
		
	@Test
	public void setId_audioTxarto() {
		a1.setId_audio(3);
		assertNotEquals(1, a1.getId_audio());
	}
	
//----------------------------------------- Izenburua --------------------------------------

    @Test
    public void testGetIzena() {
    	assertEquals("blink", a1.getIzena());
    }
    
    @Test
    public void testGetIzenaTxarto() {
    	assertNotEquals("blinkk", a1.getIzena());
    }

    @Test
    public void testSetIzena() {
        a1.setIzena("neverita");
        assertEquals("neverita", a1.getIzena());
    }
    
    @Test
	public void testSetIzenaTxarto() {
		a1.setIzena("neverita");
		assertNotEquals("blink", a1.getIzena());
	}
    
  //----------------------------------------- Iraupena --------------------------------------

    @Test
    public void testGetIraupena() {
        assertEquals(3, a1.getIraupena().getTime());
    }
    
    @Test
    public void testGetIraupenaTxarto() {
        assertNotEquals(4, a1.getIraupena().getTime());
    }
    
    @SuppressWarnings("deprecation")
	@Test
    public void testSetIraupena() {
    	Time iraupena = new Time(5);
    	a1.setIraupena(iraupena);
    	assertEquals(5, a1.getIraupena().getTime());    
    }
    
    @Test
    public void testSetIraupenaTxarto() {
    	Time iraupena = new Time(5);
    	a1.setIraupena(iraupena);
    	assertNotEquals(3, a1.getIraupena());
    }
    
  //----------------------------------------- Kolaboratzaileak --------------------------------------

    @Test
    public void testGetKolaboratzaileak() {
    	assertEquals("blink", a1.getIzena());
    }
    
    @Test
    public void testGetKolaboratzaileakTxarto() {
    	assertNotEquals("andoni", a1.getIzena());
    }

    @Test
    public void testSetKolaboratzaileak() {
        a1.setIzena("alaitz");
        assertEquals("alaitz", a1.getIzena());
    }
    
    @Test
	public void testSetKolaboratzaileakTxarto() {
		a1.setIzena("alaitz");
		assertNotEquals("andoni", a1.getIzena());
	}
    
    //----------------------------------------- Erreprodukzioak --------------------------------------

    @Test
    public void testGetErreprodukzioak() {
        assertEquals(5, a1.getErreprodukzioak(), 0.01);
    }
    
    @Test
    public void testGetErreprodukzioakTxarto() {
        assertNotEquals(4.0, a1.getErreprodukzioak(), 0.01);
    }
    
    @Test
    public void testSetErreprodukzioak() {
    	a1.setErreprodukzioak(5);
    	assertEquals(5, a1.getErreprodukzioak());
    }
    
    @Test
    public void testSetErreprodukzioakTxarto() {
    	a1.setErreprodukzioak(5);
    	assertNotEquals(3, a1.getErreprodukzioak());
    }
    
//----------------------------------------- To String --------------------------------------

    @Test
    public void testToString() {
    	String txt = a1.toString();
    	
    	String esperotakoa = "Audio [id_audio=" + a1.getId_audio() + "izena=" + a1.getIzena() + ", iraupena=" + a1.getIraupena()
    	+ ", kolaboratzaileak=" + a1.getKolaboratzaileak() + ", erreprodukzioak=" + a1.getErreprodukzioak() + "]";
    }
  
//----------------------------------------- Equals --------------------------------------

    @Test
    public void testEqualsObjetuBerdina() {
    assertTrue(a1.equals(a1));
    }

    @Test
    public void testEqualsNull() {
    assertFalse(a1.equals(null));
    }

    @Test
    public void testEqualsClaseEzberdinak() {
    String txarra = "";
    assertFalse(a1.equals(txarra));
    }

    @Test
    public void testEqualsClaseAtrBerdinak() {
    Abestia p2 = new Abestia(1, "blink", new Time(3), null, "andoni", 5);
    assertTrue(a1.equals(p2));
    }
    
}