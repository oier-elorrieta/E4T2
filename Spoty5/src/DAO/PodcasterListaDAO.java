package DAO;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Artistak.Artista;
import Artistak.Musikari;
import Artistak.Podcaster;
import master.KonexioaDB;

/**
 * Podcasteren zerrenda lortzeko datu-basearekin interakzioak egiteko klasea
 */
public class PodcasterListaDAO {
  
   public List<Artista> podcasterListKargatu() {
	   List<Artista> podcasterList = new ArrayList<>();
	   Connection con = KonexioaDB.hasi();
	   
       if (con == null) {
           System.out.println("Ezin da konexioa egin.");
           return podcasterList;
       }
      
       PreparedStatement stmt = null;
       ResultSet rs = null;
      
       try {
           // Podcasteren zerrenda lortzeko SQL kontsulta
           String sql = "SELECT * FROM podcaster";
           stmt = con.prepareStatement(sql);
           rs = stmt.executeQuery();
          
           while (rs.next()) {
               int id_podcaster = rs.getInt("id_podcaster");
               String izena = rs.getString("izenArtistikoa");
               Blob irudia = rs.getBlob("irudia");
               String deskribapena = rs.getString("deskribapena");
               Podcaster podcaster = new Podcaster(id_podcaster, izena,irudia, deskribapena);
               
               podcasterList.add(podcaster);
               
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
       return podcasterList;
   }
   
   public Podcaster podcasterLortu(String izenPod) {
	   Podcaster podcaster = null;
	    Connection con = KonexioaDB.hasi(); 

	    if (con == null) {
	        System.out.println("Ezin da konexioa egin.");
	       
	    }

	    PreparedStatement stmt = null;
	    ResultSet rs = null;

	    try {
	       
	    	String sql = "SELECT * FROM podcaster where izenArtistikoa = ?";
	        stmt = con.prepareStatement(sql);
	        stmt.setString(1, izenPod);
	        rs = stmt.executeQuery();

	        
	        while (rs.next()) {
	        	 int id_podcaster = rs.getInt("id_podcaster");
	             String izena = rs.getString("izenArtistikoa");
	             Blob irudia = rs.getBlob("irudia");
	             String deskribapena = rs.getString("deskribapena");
	            podcaster = new Podcaster(id_podcaster, izena, irudia, deskribapena);
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

	    return podcaster;
	}
}