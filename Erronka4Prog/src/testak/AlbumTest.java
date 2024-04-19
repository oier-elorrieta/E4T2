package testak;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Test;

import master.Album;

public class AlbumTest {

    @Test
       public void testConstructor() {
           ArrayList<String> titles = new ArrayList<>();
           titles.add("Title 1");
           titles.add("Title 2");
           Date releaseDate = new Date(0);
           
           Album album = new Album(titles, releaseDate);
           
           assertNotNull(album);
           assertEquals(titles, album.getIzenburua());
           assertEquals(releaseDate, album.getArgitaratzeUrtea());
       }
    
    @Test
        public void testToString() {
           ArrayList<String> titles = new ArrayList<>();
           titles.add("Title 1");
           titles.add("Title 2");
           Date releaseDate = new Date(0);
           
           Album album = new Album(titles, releaseDate);
           String expected = "Album [Izenburua=[Title 1, Title 2], ArgitaratzeUrtea=" + releaseDate + "]";
           
           assertEquals(expected, album.toString());
       }
    
    @Test
       public void testEqualsAndHashCode() {
           ArrayList<String> titles1 = new ArrayList<>();
           titles1.add("Title 1");
           titles1.add("Title 2");
           Date releaseDate1 = new Date(0);
           
           ArrayList<String> titles2 = new ArrayList<>();
           titles2.add("Title 1");
           titles2.add("Title 2");
           Date releaseDate2 = new Date(0);
           
           Album album1 = new Album(titles1, releaseDate1);
           Album album2 = new Album(titles2, releaseDate2);
           Album album3 = new Album(titles1, releaseDate1);
           
           assertTrue(album1.equals(album3));
           assertTrue(album3.equals(album1));
           assertFalse(album1.equals(album2));
           
           assertEquals(album1.hashCode(), album3.hashCode());
       }
}
