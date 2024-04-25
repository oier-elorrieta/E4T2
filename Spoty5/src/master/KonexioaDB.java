package master;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KonexioaDB {
	public static Connection hasi() {//Konexioa Datu Basearekin// 
        Connection conexioa = null;
        try {
            conexioa = DriverManager.getConnection("jdbc:mysql://localhost:3307/db_spoty5", "root", "");
            // Ondo ba doa
            System.out.println("Konexioa ondo dago!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conexioa;
    }
    
    public static void itxi(Connection conexioa) {
        try {
            if (conexioa != null && !conexioa.isClosed()) {
                conexioa.close();
            }
        } catch (SQLException e) { 
            e.printStackTrace();
        }
    }
}