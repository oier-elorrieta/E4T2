package testak;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Audioak.Album;
import Bezeroak.Free;
import Bezeroak.Bezeroa.Hizkuntza;

public class AlbumTest {
	
	private static Album al1;
	private static Album al2;
	private static Date argitaratzeUrtea;
	
	@Before
	public void setUp() throws Exception {
		argitaratzeUrtea = new Date(2024,11,17);
		al1 = new Album(new ArrayList<>(), argitaratzeUrtea);
	}
	
//----------------------------------------- Izenburua --------------------------------------

	@Test
    public void testGetPlayListZerrenda() {
        assertEquals(new ArrayList<>(), al1.getIzenburua());
    }

	@Test
	public void testGetPlaylistZerrendaTxarto() {
	    ArrayList<String> BesteAlbum = new ArrayList<>();
	    BesteAlbum.add("cancion3");
	    BesteAlbum.add("cancion4");

	    assertNotEquals(BesteAlbum, al1.getIzenburua());
	}
	
    @Test
    public void testSetPlayListZerrenda() {
        ArrayList<String> AlbumBerria = new ArrayList<>();
        AlbumBerria.add("Album1");
        AlbumBerria.add("Album2");
        al1.setIzenburua(AlbumBerria);

        assertEquals(AlbumBerria, al1.getIzenburua());
    }
    
    @Test
    public void testSetPlayListZerrendaTxarto() {
    	al1.setIzenburua(null);
    	assertNotEquals("a", al1.getIzenburua());
    }
	
  //----------------------------------------- ArgitaratzeUrtea --------------------------------------
    
	@Test
	public void testGetJdata() {
		assertEquals(argitaratzeUrtea, al1.getArgitaratzeUrtea());
	}
	
	@Test
	public void testGetJdataTxarto() {
		@SuppressWarnings("deprecation")
		Date jdata2 = new Date(2024, 11, 18);
		assertNotEquals(jdata2, al1.getArgitaratzeUrtea());
	}
	
	@Test
	public void testSetJdata() {
		@SuppressWarnings("deprecation")
		Date jdata2 = new Date(2024, 11, 18);
		al1.setArgitaratzeUrtea(jdata2);
		assertEquals(jdata2, al1.getArgitaratzeUrtea());
	}
	
	@Test
	public void testSetJdataTxarto() {
		@SuppressWarnings("deprecation")
		Date jdata2 = new Date(2024, 11, 18);
		al1.setArgitaratzeUrtea(jdata2);
		assertNotEquals(argitaratzeUrtea, al1.getArgitaratzeUrtea());
	}
	
	//----------------------------------------- To String --------------------------------------

	@Test
	public void testToString() {
		String txt = al1.toString();
		
		String esperotakoa = "Album [izenburua=" + al1.getIzenburua() + ", argitaratzeUrtea="
		+ al1.getArgitaratzeUrtea() + "]";
	}
	
	//----------------------------------------- Equals --------------------------------------

    @Test
    public void testEqualsObjetuBerdina() {
    assertTrue(al1.equals(al1));
    }

    @Test
    public void testEqualsNull() {
    assertFalse(al1.equals(null));
    }

    @Test
    public void testEqualsClaseEzberdinak() {
    String txarra = "";
    assertFalse(al1.equals(txarra));
    }

    @Test
    public void testEqualsClaseAtrBerdinak() {
    Album al2 = new Album(new ArrayList<>(), argitaratzeUrtea);
    assertTrue(al1.equals(al2));
    }
	
}
