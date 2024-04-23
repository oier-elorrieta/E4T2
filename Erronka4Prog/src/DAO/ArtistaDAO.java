package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import master.KonexioaDB;
public class ArtistaDAO {
  
   public String obtenerListaArtistas() {
       StringBuilder listaArtistas = new StringBuilder();
       Connection con = (Connection) KonexioaDB.hasi(); // Obtener la conexión a la base de datos
      
       if (con == null) {
           System.out.println("Ezin da konexioa egin.");
           return "";
       }
      
       PreparedStatement stmt = null;
       ResultSet rs = null;
      
       try {
           // Consulta SQL para obtener la lista de artistas
           String sql = "SELECT izenArtistikoa FROM MUSIKARIA";
           stmt = con.prepareStatement(sql);
           rs = stmt.executeQuery();
          
           // Construir la lista de artistas como una cadena
           while (rs.next()) {
               String artista = rs.getString("izenArtistikoa");
               listaArtistas.append(artista).append("\n");
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
       return listaArtistas.toString();
   }
  
  
}

