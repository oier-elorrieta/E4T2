package testak;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import Audioak.Abestia;
import Audioak.Podcast;

public class PodcastTest {

	private static Podcast p1;
	private static Podcast p2;
	
	@Before
	public void setUp() throws Exception {
		p1 = new Podcast("blink", 3.5, "andoni", 5);
	}

//----------------------------------------- Izenburua --------------------------------------

    @Test
    public void TestGetIzenburua() {
    	assertEquals("blink", p1.getIzenburua());
    }
    
    @Test
    public void TestGetIzenburuaTxarto() {
    	assertNotEquals("blinkk", p1.getIzenburua());
    }

    @Test
    public void TestSetIzenburua() {
    	p1.setIzenburua("neverita");
        assertEquals("neverita", p1.getIzenburua());
    }
    
    @Test
	public void TestSetIzenburuaTxarto() {
    	p1.setIzenburua("neverita");
		assertNotEquals("blink", p1.getIzenburua());
	}
    
  //----------------------------------------- Iraupena --------------------------------------

    @Test
    public void TestGetIraupena() {
        assertEquals(3.5, p1.getIraupena(), 0.01);
    }
    
    @Test
    public void TestGetIraupenaTxarto() {
        assertNotEquals(4.0, p1.getIraupena(), 0.01);
    }
    
    @SuppressWarnings("deprecation")
	@Test
    public void TestSetIraupena() {
    	p1.setIraupena(5);
    	assertEquals(5.0, p1.getIraupena(), 0.001);    }
    
    @Test
    public void TestSetIraupenaTxarto() {
    	p1.setIraupena(5);
    	assertNotEquals(3, p1.getIraupena());
    }
    
  //----------------------------------------- Kolaboratzaileak --------------------------------------

    @Test
    public void TestGetKolaboratzaileak() {
    	assertEquals("blink", p1.getIzenburua());
    }
    
    @Test
    public void TestGetKolaboratzaileakTxarto() {
    	assertNotEquals("andoni", p1.getIzenburua());
    }

    @Test
    public void TestSetKolaboratzaileak() {
    	p1.setIzenburua("alaitz");
        assertEquals("alaitz", p1.getIzenburua());
    }
    
    @Test
	public void TestSetKolaboratzaileakTxarto() {
    	p1.setIzenburua("alaitz");
		assertNotEquals("andoni", p1.getIzenburua());
	}
    
    //----------------------------------------- Erreprodukzioak --------------------------------------

    @Test
    public void TestGetErreprodukzioak() {
        assertEquals(5, p1.getErreprodukzioak(), 0.01);
    }
    
    @Test
    public void TestGetErreprodukzioakTxarto() {
        assertNotEquals(4.0, p1.getErreprodukzioak(), 0.01);
    }
    
    @Test
    public void TestSetErreprodukzioak() {
    	p1.setErreprodukzioak(5);
    	assertEquals(5, p1.getErreprodukzioak());
    }
    
    @Test
    public void TestSetErreprodukzioakTxarto() {
    	p1.setErreprodukzioak(5);
    	assertNotEquals(3, p1.getErreprodukzioak());
    }
    
	//----------------------------------------- To String --------------------------------------

    @Test
    public void TestToString() {
    	String txt = p1.toString();
    	
    	String esperotakoa = "Audio [izenburua=" + p1.getIzenburua() + ", iraupena=" + p1.getIraupena()
    	+ ", kolaboratzaileak=" + p1.getKolaboratzaileak() + ", erreprodukzioak=" + p1.getErreprodukzioak() + "]";
    }
   
	//----------------------------------------- Equals --------------------------------------

    @Test
    public void TestEqualsObjetuBerdina() {
    assertTrue(p1.equals(p1));
    }

    @Test
    public void TestEqualsNull() {
    assertFalse(p1.equals(null));
    }

    @Test
    public void TestEqualsClaseEzberdinak() {
    String txarra = "";
    assertFalse(p1.equals(txarra));
    }

    @Test
    public void TestEqualsClaseAtrBerdinak() {
    Podcast p2 = new Podcast("blink", 3.5, "andoni", 5);
    assertTrue(p1.equals(p2));
    }
}
