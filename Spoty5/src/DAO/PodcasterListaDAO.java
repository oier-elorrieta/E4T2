package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import master.KonexioaDB;

/**
 * Podcasteren zerrenda lortzeko datu-basearekin interakzioak egiteko klasea
 */
public class PodcasterListaDAO {
  
   /**
    * Zerrenda bat sortzen du, datu-basean dauden podcasteren izenak erabiliz
    * 
    * @return Podcasteren zerrenda String moduan itzuli
    */
   public String obtenerListaPodcasters() {
       StringBuilder listaPodcasters = new StringBuilder();
       Connection con = KonexioaDB.hasi(); // Datu-basearekin konexioa lortu
      
       if (con == null) {
           System.out.println("Ezin da konexioa egin.");
           return "";
       }
      
       PreparedStatement stmt = null;
       ResultSet rs = null;
      
       try {
           // Podcasteren zerrenda lortzeko SQL kontsulta
           String sql = "SELECT izenArtistikoa FROM PODCASTER";
           stmt = con.prepareStatement(sql);
           rs = stmt.executeQuery();
          
           // Podcasteren zerrenda sortu kate moduan
           while (rs.next()) {
               String podcaster = rs.getString("izenArtistikoa");
               listaPodcasters.append(podcaster).append("\n");
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
       return listaPodcasters.toString();
   }
}

