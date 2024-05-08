package testak;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Bezeroak.Free;
import Bezeroak.Premium;
import Bezeroak.Bezeroa.Hizkuntza;

public class PremiumTest {

	private static Premium p1;
    private static Premium p2;
    private static Date eguna;
    private static Date iraungitzeD;

    @Before
    public void setUp() throws Exception {
    	eguna = new Date(2024, 11, 17);
    	iraungitzeD = new Date(2024, 11,17);
        
        p1 = new Premium("hegoi", "vazquez", eguna, "vhegoi", "12345", Hizkuntza.EN, new ArrayList<>(), iraungitzeD); 
    }

//----------------------------------------- Izena --------------------------------------
    
    @Test
    public void TestGetIzena() {
    	assertEquals("hegoi", p1.getIzena());
    }
    
    @Test
    public void TestGetIzenaTxarto() {
    	assertNotEquals("hegoii", p1.getIzena());
    }

    @Test
    public void TestSetIzena() {
        p1.setIzena("irune");
        assertEquals("irune", p1.getIzena());
    }
    
    @Test
	public void TestSetIzenaTxarto() {
		p1.setIzena("irune");
		assertNotEquals("hegoi", p1.getIzena());
	}

//----------------------------------------- Abizena --------------------------------------

    @Test
    public void TestGetAbizena() {
        assertEquals("vazquez", p1.getAbizena());
    }
    
    @Test
	public void TestGetAbizenaTxarto() {
		assertNotEquals("vazuez", p1.getAbizena());
	}

    @Test
    public void TestSetAbizena() {
        p1.setAbizena("casquet");
        assertEquals("casquet", p1.getAbizena());
    }
    
    @Test
	public void TestSetAbizenaTxarto() {
		p1.setAbizena("casquet");
		assertNotEquals("vazquez", p1.getAbizena());
	}
    
//----------------------------------------- Data --------------------------------------
   
    @Test
	public void TestGetJdata() {
		assertEquals(eguna, p1.getJdata());
	}
	
	@Test
	public void TestGetJdataTxarto() {
		@SuppressWarnings("deprecation")
		Date jdata2 = new Date(2024, 11, 18);
		assertNotEquals(jdata2, p1.getJdata());
	}
	
	@Test
	public void TestSetJdata() {
		@SuppressWarnings("deprecation")
		Date jdata2 = new Date(2024, 11, 18);
		p1.setJdata(jdata2);
		assertEquals(jdata2, p1.getJdata());
	}
	
	@Test
	public void TestSetJdataTxarto() {
		@SuppressWarnings("deprecation")
		Date jdata2 = new Date(2024, 11, 18);
		p1.setJdata(jdata2);
		assertNotEquals(eguna, p1.getJdata());
	}

//----------------------------------------- Erabiltzailea --------------------------------------

	@Test
	public void TestGetErabiltzailea() {
		assertEquals("vhegoi", p1.getErabiltzailea());
	}
		
	@Test
	public void TestGetErabiltzaileaTxarto() {
		assertNotEquals("vhegoiss", p1.getErabiltzailea());
	}
	
	@Test
	public void TestSetErabiltzailea() {
		p1.setErabiltzailea("cirune");
		assertEquals("cirune", p1.getErabiltzailea());
	}
		
	@Test
	public void TestSetErabiltzaileaTxarto() {
		p1.setErabiltzailea("cirune");
		assertNotEquals("vhegoi", p1.getErabiltzailea());
	}

//----------------------------------------- Pasahitza --------------------------------------

	@Test
	public void TestGetPasahitza() {
		assertEquals("12345", p1.getPasahitza());
	}
	
	@Test
	public void TestGetPasahitzaTxarto() {
		assertNotEquals("1234@", p1.getPasahitza());
	}
	
	@Test
	public void TestSetPasahitza() {
		p1.setPasahitza("1234");
		assertEquals("1234", p1.getPasahitza());
	}
	
	@Test
	public void TestSetPasahitzaTxarto() {
		p1.setPasahitza("1234");
		assertNotEquals("12345", p1.getPasahitza());
	}

//----------------------------------------- Hizkuntza --------------------------------------

	@Test
	public void TestGetHizkuntza() {
		assertEquals(Hizkuntza.EN, p1.getHizkuntza());
	}
	
	@Test
	public void TestGetHizkuntzaTxarto() {
		assertNotEquals(Hizkuntza.AR, p1.getHizkuntza());
	}
	
	@Test
	public void TestSetHizkuntza() {
		p1.setHizkuntza(Hizkuntza.EN);
		assertEquals(Hizkuntza.EN, p1.getHizkuntza());
	}
	
	@Test
	public void TestSetHizkuntzaTxarto() {
		p1.setHizkuntza(Hizkuntza.EU);
		assertNotEquals(Hizkuntza.EN, p1.getHizkuntza());
	}
	
//----------------------------------------- IraungitzeD --------------------------------------
    
	@Test
	public void TestGetIraungitzeD() {
		assertEquals(iraungitzeD, p1.getJdata());
	}
	
	@Test
	public void TestGetIraungitzeDTxarto() {
		@SuppressWarnings("deprecation")
		Date jdata2 = new Date(2024, 11, 18);
		assertNotEquals(jdata2, p1.getJdata());
	}
	
	@Test
	public void TestSetIraungitzeD() {
		@SuppressWarnings("deprecation")
		Date jdata2 = new Date(2024, 11, 18);
		p1.setJdata(jdata2);
		assertEquals(jdata2, p1.getJdata());
	}
	
	@Test
	public void TestSetIraungitzeDTxarto() {
		@SuppressWarnings("deprecation")
		Date jdata2 = new Date(2024, 11, 18);
		p1.setJdata(jdata2);
		assertNotEquals(eguna, p1.getJdata());
	}
	
//----------------------------------------- To String --------------------------------------
	
	@Test
	public void TestToString() {
		String txt = p1.toString();
		
		String esperotakoa = "Bezeroa [izena=" + p1.getIzena() + ", abizena=" + p1.getAbizena()
		+ ", jdata=" + p1.getJdata() + ", erabiltzailea=" + p1.getErabiltzailea() + ", pasahitza="
		+ p1.getPasahitza() + ", hizkuntza=" + p1.getHizkuntza() + ", playListZerrenda=" + p1.getPlayListZerrenda()
		+ " ,jdata=" + p1.getIraungitzeData() + "]";
	}  
	
//----------------------------------------- Equals --------------------------------------


    @Test
    public void TestEqualsObjetuBerdina() {
    assertTrue(p1.equals(p1));
    }

    @Test
    public void TestEqualsNull() {
    assertFalse(p1.equals(null));
    }

    @Test
    public void TestEqualsClaseEzberdinak() {
    String txarra = "";
    assertFalse(p1.equals(txarra));
    }

    @Test
    public void TestEqualsClaseAtrBerdinak() {
    Premium p2 = new Premium("hegoi", "vazquez", eguna, "vhegoi", "12345", Hizkuntza.EN, new ArrayList<>(), iraungitzeD);
    assertTrue(p1.equals(p2));
    }
}
