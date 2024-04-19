package master;

import java.sql.Date;

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
    public Free(String izena, String abizena, Date jdata, String pasahitza, Hizkuntza hizkuntza, String erabiltzailea) {
        super(izena, abizena, jdata, pasahitza, hizkuntza, erabiltzailea);
    }

}
