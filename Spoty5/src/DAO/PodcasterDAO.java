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

import master.KonexioaDB;

/**
 * Podcaster baten informazioa eta bere podcasten zerrenda lortzeko datu-basearekin interakzioak egiteko klasea.
 */
public class PodcasterDAO {
	  
    public String[] PodcastPodcastertatikLortu(String podcaster) {
        List<String> podcasts = new ArrayList<>();
        Connection con = KonexioaDB.hasi();
      
        if (con == null) {
            System.out.println("Ezin da konexioa egin.");
            return new String[0];
        }
      
        PreparedStatement stmt = null;
        ResultSet rs = null;
      
        try {
            String sql = "SELECT izena FROM podcast WHERE id_podcaster IN (SELECT id_podcaster FROM podcaster WHERE izenArtistikoa = ?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, podcaster);
            rs = stmt.executeQuery();
          
            while (rs.next()) {
                String izena = rs.getString("izena");
                podcasts.add(String.valueOf(izena));
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
      
        return podcasts.toArray(new String[0]);
    }

    /**
     * Podcaster baten informazioa lortzen du.
     *
     * @param podcaster Informazioa lortu nahi den podcasterren izena.
     * @return Podcaster horren informazioa.
     */
    public String PodcasterInformazioaLortu(String podcaster) {
        String informacionPodcaster = "";
        Connection con = KonexioaDB.hasi();

        if (con == null) {
            System.out.println("Ezin da konexioa egin.");
            return informacionPodcaster;
        }

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT izenArtistikoa, deskribapena FROM podcaster WHERE izenArtistikoa = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, podcaster);
            rs = stmt.executeQuery();

            if (rs.next()) {
                String nombreArtistico = rs.getString("izenArtistikoa");
                String descripcion = rs.getString("deskribapena");
                informacionPodcaster = "Izen artistikoa: " + nombreArtistico + "\nDeskribapena: " + descripcion;
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
        return informacionPodcaster;
    }

    /**
     * Podcaster baten irudia lortzen du.
     *
     * @param podcaster Irudia lortu nahi den podcasterren izena.
     * @return Podcasterren irudia ImageIcon gisa.
     */
    public ImageIcon PodcasterIrudiaLortu(String podcaster) {
        ImageIcon imagenPodcaster = null;
        Connection con = KonexioaDB.hasi(); // Datu-basearekin konexioa lortu

        if (con == null) {
            System.out.println("Ezin da konexioa egin.");
            return imagenPodcaster;
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
                        imagenPodcaster = new ImageIcon(image);
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
        return imagenPodcaster;
    }
}
