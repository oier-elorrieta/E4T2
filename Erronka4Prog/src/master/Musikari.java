package master;

import java.util.ArrayList;
/**
 * Musikari klase abstraktua Artistak klasearen luzapena da.
 */
abstract class Musikari extends Artistak {
	
	 /**
     * Musikari izango duen AlbumZerrenda
     */
    protected ArrayList <String> AlbumZerrenda;

    /**
     * Musikari berri bat sortzeko konstruktorea izena, albumZerrenda
     * 
     * @param izena musikarien izena
     * @param albumZerrenda musikarien albumZerrenda
     */
    public Musikari(String izena, ArrayList<String> albumZerrenda) {
		super(izena);
		AlbumZerrenda = albumZerrenda;
	}

    /**
     * Musikariaren albumZerrenda testu batean bihurtzen du objetua
     * 
     * @return Musikariaren izena eta albumZerrenda duen testu errepresentazioa
     */
    @Override
	public String toString() {
		final int maxLen = 10;
		return "Musikari [AlbumZerrenda="
				+ (AlbumZerrenda != null ? AlbumZerrenda.subList(0, Math.min(AlbumZerrenda.size(), maxLen)) : null)
				+ ", Izena=" + Izena + "]";
	}
    
	/**
     * Musikariren albumZerrenda lortzen du
     * 
     * @return musikariaren albumZerrenda
     */
    public ArrayList<String> getAlbumZerrenda() {
        return AlbumZerrenda;
    }

	/**
     * Musikariren albumZerrenda ezartzen du
     * 
     * @param albumZerrenda musikariren albumZerrenda berria
     */
    public void setAlbumZerrenda(ArrayList<String> albumZerrenda) {
        AlbumZerrenda = albumZerrenda;
    }
    
    
}
