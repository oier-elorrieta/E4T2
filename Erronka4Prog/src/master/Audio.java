package master;

import java.util.Objects;

public abstract class Audio {

    protected String Izenburua;
    protected double Iraupena;
    protected String Kolaboratzaileak;
    protected int Erreprodukzioak;
    
    public Audio(String izenburua, double iraupena, String kolaboratzaileak, int erreprodukzioak) {
        Izenburua = izenburua;
        Iraupena = iraupena;
        Kolaboratzaileak = kolaboratzaileak;
        Erreprodukzioak = erreprodukzioak;
    }

    public String getIzenburua() {
        return Izenburua;
    }

    public double getIraupena() {
        return Iraupena;
    }

    public String getKolaboratzaileak() {
        return Kolaboratzaileak;
    }

    public int getErreprodukzioak() {
        return Erreprodukzioak;
    }

    public void setIzenburua(String izenburua) {
        Izenburua = izenburua;
    }

    public void setIraupena(double iraupena) {
        Iraupena = iraupena;
    }

    public void setKolaboratzaileak(String kolaboratzaileak) {
        Kolaboratzaileak = kolaboratzaileak;
    }

    public void setErreprodukzioak(int erreprodukzioak) {
        Erreprodukzioak = erreprodukzioak;
    }

    @Override
    public String toString() {
        return "Audio [Izenburua=" + Izenburua + ", Iraupena=" + Iraupena + ", Kolaboratzaileak=" + Kolaboratzaileak
                + ", Erreprodukzioak=" + Erreprodukzioak + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(Erreprodukzioak, Iraupena, Izenburua, Kolaboratzaileak);
    }

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
