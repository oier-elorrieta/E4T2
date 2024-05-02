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
/**
 * Artista baten albumak eta informazioa lortzeko datu-basearekin interakzioak egiteko klasea.
 */
public class ArtistaDAO {

   /**
    * Artista baten albumak lortzen ditu.
    *
    * @param artista Albumak lortu nahi den artista.
    * @return Artista horren albumen zerrenda.
    */
   public String[] AlbumakLortuArtistetatik(String artista) {
	   
       List<String> albumes = new ArrayList<>();
       Connection con = KonexioaDB.hasi(); // Datu-basearekin konexioa lortu

       if (con == null) {
           System.out.println("Ezin da konexioa egin.");
           return new String[0];
       }

       PreparedStatement stmt = null;
       ResultSet rs = null;

  
       try {
           // Artista baten albumak lortzeko SQL kontsulta
           String sql = "SELECT izenburua FROM album WHERE id_musikaria IN (SELECT id_musikaria FROM musikaria WHERE izenArtistikoa = ?)";
           stmt = con.prepareStatement(sql);
           stmt.setString(1, artista);
           rs = stmt.executeQuery();

           // Albumen zerrenda eraikitzeko
           while (rs.next()) {
               String album = rs.getString("izenburua");
               albumes.add(album);
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

       // Albumen zerrenda String-en array bihurtu
       return albumes.toArray(new String[0]);
   }

   /**
    * Artista baten informazioa lortzen du.
    *
    * @param artista Informazioa lortu nahi den artista.
    * @return Artista horren informazioa.
    */
   public String ArtistaInformazioaLortu(String artista) {

       String informacionArtista = "";
       Connection con = KonexioaDB.hasi(); // Datu-basearekin konexioa lortu
       if (con == null) {
           System.out.println("Ezin da konexioa egin.");
           return informacionArtista;
       }

       PreparedStatement stmt = null;
       ResultSet rs = null;

       try {
           // Artista baten informazioa lortzeko SQL kontsulta
           String sql = "SELECT izenArtistikoa, deskribapena FROM musikaria WHERE izenArtistikoa = ?";
           stmt = con.prepareStatement(sql);
           stmt.setString(1, artista);
           rs = stmt.executeQuery();
           
           // Artista baten informazioa eraikitzeko
           if (rs.next()) {
               String nombreArtistico = rs.getString("izenArtistikoa");
               String descripcion = rs.getString("deskribapena");
               informacionArtista = "Izen artistikoa: " + nombreArtistico + "\nDeskribapena: " + descripcion;
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
       return informacionArtista;
   }

   /**
    * Artista baten irudia lortzen du.
    *
    * @param artista Irudia lortu nahi den artista.
    * @return Artista horren irudia.
    */
   public ImageIcon ArtistaIrudiaLortu(String artista) {
       ImageIcon imagenArtista = null;
       Connection con = KonexioaDB.hasi(); // Konexioa lortu datu-basearekin
       if (con == null) {
           System.out.println("Ezin da konexioa egin.");
           return imagenArtista;
       }
       PreparedStatement stmt = null;
       ResultSet rs = null;

       try {

           // Consulta SQL para obtener la imagen del artista
           // Artista irudia lortzeko SQL kontsulta
           String sql = "SELECT irudia FROM musikaria WHERE izenArtistikoa = ?";
           stmt = con.prepareStatement(sql);
           stmt.setString(1, artista);
           rs = stmt.executeQuery();
           
           // Irudia aurkitzen denean, ImageIcon bihurtu
           if (rs.next()) {
               Blob blob = rs.getBlob("irudia");
               if (blob != null) {
                   try (ResultSet tempRS = stmt.executeQuery()) {
                       if (tempRS.next()) {
                           blob = tempRS.getBlob("irudia");
                           if (blob != null) {
                               try (ByteArrayInputStream is = new ByteArrayInputStream(blob.getBytes(1, (int) blob.length()))) {
                                   Image image = ImageIO.read(is);
                                   imagenArtista = new ImageIcon(image);
                               }
                           }
                       }
                   }
               }
           }
       } catch (SQLException | IOException e) {
           e.printStackTrace();
       } finally {
           // Baliabideak askatu
    	   
           try {
               if (rs != null) rs.close();
               if (stmt != null) stmt.close();
               KonexioaDB.itxi(con);
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
       return imagenArtista;
   }
}
