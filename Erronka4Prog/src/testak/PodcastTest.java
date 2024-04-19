package testak;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import master.Podcast;

public class PodcastTest {

    @Test
       public void testConstructorAndGetters() {
           Podcast podcast = new Podcast("Izenburua", 30.0, "Kolaboratzaileak", 500);
           assertEquals("Izenburua", podcast.getIzenburua());
           assertEquals(30.0, podcast.getIraupena(), 0.01);
           assertEquals("Kolaboratzaileak", podcast.getKolaboratzaileak());
           assertEquals(500, podcast.getErreprodukzioak());
       }

       @Test
       public void testSetters() {
           Podcast podcast = new Podcast("Izenburua", 30.0, "Kolaboratzaileak", 500);
           podcast.setIzenburua("New Izenburua");
           podcast.setIraupena(40.0);
           podcast.setKolaboratzaileak("New Kolaboratzaileak");
           podcast.setErreprodukzioak(1000);
           assertEquals("New Izenburua", podcast.getIzenburua());
           assertEquals(40.0, podcast.getIraupena(), 0.01);
           assertEquals("New Kolaboratzaileak", podcast.getKolaboratzaileak());
           assertEquals(1000, podcast.getErreprodukzioak());
       }

       @Test
       public void testEqualsAndHashCode() {
           Podcast podcast1 = new Podcast("Izenburua", 30.0, "Kolaboratzaileak", 500);
           Podcast podcast2 = new Podcast("Izenburua", 30.0, "Kolaboratzaileak", 500);
           Podcast podcast3 = new Podcast("Beste Izenburua", 40.0, "Beste Kolaboratzaileak", 1000);

           assertEquals(podcast1, podcast2);
           assertEquals(podcast1.hashCode(), podcast2.hashCode());

           assertEquals(false, podcast1.equals(podcast3));
           assertEquals(false, podcast1.hashCode() == podcast3.hashCode());
       }

       @Test
       public void testToString() {
           Podcast podcast = new Podcast("Izenburua", 30.0, "Kolaboratzaileak", 500);
           String expectedString = "Audio [Izenburua=Izenburua, Iraupena=30.0, Kolaboratzaileak=Kolaboratzaileak, Erreprodukzioak=500]";
           assertEquals(expectedString, podcast.toString());
       }
}
