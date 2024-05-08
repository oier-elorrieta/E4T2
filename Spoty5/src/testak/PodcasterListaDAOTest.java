package testak;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import DAO.PodcasterListaDAO;
import master.KonexioaDB;

public class PodcasterListaDAOTest {

    private PodcasterListaDAO podcasterListaDAO;

    @Before
    public void setUp() {
        podcasterListaDAO = new PodcasterListaDAO();
    }

    @Test
    public void testPodcasterListaLortu() {
        // Simulación de la base de datos
        String[] podcastersEsperatuak = {"Podcaster1", "Podcaster2", "Podcaster3"};

        // Preparar resultados simulados de la base de datos
        try (Connection con = KonexioaDB.hasi();
             PreparedStatement stmt = con.prepareStatement("SELECT izenArtistikoa FROM podcaster");
             ResultSet rs = stmt.executeQuery()) {

            // Configurar resultados simulados
            int i = 0;
            while (rs.next()) {
                assertEquals(podcastersEsperatuak[i], rs.getString("izenArtistikoa"));
                i++;
            }
        } catch (SQLException e) {
            fail("Errorea datu basearekin konexioa egitean: " + e.getMessage());
        }

        // Ejecutar el método de obtener lista de podcasters
        String podcastersLortutako = podcasterListaDAO.PodcasterListaLortu();

        // Verificar si los podcasters obtenidos coinciden con los esperados
        for (String podcaster : podcastersEsperatuak) {
            assertTrue(podcastersLortutako.contains(podcaster));
        }
    }
}
