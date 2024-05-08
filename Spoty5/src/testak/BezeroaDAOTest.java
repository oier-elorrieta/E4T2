package testak;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import DAO.BezeroaDAO;
import master.KonexioaDB;

public class BezeroaDAOTest {

    private BezeroaDAO bezeroaDAO;
    private String erabiltzailea;
    private String pasahitza;

    @Before
    public void setUp() {
        bezeroaDAO = new BezeroaDAO();
        erabiltzailea = "testUser";
        pasahitza = "testPassword";
    }

    @Test
    public void testBaieztatuBezeroa() throws SQLException {
        // Insertar un usuario de prueba en la base de datos
        insertTestUser();

        // Verificar si el método de autenticación funciona correctamente
        boolean login_ok = bezeroaDAO.baieztatuBezeroa(erabiltzailea, pasahitza);
        assertTrue(login_ok);

        // Limpiar datos de prueba de la base de datos
        clearTestUser();
    }

    private void insertTestUser() throws SQLException {
        Connection con = KonexioaDB.hasi();
        PreparedStatement stmt = null;
        try {
            String sql = "INSERT INTO bezeroa (erabiltzailea, pasahitza) VALUES (?, ?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, erabiltzailea);
            stmt.setString(2, pasahitza);
            stmt.executeUpdate();
        } finally {
            if (stmt != null) stmt.close();
            if (con != null) con.close();
        }
    }

    private void clearTestUser() throws SQLException {
        Connection con = KonexioaDB.hasi();
        PreparedStatement stmt = null;
        try {
            String sql = "DELETE FROM bezeroa WHERE erabiltzailea = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, erabiltzailea);
            stmt.executeUpdate();
        } finally {
            if (stmt != null) stmt.close();
            if (con != null) con.close();
        }
    }
}
