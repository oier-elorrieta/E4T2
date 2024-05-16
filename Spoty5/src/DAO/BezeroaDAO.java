package DAO;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import Artistak.Musikari;
import Bezeroak.Bezeroa;
import Bezeroak.Free;
import master.KonexioaDB;

/**
 * Bezeroen autentifikazioa egiaztatzeko klasea
 */

	public class BezeroaDAO {
	    
	    
	    /**
	     * Erabiltzailea eta pasahitza baieztatu egiaztatzen du
	     * 
	     * @param erabiltzailea Erabiltzailearen erabiltzaile-izena
	     * @param pasahitza Erabiltzailearen pasahitza
	     * @return True baieztatu egin bada, False bestela
	     */

	    
		public static Bezeroa bezeroaLortu(String izenBez, String pasahitzaBal) {
		    Bezeroa bezeroa = null;
		    Connection con = KonexioaDB.hasi(); 

		    if (con == null) {
		        System.out.println("Ezin da konexioa egin.");
		        return null; 
		    }

		    PreparedStatement stmt = null;
		    ResultSet rs = null;

		    try {
		        
		        String sql = "SELECT * FROM bezeroa WHERE erabiltzailea = ? AND pasahitza = ?";
		        stmt = con.prepareStatement(sql);
		        stmt.setString(1, izenBez);
		        stmt.setString(2, pasahitzaBal); 
		        rs = stmt.executeQuery();

		        if (rs.next()) {
		            int id_bezeroa = rs.getInt("id_bezeroa");
		            String izena = rs.getString("izena");
		            String abizena = rs.getString("abizena");
		            String id_hizkuntza = rs.getString("id_hizkuntza");
		            String erabiltzailea = rs.getString("erabiltzailea");
		            String pasahitza = rs.getString("pasahitza");
		            Date jaiotze_data = rs.getDate("jaiotze_data");
		            String mota = rs.getString("mota");
		  
		            
		            if (mota.equals("free")) {
		                bezeroa = new Free(id_bezeroa, izena, abizena, jaiotze_data, erabiltzailea, pasahitza, id_hizkuntza, mota);
		            } else {
		                bezeroa = new Bezeroak.Premium(id_bezeroa, izena, abizena, jaiotze_data, erabiltzailea, pasahitza, id_hizkuntza, mota);
		            }
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

		    return bezeroa;
		}
	}

