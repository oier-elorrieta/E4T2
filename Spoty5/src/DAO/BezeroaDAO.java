package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import master.KonexioaDB;

/**
 * Bezeroen autentifikazioa egiaztatzeko klasea
 */

	public class BezeroaDAO {
	    
		public static final int PREMIUM_USER = 1;
		public static final int FREE_USER = 2;
		public static final int INVALID = -1;
		public static final int DATABASE_ERROR = -2;

	    
	    /**
	     * Erabiltzailea eta pasahitza baieztatu egiaztatzen du
	     * 
	     * @param erabiltzailea Erabiltzailearen erabiltzaile-izena
	     * @param pasahitza Erabiltzailearen pasahitza
	     * @return True baieztatu egin bada, False bestela
	     */

		public int baieztatuBezeroa(String erabiltzailea, String pasahitza) {
		    Connection con = null;
		    PreparedStatement stmt = null;
		    ResultSet rs = null;
		    
		    try {
		        con = KonexioaDB.hasi();
		        if (con == null) {
		            System.out.println("Ezin da konexioa egin.");
		            return DATABASE_ERROR; // Devolvemos un código de error de base de datos
		        }
		        
		        String sql = "SELECT mota FROM bezeroa WHERE erabiltzailea=? AND pasahitza=?";
		        stmt = con.prepareStatement(sql);
		        stmt.setString(1, erabiltzailea);
		        stmt.setString(2, pasahitza);
		        rs = stmt.executeQuery();
		        
		        if (rs.next()) {
		            String userType = rs.getString("mota");
		            if (userType.equals("premium")) {
		                return PREMIUM_USER; // Devolvemos un código para indicar que es un usuario premium
		            } else {
		                return FREE_USER; // Devolvemos un código para indicar que es un usuario free
		            }
		        } else {
		            return INVALID; // Devolvemos un código para indicar que las credenciales son inválidas
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return DATABASE_ERROR; // Devolvemos un código de error de base de datos
		    } finally {
		        try {
		            if (rs != null) rs.close();
		            if (stmt != null) stmt.close();
		            KonexioaDB.itxi(con);
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		}



	    
	    public boolean Premium(String erabiltzailea) {
	        Connection con = KonexioaDB.hasi();
	        PreparedStatement stmt = null;
	        ResultSet rs = null;

	        try {
	            String sql = "SELECT mota FROM bezeroa WHERE erabiltzailea = ?";
	            stmt = con.prepareStatement(sql);
	            stmt.setString(1, erabiltzailea);
	            rs = stmt.executeQuery();

	            // Si hay resultados en la consulta y el tipo de usuario es "premium", devolvemos true
	            if (rs.next()) {
	                String mota = rs.getString("mota");
	                return mota.equals("premium");
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
	        return false; // Si no hay resultados o el tipo de usuario no es "premium", devolvemos false
	    }
	}
