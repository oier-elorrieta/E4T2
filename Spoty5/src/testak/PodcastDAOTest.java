package testak;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.Clip;

import org.junit.Before;
import org.junit.Test;

import Audioak.Podcast;
import DAO.PodcastDAO;
import master.KonexioaDB;

public class PodcastDAOTest {

    private PodcastDAO podcastDAO;

    @Test
    public void testPodcastLortu() throws SQLException {
        PodcastDAO podcastDAO = new PodcastDAO();

        // Ejecutar el método a probar para obtener un podcast existente en la base de datos
        Podcast podcast = podcastDAO.podcastLortu("dr.sueño");

        // Verificar que se obtiene un objeto Podcast no nulo
        assertNull(podcast);

        // Ejecutar el método a probar para obtener un podcast inexistente en la base de datos
        Podcast podcastInexistente = podcastDAO.podcastLortu("dr.sueñoo");

        // Verificar que se obtiene un objeto Podcast nulo
        assertNull(podcastInexistente);
    }

    @Test
    public void testAudioErreproduzitu() {
        PodcastDAO podcastDAO = new PodcastDAO();

        // Ejecutar el método a probar para reproducir un audio existente
        Clip clip = podcastDAO.audioErreproduzitu("blink");

        // Verificar que se obtiene un objeto Clip no nulo
        assertNotNull(clip);

        // Ejecutar el método a probar para reproducir un audio inexistente
        Clip clipInexistente = podcastDAO.audioErreproduzitu("blinkk");

        // Verificar que se obtiene un objeto Clip nulo
        assertNull(clipInexistente);
    }
}
