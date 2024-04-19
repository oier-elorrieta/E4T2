package master;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Objects;

public class Album {
    private ArrayList<String> Izenburua;
    private Date ArgitaratzeUrtea;
    
    public Album(ArrayList<String> izenburua, Date argitaratzeUrtea) {
        Izenburua = izenburua;
        ArgitaratzeUrtea = argitaratzeUrtea;
    }
    
    public ArrayList<String> getIzenburua() {
        return Izenburua;
    }

    public Date getArgitaratzeUrtea() {
        return ArgitaratzeUrtea;
    }

    public void setIzenburua(ArrayList<String> izenburua) {
        Izenburua = izenburua;
    }

    public void setArgitaratzeUrtea(Date argitaratzeUrtea) {
        ArgitaratzeUrtea = argitaratzeUrtea;
    }

    @Override
    public String toString() {
        final int maxLen = 10;
        return "Album [Izenburua="
                + (Izenburua != null ? Izenburua.subList(0, Math.min(Izenburua.size(), maxLen)) : null)
                + ", ArgitaratzeUrtea=" + ArgitaratzeUrtea + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(ArgitaratzeUrtea, Izenburua);
    }

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
