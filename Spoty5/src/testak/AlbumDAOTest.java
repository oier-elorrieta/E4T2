package testak;

import static org.junit.Assert.*;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import DAO.AlbumDAO;
import master.KonexioaDB;

public class AlbumDAOTest {
    
    private AlbumDAO albumDAO;
    private String albumIzena;

    @Before
    public void setUp() {
        albumDAO = new AlbumDAO();
        albumIzena = "Album Izena"; // Nombre del álbum para las pruebas
    }

    @Test
    public void testAlbumAbestiakHartu() {
        // Configuración
        List<String> abestiakEsperatuak = new ArrayList<>();
        abestiakEsperatuak.add("Abestia 1");
        abestiakEsperatuak.add("Abestia 2");

        // Ejecución
        List<String> abestiak = albumDAO.albumAbestiakHartu(albumIzena);

        // Verificación
        assertEquals(abestiakEsperatuak, abestiak);
    }

    @Test
    public void testAlbumInformazioaLortu() {
        // Configuración
        String albumInformazioEsperatua = "Albumaren irteera data: Data\nGeneroa: Generoa";

        // Ejecución
        String albumInformazioa = albumDAO.AlbumInformazioaLortu(albumIzena);

        // Verificación
        assertEquals(albumInformazioEsperatua, albumInformazioa);
    }

    @Test
    public void testAlbumIrudiaLortu() {
        // Configuración
        Blob irudiaEsperatua = null; // Objeto Blob esperado

        // Ejecución
        Blob irudia = (Blob) albumDAO.AlbumIrudiaLortu(albumIzena);

        // Verificación
        assertEquals(irudiaEsperatua, irudia);
    }
}
