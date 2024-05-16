package DAOTestak;

import static org.junit.Assert.assertNotNull;

import java.sql.Blob;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Artistak.Musikari;
import Audioak.Album;
import DAO.ArtistaDAO;

public class ArtistaListaDAOTest {

    private ArtistaDAO artistaDAO;
    private static Blob irudia;

    @Before
    public void setUp() {
        artistaDAO = new ArtistaDAO();
    }

    @Test
    public void testAlbumakLortuArtistetatik() {
        Musikari musikari = new Musikari(1, "bad bunny", irudia, "deskribapena");
        List<Album> albumak = artistaDAO.albumakLortuArtistetatik(musikari);
        assertNotNull(albumak);
    }

    @Test
    public void testMusikariLortu() {
        String izenMus = "bad bunny";
        Musikari musikari = artistaDAO.musikariLortu(izenMus);
        assertNotNull(musikari);
    }

}
