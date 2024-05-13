package testak;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Blob;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Artistak.Musikari;
import Artistak.Podcaster;

public class PodcasterTest {

    private static Podcaster pd1;
    private static Podcaster pd2;
    
    @Before
    public void setUp() throws Exception {
    	pd1 = new Podcaster(1, "La Script", "ama-alaben istorio bat, denboraren joanaren eta heriotzaren beldurrari buruzko gogoeta gogor eta lotsagabea");
    }
    
  //----------------------------------------- Id --------------------------------------

  	@Test
  	public void testGetId() {
  		assertEquals(1, pd1.getId_artista());
  	}
  	
  	@Test
  	public void testGetIdTxarto() {
  		assertNotEquals(2, pd1.getId_artista());
  	}
  	
  	@Test
  	public void testSetId() {
  		pd1.setId_artista(2);
  		assertEquals(2, pd1.getId_artista());
  	}
  	
  	@Test
  	public void testSetIdTxarto() {
  		pd1.setId_artista(2);
  		assertNotEquals(1, pd1.getId_artista());
  	}
  	
  //----------------------------------------- Izena --------------------------------------
  	
    @Test
    public void testGetIzena() {
    	assertEquals("La Script", pd1.getIzena());
    }
    
    @Test
    public void testGetIzenaTxarto() {
    	assertNotEquals("La Scriptt", pd1.getIzena());
    }

    @Test
    public void testSetIzena() {
  	  	pd1.setIzena("The Wild Proyect");
        assertNotEquals("The Wild Proyect", pd1.getIzena());
    }
    
    @Test
	public void testSetIzenaTxarto() {
  	pd1.setIzena("The Wild Proyect");
		assertEquals("La Script", pd1.getIzena());
	}
      
  //----------------------------------------- Deskribapena --------------------------------------

    @Test
    public void testGetDeskribapena() {
    	assertEquals("ama-alaben istorio bat, denboraren joanaren eta heriotzaren beldurrari buruzko gogoeta gogor eta lotsagabea", pd1.getDeskribapena());
    }
    
    @Test
    public void testGetDeskribapenaTxarto() {
    	assertNotEquals("ama-alaben istorio bat, denboraren joanaren eta heriotzaren beldurrari buruzko gogoeta gogor eta lotsagabeaa", pd1.getDeskribapena());
    }

    @Test
    public void testSetDeskribapena() {
  	  	pd1.setDeskribapena("Jordi Wildek bi ordu baino gehiago ematen ditu mikrofonoan pertsonaia ezberdinekin hizketan");
        assertEquals("Jordi Wildek bi ordu baino gehiago ematen ditu mikrofonoan pertsonaia ezberdinekin hizketan", pd1.getDeskribapena());
    }
    
    @Test
	public void testSetDeskribapenaTxarto() {
  	pd1.setDeskribapena("Jordi Wildek bi ordu baino gehiago ematen ditu mikrofonoan pertsonaia ezberdinekin hizketan");
		assertNotEquals("ama-alaben istorio bat, denboraren joanaren eta heriotzaren beldurrari buruzko gogoeta gogor eta lotsagabea", pd1.getDeskribapena());
	} 
   //----------------------------------------- ToString --------------------------------------

      @Test
      public void testToString() {
      	String txt = pd1.toString();
      	
      	String esperotakoa = "Artista [id=" + pd1.getId_artista() + ", izena=" + pd1.getIzena() + ", deskribapena=" + pd1.getDeskribapena() + "]";
      }
      
   //----------------------------------------- Equals --------------------------------------

      @Test
      public void testEqualsObjetuBerdina() {
      assertTrue(pd1.equals(pd1));
      }

      @Test
      public void testEqualsNull() {
      assertFalse(pd1.equals(null));
      }

      @Test
      public void testEqualsClaseEzberdinak() {
      String txarra = "";
      assertFalse(pd1.equals(txarra));
      }

      @Test
      public void testEqualsClaseAtrBerdinak() {
      Podcaster pd2 = new Podcaster(1, "La Script", "ama-alaben istorio bat, denboraren joanaren eta heriotzaren beldurrari buruzko gogoeta gogor eta lotsagabea");
      assertTrue(pd1.equals(pd2));
      }
      
}
