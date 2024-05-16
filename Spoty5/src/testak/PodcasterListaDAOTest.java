package testak;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Artistak.Artista;
import Artistak.Podcaster;
import DAO.PodcasterListaDAO;
import master.KonexioaDB;

public class PodcasterListaDAOTest {

    private PodcasterListaDAO podcasterListaDAO;

    @Test
    public void testPodcasterListKargatu() throws SQLException {
        PodcasterListaDAO podcasterListaDAO = new PodcasterListaDAO();

        // Ejecutar el método a probar para obtener la lista de podcasters
        List<Artista> podcasterList = podcasterListaDAO.podcasterListKargatu();

        // Verificar que se obtiene una lista no vacía
        assertFalse(podcasterList.isEmpty());
    }

    @Test
    public void testPodcasterLortu() throws SQLException {
        PodcasterListaDAO podcasterListaDAO = new PodcasterListaDAO();

        // Ejecutar el método a probar para obtener un podcaster existente en la base de datos
        Podcaster podcaster = podcasterListaDAO.podcasterLortu("dr.sueño");

        // Verificar que se obtiene un objeto Podcaster no nulo
        assertNull(podcaster);

        // Ejecutar el método a probar para obtener un podcaster inexistente en la base de datos
        Podcaster podcasterInexistente = podcasterListaDAO.podcasterLortu("dr.sueñoo");

        // Verificar que se obtiene un objeto Podcaster nulo
        assertNull(podcasterInexistente);
    }
}
