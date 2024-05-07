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
		a1 = new Abestia("blink", 3.5, "andoni", 5);
	}

//----------------------------------------- Izenburua --------------------------------------

    @Test
    public void TestGetIzena() {
    	assertEquals("blink", a1.getIzenburua());
    }
    
    @Test
    public void TestGetIzenaTxarto() {
    	assertNotEquals("blinkk", a1.getIzenburua());
    }

    @Test
    public void TestSetIzena() {
        a1.setIzenburua("neverita");
        assertEquals("neverita", a1.getIzenburua());
    }
    
    @Test
	public void TestSetIzenaTxarto() {
		a1.setIzenburua("neverita");
		assertNotEquals("blink", a1.getIzenburua());
	}
    
  //----------------------------------------- Iraupena --------------------------------------

    @Test
    public void TestGetIraupena() {
        assertEquals(3.5, a1.getIraupena(), 0.01);
    }
    
    @Test
    public void TestGetIraupenaTxarto() {
        assertNotEquals(4.0, a1.getIraupena(), 0.01);
    }
    
    @SuppressWarnings("deprecation")
	@Test
    public void TestSetIraupena() {
    	a1.setIraupena(5);
    	assertEquals(5.0, a1.getIraupena(), 0.001);    
    }
    
    @Test
    public void TestSetIraupenaTxarto() {
    	a1.setIraupena(5);
    	assertNotEquals(3, a1.getIraupena());
    }
    
  //----------------------------------------- Kolaboratzaileak --------------------------------------

    @Test
    public void TestGetKolaboratzaileak() {
    	assertEquals("blink", a1.getIzenburua());
    }
    
    @Test
    public void TestGetKolaboratzaileakTxarto() {
    	assertNotEquals("andoni", a1.getIzenburua());
    }

    @Test
    public void TestSetKolaboratzaileak() {
        a1.setIzenburua("alaitz");
        assertEquals("alaitz", a1.getIzenburua());
    }
    
    @Test
	public void TestSetKolaboratzaileakTxarto() {
		a1.setIzenburua("alaitz");
		assertNotEquals("andoni", a1.getIzenburua());
	}
    
    //----------------------------------------- Erreprodukzioak --------------------------------------

    @Test
    public void TestGetErreprodukzioak() {
        assertEquals(5, a1.getErreprodukzioak(), 0.01);
    }
    
    @Test
    public void TestGetErreprodukzioakTxarto() {
        assertNotEquals(4.0, a1.getErreprodukzioak(), 0.01);
    }
    
    @Test
    public void TestSetErreprodukzioak() {
    	a1.setErreprodukzioak(5);
    	assertEquals(5, a1.getErreprodukzioak());
    }
    
    @Test
    public void TestSetErreprodukzioakTxarto() {
    	a1.setErreprodukzioak(5);
    	assertNotEquals(3, a1.getErreprodukzioak());
    }
    
//----------------------------------------- To String --------------------------------------

    @Test
    public void TestToString() {
    	String txt = a1.toString();
    	
    	String esperotakoa = "Audio [izenburua=" + a1.getIzenburua() + ", iraupena=" + a1.getIraupena()
    	+ ", kolaboratzaileak=" + a1.getKolaboratzaileak() + ", erreprodukzioak=" + a1.getErreprodukzioak() + "]";
    }
  
//----------------------------------------- Equals --------------------------------------

    @Test
    public void TestEqualsObjetuBerdina() {
    assertTrue(a1.equals(a1));
    }

    @Test
    public void TestEqualsNull() {
    assertFalse(a1.equals(null));
    }

    @Test
    public void TestEqualsClaseEzberdinak() {
    String txarra = "";
    assertFalse(a1.equals(txarra));
    }

    @Test
    public void TestEqualsClaseAtrBerdinak() {
    Abestia p2 = new Abestia("blink", 3.5, "andoni", 5);
    assertTrue(a1.equals(p2));
    }
    
}