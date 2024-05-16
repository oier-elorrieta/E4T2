package Audioak;

import java.util.Objects;

/**
 * Erreproduzio-zerrenda bat irudikatzeko klasea.
 */
public class PlayListak {
    
    /**
     * Erreproduzio-zerrendaren izena.
     */
    private String izena;

    /**
     * Erreproduzio-zerrenda berri bat sortzeko eraikitzailea.
     * 
     * @param izena Erreproduzio-zerrendaren izena.
     */
    public PlayListak(String izena) {
        this.izena = izena;
    }

    /**
     * Erreproduzio-zerrendaren izena lortzen du.
     * 
     * @return Erreproduzio-zerrendaren izena.
     */
    public String getIzena() {
        return izena;
    }

    /**
     * Erreproduzio-zerrendaren izena ezartzen du.
     * 
     * @param izena Erreproduzio-zerrendaren izena berria.
     */
    public void setIzena(String izena) {
        this.izena = izena;
    }

    /**
     * Erreproduzio-zerrendaren testu errepresentazioa lortzen du.
     * 
     * @return Erreproduzio-zerrendaren testu errepresentazioa.
     */
    @Override
    public String toString() {
        return "PlayListak [izena=" + izena + "]";
    }

    /**
     * Objektuaren hash kodea kalkulatzen du.
     * 
     * @return Objektuaren hash kodea.
     */
    @Override
    public int hashCode() {
        return Objects.hash(izena);
    }

    /**
     * Bi objektuak berdinak diren ala ez konparatzen du.
     * 
     * @param obj Konparatzeko objektua.
     * @return True, objektuak berdinak badira; false, bestela.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PlayListak other = (PlayListak) obj;
        return Objects.equals(izena, other.izena);
    }
}
