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
    public Podcast(String izenburua, double iraupena, String kolaboratzaileak, int erreprodukzioak) {
        super(izenburua, iraupena, kolaboratzaileak, erreprodukzioak);
    }

}