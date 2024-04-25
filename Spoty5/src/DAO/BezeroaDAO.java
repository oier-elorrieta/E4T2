package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

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
    public boolean baieztatuBezeroa(String erabiltzailea, String pasahitza) {
    	
        boolean login_ok = false;
        Connection con = (Connection) KonexioaDB.hasi(); // Konexioa lortu
        
        if (con == null) {
            System.out.println("Ezin da konexioa egin.");
            return false;
        }
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            String sql = "SELECT * FROM bezeroa WHERE erabiltzailea=? AND pasahitza=?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, erabiltzailea);
            stmt.setString(2, pasahitza);

           
            rs = stmt.executeQuery();

           
            if (rs.next()) {
                login_ok = true;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
           
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                KonexioaDB.itxi(con); // Konexioa itxi
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return login_ok;
    }

}
