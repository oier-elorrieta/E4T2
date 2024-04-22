package master;

import java.sql.Date;
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
	public Free(String izena, String abizena, Date jdata, String erabiltzailea, String pasahitza, Hizkuntza hizkuntza,
			ArrayList<String> playListZerrenda) {
		super(izena, abizena, jdata, erabiltzailea, pasahitza, hizkuntza, playListZerrenda);
	}
}
