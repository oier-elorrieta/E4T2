package DAOTestak;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import DAO.ArtistaDAO;
import Artistak.Musikari;
import Audioak.Album;

public class ArtistaDAOTest {
    private ArtistaDAO artistaDAO;

    @Before
    public void setUp() {
        artistaDAO = new ArtistaDAO();
    }

    @Test
    public void testAlbumakLortuArtistetatik_ValidArtist() {
        Musikari musikari = new Musikari(1, "Bad bunny", null, "Deskribapena");
        List<Album> albumak = new ArrayList<>();
        albumak.add(new Album(1, "Un verano sin ti", new Date(), "Neverita", null));
        List<Album> retrievedAlbums = artistaDAO.albumakLortuArtistetatik(musikari);
        assertNotNull(retrievedAlbums);
        assertEquals(albumak.size(), retrievedAlbums.size());
    }

    @Test
    public void testAlbumakLortuArtistetatik_NullArtist() {
        Musikari musikari = new Musikari(1, "Bad bunny", null, "Deskribapena");
        List<Album> retrievedAlbums = artistaDAO.albumakLortuArtistetatik(musikari);
        assertNotNull(retrievedAlbums);
        assertEquals(1, retrievedAlbums.size());
    }

    @Test
    public void testAlbumakLortuArtistetatik_EmptyList() {
        Musikari musikari = new Musikari(2, "Bad gyal", null, "Deskribapena2");
        List<Album> retrievedAlbums = artistaDAO.albumakLortuArtistetatik(musikari);
        assertNotNull(retrievedAlbums);
    }
}