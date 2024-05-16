package testak;

import static org.junit.Assert.*;
import java.sql.Date;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import Bezeroak.Free;

public class FreeTest {
		
	private static Free f1;
	private static Free f2;
	private static Date eguna;

	@Before
	public void setUp() throws Exception {
		eguna = new Date(2024, 11, 17);
		f1 = new Free(1, "hegoi", "vazquez", eguna, "vhegoi", "12345", "EU", new ArrayList<>(), "Free");
	}
	
//----------------------------------------- Id --------------------------------------

	@Test
	public void testGetId() {
		assertEquals(1, f1.getId_bezeroa());
	}
	
	@Test
	public void testGetIdTxarto() {
		assertNotEquals(2, f1.getId_bezeroa());
	}
	 
	@Test
	public void testSetId() {
		f1.setId_bezeroa(3);
		assertEquals(3, f1.getId_bezeroa());
	}
	
	@Test
	public void testSetIdTxarto() {
		f1.setId_bezeroa(3);
		assertNotEquals(1, f1.getId_bezeroa());
	}
	
//----------------------------------------- Izena --------------------------------------
	
	@Test
	public void testGetIzena() {
		assertEquals("hegoi", f1.getIzena());
	}
	
	@Test
	public void testGetIzenaTxarto() {
		assertNotEquals("hegoii", f1.getIzena());
	}
	
	@Test
	public void testSetIzena() {
		f1.setIzena("irune");
		assertEquals("irune", f1.getIzena());
	}
	
	@Test
	public void testSetIzenaTxarto() {
		f1.setIzena("irune");
		assertNotEquals("hegoi", f1.getIzena());
	}
	
//----------------------------------------- Abizena --------------------------------------

	@Test
	public void testGetAbizena() {
		assertEquals("vazquez", f1.getAbizena());
	}
	
	@Test
	public void testGetAbizenaTxarto() {
		assertNotEquals("vazuez", f1.getAbizena());
	}
	
	@Test
	public void testSetAbizena() {
		f1.setAbizena("casquet");
		assertEquals("casquet", f1.getAbizena());
	}
	
	@Test
	public void testSetAbizenaTxarto() {
		f1.setAbizena("casquet");
		assertNotEquals("vazquez", f1.getAbizena());
	}
	
//----------------------------------------- Data --------------------------------------

	@Test
	public void testGetJdata() {
		assertEquals(eguna, f1.getJdata());
	}
	
	@Test
	public void testGetJdataTxarto() {
		@SuppressWarnings("deprecation")
		Date jdata2 = new Date(2024, 11, 18);
		assertNotEquals(jdata2, f1.getJdata());
	}
	
	@Test
	public void testSetJdata() {
		@SuppressWarnings("deprecation")
		Date jdata2 = new Date(2024, 11, 18);
		f1.setJdata(jdata2);
		assertEquals(jdata2, f1.getJdata());
	}
	
	@Test
	public void testSetJdataTxarto() {
		@SuppressWarnings("deprecation")
		Date jdata2 = new Date(2024, 11, 18);
		f1.setJdata(jdata2);
		assertNotEquals(eguna, f1.getJdata());
	}
	
//----------------------------------------- Erabiltzailea --------------------------------------

	@Test
	public void testGetErabiltzailea() {
		assertEquals("vhegoi", f1.getErabiltzailea());
	}
	
	@Test
	public void testGetErabiltzaileaTxarto() {
		assertNotEquals("vhegoiss", f1.getErabiltzailea());
	}
	
	@Test
	public void testSetErabiltzailea() {
		f1.setErabiltzailea("cirune");
		assertEquals("cirune", f1.getErabiltzailea());
	}
	
	@Test
	public void testSetErabiltzaileaTxarto() {
		f1.setErabiltzailea("cirune");
		assertNotEquals("vhegoi", f1.getErabiltzailea());
	}
	
//----------------------------------------- Pasahitza --------------------------------------

	@Test
	public void testGetPasahitza() {
		assertEquals("12345", f1.getPasahitza());
	}
	
	@Test
	public void testGetPasahitzaTxarto() {
		assertNotEquals("1234@", f1.getPasahitza());
	}
	
	@Test
	public void testSetPasahitza() {
		f1.setPasahitza("1234");
		assertEquals("1234", f1.getPasahitza());
	}
	
	@Test
	public void testSetPasahitzaTxarto() {
		f1.setPasahitza("1234");
		assertNotEquals("12345", f1.getPasahitza());
	}
	
//----------------------------------------- Hizkuntza --------------------------------------

	@Test
	public void testGetHizkuntza() {
		assertEquals("EU", f1.getHizkuntza());
	}
	
	@Test
	public void testGetHizkuntzaTxarto() {
		assertNotEquals("ES", f1.getHizkuntza());
	}
	
	@Test
	public void testSetHizkuntza() {
		f1.setHizkuntza("ES");
		assertEquals("ES", f1.getHizkuntza());
	}
	
	@Test
	public void testSetHizkuntzaTxarto() {
		f1.setHizkuntza("ES");
		assertNotEquals("EU", f1.getHizkuntza());
	}
	
//----------------------------------------- PlayListZerrenda --------------------------------------

	@Test
    public void testGetPlayListZerrenda() {
        assertEquals(new ArrayList<>(), f1.getPlayListZerrenda());
    }

	@Test
	public void testGetPlaylistZerrendaTxarto() {
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
    public void testToString() {
    	String txt = f1.toString();
    	
    	String esperotakoa = "Bezeroa [izena=" + f1.getIzena() + ", abizena=" + f1.getAbizena() 
    	+ ", jdata=" + f1.getJdata() + ", erabiltzailea=" + f1.getErabiltzailea() + ", pasahitza=" 
    	+ f1.getPasahitza() + ", hizkuntza=" + f1.getHizkuntza() + ", playListZerrenda=" + f1.getPlayListZerrenda() + "]";
    }
    
//----------------------------------------- Equals --------------------------------------

    @Test
    public void testEqualsObjetuBerdina() {
    assertTrue(f1.equals(f1));
    }

    @Test
    public void testEqualsNull() {
    assertFalse(f1.equals(null));
    }

    @Test
    public void testEqualsClaseEzberdinak() {
    String txarra = "";
    assertFalse(f1.equals(txarra));
    }

    @Test
    public void testEqualsClaseAtrBerdinak() {
    Free f2 = new Free(1, "hegoi", "vazquez", eguna, "vhegoi", "12345", "EU", new ArrayList(), "Free");
    assertTrue(f1.equals(f2));
    }

}