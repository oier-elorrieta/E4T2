package testak;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import Artistak.Podcaster;

public class PodcasterTest {

    @Test
    public void testConstructorAndGetters() {
        ArrayList<String> podcastList = new ArrayList<>();
        podcastList.add("Podcast1");
        podcastList.add("Podcast2");
        podcastList.add("Podcast3");

        Podcaster podcaster = new Podcaster("Izena", null, podcastList);
        
        assertEquals("Izena", podcaster.getIzena());
        assertEquals(podcastList, podcaster.getPodcastZerrenda());
    }

    @Test
    public void testToString() {
        ArrayList<String> podcastList = new ArrayList<>();
        podcastList.add("Podcast1");
        podcastList.add("Podcast2");
        podcastList.add("Podcast3");

        Podcaster podcaster = new Podcaster("Izena", null, podcastList);
        
        String expectedString = "Podcaster [PodcastZerrenda=[Podcast1, Podcast2, Podcast3], Izena=Izena]";
        assertEquals(expectedString, podcaster.toString());
    }

    @Test
    public void testSetPodcastZerrenda() {
        ArrayList<String> podcastList = new ArrayList<>();
        podcastList.add("Podcast1");
        podcastList.add("Podcast2");

        Podcaster podcaster = new Podcaster("Izena", null, podcastList);

        ArrayList<String> newPodcastList = new ArrayList<>();
        newPodcastList.add("New Podcast1");
        newPodcastList.add("New Podcast2");
        newPodcastList.add("New Podcast3");

        podcaster.setPodcastZerrenda(newPodcastList);

        assertEquals(newPodcastList, podcaster.getPodcastZerrenda());
    }
}
