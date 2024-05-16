package DAOTestak;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import Artistak.Artista;
import Artistak.Podcaster;
import DAO.PodcasterListaDAO;

public class PodcasterListaDAOTest {

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

        Podcaster ezsortutakoPodcast = podcasterListaDAO.podcasterLortu("dr.sueñoo");

        assertNull(ezsortutakoPodcast);
    }
}
