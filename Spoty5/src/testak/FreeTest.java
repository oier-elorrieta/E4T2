package testak;

import static org.junit.Assert.*;
import java.sql.Date;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import Bezeroak.Free;
import Bezeroak.Bezeroa.Hizkuntza;

public class FreeTest {
		
	private static Free f1;
	private static Free a2;
	private static Date eguna;

	@Before
	public void setUp() throws Exception {
		eguna = new Date(2024, 11, 17);
		f1 = new Free("hegoi", "vazquez", eguna, "vhegoi", "12345", Hizkuntza.EU, new ArrayList<>());
	}
	
//----------------------------------------- Izena --------------------------------------
	
	@Test
	public void TestGetIzena() {
		assertEquals("hegoi", f1.getIzena());
	}
	
	@Test
	public void TestGetIzenaTxarto() {
		assertNotEquals("hegoii", f1.getIzena());
	}
	
	@Test
	public void TestSetIzena() {
		f1.setIzena("irune");
		assertEquals("irune", f1.getIzena());
	}
	
	@Test
	public void TestSetIzenaTxarto() {
		f1.setIzena("irune");
		assertNotEquals("hegoi", f1.getIzena());
	}
	
//----------------------------------------- Abizena --------------------------------------

	@Test
	public void TestGetAbizena() {
		assertEquals("vazquez", f1.getAbizena());
	}
	
	@Test
	public void TestGetAbizenaTxarto() {
		assertNotEquals("vazuez", f1.getAbizena());
	}
	
	@Test
	public void TestSetAbizena() {
		f1.setAbizena("casquet");
		assertEquals("casquet", f1.getAbizena());
	}
	
	@Test
	public void TestSetAbizenaTxarto() {
		f1.setAbizena("casquet");
		assertNotEquals("vazquez", f1.getAbizena());
	}
	
//----------------------------------------- Data --------------------------------------

	@Test
	public void TestGetJdata() {
		assertEquals(eguna, f1.getJdata());
	}
	
	@Test
	public void TestGetJdataTxarto() {
		@SuppressWarnings("deprecation")
		Date jdata2 = new Date(2024, 11, 18);
		assertNotEquals(jdata2, f1.getJdata());
	}
	
	@Test
	public void TestSetJdata() {
		@SuppressWarnings("deprecation")
		Date jdata2 = new Date(2024, 11, 18);
		f1.setJdata(jdata2);
		assertEquals(jdata2, f1.getJdata());
	}
	
	@Test
	public void TestSetJdataTxarto() {
		@SuppressWarnings("deprecation")
		Date jdata2 = new Date(2024, 11, 18);
		f1.setJdata(jdata2);
		assertNotEquals(eguna, f1.getJdata());
	}
	
//----------------------------------------- Erabiltzailea --------------------------------------

	@Test
	public void TestGetErabiltzailea() {
		assertEquals("vhegoi", f1.getErabiltzailea());
	}
	
	@Test
	public void TestGetErabiltzaileaTxarto() {
		assertNotEquals("vhegoiss", f1.getErabiltzailea());
	}
	
	@Test
	public void TestSetErabiltzailea() {
		f1.setErabiltzailea("cirune");
		assertEquals("cirune", f1.getErabiltzailea());
	}
	
	@Test
	public void TestSetErabiltzaileaTxarto() {
		f1.setErabiltzailea("cirune");
		assertNotEquals("vhegoi", f1.getErabiltzailea());
	}
	
//----------------------------------------- Pasahitza --------------------------------------

	@Test
	public void TestGetPasahitza() {
		assertEquals("12345", f1.getPasahitza());
	}
	
	@Test
	public void TestGetPasahitzaTxarto() {
		assertNotEquals("1234@", f1.getPasahitza());
	}
	
	@Test
	public void TestSetPasahitza() {
		f1.setPasahitza("1234");
		assertEquals("1234", f1.getPasahitza());
	}
	
	@Test
	public void TestSetPasahitzaTxarto() {
		f1.setPasahitza("1234");
		assertNotEquals("12345", f1.getPasahitza());
	}
	
//----------------------------------------- Hizkuntza --------------------------------------

	@Test
	public void TestGetHizkuntza() {
		assertEquals(Hizkuntza.EU, f1.getHizkuntza());
	}
	
	@Test
	public void TestGetHizkuntzaTxarto() {
		assertNotEquals(Hizkuntza.AR, f1.getHizkuntza());
	}
	
	@Test
	public void TestSetHizkuntza() {
		f1.setHizkuntza(Hizkuntza.EN);
		assertEquals(Hizkuntza.EN, f1.getHizkuntza());
	}
	
	@Test
	public void TestSetHizkuntzaTxarto() {
		f1.setHizkuntza(Hizkuntza.EU);
		assertNotEquals(Hizkuntza.EN, f1.getHizkuntza());
	}
	
//----------------------------------------- PlayListZerrenda --------------------------------------

	@Test
    public void TestGetPlayListZerrenda() {
        assertEquals(new ArrayList<>(), f1.getPlayListZerrenda());
    }

	@Test
	public void TestGetPlaylistZerrendaTxarto() {
	    ArrayList<String> BestePlayList = new ArrayList<>();
	    BestePlayList.add("cancion3");
	    BestePlayList.add("cancion4");

	    assertNotEquals(BestePlayList, f1.getPlayListZerrenda());
	}
	
    @Test
    public void testSetPlayListZerrenda() {
        ArrayList<String> PlayListBerria = new ArrayList<>();
        PlayListBerria.add("PlayList1");
        PlayListBerria.add("PlayList2");
        f1.setPlayListZerrenda(PlayListBerria);

        assertEquals(PlayListBerria, f1.getPlayListZerrenda());
    }
    
    @Test
    public void testSetPlayListZerrendaTxarto() {
    	f1.setPlayListZerrenda(null);
    	assertNotEquals("a", f1.getPlayListZerrenda());
    }
	
//----------------------------------------- To String --------------------------------------

    @Test
    public void TestToString() {
    	String txt = f1.toString();
    	
    	String esperotakoa = "Bezeroa [izena=" + f1.getIzena() + ", abizena=" + f1.getAbizena() 
    	+ ", jdata=" + f1.getJdata() + ", erabiltzailea=" + f1.getErabiltzailea() + ", pasahitza=" 
    	+ f1.getPasahitza() + ", hizkuntza=" + f1.getHizkuntza() + ", playListZerrenda=" + f1.getPlayListZerrenda() + "]";
    }
    
//----------------------------------------- Equals --------------------------------------

    @Test
    public void TestEqualsObjetuBerdina() {
    assertTrue(f1.equals(f1));
    }

    @Test
    public void TestEqualsNull() {
    assertFalse(f1.equals(null));
    }

    @Test
    public void TestEqualsClaseEzberdinak() {
    String txarra = "";
    assertFalse(f1.equals(txarra));
    }

    @Test
    public void TestEqualsClaseAtrBerdinak() {
    Free f2 = new Free("hegoi", "vazquez", eguna, "vhegoi", "12345", Hizkuntza.EU, new ArrayList());
    assertTrue(f1.equals(f2));
    }

}