package Artistak;
import java.util.ArrayList;
import java.util.Objects;
/**
* Musikari klase pribatua Artistak klasearen luzapena da.
*/
public class Musikari extends Artista {
	
	 /**
    * Musikari izango duen AlbumZerrenda
    */
   private ArrayList <String> AlbumZerrenda;
   /**
    * Musikari berri bat sortzeko konstruktorea izena, albumZerrenda
    *
    * @param izena musikarien izena
    * @param albumZerrenda musikarien albumZerrenda
    */
   public Musikari(String izena, ArrayList<String> albumZerrenda) {
		super(izena);
		AlbumZerrenda = albumZerrenda;
	}
  
	/**
    * Musikariren albumZerrenda lortzen du
    *
    * @return musikariaren albumZerrenda
    */
   public ArrayList<String> getAlbumZerrenda() {
       return AlbumZerrenda;
   }
	/**
    * Musikariren albumZerrenda ezartzen du
    *
    * @param albumZerrenda musikariren albumZerrenda berria
    */
   public void setAlbumZerrenda(ArrayList<String> albumZerrenda) {
       AlbumZerrenda = albumZerrenda;
   }
  
   /**
    * Musikariaren albumZerrenda testu batean bihurtzen du objetua
    *
    * @return Musikariaren izena eta albumZerrenda duen testu errepresentazioa
    */
   @Override
	public String toString() {
		final int maxLen = 10;
		return "Musikari [AlbumZerrenda="
				+ (AlbumZerrenda != null ? AlbumZerrenda.subList(0, Math.min(AlbumZerrenda.size(), maxLen)) : null)
				+ ", Izena=" + Izena + "]";
	}
   /**
    * Objetuaren hash kodea kalkulatzen du
    *
    * @return objetuaren hash kodea
    */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(AlbumZerrenda);
		return result;
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
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Musikari other = (Musikari) obj;
		return Objects.equals(AlbumZerrenda, other.AlbumZerrenda);
	}
  
}
