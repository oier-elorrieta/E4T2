package Artistak;

import java.sql.Blob;
import java.util.Objects;

/**
 * Artista izeneko klase abstraktua 
**/
public abstract class Artista {
	
	/**
	* Artista izango duen izena
	*/
    protected String Izena;
    protected static Blob irudia;

    /**
     * Artista sortzeko konstruktorea izenarekin
     * 
     * @param izena artistaren izena
     */
    public Artista(String izena, Blob irudia) {
        this.Izena = izena;
        this.irudia = irudia;
    }
    
    
    public static Blob getIrudia() {
		return irudia;
	}


	public void setIrudia(Blob irudia) {
		this.irudia = irudia;
	}


	/**
     * Artistaren izena lortzen du
     * 
     * @return artistaren izena
     */
    public String getIzena() {
        return Izena;
    }

    /**
     * Artistaren izena ezartzen du
     * 
     * @param izena artistaren izena berria
     */
    public void setIzena(String izena) {
        Izena = izena;
    }
    
    /**
     * Artistaren izenarekin testu batean bihurtzen du objetua
     * 
     * @return Artistaren izena duen testu errepresentazioa
     */
    @Override
    public String toString() {
        return "Artistak [Izena=" + Izena + "]";
    }

    /**
     * Objetuaren hash kodea kalkulatzen du
     * 
     * @return objetuaren hash kodea
     */
    @Override
    public int hashCode() {
        return Objects.hash(Izena);
    }
    
    /**
     * Komparatzen du objetua beste objetu batekin jakiteko berdin direla ala ez
     * 
     * @param zein objetuarekin konparatuko den
     * @return true objetuak berdin badira, false objetuak desberdinak badira
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Artista other = (Artista) obj;
        return Objects.equals(Izena, other.Izena);
    }
    
}
