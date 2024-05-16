package testak;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import DAO.NirePlayListDAO;
import master.KonexioaDB;

public class NirePlayListDAOTest {

    @Test
    public void testBezeroPlayListZerrenda() {
        // Configurar datos de prueba
        String erabiltzaileIzena = "usuario_prueba";
        List<String> expectedPlayList = new ArrayList<>();
        expectedPlayList.add("Playlist1");
        expectedPlayList.add("Playlist2");
        expectedPlayList.add("Playlist3");

        // Simular la conexión y la consulta a la base de datos
        try (Connection con = KonexioaDB.hasi();
             PreparedStatement stmt = con.prepareStatement("SELECT izenburua FROM playlist WHERE id_bezeroa = ?");
        ) {
            // Configurar resultados simulados de la consulta
            ResultSet rs = stmt.executeQuery();
            int i = 0;
            while (rs.next()) {
                assertEquals(expectedPlayList.get(i), rs.getString("izenburua"));
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Error en la conexión a la base de datos: " + e.getMessage());
        }

        // Llamar al método a testear
        List<String> playListZerrenda = NirePlayListDAO.BezeroPlayListZerrenda(erabiltzaileIzena);

        // Verificar que la lista obtenida coincide con la esperada
        assertEquals(expectedPlayList, playListZerrenda);
    }
}
