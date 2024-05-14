package Audioak;

import java.util.Date;

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
    public Podcast(int id_audio, String izena, Date iraupena, String kolaboratzaileak, int erreprodukzioak) {
        super(id_audio, izena, iraupena, kolaboratzaileak, erreprodukzioak);
    }

}