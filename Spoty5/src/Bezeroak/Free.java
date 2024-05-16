package Bezeroak;

import java.util.Date;
import java.util.ArrayList;

/**
 * Free klasea Bezeroa klasearen luzapena da.
 */
public class Free extends Bezeroa {


	/**
	 * Free sortzeko konstruktorea, Bezeroa klasearen konstruktorea erabiliz
	 * 
	 * @param izena FreeBezeroaren izena
	 * @param abizena FreeBezeroaren abizena
	 * @param jdata FreeBezeroaren jaiotze data
	 * @param pasahitza FreeBezeroaren pasahitza
	 * @param hizkuntza FreeBezeroaren gustokoaren hizkuntza
	 * @param erabiltzailea FreeBezeroaren erabiltzailea
	 */
	public Free(int id_bezeroa, String izena, String abizena, Date jdata, String erabiltzailea, String pasahitza,
			Hizkuntza hizkuntza, ArrayList<String> playListZerrenda) {
		super(id_bezeroa, izena, abizena, jdata, erabiltzailea, pasahitza, hizkuntza, playListZerrenda);
		// TODO Auto-generated constructor stub
	}

	public Free(int id_bezeroa, String izena, String abizena, Date jdata, String erabiltzailea, String pasahitza) {
		super(id_bezeroa, izena, abizena, jdata, erabiltzailea, pasahitza);
		// TODO Auto-generated constructor stub
	}

	public Free(String erabiltzailea, String pasahitza) {
		super(erabiltzailea, pasahitza);
		// TODO Auto-generated constructor stub
	}
}
