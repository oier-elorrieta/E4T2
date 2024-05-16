package DAOTestak;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Bezeroak.Bezeroa;
import DAO.ErregistratuDAO;

public class ErregistratuDAOTest {
    
    private ErregistratuDAO erregistratuDAO;
    
    @Before
    public void setUp() {
        erregistratuDAO = new ErregistratuDAO();
    }

    @Test
    public void testErregistroaEgin() {
        String izena = "hegoi";
        String abizena = "vazquez";
        String id_hizkuntza = "ES";
        String erabiltzailea = "hvazquez";
        String pasahitza = "haia";
        String jaiotze_data = "2005-01-01";
        String erregistro_data = "2023-01-01";
        String mota = "EU";

        Bezeroa result = erregistratuDAO.erregistroaEgin(izena, abizena, id_hizkuntza, erabiltzailea, pasahitza,
                jaiotze_data, erregistro_data, mota);

        assertNotNull(result);
        assertNotEquals(erabiltzailea, result);
    }

    @Test
    public void testLortuHizkuntza() {
        try {
            String[] hizkuntzaIDs = erregistratuDAO.lortuHizkuntza();
            assertNotNull(hizkuntzaIDs);
            assertTrue(hizkuntzaIDs.length > 0);
        } catch (Exception e) {
            fail("Errorea: " + e.getMessage());
        }
    }
}
