package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Audioak.PlayListak;
import master.KonexioaDB;

/**
 * Erabiltzailearen PlayList-ak kudeatzeko datu atzipen klasea.
 */
public class NirePlayListDAO {
    
    /**
     * Erabiltzailearen PlayList-ak lortzen ditu.
     * 
     * @param erabiltzaileIzena Erabiltzailearen izena.
     * @return Erabiltzailearen PlayList-ak.
     */
    public static List<PlayListak> bezeroPlaylistZerrenda(String erabiltzaileIzena) {
        List<PlayListak> playListZerrenda = new ArrayList<>();
        Connection con = KonexioaDB.hasi(); 
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            String sql = "SELECT izenburua FROM playlist p INNER JOIN bezeroa b ON p.id_bezeroa = b.id_bezeroa WHERE b.erabiltzailea = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, erabiltzaileIzena);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                String izenburua = rs.getString("izenburua");
                PlayListak playLista = new PlayListak(izenburua);
                playListZerrenda.add(playLista);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            KonexioaDB.itxi(con);
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return playListZerrenda;
    }
  

        public static void sortuPlayList(String erabiltzaileIzena, String playListIzena) {
            Connection con = KonexioaDB.hasi();
            PreparedStatement stmt = null;

            try {
                
                String sql = "INSERT INTO Playlist (izenburua, sorrera_data, id_bezeroa) VALUES (?, NOW(), ?)";

                
                stmt = con.prepareStatement(sql);
                stmt.setString(1, playListIzena);
                stmt.setString(2, erabiltzaileIzena);

                
                int filasAfectadas = stmt.executeUpdate();

                
                if (filasAfectadas > 0) {
                    System.out.println("ondo.");
                } else {
                    System.out.println("txarto.");
                }
            } catch (SQLException e) {
                
                e.printStackTrace();
            } finally {
               
                try {
                    if (stmt != null) {
                        stmt.close();
                    }
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    

}
