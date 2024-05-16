package testak;
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
        Musikari musikari = new Musikari(1, "Artista1", null, "Descripción Artista1");
        List<Album> albumak = new ArrayList<>();
        albumak.add(new Album(1, "Album1", new Date(), "Rock", null));
        List<Album> retrievedAlbums = artistaDAO.AlbumakLortuArtistetatik(musikari);
        assertNotNull(retrievedAlbums);
        assertEquals(albumak.size(), retrievedAlbums.size());
    }

    @Test
    public void testAlbumakLortuArtistetatik_NullArtist() {
        Musikari musikari = new Musikari(1, "Artista1", null, "Descripción Artista1");
        List<Album> retrievedAlbums = artistaDAO.AlbumakLortuArtistetatik(musikari);
        assertNotNull(retrievedAlbums);
        assertEquals(1, retrievedAlbums.size());
    }

    @Test
    public void testAlbumakLortuArtistetatik_EmptyList() {
        Musikari musikari = new Musikari(2, "Artista2", null, "Descripción Artista2");
        List<Album> retrievedAlbums = artistaDAO.AlbumakLortuArtistetatik(musikari);
        assertNotNull(retrievedAlbums);
    }
}