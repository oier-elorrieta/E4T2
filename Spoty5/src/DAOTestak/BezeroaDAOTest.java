package DAOTestak;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import Bezeroak.Bezeroa;
import Bezeroak.Free;
import Bezeroak.Premium;
import DAO.BezeroaDAO;

public class BezeroaDAOTest {
    
	 private BezeroaDAO bezeroaDAO;
	    
	    @Before
	    public void setUp() {
	        bezeroaDAO = new BezeroaDAO();
	    }
	    
	    @Test
	    public void testBezeroaLortuFree() throws SQLException {
	        String erabiltzailea = "hvazquez";
	        String pasahitza = "haia";

	        Bezeroa esperotakoBezeroa = new Free(3, "Hegoi", "Vazquez", null, "hvazquez", "haia", "ES", "free");

	        Bezeroa ateratakoBezeroa = bezeroaDAO.bezeroaLortu(erabiltzailea, pasahitza);

	        assertNotNull(ateratakoBezeroa);
	        assertEquals(esperotakoBezeroa.getClass(), ateratakoBezeroa.getClass());
	        assertEquals(esperotakoBezeroa.getId_bezeroa(), ateratakoBezeroa.getId_bezeroa());
	        assertEquals(esperotakoBezeroa.getIzena(), ateratakoBezeroa.getIzena());
	        assertEquals(esperotakoBezeroa.getAbizena(), ateratakoBezeroa.getAbizena());
	        assertEquals(esperotakoBezeroa.getErabiltzailea(), ateratakoBezeroa.getErabiltzailea());
	        assertEquals(esperotakoBezeroa.getPasahitza(), ateratakoBezeroa.getPasahitza());
	        assertEquals(esperotakoBezeroa.getHizkuntza(), ateratakoBezeroa.getHizkuntza());
	        assertEquals(esperotakoBezeroa.getMota(), ateratakoBezeroa.getMota());
	    }

	    @Test
	    public void testBezeroaLortuPremium() throws SQLException {
	        String erabiltzailea = "icas";
	        String pasahitza = "haia";

	        Bezeroa esperotakoBezeroa = new Premium(1, "Irune", "Casquet", null, "icas", "haia", "ES", null, "premium", null);

	        Bezeroa ateratakoBezeroa = bezeroaDAO.bezeroaLortu(erabiltzailea, pasahitza);

	        assertNotNull(ateratakoBezeroa);
	        assertEquals(esperotakoBezeroa.getClass(), ateratakoBezeroa.getClass());
	        assertEquals(esperotakoBezeroa.getId_bezeroa(), ateratakoBezeroa.getId_bezeroa());
	        assertEquals(esperotakoBezeroa.getIzena(), ateratakoBezeroa.getIzena());
	        assertEquals(esperotakoBezeroa.getAbizena(), ateratakoBezeroa.getAbizena());
	        assertEquals(esperotakoBezeroa.getErabiltzailea(), ateratakoBezeroa.getErabiltzailea());
	        assertEquals(esperotakoBezeroa.getPasahitza(), ateratakoBezeroa.getPasahitza());
	        assertEquals(esperotakoBezeroa.getHizkuntza(), ateratakoBezeroa.getHizkuntza());
	        assertEquals(esperotakoBezeroa.getMota(), ateratakoBezeroa.getMota());
	    }
}