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
        // Crear un objeto Album para utilizarlo en la prueba
        Album album = new Album(1, "Un verano sin ti", urtea, "trap", irudia);
        album.setId_album(1); // Aquí establece el ID del álbum que quieres probar

        // Ejecutar el método a probar
        List<Abestia> abestiak = AlbumDAO.abestiakLortuAlbumetik(album);

        // Verificar que la lista no esté vacía
        assertFalse(abestiak.isEmpty());
    }

    @Test
    public void testAlbumLortu() throws SQLException {
        // Ejecutar el método a probar
        Album album = new AlbumDAO().albumLortu("Un verano sin ti");

        // Verificar que el objeto Album no sea nulo
        assertNotNull(album);
    }
}
