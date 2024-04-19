package master;

import java.util.Objects;

public abstract class Artistak {
    protected String Izena;

    public Artistak(String izena) {
        Izena = izena;
    }


	public void mostrar() {
        System.out.println("Artistak [Izena=" + Izena + "]");
    }


    public String getIzena() {
        return Izena;
    }


    public void setIzena(String izena) {
        Izena = izena;
    }


    @Override
    public int hashCode() {
        return Objects.hash(Izena);
    }


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


    @Override
    public String toString() {
        return "Artistak [Izena=" + Izena + "]";
    }

    
}
