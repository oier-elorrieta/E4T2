package testak;

import static org.junit.Assert.*;

import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Audioak.Abestia;
import Audioak.Album;
import DAO.AlbumDAO;
import master.KonexioaDB;

public class AlbumDAOTest {
    
    private AlbumDAO albumDAO;
    private String albumIzena;
    private Date urtea;
    private Blob irudia;

    @Test
    public void testAbestiakLortuAlbumetik() throws SQLException {
        Album album = new Album(1, "Un verano sin ti", urtea, "trap", irudia);
        album.setId_album(1); 

        List<Abestia> abestiak = AlbumDAO.abestiakLortuAlbumetik(album);

        assertFalse(abestiak.isEmpty());
    }

    @Test
    public void testAlbumLortu() throws SQLException {
        Album album = new AlbumDAO().albumLortu("Un verano sin ti");

        assertNotNull(album);
    }
}
