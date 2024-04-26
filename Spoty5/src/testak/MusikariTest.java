package testak;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

import Artistak.Musikari;
public class MusikariTest {
	 @Test
	    public void testConstructorAndGetters() {
	        ArrayList<String> albumList = new ArrayList<>();
	        albumList.add("Album1");
	        albumList.add("Album2");
	        albumList.add("Album3");
	        Musikari musikari = new Musikari("Izena", null, albumList);
	       
	        assertEquals("Izena", musikari.getIzena());
	        assertEquals(albumList, musikari.getAlbumZerrenda());
	    }
	    @Test
	    public void testToString() {
	        ArrayList<String> albumList = new ArrayList<>();
	        albumList.add("Album1");
	        albumList.add("Album2");
	        albumList.add("Album3");
	        Musikari musikari = new Musikari("Izena", null, albumList);
	       
	        String expectedString = "Musikari [AlbumZerrenda=[Album1, Album2, Album3], Izena=Izena]";
	        assertEquals(expectedString, musikari.toString());
	    }
	    @Test
	    public void testSetAlbumZerrenda() {
	        ArrayList<String> albumList = new ArrayList<>();
	        albumList.add("Album1");
	        albumList.add("Album2");
	        Musikari musikari = new Musikari("Izena", null, albumList);
	        ArrayList<String> newAlbumList = new ArrayList<>();
	        newAlbumList.add("New Album1");
	        newAlbumList.add("New Album2");
	        newAlbumList.add("New Album3");
	        musikari.setAlbumZerrenda(newAlbumList);
	        assertEquals(newAlbumList, musikari.getAlbumZerrenda());
	    }
}

