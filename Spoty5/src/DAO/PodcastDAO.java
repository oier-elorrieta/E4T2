package DAO;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import Audioak.Podcast;
import master.KonexioaDB;

public class PodcastDAO {
  
    public List<Integer> obtenerAudiosPorPodcaster(String podcaster) {
        List<Integer> idsAudio = new ArrayList<>();
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
                idsAudio.add(id_audio);
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
            String sql = "SELECT * FROM podcast WHERE id_audio = ?";
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
    
    /**
     * Podcast-aren irudia lortzen du.
     *
     * @param izena Irudia lortu nahi den podcastaren izena.
     * @return Podcast-aren irudia ImageIcon gisa.
     */
    public ImageIcon obtenerPodcastIrudia(String izena) {
        ImageIcon irudia = null;
        Connection con = KonexioaDB.hasi();
      
        if (con == null) {
            System.out.println("Ezin da konexioa egin.");
            return null;
        }
      
        PreparedStatement stmt = null;
        ResultSet rs = null;
      
        try {
            String sql = "SELECT irudia FROM podcast WHERE izena = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, izena);
            rs = stmt.executeQuery();
          
            if (rs.next()) {
                Blob blob = rs.getBlob("irudia");
                if (blob != null) {
                    try (ByteArrayInputStream is = new ByteArrayInputStream(blob.getBytes(1, (int) blob.length()))) {
                        BufferedImage image = ImageIO.read(is);
                        irudia = new ImageIcon(image);
                    }
                }
            }
        } catch (SQLException | IOException e) {
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
        return irudia;
    }
}