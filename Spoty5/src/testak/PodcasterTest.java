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
    private static Blob irudia;
    
    @Before
    public void setUp() throws Exception {
    	pd1 = new Podcaster("La Script", irudia, new ArrayList<>());
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
          assertEquals("The Wild Proyect", pd1.getIzena());
      }
      
      @Test
  	public void testSetIzenaTxarto() {
    	pd1.setIzena("The Wild Proyect");
  		assertNotEquals("La Script", pd1.getIzena());
  	}
  	
  //----------------------------------------- Irudia --------------------------------------
  	
      @Test
      public void testGetIrudia() {
          assertEquals(irudia, pd1.getIrudia());
      }

      
  //----------------------------------------- AlbumZerrenda --------------------------------------

  	@Test
      public void testGetPlayListZerrenda() {
          assertEquals(new ArrayList<>(), pd1.getPodcastZerrenda());
      }

  	@Test
  	public void testGetPlaylistZerrendaTxarto() {
  	    ArrayList<String> BesteAlbum = new ArrayList<>();
  	    BesteAlbum.add("abestia1");
  	    BesteAlbum.add("abestia2");

  	    assertNotEquals(BesteAlbum, pd1.getPodcastZerrenda());
  	}
  	
      @Test
      public void testSetPlayListZerrenda() {
          ArrayList<String> AlbumBerria = new ArrayList<>();
          AlbumBerria.add("Album1");
          AlbumBerria.add("Album2");
          pd1.setPodcastZerrenda(AlbumBerria);

          assertEquals(AlbumBerria, pd1.getPodcastZerrenda());
      }
      
      @Test
      public void testSetPlayListZerrendaTxarto() {
    	  pd1.setPodcastZerrenda(null);
      	assertNotEquals("a", pd1.getPodcastZerrenda());
      }
      
   //----------------------------------------- ToString --------------------------------------

      @Test
      public void testToString() {
      	String txt = pd1.toString();
      	
      	String esperotakoa = "Artista [izena=" + pd1.getIzena() + ", irudia=" + pd1.getIrudia()
      	+ ", albumZerrenda=" + pd1.getPodcastZerrenda() + "]";
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
      Podcaster pd2 = new Podcaster("La Script", irudia, new ArrayList<>());
      assertTrue(pd1.equals(pd2));
      }
      
}
