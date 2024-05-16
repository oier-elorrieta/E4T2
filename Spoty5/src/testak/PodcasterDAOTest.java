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

	        // Crear un objeto Podcaster para utilizarlo en la prueba
	        Podcaster podcaster = new Podcaster(1, "La Script", irudia, "ama-alaben istorio bat, denboraren joanaren eta heriotzaren beldurrari buruzko gogoeta gogor eta lotsagabea");
	        podcaster.setIzena("dr.sueño");

	        // Ejecutar el método a probar para obtener la lista de podcasts asociados al podcaster
	        List<Podcast> podcastak = podcasterDAO.podcastLortuPodcasterretik(podcaster);

	        // Verificar que se obtiene una lista no vacía
	        assertFalse(podcastak.isEmpty());
	    }

	    @Test
	    public void testPodcastLortu() throws SQLException {
	        PodcasterDAO podcasterDAO = new PodcasterDAO();

	        // Ejecutar el método a probar para obtener un podcast existente en la base de datos
	        Podcast podcast = podcasterDAO.podcastLortu("dr.sueño");

	        // Verificar que se obtiene un objeto Podcast no nulo
	        assertNull(podcast);

	        // Ejecutar el método a probar para obtener un podcast inexistente en la base de datos
	        Podcast podcastInexistente = podcasterDAO.podcastLortu("dr.sueñoo");

	        // Verificar que se obtiene un objeto Podcast nulo
	        assertNull(podcastInexistente);
	    }
}
