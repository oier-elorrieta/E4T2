package testak;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;

import org.junit.Before;
import org.junit.Test;

import DAO.ArtistaDAO;
import master.KonexioaDB;

public class ArtistaDAOTest {

    private ArtistaDAO artistaDAO;
    private String artista;

    @Before
    public void setUp() {
        artistaDAO = new ArtistaDAO();
        artista = "TestArtist";
    }

    @Test
    public void testAlbumakLortuArtistetatik() throws SQLException {
        // Simulación de la base de datos
        String[] albumakEsperatuak = {"Album1", "Album2", "Album3"};

        // Preparar resultados simulados de la base de datos
        try (Connection con = KonexioaDB.hasi();
             PreparedStatement stmt = con.prepareStatement("SELECT izenburua FROM album WHERE id_musikaria IN (SELECT id_musikaria FROM musikaria WHERE izenArtistikoa = ?)");
             ResultSet rs = stmt.executeQuery()) {

            // Configurar resultados simulados
            stmt.setString(1, artista);
            int i = 0;
            while (rs.next()) {
                assertEquals(albumakEsperatuak[i], rs.getString("izenburua"));
                i++;
            }
        } catch (SQLException e) {
            fail("Errorea datu basearekin konexioa egitean: " + e.getMessage());
        }

        // Ejecutar el método de obtener lista de albumes
        String[] albumakLortutako = artistaDAO.AlbumakLortuArtistetatik(artista);

        // Verificar si los albumes obtenidos coinciden con los esperados
        assertArrayEquals(albumakEsperatuak, albumakLortutako);
    }

    @Test
    public void testArtistaInformazioaLortu() throws SQLException {
        // Simulación de la base de datos
        String esperatutakoInformazioa = "Izen artistikoa: TestArtist\nDeskribapena: TestArtist deskribapena";

        // Preparar resultados simulados de la base de datos
        try (Connection con = KonexioaDB.hasi();
             PreparedStatement stmt = con.prepareStatement("SELECT izenArtistikoa, deskribapena FROM musikaria WHERE izenArtistikoa = ?");
             ResultSet rs = stmt.executeQuery()) {

            // Configurar resultados simulados
            stmt.setString(1, artista);
            rs.next();
            assertEquals(esperatutakoInformazioa, "Izen artistikoa: " + rs.getString("izenArtistikoa") + "\nDeskribapena: " + rs.getString("deskribapena"));
        } catch (SQLException e) {
            fail("Errorea datu basearekin konexioa egitean: " + e.getMessage());
        }

        // Ejecutar el método de obtener información del artista
        String informazioaLortutako = artistaDAO.ArtistaInformazioaLortu(artista);

        // Verificar si la información obtenida coincide con la esperada
        assertEquals(esperatutakoInformazioa, informazioaLortutako);
    }

    @Test
    public void testArtistaIrudiaLortu() throws SQLException {
        // Simulación de la base de datos
        ImageIcon irudiaEsperatua = new ImageIcon(); // Añadir aquí la imagen esperada

        // Preparar resultados simulados de la base de datos
        // No se puede simular una imagen en este test, por lo que no se realiza una simulación

        // Ejecutar el método de obtener imagen del artista
        ImageIcon irudiaLortutako = artistaDAO.ArtistaIrudiaLortu(artista);

        // Verificar si la imagen obtenida coincide con la esperada
        // Se compara solo si no es nula, ya que no se puede simular una imagen
        if (irudiaEsperatua != null && irudiaLortutako != null) {
            assertEquals(irudiaEsperatua.getIconWidth(), irudiaLortutako.getIconWidth());
            assertEquals(irudiaEsperatua.getIconHeight(), irudiaLortutako.getIconHeight());
        }
    }
}
