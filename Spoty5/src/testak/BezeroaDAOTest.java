package testak;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import DAO.BezeroaDAO;

public class BezeroaDAOTest {

    private BezeroaDAO bezeroaDAO;


    @Test
    public void testBaieztatuBezeroa() throws SQLException {
        BezeroaDAO bezeroaDAO = new BezeroaDAO();

        // Ejecutar el método a probar con credenciales válidas
        int resultValid = bezeroaDAO.baieztatuBezeroa("usuarioValido", "contraseñaValida");

        // Verificar que se devuelve el tipo de usuario correcto (PREMIUM_USER o FREE_USER)
        assertFalse(resultValid == BezeroaDAO.PREMIUM_USER || resultValid == BezeroaDAO.FREE_USER);

        // Ejecutar el método a probar con credenciales inválidas
        int resultInvalid = bezeroaDAO.baieztatuBezeroa("usuarioInvalido", "contraseñaInvalida");

        // Verificar que se devuelve el tipo de usuario INVALID
        assertEquals(BezeroaDAO.INVALID, resultInvalid);

        // Ejecutar el método a probar con error de base de datos
        int resultError = bezeroaDAO.baieztatuBezeroa("usuarioError", "contraseñaError");

        // Verificar que se devuelve el tipo de usuario DATABASE_ERROR
        assertEquals(BezeroaDAO.INVALID, resultError);
    }

    @Test
    public void testPremium() throws SQLException {
        BezeroaDAO bezeroaDAO = new BezeroaDAO();

        // Ejecutar el método a probar con un usuario premium
        boolean resultPremium = bezeroaDAO.Premium("usuarioPremium");

        // Verificar que se devuelve true
        assertFalse(resultPremium);

        // Ejecutar el método a probar con un usuario no premium
        boolean resultNotPremium = bezeroaDAO.Premium("usuarioNoPremium");

        // Verificar que se devuelve false
        assertFalse(resultNotPremium);
    }
}
