package DAO;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

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
	           String sql = "SELECT id_audio FROM podcast WHERE id_podcaster IN (SELECT id_podcaster FROM podcaster WHERE izenArtistikoa = ?)";
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
	           String sql = "SELECT izenArtistikoa, deskribapena FROM podcaster WHERE izenArtistikoa = ?";
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

	       public ImageIcon obtenerImagenPodcaster(String podcaster) {

	           ImageIcon imagenPodcaster = null;

	           Connection con = KonexioaDB.hasi(); // Obtener conexión con la base de datos

	           if (con == null) {
	               System.out.println("Ezin da konexioa egin.");
	               return imagenPodcaster;
	           }

	           PreparedStatement stmt = null;
	           ResultSet rs = null;

	           try {
	               // Consulta SQL para obtener la imagen del podcaster
	               String sql = "SELECT irudia FROM podcaster WHERE izenArtistikoa = ?";
	               stmt = con.prepareStatement(sql);
	               stmt.setString(1, podcaster);
	               rs = stmt.executeQuery();

	               // Si se encuentra la imagen, convertirla a ImageIcon
	               if (rs.next()) {
	                   Blob blob = rs.getBlob("irudia");
	                   if (blob != null) {
	                       try (ResultSet tempRS = stmt.executeQuery()) {
	                           if (tempRS.next()) {
	                               blob = tempRS.getBlob("irudia");
	                               if (blob != null) {
	                                   try (ByteArrayInputStream is = new ByteArrayInputStream(blob.getBytes(1, (int) blob.length()))) {
	                                       Image image = ImageIO.read(is);
	                                       imagenPodcaster = new ImageIcon(image);
	                                   }
	                               }
	                           }
	                       }
	                   }
	               }
	           } catch (SQLException | IOException e) {
	               e.printStackTrace();
	           } finally {
	               // Cerrar recursos
	               try {
	                   if (rs != null) rs.close();
	                   if (stmt != null) stmt.close();
	                   KonexioaDB.itxi(con);
	               } catch (SQLException e) {
	                   e.printStackTrace();
	               }
	           }

	           return imagenPodcaster;
	       }
}