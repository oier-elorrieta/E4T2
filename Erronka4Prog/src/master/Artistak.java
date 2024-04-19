package master;

import java.util.Objects;

/**
 * Artistak izeneko klase abstraktua 
**/
public abstract class Artistak {
	
	/**
	* Artista izango duen izena
	*/
    protected String Izena;

    /**
     * Artista sortzeko konstruktorea izenarekin
     * 
     * @param izena artistaren izena
     */
    public Artistak(String izena) {
        Izena = izena;
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
        Artistak other = (Artistak) obj;
        return Objects.equals(Izena, other.Izena);
    }
    
}
