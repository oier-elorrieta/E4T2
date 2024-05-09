package DAO;


import java.io.IOException;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class ErreproduzioaDAO {


	public Clip audioErreproduzitu(String abestiIzena) {
	    Clip clip = null;
	    try {
	        // Cargar el archivo de audio desde el directorio "media" dentro de la carpeta "src"
	        URL urlArchivo = getClass().getClassLoader().getResource("media/" + abestiIzena);

	        if (urlArchivo == null) {
	            System.out.println("No se pudo encontrar el archivo de audio: " + abestiIzena);
	            return null;
	        }

	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(urlArchivo);

	        // Obtener un clip de audio
	        clip = AudioSystem.getClip();

	        // Abrir el clip con el flujo de audio
	        clip.open(audioInputStream);

	        // Reproducir el clip
	        clip.start();

	        // Esperar hasta que el clip termine de reproducirse
	        while (clip.isRunning()) {
	            Thread.sleep(10);
	        }

	        // No es necesario cerrar el clip aquí

	    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
	        e.printStackTrace();
	    }
	    return clip;
	}

    private static final String SERVER_URL = "http://10.5.6.219";
    
    

    public static String lortuAudioarenURLa() {
    	String audioarenURLa = SERVER_URL ;
    	try {
    		System.out.println("ayyy");
            URL url = new URL(audioarenURLa);
            HttpURLConnection konexioa = (HttpURLConnection) url.openConnection();
            konexioa.setRequestMethod("GET");

            int erantzunKodea = konexioa.getResponseCode();
            if (erantzunKodea == HttpURLConnection.HTTP_OK) {
                System.out.println("Konexioa ondo.");
                return audioarenURLa;
            } else {
                System.out.println("ERROREA: " + erantzunKodea);
                return null;
            }
        } catch (IOException e) {
            return null;
        }
    }

    public static void erreproduzituAudioa(String audioarenURLa) {
        if (audioarenURLa != null && !audioarenURLa.isEmpty()) {
            try {
            	System.out.println("Audioaren URLa: " + audioarenURLa);
                URL url = new URL(audioarenURLa);
                BufferedInputStream bis = new BufferedInputStream(url.openStream());
                AudioInputStream ais = AudioSystem.getAudioInputStream(bis);
                Clip clip = AudioSystem.getClip();
                clip.open(ais);
                clip.start();
            } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
                System.out.println("Errorea audioa erreproduzitzean: " + e.getMessage());
            }
        } else {
            System.out.println("Errorea: Audioaren URLa hutsik edo NULL da.");
        }
    }
}