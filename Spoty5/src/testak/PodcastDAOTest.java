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

        Podcast podcast = podcastDAO.podcastLortu("Dr.sueño");

        assertNotNull(podcast);

        Podcast podcastInexistente = podcastDAO.podcastLortu("dr.sueñoo");

        assertNull(podcastInexistente);
    }

    @Test
    public void testAudioErreproduzitu() {
        PodcastDAO podcastDAO = new PodcastDAO();

        Clip clip = podcastDAO.audioErreproduzitu("Blink");

        assertNotNull(clip);

        Clip clipInexistente = podcastDAO.audioErreproduzitu("blinkk");

        assertNull(clipInexistente);
    }
}
