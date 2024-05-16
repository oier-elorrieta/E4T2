package DAOTestak;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.sound.sampled.Clip;

import org.junit.Test;

import Audioak.Podcast;
import DAO.PodcastDAO;


public class PodcastDAOTest {

    @Test
    public void testPodcastLortu() throws SQLException {
        PodcastDAO podcastDAO = new PodcastDAO();

        Podcast podcast = podcastDAO.podcastLortu("Dr.sueño");

        assertNotNull(podcast);

        Podcast ezsortutakoPodcast = podcastDAO.podcastLortu("dr.sueñoo");

        assertNull(ezsortutakoPodcast);
    }

    @Test
    public void testAudioErreproduzitu() {
        PodcastDAO podcastDAO = new PodcastDAO();

        Clip clip = podcastDAO.audioErreproduzitu("Blink");

        assertNotNull(clip);

        Clip ezsortutakoClip = podcastDAO.audioErreproduzitu("blinkk");

        assertNull(ezsortutakoClip);
    }
}
