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

        List<Artista> podcasterList = podcasterListaDAO.podcasterListKargatu();

        assertFalse(podcasterList.isEmpty());
    }

    @Test
    public void testPodcasterLortu() throws SQLException {
        PodcasterListaDAO podcasterListaDAO = new PodcasterListaDAO();

        Podcaster podcaster = podcasterListaDAO.podcasterLortu("dr.sueño");

        assertNull(podcaster);

        Podcaster podcasterInexistente = podcasterListaDAO.podcasterLortu("dr.sueñoo");

        assertNull(podcasterInexistente);
    }
}
