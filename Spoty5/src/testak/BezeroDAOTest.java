package testak;

import static org.junit.Assert.*;

import org.junit.Test;

import DAO.BezeroaDAO;

public class BezeroDAOTest {

	@Test
    public void testBaieztatuAdmin() {
        BezeroaDAO bezeroaDAO = new BezeroaDAO();
        
        // Erabiltzaile eta pasahitza ONAK
        boolean emaitzaOndo = bezeroaDAO.baieztatuAdmin("icas", "haia");
        assertTrue(emaitzaOndo);
        
        // Erabiltzaile ONDO, pasahitza TXARTO
        boolean emaitza1 = bezeroaDAO.baieztatuAdmin("icas", "1234");
        assertFalse(emaitza1);
        
        // Erabiltzaile eta pasahitza TXARTO
        boolean emaitzaTxarto = bezeroaDAO.baieztatuAdmin("kkk", "1111");
        assertFalse(emaitzaTxarto);
	}
}
