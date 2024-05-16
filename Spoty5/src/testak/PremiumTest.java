package testak;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Bezeroak.Free;
import Bezeroak.Premium;

public class PremiumTest {

	private static Premium p1;
    private static Premium p2;
    private static Date eguna;
    private static Date iraungitzeD;

    @Before
    public void setUp() throws Exception {
    	eguna = new Date(2024, 11, 17);
    	iraungitzeD = new Date(2024, 11,17);
        
        p1 = new Premium(1, "hegoi", "vazquez", eguna, "vhegoi", "12345", "EU", new ArrayList<>(), "Premium", iraungitzeD); 
    }
    
 //----------------------------------------- Id --------------------------------------

  	@Test
  	public void testGetId() {
  		assertEquals(1, p1.getId_bezeroa());
  	}
  	
  	@Test
  	public void testGetIdTxarto() {
  		assertNotEquals(2, p1.getId_bezeroa());
  	}
  	 
  	@Test
  	public void testSetId() {
  		p1.setId_bezeroa(3);
  		assertEquals(3, p1.getId_bezeroa());
  	}
  	
  	@Test
  	public void testSetIdTxarto() {
  		p1.setId_bezeroa(3);
  		assertNotEquals(1, p1.getId_bezeroa());
  	}

//----------------------------------------- Izena --------------------------------------
    
    @Test
    public void testGetIzena() {
    	assertEquals("hegoi", p1.getIzena());
    }
    
    @Test
    public void testGetIzenaTxarto() {
    	assertNotEquals("hegoii", p1.getIzena());
    }

    @Test
    public void testSetIzena() {
        p1.setIzena("irune");
        assertEquals("irune", p1.getIzena());
    }
    
    @Test
	public void testSetIzenaTxarto() {
		p1.setIzena("irune");
		assertNotEquals("hegoi", p1.getIzena());
	}

//----------------------------------------- Abizena --------------------------------------

    @Test
    public void testGetAbizena() {
        assertEquals("vazquez", p1.getAbizena());
    }
    
    @Test
	public void testGetAbizenaTxarto() {
		assertNotEquals("vazuez", p1.getAbizena());
	}

    @Test
    public void testSetAbizena() {
        p1.setAbizena("casquet");
        assertEquals("casquet", p1.getAbizena());
    }
    
    @Test
	public void testSetAbizenaTxarto() {
		p1.setAbizena("casquet");
		assertNotEquals("vazquez", p1.getAbizena());
	}
    
//----------------------------------------- Data --------------------------------------
   
    @Test
	public void testGetJdata() {
		assertEquals(eguna, p1.getJdata());
	}
	
	@Test
	public void testGetJdataTxarto() {
		@SuppressWarnings("deprecation")
		Date jdata2 = new Date(2024, 11, 18);
		assertNotEquals(jdata2, p1.getJdata());
	}
	
	@Test
	public void testSetJdata() {
		@SuppressWarnings("deprecation")
		Date jdata2 = new Date(2024, 11, 18);
		p1.setJdata(jdata2);
		assertEquals(jdata2, p1.getJdata());
	}
	
	@Test
	public void testSetJdataTxarto() {
		@SuppressWarnings("deprecation")
		Date jdata2 = new Date(2024, 11, 18);
		p1.setJdata(jdata2);
		assertNotEquals(eguna, p1.getJdata());
	}

//----------------------------------------- Erabiltzailea --------------------------------------

	@Test
	public void testGetErabiltzailea() {
		assertEquals("vhegoi", p1.getErabiltzailea());
	}
		
	@Test
	public void testGetErabiltzaileaTxarto() {
		assertNotEquals("vhegoiss", p1.getErabiltzailea());
	}
	
	@Test
	public void testSetErabiltzailea() {
		p1.setErabiltzailea("cirune");
		assertEquals("cirune", p1.getErabiltzailea());
	}
		
	@Test
	public void testSetErabiltzaileaTxarto() {
		p1.setErabiltzailea("cirune");
		assertNotEquals("vhegoi", p1.getErabiltzailea());
	}

//----------------------------------------- Pasahitza --------------------------------------

	@Test
	public void testGetPasahitza() {
		assertEquals("12345", p1.getPasahitza());
	}
	
	@Test
	public void testGetPasahitzaTxarto() {
		assertNotEquals("1234@", p1.getPasahitza());
	}
	
	@Test
	public void testSetPasahitza() {
		p1.setPasahitza("1234");
		assertEquals("1234", p1.getPasahitza());
	}
	
	@Test
	public void testSetPasahitzaTxarto() {
		p1.setPasahitza("1234");
		assertNotEquals("12345", p1.getPasahitza());
	}

//----------------------------------------- Hizkuntza --------------------------------------

	@Test
	public void testGetHizkuntza() {
		assertEquals("EU", p1.getHizkuntza());
	}
	
	@Test
	public void testGetHizkuntzaTxarto() {
		assertNotEquals("ES", p1.getHizkuntza());
	}
	
	@Test
	public void testSetHizkuntza() {
		p1.setHizkuntza("ES");
		assertEquals("ES", p1.getHizkuntza());
	}
	
	@Test
	public void testSetHizkuntzaTxarto() {
		p1.setHizkuntza("ES");
		assertNotEquals("EU", p1.getHizkuntza());
	}
	
//----------------------------------------- IraungitzeD --------------------------------------
    
	@Test
	public void testGetIraungitzeD() {
		assertEquals(iraungitzeD, p1.getJdata());
	}
	
	@Test
	public void testGetIraungitzeDTxarto() {
		@SuppressWarnings("deprecation")
		Date jdata2 = new Date(2024, 11, 18);
		assertNotEquals(jdata2, p1.getJdata());
	}
	
	@Test
	public void testSetIraungitzeD() {
		@SuppressWarnings("deprecation")
		Date jdata2 = new Date(2024, 11, 18);
		p1.setJdata(jdata2);
		assertEquals(jdata2, p1.getJdata());
	}
	
	@Test
	public void testSetIraungitzeDTxarto() {
		@SuppressWarnings("deprecation")
		Date jdata2 = new Date(2024, 11, 18);
		p1.setJdata(jdata2);
		assertNotEquals(eguna, p1.getJdata());
	}
	
//----------------------------------------- To String --------------------------------------
	
	@Test
	public void testToString() {
		String txt = p1.toString();
		
		String esperotakoa = "Bezeroa [izena=" + p1.getIzena() + ", abizena=" + p1.getAbizena()
		+ ", jdata=" + p1.getJdata() + ", erabiltzailea=" + p1.getErabiltzailea() + ", pasahitza="
		+ p1.getPasahitza() + ", hizkuntza=" + p1.getHizkuntza() + ", playListZerrenda=" + p1.getPlayListZerrenda()
		+ " ,jdata=" + p1.getIraungitzeData() + "]";
	}  
	
//----------------------------------------- Equals --------------------------------------


    @Test
    public void testEqualsObjetuBerdina() {
    assertTrue(p1.equals(p1));
    }

    @Test
    public void testEqualsNull() {
    assertFalse(p1.equals(null));
    }

    @Test
    public void testEqualsClaseEzberdinak() {
    String txarra = "";
    assertFalse(p1.equals(txarra));
    }

    @Test
    public void testEqualsClaseAtrBerdinak() {
    Premium p2 = new Premium(1, "hegoi", "vazquez", eguna, "vhegoi", "12345", "EU", new ArrayList<>(), "Premium", iraungitzeD);
    assertTrue(p1.equals(p2));
    }
}
