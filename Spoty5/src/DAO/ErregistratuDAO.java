package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bezeroak.Mota;
import master.KonexioaDB;

/**
 * Bezeroen erregistroa datu-basearekin interakzioak egiteko klasea.
 */
public class ErregistratuDAO {

    /**
     * Datu basean erabiltzaile berri baten erregistroa egiten du.
     * 
     * @param izena Erabiltzailearen izena.
     * @param abizena Erabiltzailearen abizena.
     * @param id_hizkuntza Gustokoaren hizkuntzaren ID-a.
     * @param erabiltzailea Erabiltzailearen erabiltzaile-izena.
     * @param pasahitza Erabiltzailearen pasahitza.
     * @param jaiotze_data Erabiltzailearen jaiotze data "YYYY-MM-DD" formatuan.
     * @param erregistro_data Erabiltzailearen erregistro data "YYYY-MM-DD" formatuan.
     * @param mota Erabiltzailearen datu mota (FREE, PREMIUM).
     * @return Erabiltzaile izena, erregistroa egiten den bitartean.
     */
    public String erregistroaEgin(String izena, String abizena, String id_hizkuntza, String erabiltzailea,
            String pasahitza, String jaiotze_data, String erregistro_data, Mota mota) {
        String erabiltzaileIzena = null;
        Connection con = KonexioaDB.hasi();

        if (con == null) {
            System.out.println("Ezin da konexioa egin.");
            return null;
        }

        PreparedStatement stmt = null;

        try {
            String sql = "INSERT INTO bezeroa (izena, abizena, id_hizkuntza, erabiltzailea, pasahitza, jaiotze_data, erregistro_data, mota) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
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
                erabiltzaileIzena = erabiltzailea;
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
        return erabiltzaileIzena;
    }

    /**
     * Hizkuntzen ID zerrenda bat lortzen du datu baseatik.
     * 
     * @return Hizkuntzen ID zerrenda String-eko array moduan.
     * @throws Exception Datu basean errore bat gertatu bada.
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