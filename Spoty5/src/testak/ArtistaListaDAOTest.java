package testak;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Blob;
import java.util.List;

import org.junit.After;
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

    @After
    public void tearDown() {
        // Realizar tareas de limpieza si es necesario
    }

    @Test
    public void testAlbumakLortuArtistetatik() {
        Musikari musikari = new Musikari(1, "bad bunny", irudia, "si");
        List<Album> albumak = artistaDAO.AlbumakLortuArtistetatik(musikari);
        assertNotNull(albumak);
        // Añade más aserciones según sea necesario para verificar los resultados
    }

    @Test
    public void testMusikariLortu() {
        String izenMus = "nombreArtista";
        Musikari musikari = artistaDAO.musikariLortu(izenMus);
        assertNotNull(musikari);
        // Añade más aserciones según sea necesario para verificar los resultados
    }

    // Puedes añadir más métodos de prueba según lo necesites
}
