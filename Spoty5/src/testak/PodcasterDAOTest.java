package testak;

import javax.swing.ImageIcon;

import DAO.PodcasterDAO;

public class PodcasterDAOTest {

    public static void main(String[] args) {
        // Test-ea egiteko PodcasterDAO instantzia sortu
        PodcasterDAO podcasterDAO = new PodcasterDAO();

        // Test-ea PodcastPodcastertatikLortu metodoarekin egingo da
        System.out.println("Podcastak lortzen Podcaster baten izen artistikoaren arabera:");
        String[] podcasts = podcasterDAO.PodcastPodcastertatikLortu("Podcaster Izena");
        for (String podcast : podcasts) {
            System.out.println("- " + podcast);
        }

        // Test-ea PodcasterInformazioaLortu metodoarekin egingo da
        System.out.println("\nPodcasterren informazioa lortzen:");
        String informacionPodcaster = podcasterDAO.PodcasterInformazioaLortu("Podcaster Izena");
        System.out.println(informacionPodcaster);

        // Test-ea PodcasterIrudiaLortu metodoarekin egingo da
        System.out.println("\nPodcasterren irudia lortzen:");
        ImageIcon imagenPodcaster = podcasterDAO.PodcasterIrudiaLortu("Podcaster Izena");
        if (imagenPodcaster != null) {
            System.out.println("Irudia lortu da.");
        } else {
            System.out.println("Irudia ez da lortu.");
        }
    }
}
