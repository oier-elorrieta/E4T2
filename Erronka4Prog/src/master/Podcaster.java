package master;

import java.util.ArrayList;

public class Podcaster extends Artistak{
    
    private ArrayList<String> PodcastZerrenda;

    public Podcaster(String izena, ArrayList<String> podcastZerrenda) {
        super(izena);
        PodcastZerrenda = podcastZerrenda;
    }

    public ArrayList<String> getPodcastZerrenda() {
        return PodcastZerrenda;
    }

    public void setPodcastZerrenda(ArrayList<String> podcastZerrenda) {
        PodcastZerrenda = podcastZerrenda;
    }

    @Override
    public String toString() {
        final int maxLen = 10;
        return "Podcaster [PodcastZerrenda="
                + (PodcastZerrenda != null ? PodcastZerrenda.subList(0, Math.min(PodcastZerrenda.size(), maxLen))
                        : null)
                + "]";
    }
}