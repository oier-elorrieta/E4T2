package DAO;


import java.io.IOException;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;

import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.Timer;

import Audioak.Abestia;
import Audioak.Album;
import master.KonexioaDB;

public class ErreproduzioaDAO {
    private List<Abestia> abestiak;
    private int currentIndex = 0;
    private Clip clip;

    public ErreproduzioaDAO() {
       
    }
    
    public ErreproduzioaDAO(Album album) {
        AlbumDAO albumDAO = new AlbumDAO();
        abestiak = albumDAO.abestiakLortuAlbumetik(album);
    }

    public void urrengoAbestia() {
        if (abestiak.isEmpty()) {
            return;
        }
        
        
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
        
        currentIndex = (currentIndex + 1) % abestiak.size();
        Abestia abestia = abestiak.get(currentIndex);
        clip = audioErreproduzitu(abestia.getIzenburua());
    }

    public void pasadenAbestia() {
        if (abestiak.isEmpty()) {
            return;
        }
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
        
        currentIndex = (currentIndex - 1 + abestiak.size()) % abestiak.size();
        Abestia abestia = abestiak.get(currentIndex);
        clip = audioErreproduzitu(abestia.getIzenburua());
    }
	
	public Abestia abestiaLortu(String abestiaIzen) {
		Abestia abestia = null;
	    Connection con = KonexioaDB.hasi(); 

	    if (con == null) {
	        System.out.println("Ezin da konexioa egin.");
	       
	    }

	    PreparedStatement stmt = null;
	    ResultSet rs = null;

	    try {
		       
	        String sql = "SELECT * FROM audio WHERE izena = ? ";
	        stmt = con.prepareStatement(sql);
	        stmt.setString(1, abestiaIzen);
	        rs = stmt.executeQuery();

	        
	        while (rs.next()) {
	            int id_audio = rs.getInt("id_audio");
	            String izena = rs.getString("izena");
	            Time iraupena = rs.getTime("iraupena");
	            Blob irudia = rs.getBlob("irudia");
	            abestia = new Abestia(id_audio, izena, iraupena, irudia);


	           
	        }
	    } catch (SQLException e) {
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

	    
	    return abestia;
	}


	public Clip audioErreproduzitu(String abestiIzena) {
	    try {
	        // Cargar el archivo de audio desde el directorio "media" dentro de la carpeta "src"
	        URL urlArchivo = getClass().getClassLoader().getResource("media/" + abestiIzena + ".wav");

	        if (urlArchivo == null) {
	            System.out.println("No se pudo encontrar el archivo de audio: " + abestiIzena);
	            return null;
	        }

	        // Detener y cerrar el clip actual si está sonando y ya ha sido inicializado
	        if (clip != null && clip.isRunning()) {
	            clip.stop();
	            clip.close();
	        }

	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(urlArchivo);

	        // Obtener un clip de audio
	        clip = AudioSystem.getClip();

	        // Abrir el clip con el flujo de audio
	        clip.open(audioInputStream);

	        // Inicializar el contador
	        final int[] segundosTranscurridos = {0};

	        // Crear un timer para actualizar el contador cada segundo
	        Timer timer = new Timer(1000, e -> {
	        	 segundosTranscurridos[0]++;
	            System.out.println("Tiempo transcurrido: " + segundosTranscurridos[0] + " segundos");
	        });
	        timer.start();

	        // Reproducir el clip
	        clip.start();

	        // Esperar hasta que el clip termine de reproducirse
	        clip.addLineListener(event -> {
	            if (event.getType() == LineEvent.Type.STOP) {
	                clip.close();
	                timer.stop(); // Detener el timer cuando se detiene la reproducción
	            }
	        });

	        return clip;

	    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
	        e.printStackTrace();
	    }
	    return null;
	}

}