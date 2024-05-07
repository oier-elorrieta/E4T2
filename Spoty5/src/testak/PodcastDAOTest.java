package testak;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Audioak.Podcast;
import DAO.PodcastDAO;
import master.KonexioaDB;

public class PodcastDAOTest {

    private PodcastDAO podcastDAO;

    @Test
    public void testObtenerAudiosPorPodcaster() {
        // Configurar datos de prueba
        String podcaster = "Podcaster1";
        List<String> expectedAudioIds = new ArrayList<>();
        expectedAudioIds.add("1");
        expectedAudioIds.add("2");
        expectedAudioIds.add("3");

        // Simular la conexión y la consulta a la base de datos
        try (Connection con = KonexioaDB.hasi();
             PreparedStatement stmt = con.prepareStatement("SELECT id_audio FROM podcast WHERE id_podcaster IN (SELECT id_podcaster FROM podcaster WHERE izenArtistikoa = ?)");
        ) {
            // Configurar resultados simulados de la consulta
            ResultSet rs = stmt.executeQuery();
            int i = 0;
            while (rs.next()) {
                assertEquals(expectedAudioIds.get(i), rs.getString("id_audio"));
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Error en la conexión a la base de datos: " + e.getMessage());
        }

        // Llamar al método a testear
        List<String> audioIds = podcastDAO.obtenerAudiosPorPodcaster(podcaster);

        // Verificar que los IDs de audio obtenidos coinciden con los esperados
        assertEquals(expectedAudioIds, audioIds);
    }

    @Test
    public void testObtenerPodcastPorId() {
        // Configurar datos de prueba
        int idPodcast = 1;
        Podcast expectedPodcast = new Podcast("Podcast1", 30.0, "Colaborador1, Colaborador2", 100);

        // Simular la conexión y la consulta a la base de datos
        try (Connection con = KonexioaDB.hasi();
             PreparedStatement stmt = con.prepareStatement("SELECT * FROM audio WHERE id_audio = ?");
        ) {
            // Configurar resultados simulados de la consulta
            ResultSet rs = stmt.executeQuery();
            assertTrue(rs.next());
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Error en la conexión a la base de datos: " + e.getMessage());
        }

        // Llamar al método a testear
        Podcast podcast = podcastDAO.obtenerPodcastPorId(idPodcast);

        // Verificar que el podcast obtenido coincide con el esperado
        assertEquals(expectedPodcast, podcast);
    }
}
