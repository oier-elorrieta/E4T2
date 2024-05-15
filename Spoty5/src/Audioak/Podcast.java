package Audioak;

import java.sql.Time;
import java.util.Date;

import java.sql.Blob;

/**
 * Podcast klasea Audio klasearen luzapena da.
 */
public class Podcast extends Audio{
	
	 /**
     * Podcast berri bat sortzeko konstruktorea iraupena, kolaboratzaileak eta erreprodukzioak
     * 
     * @param iraupena podcastren iraupena
     * @param kolaboratzaileak podcastren kolaboratzaileak
     * @param erreprodukzioak podcastren erreprodukzioak
     */
    public Podcast(int id_audio, String izena, Time iraupena, Blob irudia, String kolaboratzaileak, int erreprodukzioak) {
        super(id_audio, izena, iraupena,irudia, kolaboratzaileak, erreprodukzioak);
    }
    
    public Podcast(int id_audio, String izena, Time iraupena, Blob irudia, String kolaboratzaileak) {
        super(id_audio, izena, iraupena,irudia, kolaboratzaileak);
    }
    
    public Podcast(int id_audio, String izena, Time iraupena, Blob irudia) {
        super(id_audio, izena, iraupena,irudia);
    }

}