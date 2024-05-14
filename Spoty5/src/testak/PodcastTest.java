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
		p1 = new Podcast(1, "blink", 3.5, "andoni", 5);
	}

//----------------------------------------- Id_audio --------------------------------------

	@Test
	public void testGetId_audio() {
		assertEquals(1, p1.getId_audio());
	}
	
	@Test
	public void testGetId_audioTxarto() {
		assertNotEquals(2, p1.getId_audio());
	}
	
	@Test
	public void setId_audio() {
		p1.setId_audio(3);
		assertEquals(3, p1.getId_audio());
	}
	
	@Test
	public void setId_audioTxarto() {
		p1.setId_audio(3);
		assertNotEquals(1, p1.getId_audio());
	}
	
//----------------------------------------- Izenburua --------------------------------------

    @Test
    public void testGetIzenburua() {
    	assertEquals("blink", p1.getIzenburua());
    }
    
    @Test
    public void testGetIzenburuaTxarto() {
    	assertNotEquals("blinkk", p1.getIzenburua());
    }

    @Test
    public void testSetIzenburua() {
    	p1.setIzenburua("neverita");
        assertEquals("neverita", p1.getIzenburua());
    }
    
    @Test
	public void testSetIzenburuaTxarto() {
    	p1.setIzenburua("neverita");
		assertNotEquals("blink", p1.getIzenburua());
	}
    
  //----------------------------------------- Iraupena --------------------------------------

    @Test
    public void testGetIraupena() {
        assertEquals(3.5, p1.getIraupena(), 0.01);
    }
    
    @Test
    public void testGetIraupenaTxarto() {
        assertNotEquals(4.0, p1.getIraupena(), 0.01);
    }
    
    @SuppressWarnings("deprecation")
	@Test
    public void testSetIraupena() {
    	p1.setIraupena(5);
    	assertEquals(5.0, p1.getIraupena(), 0.001);    }
    
    @Test
    public void testSetIraupenaTxarto() {
    	p1.setIraupena(5);
    	assertNotEquals(3, p1.getIraupena());
    }
    
  //----------------------------------------- Kolaboratzaileak --------------------------------------

    @Test
    public void testGetKolaboratzaileak() {
    	assertEquals("blink", p1.getIzenburua());
    }
    
    @Test
    public void testGetKolaboratzaileakTxarto() {
    	assertNotEquals("andoni", p1.getIzenburua());
    }

    @Test
    public void testSetKolaboratzaileak() {
    	p1.setIzenburua("alaitz");
        assertEquals("alaitz", p1.getIzenburua());
    }
    
    @Test
	public void testSetKolaboratzaileakTxarto() {
    	p1.setIzenburua("alaitz");
		assertNotEquals("andoni", p1.getIzenburua());
	}
    
    //----------------------------------------- Erreprodukzioak --------------------------------------

    @Test
    public void testGetErreprodukzioak() {
        assertEquals(5, p1.getErreprodukzioak(), 0.01);
    }
    
    @Test
    public void testGetErreprodukzioakTxarto() {
        assertNotEquals(4.0, p1.getErreprodukzioak(), 0.01);
    }
    
    @Test
    public void testSetErreprodukzioak() {
    	p1.setErreprodukzioak(5);
    	assertEquals(5, p1.getErreprodukzioak());
    }
    
    @Test
    public void testSetErreprodukzioakTxarto() {
    	p1.setErreprodukzioak(5);
    	assertNotEquals(3, p1.getErreprodukzioak());
    }
    
	//----------------------------------------- To String --------------------------------------

    @Test
    public void testToString() {
    	String txt = p1.toString();
    	
    	String esperotakoa = "Audio [id_audio=" + p1.getId_audio() + "izenburua=" + p1.getIzenburua() + ", iraupena=" + p1.getIraupena()
    	+ ", kolaboratzaileak=" + p1.getKolaboratzaileak() + ", erreprodukzioak=" + p1.getErreprodukzioak() + "]";
    }
   
	//----------------------------------------- Equals --------------------------------------

    @Test
    public void testEqualsObjetuBerdina() {
    assertTrue(p1.equals(p1));
    }

    @Test
    public void testEqualsNull() {
    assertFalse(p1.equals(null));
    }

    @Test
    public void testEqualsClaseEzberdinak() {
    String txarra = "";
    assertFalse(p1.equals(txarra));
    }

    @Test
    public void testEqualsClaseAtrBerdinak() {
    Podcast p2 = new Podcast(1, "blink", 3.5, "andoni", 5);
    assertTrue(p1.equals(p2));
    }
}
