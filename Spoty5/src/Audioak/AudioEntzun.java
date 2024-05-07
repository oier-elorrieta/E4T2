package Audioak;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AudioEntzun {
    public static void reproducir(String rutaAudio) {
        try {
            FileInputStream fis = new FileInputStream(rutaAudio);
            AdvancedPlayer player = new AdvancedPlayer(fis);
            player.play();
        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado: " + e.getMessage());
        } catch (JavaLayerException e) {
            System.err.println("Error al reproducir el archivo: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Excepción durante la reproducción: " + e.getMessage());
            e.printStackTrace(); // Imprime la traza de la excepción
        }
    }
}