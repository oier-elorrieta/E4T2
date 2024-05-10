package DAO;

import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import master.KonexioaDB;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class PodcastDAO {

	public Clip audioErreproduzitu(String podcastIzena) {
        Clip clip = null;
        try {
            // Cargar el archivo de audio desde el directorio "media" dentro de la carpeta "src"
            URL urlArchivo = getClass().getClassLoader().getResource("media/" + podcastIzena);

            if (urlArchivo == null) {
                System.out.println("No se pudo encontrar el archivo de audio: " + podcastIzena);
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

	 public String podcastInformazioaLortu(String podcastIzena) {
	        StringBuilder podcastInformazioa = new StringBuilder();
	        Connection con = KonexioaDB.hasi(); // Obtener conexión con la base de datos
	        if (con == null) {
	            System.out.println("Ezin da konexioa egin.");
	            return "";
	        }

	        PreparedStatement stmt = null;
	        ResultSet rs = null;

	        try {
	            // Obtener la información del podcast desde la base de datos
	            String sql = "SELECT izena, iraupena FROM audio WHERE izena = ? AND mota = 'podcast'";
	            stmt = con.prepareStatement(sql);
	            stmt.setString(1, podcastIzena);
	            rs = stmt.executeQuery();

	            // Construir la información del podcast
	            if (rs.next()) {
	                String izena = rs.getString("izena");
	                String iraupena = rs.getString("iraupena");
	                podcastInformazioa.append("Podcast izena: ").append(izena).append("\n");
	                podcastInformazioa.append("Iraupena: ").append(iraupena).append("\n");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            // Cerrar la conexión y liberar recursos
	            try {
	                if (rs != null) rs.close();
	                if (stmt != null) stmt.close();
	                KonexioaDB.itxi(con);
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        return podcastInformazioa.toString();
	    }
    
    public ImageIcon podcastIrudiaLortu(String audioIzena) {
        ImageIcon podcastArgazki = null;
        Connection con = KonexioaDB.hasi(); 

        if (con == null) {
            System.out.println("Ezin da konexioa egin.");
            return podcastArgazki;
        }

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT irudia FROM audio WHERE izena = ? AND mota = 'podcast'";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, audioIzena);
            rs = stmt.executeQuery();

            if (rs.next()) {
                byte[] imageBytes = rs.getBytes("irudia");
                if (imageBytes != null) {
                    try (ByteArrayInputStream is = new ByteArrayInputStream(imageBytes)) {
                        Image image = ImageIO.read(is);
                        podcastArgazki = new ImageIcon(image);
                    }
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                KonexioaDB.itxi(con); 
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return podcastArgazki;
    }
}
