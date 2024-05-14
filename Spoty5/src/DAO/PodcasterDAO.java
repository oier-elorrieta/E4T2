package DAO;

import java.awt.Image;
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

import Artistak.Podcaster;
import Audioak.Podcast;
import master.KonexioaDB;

/**
 * Podcaster baten informazioa eta bere podcasten zerrenda lortzeko datu-basearekin interakzioak egiteko klasea.
 */
public class PodcasterDAO {
	  
    public List<Podcast> PodcastPodcastertatikLortu(Podcaster podcaster) {
        List<Podcast> podcasts = new ArrayList<>();
        Connection con = KonexioaDB.hasi();
      
        if (con == null) {
	        System.out.println("Ezin da konexioa egin.");
	        return podcasts; 
	    }
      
        PreparedStatement stmt = null;
        ResultSet rs = null;
      
        try {
            String sql = "SELECT * FROM podcast WHERE id_podcaster IN (SELECT id_podcaster FROM podcaster WHERE izenArtistikoa = ?)";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, podcaster.getId_artista());
            rs = stmt.executeQuery();
          
            while (rs.next()) {
                int id_audio = rs.getInt("id_audio");
                String izena = rs.getString("izena");
                String kolaboratzaileak = rs.getString("kolaboratzaileak");
                Podcast podcast = new Podcast(id_audio, izena, kolaboratzaileak);
                
                podcasts.add(podcast);
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
      
        return podcasts;
    }

    /**
     * Podcaster baten informazioa lortzen du.
     *
     * @param podcaster Informazioa lortu nahi den podcasterren izena.
     * @return Podcaster horren informazioa.
     */
    public String PodcasterInformazioaLortu(String podcaster) {
        String podcasterInfo = "";
        Connection con = KonexioaDB.hasi();

        if (con == null) {
            System.out.println("Ezin da konexioa egin.");
            return podcasterInfo;
        }

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT izenArtistikoa, deskribapena FROM podcaster WHERE izenArtistikoa = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, podcaster);
            rs = stmt.executeQuery();

            if (rs.next()) {
                String izenArtistikoa = rs.getString("izenArtistikoa");
                String deskribapena = rs.getString("deskribapena");
                podcasterInfo = "Izen artistikoa: " + izenArtistikoa + "\nDeskribapena: " + deskribapena;
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
        return podcasterInfo;
    }

    /**
     * Podcaster baten irudia lortzen du.
     *
     * @param podcaster Irudia lortu nahi den podcasterren izena.
     * @return Podcasterren irudia ImageIcon gisa.
     */
    public ImageIcon PodcasterIrudiaLortu(String podcaster) {
        ImageIcon podcasterIrudia = null;
        Connection con = KonexioaDB.hasi(); // Datu-basearekin konexioa lortu

        if (con == null) {
            System.out.println("Ezin da konexioa egin.");
            return podcasterIrudia;
        }

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Podcasterren irudia lortzeko SQL kontsulta
            String sql = "SELECT irudia FROM podcaster WHERE izenArtistikoa = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, podcaster);
            rs = stmt.executeQuery();

            // Irudia aurkitzen bada, ImageIcon-ra bihurtzen da
            if (rs.next()) {
                Blob blob = rs.getBlob("irudia");
                if (blob != null) {
                    try (ByteArrayInputStream is = new ByteArrayInputStream(blob.getBytes(1, (int) blob.length()))) {
                        Image image = ImageIO.read(is);
                        podcasterIrudia = new ImageIcon(image);
                    }
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            // Baliabideak askatu
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                KonexioaDB.itxi(con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return podcasterIrudia;
    }
}