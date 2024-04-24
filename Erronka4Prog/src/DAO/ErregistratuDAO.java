package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import master.KonexioaDB;

/**
 * Bezeroen erregistroa datu-basearekin interakzioak egiteko klasea
 */
public class ErregistratuDAO {

    /** 
     * Enum bat bere datu motekin
     */
    public enum Mota {
        /**
         * Datu mota free
         */
        FREE,
        /**
         * Datu mota premium
         */
        PREMIUM
    }

    /**
     * Datu basean erabiltzaile berri baten erregistroa egiten du
     * 
     * @param izena Erabiltzailearen izena
     * @param abizena Erabiltzailearen abizena
     * @param id_hizkuntza Gustokoaren hizkuntzaren ID-a
     * @param erabiltzailea Erabiltzailearen erabiltzaile-izena
     * @param pasahitza Erabiltzailearen pasahitza
     * @param jaiotze_data Erabiltzailearen jaiotze data "YYYY-MM-DD" formatuan
     * @param erregistro_data Erabiltzailearen erregistro data "YYYY-MM-DD" formatuan
     * @param mota Erabiltzailearen datu mota (FREE, PREMIUM)
     * @return True baieztatu egin bada, False bestela
     */
    public boolean erregistroaEgin(String izena, String abizena, String id_hizkuntza, String erabiltzailea,
            String pasahitza, String jaiotze_data, String erregistro_data, Mota mota) {
        boolean erregistro_ok = false;
        Connection con = KonexioaDB.hasi();

        if (con == null) {
            System.out.println("Ezin da konexioa egin.");
            return false;
        }

        PreparedStatement stmt = null;

        try {
            String sql = "INSERT INTO BEZEROA (izena, abizena, id_hizkuntza, erabiltzailea, pasahitza, jaiotze_data, erregistro_data, mota) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, izena);
            stmt.setString(2, abizena);
            stmt.setString(3, id_hizkuntza);
            stmt.setString(4, erabiltzailea);
            stmt.setString(5, pasahitza);
            stmt.setString(6, jaiotze_data);
            stmt.setString(7, erregistro_data);
            stmt.setString(8, mota.toString());

            int lerroAfektatuak = stmt.executeUpdate();

            if (lerroAfektatuak > 0) {
                System.out.println("Erregistratu zara!");
                erregistro_ok = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
                KonexioaDB.itxi(con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return erregistro_ok;
    }

    /**
     * Hizkuntzen ID zerrenda bat lortzen du datu baseatik
     * 
     * @return String-eko ArrayList bat hizkuntzen ID duena
     * @throws Exception Akats bat badago datu basean sartzean
     */
    public String[] lortuHizkuntza() throws Exception {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<String> hizkuntzaList = new ArrayList<>();

        try {
            Connection con2 = (Connection) KonexioaDB.hasi();

            String sql = "SELECT id_hizkuntza FROM hizkuntza";
            stmt = con2.prepareStatement(sql);
            rs = stmt.executeQuery();

            // Recorre los resultados y los agrega a la lista
            while (rs.next()) {
                String id_hizkuntza = rs.getString("id_hizkuntza");
                hizkuntzaList.add(id_hizkuntza);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Ezin da hizkuntza lortu " + e.getMessage());
        } finally {
            if (rs != null)
                rs.close();
            if (stmt != null)
                stmt.close();
            if (con != null)
                con.close();
        }

        return hizkuntzaList.toArray(new String[0]);
    }
}
