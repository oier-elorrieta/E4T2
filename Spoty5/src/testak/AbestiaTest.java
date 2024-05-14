package testak;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Audioak.Abestia;
import Bezeroak.Premium;
import Bezeroak.Bezeroa.Hizkuntza;

public class AbestiaTest {
	
	private static Abestia a1;
	private static Abestia a2;
	
	@Before
	public void setUp() throws Exception {
		a1 = new Abestia(1, "blink", 3.5, "andoni", 5);
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
    	assertEquals("blink", a1.getIzenburua());
    }
    
    @Test
    public void testGetIzenaTxarto() {
    	assertNotEquals("blinkk", a1.getIzenburua());
    }

    @Test
    public void testSetIzena() {
        a1.setIzenburua("neverita");
        assertEquals("neverita", a1.getIzenburua());
    }
    
    @Test
	public void testSetIzenaTxarto() {
		a1.setIzenburua("neverita");
		assertNotEquals("blink", a1.getIzenburua());
	}
    
  //----------------------------------------- Iraupena --------------------------------------

    @Test
    public void testGetIraupena() {
        assertEquals(3.5, a1.getIraupena(), 0.01);
    }
    
    @Test
    public void testGetIraupenaTxarto() {
        assertNotEquals(4.0, a1.getIraupena(), 0.01);
    }
    
    @SuppressWarnings("deprecation")
	@Test
    public void testSetIraupena() {
    	a1.setIraupena(5);
    	assertEquals(5.0, a1.getIraupena(), 0.001);    
    }
    
    @Test
    public void testSetIraupenaTxarto() {
    	a1.setIraupena(5);
    	assertNotEquals(3, a1.getIraupena());
    }
    
  //----------------------------------------- Kolaboratzaileak --------------------------------------

    @Test
    public void testGetKolaboratzaileak() {
    	assertEquals("blink", a1.getIzenburua());
    }
    
    @Test
    public void testGetKolaboratzaileakTxarto() {
    	assertNotEquals("andoni", a1.getIzenburua());
    }

    @Test
    public void testSetKolaboratzaileak() {
        a1.setIzenburua("alaitz");
        assertEquals("alaitz", a1.getIzenburua());
    }
    
    @Test
	public void testSetKolaboratzaileakTxarto() {
		a1.setIzenburua("alaitz");
		assertNotEquals("andoni", a1.getIzenburua());
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
    	
    	String esperotakoa = "Audio [id_audio=" + a1.getId_audio() + "izenburua=" + a1.getIzenburua() + ", iraupena=" + a1.getIraupena()
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
    Abestia p2 = new Abestia(1, "blink", 3.5, "andoni", 5);
    assertTrue(a1.equals(p2));
    }
    
}