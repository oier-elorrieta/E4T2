package DAO;

import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.swing.ImageIcon;
import javax.swing.Timer;

import Artistak.Podcaster;
import Audioak.Abestia;
import Audioak.Album;
import Audioak.Podcast;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import master.KonexioaDB;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class PodcastDAO {
	 	private List<Podcast> podcastak;
	    private int currentIndex = 0;
	    private Clip clip;

	    public PodcastDAO() {
	       
	    }
	    
	    public PodcastDAO(Podcaster podcaster) {
	    	PodcasterDAO podcasterDAO = new PodcasterDAO();
	        podcastak = podcasterDAO.podcastLortuPodcasterretik(podcaster);
	    }
	    
	    public Podcast podcastLortu(String izenPodcast) {
			   Podcast podcast = null;
			    Connection con = KonexioaDB.hasi(); 

			    if (con == null) {
			        System.out.println("Ezin da konexioa egin.");
			       
			    }

			    PreparedStatement stmt = null;
			    ResultSet rs = null;

			    try {
			       
			    	String sql = "SELECT * FROM podcast where izena = ?";
			        stmt = con.prepareStatement(sql);
			        stmt.setString(1, izenPodcast);
			        rs = stmt.executeQuery();

			        
			        while (rs.next()) {
			        	 int id_audio = rs.getInt("id_audio");
			             String izena = rs.getString("izena");
			             Time iraupena = rs.getTime("iraupena");
			             Blob irudia = rs.getBlob("irudia");
			             String kolaboratzaileak = rs.getString("kolaboratzaileak");
			            podcast = new Podcast(id_audio, izena,iraupena, irudia, kolaboratzaileak);
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

			    return podcast;
			}
	    
	    
	    public Clip audioErreproduzitu(String abestiIzena) {
		    try {
		        URL urlArchivo = getClass().getClassLoader().getResource("media/" + abestiIzena + ".wav");

		        if (urlArchivo == null) {
		            System.out.println("No se pudo encontrar el archivo de audio: " + abestiIzena);
		            return null;
		        }

		        if (clip != null && clip.isRunning()) {
		            clip.stop();
		            clip.close();
		        }

		        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(urlArchivo);

		        clip = AudioSystem.getClip();

		        clip.open(audioInputStream);

		        final int[] pasatuDirenSegunduak = {0};

		        Timer timer = new Timer(1000, e -> {
		        	 pasatuDirenSegunduak[0]++;
		        });
		        timer.start();

		        clip.start();

		        clip.addLineListener(event -> {
		            if (event.getType() == LineEvent.Type.STOP) {
		                clip.close();
		                timer.stop(); 
		            }
		        });

		        return clip;

		    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
		        e.printStackTrace();
		    }
		    return null;
		}
}
