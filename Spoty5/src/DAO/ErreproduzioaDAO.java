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

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;

import master.KonexioaDB;

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
	
	
	
	public ImageIcon AbestiIrudiaLortu(String audioIzena) {
	    ImageIcon abestiArgazki = null;
	    
	    Connection con = KonexioaDB.hasi(); 
	    if (con == null) {
	        System.out.println("Ezin da konexioa egin.");
	        return abestiArgazki;
	    }
	    PreparedStatement stmt = null;
	    ResultSet rs = null;

	    try {
	       
	        String sql = "SELECT irudia FROM audio WHERE izena = ?";
	        stmt = con.prepareStatement(sql);
	        stmt.setString(1, audioIzena);
	        rs = stmt.executeQuery();

	        
	        if (rs.next()) {
                Blob blob = rs.getBlob("irudia");
                if (blob != null) {
                    try (ByteArrayInputStream is = new ByteArrayInputStream(blob.getBytes(1, (int) blob.length()))) {
                        Image image = ImageIO.read(is);
                        abestiArgazki = new ImageIcon(image);
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
	    return abestiArgazki;
	}
	
	 public String AbestiInformazioaLortu(String audioIzena) {

	        String AbestiInformazioa = "";
	        Connection con = KonexioaDB.hasi(); // Datu-basearekin konexioa lortu
	        if (con == null) {
	            System.out.println("Ezin da konexioa egin.");
	            return AbestiInformazioa;
	        }

	        PreparedStatement stmt = null;
	        ResultSet rs = null;

	        try {
	            // Artista baten informazioa lortzeko SQL kontsulta
	            String sql = "SELECT izena, iraupena, mota FROM audio WHERE izena = ?";
	            stmt = con.prepareStatement(sql);
	            stmt.setString(1, audioIzena);
	            rs = stmt.executeQuery();
	            
	            // Artista baten informazioa eraikitzeko
	            if (rs.next()) {
	                String Izena = rs.getString("izena");
	                String Iraupena = rs.getString("iraupena");
	                String Mota = rs.getString("mota");
	                AbestiInformazioa =  Izena + "  "+ "\nIraupena: " + Iraupena + "  " + "\nMota: " + Mota;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            // Konexioa itxi eta baliabideak askatu
	            try {
	                if (rs != null) rs.close();
	                if (stmt != null) stmt.close();
	                KonexioaDB.itxi(con);
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        return AbestiInformazioa;
	    }
}