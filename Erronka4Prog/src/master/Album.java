package master;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Album izeneko klasea
 */
public class Album {
    private ArrayList<String> Izenburua;
    
    /**
     * Albuma izango duen argitaratze urtea 
     */
    private Date ArgitaratzeUrtea;
    
    /**
     * Albuma sortzeko konstruktorea izenburua eta argitaratze urtearekin
     * 
     * @param izenburua albumaren izenburua
     * @param argitaratzeUrtea albumaren argitaratze urtea
     */
    public Album(ArrayList<String> izenburua, Date argitaratzeUrtea) {
        Izenburua = izenburua;
        ArgitaratzeUrtea = argitaratzeUrtea;
    }
    
    /**
     * Albumaren izenburua lortzen du
     * 
     * @return albumaren izenburua
     */
    public ArrayList<String> getIzenburua() {
        return Izenburua;
    }
    
    /**
     * Albumaren izenburua ezartzen du
     * 
     * @param izenburua albumaren izenburu berria
     */
    public void setIzenburua(ArrayList<String> izenburua) {
        Izenburua = izenburua;
    }

    /**
     * Albumaren argitaratze urtea lortzen du
     * 
     * @return albumaren argitaratze urtea
     */
    public Date getArgitaratzeUrtea() {
        return ArgitaratzeUrtea;
    }

    /**
     * Albumaren argitaratze urtea ezartzen du
     * 
     * @param argitaratzeUrtea albumaren argitaratze urte berria
     */
    public void setArgitaratzeUrtea(Date argitaratzeUrtea) {
        ArgitaratzeUrtea = argitaratzeUrtea;
    }

    /**
     * Albumaren izenburua eta argitaratzeurtearekin testu batean bihurtzen du objetua
     * 
     * @returnf Albumaren izenburua eta argitaratze urtea duen testu errepresentazioa
     */
    @Override
    public String toString() {
        final int maxLen = 10;
        return "Album [Izenburua="
                + (Izenburua != null ? Izenburua.subList(0, Math.min(Izenburua.size(), maxLen)) : null)
                + ", ArgitaratzeUrtea=" + ArgitaratzeUrtea + "]";
    }

    /**
     * Objetuaren hash kodea kalkulatzen du
     * 
     * @return objetuaren hash kodea
     */
    @Override
    public int hashCode() {
        return Objects.hash(ArgitaratzeUrtea, Izenburua);
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
        Album other = (Album) obj;
        return Objects.equals(ArgitaratzeUrtea, other.ArgitaratzeUrtea) && Objects.equals(Izenburua, other.Izenburua);
    }
    
}
