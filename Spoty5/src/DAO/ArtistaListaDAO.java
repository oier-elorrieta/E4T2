package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import master.KonexioaDB;

/**
 * Musika artisten zerrenda lortzeko datu-basearekin interakzioak egiteko klasea.
 */
public class ArtistaListaDAO {
  
   /**
    * Zerrenda bat sortzen du, datu-basean dauden musika artisten izenak erabiliz.
    * 
    * @return Musika artisten zerrenda String moduan itzuli.
    */
   public String obtenerListaArtistas() {
       StringBuilder listaArtistas = new StringBuilder();
       Connection con = (Connection) KonexioaDB.hasi(); // Datu-basearekin konexioa lortu
      
       if (con == null) {
           System.out.println("Ezin da konexioa egin.");
           return "";
       }
      
       PreparedStatement stmt = null;
       ResultSet rs = null;
      
       try {
           // Musika artisten zerrenda lortzeko SQL kontsulta
           String sql = "SELECT izenArtistikoa FROM musikaria";
           stmt = con.prepareStatement(sql);
           rs = stmt.executeQuery();
          
           // Musika artisten zerrenda sortu kate moduan
           while (rs.next()) {
               String artista = rs.getString("izenArtistikoa");
               listaArtistas.append(artista).append("\n");
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
       return listaArtistas.toString();
   }
}