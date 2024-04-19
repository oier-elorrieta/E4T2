package master;

import java.util.ArrayList;
/**
 * Taldea klasea Musikari klasearen luzapena da.
 */
public class Taldea extends Musikari{
	/**
	 * Taldea sortzeko konstruktorea, Musikari klasearen konstuktorea erabiliz
	 * 
	 * @param izena bakarlariaren izna
	 * @param album bakarlariaren albuma
	 */
    public Taldea(String izena, ArrayList<String> album) {
        super(izena, album);
    }

}