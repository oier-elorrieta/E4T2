package DAO;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Artistak.Podcaster;
import master.KonexioaDB;

/**
 * Podcasteren zerrenda lortzeko datu-basearekin interakzioak egiteko klasea
 */
public class PodcasterListaDAO {
  
   public List<Podcaster> PodcasterListaLortu() {
	   List<Podcaster> podcasterList = new ArrayList<>();
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
               int id_artista = rs.getInt("id_podcaster");
               String izena = rs.getString("izenArtistikoa");
               Blob irudia = rs.getBlob("irudia");
               String deskribapena = rs.getString("deskribapena");
               Podcaster podcaster = new Podcaster(id_artista, izena,irudia, deskribapena);
               
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
}