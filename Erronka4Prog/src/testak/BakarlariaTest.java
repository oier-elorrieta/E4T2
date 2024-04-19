package testak;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import master.Bakarlaria;

public class BakarlariaTest {

    @Test
    public void testConstructorAndGetters() {
        ArrayList<String> albumList = new ArrayList<>();
        albumList.add("Album1");
        albumList.add("Album2");
        albumList.add("Album3");

        Bakarlaria bakarlaria = new Bakarlaria("Izena", albumList);
        
        assertEquals("Izena", bakarlaria.getIzena());
        assertEquals(albumList, bakarlaria.getAlbumZerrenda());
    }

    @Test
    public void testToString() {
        ArrayList<String> albumList = new ArrayList<>();
        albumList.add("Album1");
        albumList.add("Album2");
        albumList.add("Album3");

        Bakarlaria bakarlaria = new Bakarlaria("Izena", albumList);
        
        String expectedString = "Musikari [AlbumZerrenda=[Album1, Album2, Album3]]";
        assertEquals(expectedString, bakarlaria.toString());
    }

    @Test
    public void testSetAlbumZerrenda() {
        ArrayList<String> albumList = new ArrayList<>();
        albumList.add("Album1");
        albumList.add("Album2");

        Bakarlaria bakarlaria = new Bakarlaria("Izena", albumList);

        ArrayList<String> newAlbumList = new ArrayList<>();
        newAlbumList.add("New Album1");
        newAlbumList.add("New Album2");
        newAlbumList.add("New Album3");

        bakarlaria.setAlbumZerrenda(newAlbumList);

        assertEquals(newAlbumList, bakarlaria.getAlbumZerrenda());
    }
}