package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import master.KonexioaDB;

public class ErregistratuDAO {
	
    public boolean erregistroaEgin(String izena, String abizena, String id_hizkuntza, String erabiltzailea, String pasahitza, String jaiotze_data, String erregistro_data) {
    	
        boolean erregistro_ok = false;
        Connection con = (Connection) KonexioaDB.hasi(); 
        
        if (con == null) {
            System.out.println("Ezin da konexioa egin.");
            return false;
        }
        
        PreparedStatement stmt = null;
        
        try {
            String sql = "INSERT INTO BEZEROA (izena, abizena, id_hizkuntza, erabiltzailea, pasahitza, jaiotze_data, erregistro_data) VALUES (?, ?, ?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, izena);
            stmt.setString(2, abizena);
            stmt.setString(3, id_hizkuntza);
            stmt.setString(4, erabiltzailea);
            stmt.setString(5, pasahitza);
            stmt.setString(6, jaiotze_data);
            stmt.setString(7, erregistro_data);
           
            int lerroAfektatuak = stmt.executeUpdate();
            
            if (lerroAfektatuak > 0) {
            	System.out.println("Erregistratu zara!");
            	erregistro_ok = true;
            }
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
        return erregistro_ok;
    }
}