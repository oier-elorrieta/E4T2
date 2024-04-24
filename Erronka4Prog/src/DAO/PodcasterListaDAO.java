package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import master.KonexioaDB;

public class PodcasterListaDAO {
	
	public String obtenerListaPodcasters() {
	       StringBuilder listaPodcasters = new StringBuilder();
	       Connection con = (Connection) KonexioaDB.hasi(); // Datu-basearekin konexioa lortu
	      
	       if (con == null) {
	           System.out.println("Ezin da konexioa egin.");
	           return "";
	       }
	      
	       PreparedStatement stmt = null;
	       ResultSet rs = null;
	      
	       try {
	           // Podcaster zerrenda lortzeko SQL kontsulta
	           String sql = "SELECT izenArtistikoa FROM PODCASTER";
	           stmt = con.prepareStatement(sql);
	           rs = stmt.executeQuery();
	          
	           // Podcasterren zerrenda sortu kate moduan
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
