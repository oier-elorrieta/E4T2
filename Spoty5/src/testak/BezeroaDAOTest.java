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

        int resultValid = bezeroaDAO.baieztatuBezeroa("icas", "haia");
        assertTrue(resultValid == BezeroaDAO.PREMIUM_USER || resultValid == BezeroaDAO.FREE_USER);

        int resultInvalidPass = bezeroaDAO.baieztatuBezeroa("icas", "12");
        assertEquals(BezeroaDAO.INVALID, resultInvalidPass);

        int resultInvalidUser = bezeroaDAO.baieztatuBezeroa("icasa", "1234");
        assertEquals(BezeroaDAO.INVALID, resultInvalidUser);
    }

    @Test
    public void testPremium() throws SQLException {
        BezeroaDAO bezeroaDAO = new BezeroaDAO();

        boolean resultPremium = bezeroaDAO.Premium("icas");

        assertTrue(resultPremium);

        boolean resultNotPremium = bezeroaDAO.Premium("hvazquez");

        assertFalse(resultNotPremium);
    }
}
