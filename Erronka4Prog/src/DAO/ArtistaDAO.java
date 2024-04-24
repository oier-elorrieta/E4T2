package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import master.KonexioaDB;

/**
 * Artista baten albumak eta informazioa lortzeko datu-basearekin interakzioak egiteko klasea
 */
public class ArtistaDAO {
  
   /**
    * Artista baten albumak lortzen ditu
    * 
    * @param artista Albumak lortu nahi den artista
    * @return Artista horren albumen zerrenda
    */
   public String[] obtenerAlbumesPorArtista(String artista) {
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
           String sql = "SELECT izenburua FROM ALBUM WHERE id_musikaria IN (SELECT id_musikaria FROM MUSIKARIA WHERE izenArtistikoa = ?)";
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
    * Artista baten informazioa lortzen du
    * 
    * @param artista Informazioa lortu nahi den artista
    * @return Artista horren informazioa
    */
   public String obtenerInformacionArtista(String artista) {
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
           String sql = "SELECT izenArtistikoa, deskribapena FROM MUSIKARIA WHERE izenArtistikoa = ?";
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
}
