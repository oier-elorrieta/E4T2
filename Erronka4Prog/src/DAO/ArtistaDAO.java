package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import master.KonexioaDB;
public class ArtistaDAO {
  
   public String[] obtenerAlbumesPorArtista(String artista) {
       List<String> albumes = new ArrayList<>();
       Connection con = KonexioaDB.hasi();
      
       if (con == null) {
           System.out.println("Ezin da konexioa egin.");
           return new String[0];
       }
      
       PreparedStatement stmt = null;
       ResultSet rs = null;
      
       try {
           // Consulta SQL para obtener los álbumes del artista
           String sql = "SELECT izenburua FROM ALBUM WHERE id_musikaria IN (SELECT id_musikaria FROM MUSIKARIA WHERE izenArtistikoa = ?)";
           stmt = con.prepareStatement(sql);
           stmt.setString(1, artista);
           rs = stmt.executeQuery();
          
           // Construir la lista de álbumes
           while (rs.next()) {
               String album = rs.getString("izenburua");
               albumes.add(album);
           }
       } catch (SQLException e) {
           e.printStackTrace();
       } finally {
           // Cerrar la conexión y liberar recursos
           try {
               if (rs != null) rs.close();
               if (stmt != null) stmt.close();
               KonexioaDB.itxi(con);
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
      
       // Convertir la lista de álbumes a un array de Strings
       return albumes.toArray(new String[0]);
   }
}





