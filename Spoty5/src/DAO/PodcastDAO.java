package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Audioak.Podcast;
import master.KonexioaDB;

/**
 * PodcastDAO klasea datu-basearekin erabilera komunikatzeko balio duen klasea da.
 */
public class PodcastDAO {
  
    /**
     * Podcaster baten audioak lortzen ditu datu-basean.
     *
     * @param podcaster Podcasterren izena.
     * @return Podcaster baten audioen identifikadoreak.
     */
    public List<String> obtenerAudiosPorPodcaster(String podcaster) {
        List<String> idsAudio = new ArrayList<>();
        Connection con = KonexioaDB.hasi();
      
        if (con == null) {
            System.out.println("Ezin da konexioa egin.");
            return idsAudio;
        }
      
        PreparedStatement stmt = null;
        ResultSet rs = null;
      
        try {
            String sql = "SELECT id_audio FROM podcast WHERE id_podcaster IN (SELECT id_podcaster FROM podcaster WHERE izenArtistikoa = ?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, podcaster);
            rs = stmt.executeQuery();
          
            while (rs.next()) {
                int id_audio = rs.getInt("id_audio");
                idsAudio.add(String.valueOf(id_audio));
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
      
        return idsAudio;
    }

    /**
     * Identifikadorearen arabera podcast bat lortzen du datu-basean.
     *
     * @param idPodcast Podcast identifikadorea.
     * @return Podcast objektua.
     */
    public Podcast obtenerPodcastPorId(int idPodcast) {
        Podcast podcast = null;
        Connection con = KonexioaDB.hasi();
      
        if (con == null) {
            System.out.println("Ezin da konexioa egin.");
            return null;
        }
      
        PreparedStatement stmt = null;
        ResultSet rs = null;
      
        try {
            String sql = "SELECT * FROM audio WHERE id_audio = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, idPodcast);
            rs = stmt.executeQuery();
          
            if (rs.next()) {
                // Obtener los datos del podcast
                String izenburua = rs.getString("izena");
                double iraupena = rs.getDouble("iraupena");
                String kolaboratzaileak = rs.getString("kolaboratzaileak");
                int erreprodukzioak = rs.getInt("erreprodukzioak");

                // Crear un objeto Podcast
                podcast = new Podcast(izenburua, iraupena, kolaboratzaileak, erreprodukzioak);
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
      
        return podcast;
    }
}
