package testak;

import static org.junit.Assert.*;

import java.sql.Blob;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import Artistak.Musikari;
import Bezeroak.Free;
import Bezeroak.Bezeroa.Hizkuntza;

public class MusikariTest {
	
	private static Musikari m1;
	private static Musikari m2;
	private static Blob irudia;
	
	@Before
	public void setUp() throws Exception {
		m1 = new Musikari(1, "Bad Bunny", irudia, "Hiriko musikako konpositore eta abeslaria da, batez ere trap eta reggaetoia");
	}
	
//----------------------------------------- Id --------------------------------------

	@Test
	public void testGetId() {
		assertEquals(1, m1.getId_artista());
	}
	
	@Test
	public void testGetIdTxarto() {
		assertNotEquals(2, m1.getId_artista());
	}
	
	@Test
	public void testSetId() {
		m1.setId_artista(2);
		assertEquals(2, m1.getId_artista());
	}
	
	@Test
	public void testSetIdTxarto() {
		m1.setId_artista(2);
		assertNotEquals(1, m1.getId_artista());
	}
	
//----------------------------------------- Izena --------------------------------------

	@Test
    public void testGetIzena() {
    	assertEquals("Bad Bunny", m1.getIzena());
    }
    
    @Test
    public void testGetIzenaTxarto() {
    	assertNotEquals("Bad Bunnyy", m1.getIzena());
    }

    @Test
    public void testSetIzena() {
    	m1.setIzena("Bad Gyal");
        assertNotEquals("Bad Gyal", m1.getIzena());
    }
    
    @Test
	public void testSetIzenaTxarto() {
    	m1.setIzena("Bad Gyal");
		assertEquals("Bad Bunny", m1.getIzena());
	}
    
//----------------------------------------- Irudia --------------------------------------

    @Test
    public void testGetIrudia() {
    	assertEquals(irudia, m1.getIrudia());
    }
    
    @Test
    public void testGetIrudiaTxarto() {
    	assertNotEquals(irudia, m1.getIrudia());
    }
    
    @Test
    public void testSetIrudia() {
    	m1.setIrudia(irudia);
    	assertEquals(irudia, m1.getIrudia());
    }
    
    @Test
    public void testSetIrudiaTxarto() {
    	m1.setIrudia(irudia);
    	assertEquals(irudia, m1.getIrudia());
    }
    
//----------------------------------------- AlbumZerrenda --------------------------------------

    @Test
    public void testGetDeskribapena() {
    	assertEquals("Hiriko musikako konpositore eta abeslaria da, batez ere trap eta reggaetoia", m1.getDeskribapena());
    }
    
    @Test
    public void testGetDeskribapenaTxarto() {
    	assertNotEquals("Hiriko musikako konpositore eta abeslaria da, batez ere trap eta reggaetoiaa", m1.getDeskribapena());
    }
    
    @Test
    public void testSetDeskribapena() {
    	m1.setDeskribapena("Reggaeton, dancehall eta trap generoen fusio gisa katalogatu da bere musika.");
    	assertEquals("Reggaeton, dancehall eta trap generoen fusio gisa katalogatu da bere musika.", m1.getDeskribapena());
    }
    
    @Test
    public void testDeskribapenaTxarto() {
    	m1.setDeskribapena("Reggaeton, dancehall eta trap generoen fusio gisa katalogatu da bere musika.");
    	assertNotEquals("Hiriko musikako konpositore eta abeslaria da, batez ere trap eta reggaetoia", m1.getDeskribapena());
    }
    
 //----------------------------------------- ToString --------------------------------------

    @Test
    public void testToString() {
    	String txt = m1.toString();
    	
    	String esperotakoa = "Artista [id=" + m1.getId_artista() + ", izena=" + m1.getIzena() + ", irudia=" + m1.getIrudia() + ", deskribapena=" + m1.getDeskribapena() + "]";
    }
    
 //----------------------------------------- Equals --------------------------------------

    @Test
    public void testEqualsObjetuBerdina() {
    assertTrue(m1.equals(m1));
    }

    @Test
    public void testEqualsNull() {
    assertFalse(m1.equals(null));
    }

    @Test
    public void testEqualsClaseEzberdinak() {
    String txarra = "";
    assertFalse(m1.equals(txarra));
    }

    @Test
    public void testEqualsClaseAtrBerdinak() {
    Musikari m2 = new Musikari(1, "Bad Bunny", irudia, "Hiriko musikako konpositore eta abeslaria da, batez ere trap eta reggaetoia");
    assertTrue(m1.equals(m2));
    }
    
}