package testak;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import DAO.MusikariListaDAO;
import master.KonexioaDB;

public class ArtistaListaDAOTest {

    private MusikariListaDAO artistaListaDAO;

    @Before
    public void setUp() {
        artistaListaDAO = new MusikariListaDAO();
    }

    @Test
    public void testArtistaListaLortu() throws SQLException {
        // Simulación de la base de datos
        String[] artistakEsperatuak = {"Bad Bunny", "Bad Gyal", "Coldplay"};

        // Preparar resultados simulados de la base de datos
        try (Connection con = KonexioaDB.hasi();
             PreparedStatement stmt = con.prepareStatement("SELECT izenArtistikoa FROM musikaria");
             ResultSet rs = stmt.executeQuery()) {

            // Configurar resultados simulados
            int i = 0;
            while (rs.next()) {
                assertEquals(artistakEsperatuak[i], rs.getString("izenArtistikoa"));
                i++;
            }
        } catch (SQLException e) {
            fail("Errorea datu basearekin konexioa egitean: " + e.getMessage());
        }

        // Ejecutar el método de obtener lista de artistas
        String artistakLortutako = artistaListaDAO.ArtistaListaLortu();

        // Verificar si los artistas obtenidos coinciden con los esperados
        assertEquals(String.join("\n", artistakEsperatuak) + "\n", artistakLortutako);
    }
}
