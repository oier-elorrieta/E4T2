package master;

import java.util.Objects;

/**
 * Audio izeneko klase abstraktua
 */
public abstract class Audio {

	/**
	 * Audioa izango duen izenburua
	 */
    protected String Izenburua;
    
    /**
     * Audioa izangoo duen iraupena
     */
    protected double Iraupena;
    
    /**
     * Audioa izango dituen kolaboratzaileen izenak
     */
    protected String Kolaboratzaileak;
    
    /**
     * Audioa izango dituen erreprodukzio kantitateak
     */
    protected int Erreprodukzioak;
    
    /**
     * Audioa sortzeko konstruktorea izenburua, iraupena, kolaboratzaileak eta erreprodukzioarekin
     * 
     * @param izenburua audioaren izenburua
     * @param iraupena audioaren iraupena
     * @param kolaboratzaileak audioaren kolaboratzaileak
     * @param erreprodukzioak audioaren erreprodukzioak
     */
    public Audio(String izenburua, double iraupena, String kolaboratzaileak, int erreprodukzioak) {
        Izenburua = izenburua;
        Iraupena = iraupena;
        Kolaboratzaileak = kolaboratzaileak;
        Erreprodukzioak = erreprodukzioak;
    }

    /**
     * Audioaren izenburua lortzen du
     * 
     * @return audioaren izenburua
     */
    public String getIzenburua() {
        return Izenburua;
    }
    
    /**
     * Audioaren izenburua ezartzen du
     * 
     * @param izenburua audioaren izenburu berria
     */
    public void setIzenburua(String izenburua) {
        Izenburua = izenburua;
    }

    /**
     * Audioaren iraupena lortze du
     * 
     * @return audioaren iraupena
     */
    public double getIraupena() {
        return Iraupena;
    }
    
    /**
     * Audioaren iraupena ezartzen du
     * 
     * @param iraupena audioaren iraupen berria
     */
    public void setIraupena(double iraupena) {
        Iraupena = iraupena;
    }

    /**
     * Audioaren kolaboratzaileak lortzen du
     * 
     * @return audioaren kolaboratzaileak
     */
    public String getKolaboratzaileak() {
        return Kolaboratzaileak;
    }
    
    /**
     * Audioaren kolaboratzaileak ezartzen ditu
     * 
     * @param kolaboratzaileak audioaren kolaboratzaile berriak
     */
    public void setKolaboratzaileak(String kolaboratzaileak) {
        Kolaboratzaileak = kolaboratzaileak;
    }

    /**
     * Audioaren erreprodukzioak lortzen du
     * 
     * @return audioaren erreprodukzioak
     */
    public int getErreprodukzioak() {
        return Erreprodukzioak;
    }

    /**
     * Audioaren erreprodukzioak ezartzen ditu
     * 
     * @param erreprodukzioak audioaren erreprodukzio kantitae berriak
     */
    public void setErreprodukzioak(int erreprodukzioak) {
        Erreprodukzioak = erreprodukzioak;
    }

    /**
     * Audioa izenburua, iraupena, kolaboratzaileak eta erreprodukzioak testu batean bihurtzen du objetua
     * 
     * @return Artistaren izenburua, iraupena, kolaboratzaileak eta erreprodukzioak duen testu errepresentazioa
     */
    @Override
    public String toString() {
        return "Audio [Izenburua=" + Izenburua + ", Iraupena=" + Iraupena + ", Kolaboratzaileak=" + Kolaboratzaileak
                + ", Erreprodukzioak=" + Erreprodukzioak + "]";
    }

    /**
     * Objetuaren hash kodea kalkulatzen du
     * 
     * @return objetuaren hash kodea
     */
    @Override
    public int hashCode() {
        return Objects.hash(Erreprodukzioak, Iraupena, Izenburua, Kolaboratzaileak);
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
        Audio other = (Audio) obj;
        return Erreprodukzioak == other.Erreprodukzioak
                && Double.doubleToLongBits(Iraupena) == Double.doubleToLongBits(other.Iraupena)
                && Objects.equals(Izenburua, other.Izenburua)
                && Objects.equals(Kolaboratzaileak, other.Kolaboratzaileak);
    }
    
}
