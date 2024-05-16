package testak;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;

import org.junit.Test;

import Artistak.Podcaster;
import Audioak.Podcast;
import DAO.PodcasterDAO;

public class PodcasterDAOTest {
	
	private Blob irudia;

	 @Test
	   public void testPodcastLortuPodcasterretik() throws SQLException {
	        PodcasterDAO podcasterDAO = new PodcasterDAO();

	        Podcaster podcaster = new Podcaster(1, "La Script", irudia, "ama-alaben istorio bat, denboraren joanaren eta heriotzaren beldurrari buruzko gogoeta gogor eta lotsagabea");
	        podcaster.setIzena("dr.sueño");

	        List<Podcast> podcastak = podcasterDAO.podcastLortuPodcasterretik(podcaster);

	        assertFalse(podcastak.isEmpty());
	    }

	    @Test
	    public void testPodcastLortu() throws SQLException {
	        PodcasterDAO podcasterDAO = new PodcasterDAO();

	        Podcast podcast = podcasterDAO.podcastLortu("dr.sueño");

	        assertNull(podcast);

	        Podcast podcastInexistente = podcasterDAO.podcastLortu("dr.sueñoo");

	        assertNull(podcastInexistente);
	    }
}
