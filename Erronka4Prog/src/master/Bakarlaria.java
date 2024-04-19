package master;

import java.util.ArrayList;

/**
 * Bakarlaria klasea Musikari klasearen luzapena da.
 */
public class Bakarlaria extends Musikari {

	/**
	 * Bakarlaria sortzeko konstruktorea, Musikari klasearen konstuktorea erabiliz
	 * 
	 * @param izena bakarlariaren izna
	 * @param album bakarlariaren albuma
	 */
    public Bakarlaria(String izena, ArrayList<String> album) {
        super(izena, album);
    }

}
