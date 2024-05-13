package Artistak;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.Objects;
/**
 * Podcaster klasea Artistak klasearen luzapena da.
 */
public class Podcaster extends Artista{

    /**
     * Podcaster berri bat sortzeko konstruktorea id_artista, izena,deskribapena
     * @param izena podcaster izena
     * @param deskribapena podcasterrena
     */
    public Podcaster(int id_artista, String izena, String deskribapena) {
    	super(id_artista, izena, deskribapena);
    }

	@Override
	public String toString() {
		return "Podcaster [id_artista=" + id_artista + ", izena=" + izena + ", deskribapena=" + deskribapena + "]";
	}
    

    /**
     * Podcasterren izena eta PodcastZerrenda testu batean bihurtzen du objetua
     * 
     * @return Podcasterren izena eta podcastZerrenda duen testu errepresentazioa
     */
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	/**
     * Objetuaren hash kodea kalkulatzen du
     * 
     * @return objetuaren hash kodea
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}  

	/**
     * @param zein objetuarekin konparatuko den
     * @return true objetuak berdin badira, false objetuak desberdinak badira
     */
    }