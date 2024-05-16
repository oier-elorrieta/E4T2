package DAO;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import Artistak.Podcaster;
import Audioak.Podcast;
import master.KonexioaDB;

/**
 * Podcaster baten informazioa eta bere podcasten zerrenda lortzeko datu-basearekin interakzioak egiteko klasea.
 */
public class PodcasterDAO {
	
	public PodcasterDAO() {
		
	}

	public static List<Podcast> podcastLortuPodcasterretik(Podcaster podcaster) {
	    List<Podcast> podcastak = new ArrayList<>();
	    Connection con = KonexioaDB.hasi(); 

	    if (con == null) {
	        System.out.println("Ezin da konexioa egin.");
	        return podcastak; 
	    }

	    PreparedStatement stmt = null;
	    ResultSet rs = null;

	    try {
	       
	    	String sql = "SELECT audio.id_audio, audio.izena, audio.iraupena, audio.irudia, audio.mota " +
	                "FROM audio " +
	                "INNER JOIN podcast ON audio.id_audio = podcast.id_audio " +
	                "INNER JOIN podcaster ON podcast.id_podcaster = podcaster.id_podcaster " +
	                "WHERE podcaster.izenArtistikoa = ?";
	        stmt = con.prepareStatement(sql);
	        stmt.setString(1, podcaster.getIzena());
	        rs = stmt.executeQuery();
	        
	        while (rs.next()) {
	            int id_audio = rs.getInt("id_audio");
	            String izena = rs.getString("izena");
	            Time iraupena = rs.getTime("iraupena");
	            Blob irudia = rs.getBlob("irudia");
	            Podcast podcast = new Podcast(id_audio, izena, iraupena, irudia);

	            podcastak.add(podcast);
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
	    
	    return podcastak;
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
		             String kolaboratzailea = rs.getString("kolaboratzailea");
		            podcast = new Podcast(id_audio, izena,iraupena, irudia, kolaboratzailea);
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
}
