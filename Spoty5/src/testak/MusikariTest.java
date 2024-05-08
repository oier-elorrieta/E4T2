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
		m1 = new Musikari("Bad Bunny", irudia, new ArrayList<>());
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
        assertEquals("Bad Gyal", m1.getIzena());
    }
    
    @Test
	public void testSetIzenaTxarto() {
    	m1.setIzena("Bad Gyal");
		assertNotEquals("Bad Bunny", m1.getIzena());
	}
	
//----------------------------------------- Irudia --------------------------------------
	
    @Test
    public void testGetIrudia() {
        assertEquals(irudia, m1.getIrudia());
    }

    
//----------------------------------------- AlbumZerrenda --------------------------------------

	@Test
    public void testGetPlayListZerrenda() {
        assertEquals(new ArrayList<>(), m1.getAlbumZerrenda());
    }

	@Test
	public void testGetPlaylistZerrendaTxarto() {
	    ArrayList<String> BesteAlbum = new ArrayList<>();
	    BesteAlbum.add("cancion3");
	    BesteAlbum.add("cancion4");

	    assertNotEquals(BesteAlbum, m1.getAlbumZerrenda());
	}
	
    @Test
    public void testSetPlayListZerrenda() {
        ArrayList<String> AlbumBerria = new ArrayList<>();
        AlbumBerria.add("Album1");
        AlbumBerria.add("Album2");
        m1.setAlbumZerrenda(AlbumBerria);

        assertEquals(AlbumBerria, m1.getAlbumZerrenda());
    }
    
    @Test
    public void testSetPlayListZerrendaTxarto() {
    	m1.setAlbumZerrenda(null);
    	assertNotEquals("a", m1.getAlbumZerrenda());
    }
    
 //----------------------------------------- ToString --------------------------------------

    @Test
    public void testToString() {
    	String txt = m1.toString();
    	
    	String esperotakoa = "Artista [izena=" + m1.getIzena() + ", irudia=" + m1.getIrudia()
    	+ ", albumZerrenda=" + m1.getAlbumZerrenda() + "]";
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
    Musikari m2 = new Musikari("Bad Bunny", irudia, new ArrayList<>());
    assertTrue(m1.equals(m2));
    }
    
}