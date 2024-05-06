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

        try {
            // Artista baten informazioa lortzeko SQL kontsulta
            String sql = "SELECT izenburua FROM playlist JOIN bezeroa using (id_bezeroa) WHERE erabiltzailea = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, erabiltzaileIzena);
            rs = stmt.executeQuery();
            
            
            while (rs.next()) {
            	playListZerrenda.add(rs.getString("izenburua"));
                
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
        return playListZerrenda;
    }
	
	public static void playListBerriaSortu(String playListIzena, String erabiltzaileIzena) {
	    Connection con = KonexioaDB.hasi(); 
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    
	    try {
	        // Obtener el id_bezeroa basado en el nombre de usuario
	        String getUserIdQuery = "SELECT id_bezeroa FROM bezeroa WHERE izena = ?";
	        stmt = con.prepareStatement(getUserIdQuery);
	        stmt.setString(1, erabiltzaileIzena);
	        rs = stmt.executeQuery();
	        
	        // Si se encuentra el usuario, obtener su id_bezeroa
	        if (rs.next()) {
	            int id_bezeroa = rs.getInt("id_bezeroa");
	            
	            // Insertar la nueva playlist utilizando el id_bezeroa obtenido
	            String insertPlaylistQuery = "INSERT INTO playlist (izenburua, sorrera_data, id_bezeroa) VALUES (?, CURRENT_DATE(), ?)";
	            stmt = con.prepareStatement(insertPlaylistQuery);
	            stmt.setString(1, playListIzena);
	            stmt.setInt(2, id_bezeroa);
	            stmt.executeUpdate();
	        } else {
	            // Manejar el caso donde el usuario no se encuentra
	            System.out.println("Usuario no encontrado: " + erabiltzaileIzena);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Cerrar recursos
	        try {
	            if (rs != null) rs.close();
	            if (stmt != null) stmt.close();
	            KonexioaDB.itxi(con);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
}


