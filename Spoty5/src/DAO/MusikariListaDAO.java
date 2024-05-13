package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Artistak.Artista;
import Artistak.Musikari;
import Audioak.Album;
import master.KonexioaDB;

/**
 * Musika artisten zerrenda lortzeko datu-basearekin interakzioak egiteko klasea.
 */
public class MusikariListaDAO {
  
   /**
    * Zerrenda bat sortzen du, datu-basean dauden musika artisten izenak erabiliz.
    * 
    * @return Musika artisten zerrenda String moduan itzuli.
    */
	public List<Artista> artistaListKargatu() {
	    List<Artista> musikariak = new ArrayList<>();
	    Connection con = KonexioaDB.hasi(); 

	    if (con == null) {
	        System.out.println("Ezin da konexioa egin.");
	        return musikariak; 
	    }

	    PreparedStatement stmt = null;
	    ResultSet rs = null;

	    try {
	       
	    	String sql = "SELECT * FROM musikaria";
	        stmt = con.prepareStatement(sql);
	        rs = stmt.executeQuery();

	        
	        while (rs.next()) {
	            int id_artista = rs.getInt("id_musikaria");
	            String izena = rs.getString("izenArtistikoa");
	            String deskribapena = rs.getString("deskribapena");
	            Musikari musikaria = new Musikari(id_artista, izena,deskribapena);

	            musikariak.add(musikaria);
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

	    
	    return musikariak;
	}
	/**
	    * Zerrenda bat sortzen du, datu-basean dauden musika artisten izenak erabiliz.
	    * 
	    * @return Musika artisten zerrenda String moduan itzuli.
	    */
		public Musikari musikariLortu(String izena) {
			Musikari musikaria = null;
		    Connection con = KonexioaDB.hasi(); 

		    if (con == null) {
		        System.out.println("Ezin da konexioa egin.");
		       
		    }

		    PreparedStatement stmt = null;
		    ResultSet rs = null;

		    try {
		       
		    	String sql = "SELECT * FROM musikaria where izenArtistikoa = ?";
		        stmt = con.prepareStatement(sql);
		        stmt.setString(1, izena);
		        rs = stmt.executeQuery();

		        
		        while (rs.next()) {
		            int id_artista = rs.getInt("id_musikaria");
		            String izenaa = rs.getString("izenArtistikoa");
		            String deskribapena = rs.getString("deskribapena");
		           musikaria = new Musikari(id_artista, izenaa,deskribapena);
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
  
		    return musikaria;
		}
}