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
	private static Date urtea;
	
	@Before
	public void setUp() throws Exception {
		urtea = new Date(2024,11,17);
		al1 = new Album(1, "Un verano sin ti", urtea, "trap", null);
	}
	
//----------------------------------------- Id --------------------------------------

	@Test
    public void testGetId() {
        assertEquals(1, al1.getId_album());
    }

	@Test
	public void testGetIdTxarto() {
		assertNotEquals(2, al1.getId_album());
	}
	
    @Test
    public void testSetId() {
    	al1.setId_album(2);
    	assertEquals(2, al1.getId_album());
    }
    
    @Test
    public void testSetIdTxarto() {
    	al1.setId_album(2);
    	assertNotEquals(1, al1.getId_album());
    }
	
 //----------------------------------------- Izenburua --------------------------------------
    
	@Test
	public void testGetIzenburua() {
		assertEquals("Un verano sin ti", al1.getIzenburua());
	}
	
	@Test
	public void testGetIzenburuaTxarto() {
		assertNotEquals("Un verano sin tii", al1.getIzenburua());
	}
	
	@Test
	public void testSetIzenburua() {
		al1.setIzenburua("Worldwide Angel");
		assertEquals("Worldwide Angel", al1.getIzenburua());
	}	
	
	@Test
	public void testSetIzenburuaTxarto() {
		al1.setIzenburua("Worldwide Angel");
		assertNotEquals("Un verano sin ti", al1.getIzenburua());
	}
	
//----------------------------------------- Urtea --------------------------------------

	@Test
	public void testGetUrtea() {
		assertEquals(urtea, al1.getUrtea());
	}
	
	@Test
	public void testGetUrteaTxarto() {
		Date urtea2 = new Date(2024, 11, 15);
		assertNotEquals(urtea2, al1.getUrtea());
	}
	
	@Test
	public void testSetUrtea() {
		Date urtea2 = new Date(2024, 11, 15);
		al1.setUrtea(urtea2);
		assertEquals(urtea2, al1.getUrtea());
	}
	
	@Test
	public void testSetUrteaTxarto() {
		Date urtea2 = new Date(2024, 11, 15);
		al1.setUrtea(urtea2);
		assertNotEquals(urtea, al1.getUrtea());
	}
	
//----------------------------------------- Generoa --------------------------------------

	@Test
	public void Generoa() {
		assertEquals("trap", al1.getGeneroa());
	}
	
	@Test
	public void testGetGeneroaTxarto() {
		assertNotEquals("trapp", al1.getGeneroa());
	}
	
	@Test
	public void testSetGeneroa() {
		al1.setGeneroa("pop");
		assertEquals("pop", al1.getGeneroa());
	}	
	
	@Test
	public void testSetGeneroaTxarto() {
		al1.setGeneroa("pop");
		assertNotEquals("trap", al1.getGeneroa());
	}
	
//----------------------------------------- To String --------------------------------------

	@Test
	public void testToString() {
		String txt = al1.toString();
		
		String esperotakoa = "Album [id=" + al1.getId_album() + ", izenburua=" + al1.getIzenburua() + ", urtea=" + al1.getUrtea() + ", generoa=" + al1.getGeneroa() + "]";
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
    Album al2 = new Album(2, "Un verano sin ti", urtea, "trap", null);
    assertTrue(al2.equals(al2));
    }
	
}
