package master;

import java.util.ArrayList;
import java.util.Objects;

/**
 * PlayListak izeneko klase publikoa
 */
public class PlayListak {
	
	/**
     * PlayLista izango duen izena
     */
	private String Izena;
	
	/**
     * PlayListak izango duen PlayListZerrenda
     */
	private ArrayList <String> PlayListZerrenda;
	
	/**
     * PlayLista berri bat sortzeko konstruktorea izena, PlayListZerrenda
     * 
     * @param izena playlistaren izena
     * @param playListZerrenda musikarien PlayListZerrenda
     */
	public PlayListak(String izena, ArrayList<String> playListZerrenda) {
		Izena = izena;
		PlayListZerrenda = playListZerrenda;
	}
	
	 /**
     * PlayListaren izena lortzen du
     * 
     * @return Playlistaren izena
     */
	public String getIzena() {
		return Izena;
	}
	
	/**
     * PlayListaren izena ezartzen du
     * 
     * @param izena PlayListaren izena berria
     */
	public void setIzena(String izena) {
		Izena = izena;
	}
	
	/**
     * PlayListaren playlistZerrenda lortzen du
     * 
     * @return Playlistaren PlayListZerrenda
     */
	public ArrayList<String> getPlayListZerrenda() {
		return PlayListZerrenda;
	}
	
	/**
     * PlayListaren playlistZerrenda ezartzen du
	 * @param playListZerrenda PlayListaren playListZerrenda berria
     */
	public void setPlayListZerrenda(ArrayList<String> playListZerrenda) {
		PlayListZerrenda = playListZerrenda;
	}

	/**
     * Playlistaren izena eta playListZerrenda testu batean bihurtzen du objetua
     * 
     * @return PlayListaren izena eta playListZerrenda duen testu errepresentazioa
     */
	@Override
	public String toString() {
		final int maxLen = 10;
		return "PlayListak [Izena=" + Izena + ", PlayListZerrenda="
				+ (PlayListZerrenda != null ? PlayListZerrenda.subList(0, Math.min(PlayListZerrenda.size(), maxLen))
						: null)
				+ "]";
	}

	/**
     * Objetuaren hash kodea kalkulatzen du
     * 
     * @return objetuaren hash kodea
     */
	@Override
	public int hashCode() {
		return Objects.hash(Izena, PlayListZerrenda);
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
		PlayListak other = (PlayListak) obj;
		return Objects.equals(Izena, other.Izena) && Objects.equals(PlayListZerrenda, other.PlayListZerrenda);
	}
	
}
