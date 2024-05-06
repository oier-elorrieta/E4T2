package Audioak;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioEntzun {
	public static void reproducir(String rutaAudio) {
        try {
            File archivoAudio = new File(rutaAudio);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(archivoAudio);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
