package testak;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import master.Taldea;

public class TaldeaTest {

    @Test
       public void testConstructorAndGetters() {
           ArrayList<String> albumList = new ArrayList<>();
           albumList.add("Album1");
           albumList.add("Album2");
           albumList.add("Album3");

           Taldea taldea = new Taldea("Izena", albumList);
           
           assertEquals("Izena", taldea.getIzena());
           assertEquals(albumList, taldea.getAlbumZerrenda());
       }

       @Test
       public void testToString() {
           ArrayList<String> albumList = new ArrayList<>();
           albumList.add("Album1");
           albumList.add("Album2");
           albumList.add("Album3");

           Taldea taldea = new Taldea("Izena", albumList);
           
           String expectedString = "Musikari [AlbumZerrenda=[Album1, Album2, Album3]]";
           assertEquals(expectedString, taldea.toString());
       }

       @Test
       public void testSetAlbumZerrenda() {
           ArrayList<String> albumList = new ArrayList<>();
           albumList.add("Album1");
           albumList.add("Album2");

           Taldea taldea = new Taldea("Izena", albumList);

           ArrayList<String> newAlbumList = new ArrayList<>();
           newAlbumList.add("New Album1");
           newAlbumList.add("New Album2");
           newAlbumList.add("New Album3");

           taldea.setAlbumZerrenda(newAlbumList);

           assertEquals(newAlbumList, taldea.getAlbumZerrenda());
       }
}