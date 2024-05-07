package Audioak;

import javazoom.jl.player.advanced.AdvancedPlayer;
import java.io.FileInputStream;

public class AudioEntzun {
    public static void reproducir(String rutaAudio) {
        try {
            FileInputStream fis = new FileInputStream(rutaAudio);
            AdvancedPlayer player = new AdvancedPlayer(fis);
            player.play();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}