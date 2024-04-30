package master;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KonexioaDB {
	public static Connection hasi() {//Konexioa Datu Basearekin// 
        Connection conexioa = null;
        try {
            conexioa = DriverManager.getConnection("jdbc:mysql://10.5.6.219:3306/db_spoty5", "analista1", "haia");
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