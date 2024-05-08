package Artistak;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.Objects;
/**
 * Podcaster klasea Artistak klasearen luzapena da.
 */
public class Podcaster extends Artista{
	/**
	 * Podcasterra izango duen PodcastZerrenda
	 */
    private ArrayList<String> PodcastZerrenda;
    
    /**
     * Podcaster berri bat sortzeko konstruktorea izena, PodcastZerrenda
     * @param izena playlistaren izena
     * @param podcastZerrenda musikarien PodcastZerrenda
     */
    public Podcaster(String izena, Blob irudia, ArrayList<String> podcastZerrenda) {
        super(izena, irudia);
        PodcastZerrenda = podcastZerrenda;
    }

    /**
     * Podcasterra PodcastZerrenda lortzen du
     * 
     * @return Podcasterraren podcastZerrenda
     */
    public ArrayList<String> getPodcastZerrenda() {
        return PodcastZerrenda;
    }

    /**
     * Podcasterra PodcastZerrenda ezartzen du
     * 
     * @param podcastZerrenda Podcasterraren podcastZerrenda berria
     */
    public void setPodcastZerrenda(ArrayList<String> podcastZerrenda) {
        PodcastZerrenda = podcastZerrenda;
    }

    /**
     * Podcasterren izena eta PodcastZerrenda testu batean bihurtzen du objetua
     * 
     * @return Podcasterren izena eta podcastZerrenda duen testu errepresentazioa
     */
    @Override
	public String toString() {
		return "Podcaster [PodcastZerrenda=" + PodcastZerrenda + ", Izena=" + Izena + ", irudia=" + irudia + "]";
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
		result = prime * result + Objects.hash(PodcastZerrenda);
		return result;
	}


	/**
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
		Podcaster other = (Podcaster) obj;
		return Objects.equals(PodcastZerrenda, other.PodcastZerrenda);
	}
    
}