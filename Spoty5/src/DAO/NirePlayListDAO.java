package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

import master.KonexioaDB;

public class NirePlayListDAO {
	
	public static List<String> BezeroPlayListZerrenda(String erabiltzaileIzena) {

		List<String> playListZerrenda = new ArrayList<>();
        Connection con = KonexioaDB.hasi(); // Datu-basearekin konexioa lortu
       

        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        
        return playListZerrenda;
    }
	
	
	// bihar begiratu
	public static void playListBerriaSortu(String playListIzena) {
	    Connection con = KonexioaDB.hasi(); 
	    PreparedStatement stmt = null;
	    try {
	    	String sql = "INSERT INTO playlist (id_bezeroa, izenburua, sorrera_data) VALUES (DEFAULT, ?, CURRENT_DATE())";
	        stmt = con.prepareStatement(sql);
	        stmt.setString(1, playListIzena);
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (stmt != null) stmt.close();
	            KonexioaDB.itxi(con);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
}


