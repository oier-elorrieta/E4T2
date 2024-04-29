package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import master.KonexioaDB;

public class PodcasterDAO {
	  
	   public String[] obtenerPodcastsPorPodcaster(String podcaster) {
	       List<String> podcasts = new ArrayList<>();
	       Connection con = KonexioaDB.hasi();
	      
	       if (con == null) {
	           System.out.println("Ezin da konexioa egin.");
	           return new String[0];
	       }
	      
	       PreparedStatement stmt = null;
	       ResultSet rs = null;
	      
	       try {
	           String sql = "SELECT id_audio FROM PODCAST WHERE id_podcaster IN (SELECT id_podcaster FROM PODCASTER WHERE izenArtistikoa = ?)";
	           stmt = con.prepareStatement(sql);
	           stmt.setString(1, podcaster);
	           rs = stmt.executeQuery();
	          
	           while (rs.next()) {
	               int id_audio = rs.getInt("id_audio");
	               podcasts.add(String.valueOf(id_audio));
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
	      
	       return podcasts.toArray(new String[0]);
	   }
	   
	   public String obtenerInformacionPodcaster(String podcaster) {
	       String informacionPodcaster = "";
	       Connection con = KonexioaDB.hasi();

	       if (con == null) {
	           System.out.println("Ezin da konexioa egin.");
	           return informacionPodcaster;
	       }

	       PreparedStatement stmt = null;
	       ResultSet rs = null;

	       try {
	           String sql = "SELECT izenArtistikoa, deskribapena FROM PODCASTER WHERE izenArtistikoa = ?";
	           stmt = con.prepareStatement(sql);
	           stmt.setString(1, podcaster);
	           rs = stmt.executeQuery();

	           if (rs.next()) {
	               String nombreArtistico = rs.getString("izenArtistikoa");
	               String descripcion = rs.getString("deskribapena");
	               informacionPodcaster = "Nombre artístico: " + nombreArtistico + "\nDescripción: " + descripcion;
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

	       return informacionPodcaster;
	   }  
	}