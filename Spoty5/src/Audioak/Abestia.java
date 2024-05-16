 package Audioak;

import java.sql.Blob;
import java.sql.Time;

/**
 * Abestia klasea Audio klasearen luzapena da.
 */
public class Abestia extends Audio {

	/**
	 * Abestia sortzeko konstruktorea, Audioa klasearen konstruktorea erabiliz
	 * 
	 * @param izenburua abestiaren izenburua
	 * @param iraupena abestiaren iraupena
	 * @param kolaboratzaileak abestian kolaboratu dutenak
	 * @param erreprodukzioak abestia zenbat aldiz erreproduzitu den
	 */
	public Abestia(int id_audio, String izena, Time iraupena,Blob irudia, String kolaboratzaileak, int erreprodukzioak) {
        super(id_audio, izena, iraupena, irudia, kolaboratzaileak, erreprodukzioak);
    }

	public Abestia(int id_audio, String izena, Time iraupena, Blob irudia) {
		super(id_audio, izena, iraupena,irudia);// TODO Auto-generated constructor stub
	}
    
}