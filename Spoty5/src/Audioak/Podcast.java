package Audioak;

/**
 * Podcast klasea Audio klasearen luzapena da.
 */
public class Podcast extends Audio{
	
	 /**
     * Podcast berri bat sortzeko konstruktorea izenburua, iraupena, kolaboratzaileak eta erreprodukzioak
     * 
     * @param izenburua podcastren izenburua
     * @param iraupena podcastren iraupena
     * @param kolaboratzaileak podcastren kolaboratzaileak
     * @param erreprodukzioak podcastren erreprodukzioak
     */
    public Podcast(int id_audio, String izena, double iraupena, String kolaboratzaileak, int erreprodukzioak) {
        super(id_audio, izena, iraupena, kolaboratzaileak, erreprodukzioak);
    }

}