package DAO;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Artistak.Musikari;
import Audioak.Album;
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
	public List<Album> albumakLortuArtistetatik(Musikari musikari) {
	    List<Album> albumak = new ArrayList<>();
	    Connection con = KonexioaDB.hasi(); 

	    if (con == null) {
	        System.out.println("Ezin da konexioa egin.");
	        return albumak; 
	    }

	    PreparedStatement stmt = null;
	    ResultSet rs = null;

	    try {
	       
	        String sql = "SELECT * FROM album WHERE id_musikaria = ? ";
	        stmt = con.prepareStatement(sql);
	        stmt.setInt(1, musikari.getId_artista());
	        rs = stmt.executeQuery();

	        while (rs.next()) {
	            int id_album = rs.getInt("id_album");
	            String izenburua = rs.getString("izenburua");
	            Date urtea = rs.getDate("urtea");
	            String generoa = rs.getString("generoa");
	            Blob irudia = rs.getBlob("irudia");
	            Album album = new Album(id_album, izenburua, urtea, generoa,irudia);

	            albumak.add(album);
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

	    return albumak;
	}

	public Musikari musikariLortu(String izenMus) {
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
	        stmt.setString(1, izenMus);
	        rs = stmt.executeQuery();

	        
	        while (rs.next()) {
	            int id_artista = rs.getInt("id_musikaria");
	            String izena = rs.getString("izenArtistikoa");
	            String deskribapena = rs.getString("deskribapena");
	            Blob irudia = rs.getBlob("irudia");
	           musikaria = new Musikari(id_artista, izena, irudia, deskribapena);
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