package master;

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
    public Abestia(String izenburua, double iraupena, String kolaboratzaileak, int erreprodukzioak) {
        super(izenburua, iraupena, kolaboratzaileak, erreprodukzioak);
    }
    
}