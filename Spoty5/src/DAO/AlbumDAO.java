package DAO;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Audioak.Abestia;
import Audioak.Album;

import master.KonexioaDB;

public class AlbumDAO {

	public static List<Abestia> abestiakLortuAlbumetik(Album album) {
	    List<Abestia> abestiak = new ArrayList<>();
	    Connection con = KonexioaDB.hasi(); 

	    if (con == null) {
	        System.out.println("Ezin da konexioa egin.");
	        return abestiak; 
	    }

	    PreparedStatement stmt = null;
	    ResultSet rs = null;

	    try {
	       
	        String sql = "SELECT audio.* " +
                    "FROM audio " +
                    "JOIN abestia ON audio.id_audio = abestia.id_audio " +
                    "WHERE abestia.id_album = ?";
	        stmt = con.prepareStatement(sql);
	        stmt.setInt(1, album.getId_album());
	        rs = stmt.executeQuery();

	        while (rs.next()) {
	            int id_audio = rs.getInt("id_audio");
	            String izena = rs.getString("izena");
	            Time iraupena = rs.getTime("iraupena");
	            Blob irudia = rs.getBlob("irudia");
	            Abestia abestia = new Abestia(id_audio, izena, iraupena, irudia);

	            abestiak.add(abestia);
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

	    return abestiak;
	}
	
	public Album albumLortu(String albumIzen) {
		Album albuma = null;
	    Connection con = KonexioaDB.hasi(); 

	    if (con == null) {
	        System.out.println("Ezin da konexioa egin.");
	       
	    }

	    PreparedStatement stmt = null;
	    ResultSet rs = null;

	    try {
		       
	        String sql = "SELECT * FROM album WHERE izenburua = ? ";
	        stmt = con.prepareStatement(sql);
	        stmt.setString(1, albumIzen);
	        rs = stmt.executeQuery();

	        
	        while (rs.next()) {
	            int id_album = rs.getInt("id_album");
	            String izenburua = rs.getString("izenburua");
	            Date urtea = rs.getDate("urtea");
	            String generoa = rs.getString("generoa");
	            Blob irudia = rs.getBlob("irudia");
	            albuma = new Album(id_album, izenburua, urtea, generoa,irudia);

	           
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

	    return albuma;
	}
    
 }