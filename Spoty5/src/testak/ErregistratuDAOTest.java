package testak;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Bezeroak.Mota;
import DAO.ErregistratuDAO;
import master.KonexioaDB;

public class ErregistratuDAOTest {

    private ErregistratuDAO erregistratuDAO;
    private String izena;
    private String abizena;
    private String id_hizkuntza;
    private String erabiltzailea;
    private String pasahitza;
    private String jaiotze_data;
    private String erregistro_data;
    private Mota mota;

    @Before
    public void setUp() {
        erregistratuDAO = new ErregistratuDAO();
        izena = "John";
        abizena = "Doe";
        id_hizkuntza = "es"; // Hizkuntzaren ID-a
        erabiltzailea = "johndoe";
        pasahitza = "password";
        jaiotze_data = "2000-01-01"; // Data formatuan "YYYY-MM-DD"
        erregistro_data = "2022-05-01"; // Data formatuan "YYYY-MM-DD"
        mota = Mota.FREE; // Erabiltzailearen mota (FREE, PREMIUM)
    }

    @Test
    public void testErregistroaEgin() {
        // Ejecutar el método de registro
        String erabiltzaileIzena = erregistratuDAO.erregistroaEgin(izena, abizena, id_hizkuntza, erabiltzailea, pasahitza,
                jaiotze_data, erregistro_data, mota);

        // Verificar si el nombre de usuario es el esperado
        assertEquals(erabiltzailea, erabiltzaileIzena);

        // Verificar si el usuario está en la base de datos
        try (Connection con = KonexioaDB.hasi();
                PreparedStatement stmt = con.prepareStatement("SELECT * FROM bezeroa WHERE erabiltzailea = ?")) {
            stmt.setString(1, erabiltzailea);
            try (ResultSet rs = stmt.executeQuery()) {
                assertTrue(rs.next()); // El usuario debe existir en la base de datos
            }
        } catch (SQLException e) {
            fail("Errorea datu basearekin konexioa egitean: " + e.getMessage());
        }
    }

    @Test
    public void testLortuHizkuntza() {
        // Ejecutar el método para obtener la lista de IDs de idiomas
        String[] hizkuntzaIds;
        try {
            hizkuntzaIds = erregistratuDAO.lortuHizkuntza();
        } catch (Exception e) {
            fail("Errorea hizkuntza ID-ak lortzean: " + e.getMessage());
            return;
        }

        // Verificar si se han obtenido algunos IDs de idiomas
        assertTrue(hizkuntzaIds.length > 0);
    }
}

