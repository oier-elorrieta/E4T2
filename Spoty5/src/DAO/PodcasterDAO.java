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

    /**
     * Podcaster baten podcasten ID-ak lortzen ditu.
     * 
     * @param podcaster Podcastak lortu nahi den podcasterren izena.
     * @return Podcaster horren podcasten ID-en zerrenda.
     */
    public String[] obtenerPodcastsPorPodcaster(String podcaster) {
        List<String> podcasts = new ArrayList<>();
        Connection con = KonexioaDB.hasi();

        if (con == null) {
            System.out.println("Ezin da konexioa egin.");
            return new String[0];
        }

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT id_audio FROM PODCAST WHERE id_podcaster IN (SELECT id_podcaster FROM PODCASTER WHERE izenArtistikoa = ?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, podcaster);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id_audio = rs.getInt("id_audio");
                podcasts.add(String.valueOf(id_audio));
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
    public String obtenerInformacionPodcaster(String podcaster) {
        String informacionPodcaster = "";
        Connection con = KonexioaDB.hasi();

        if (con == null) {
            System.out.println("Ezin da konexioa egin.");
            return informacionPodcaster;
        }

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT izenArtistikoa, deskribapena FROM PODCASTER WHERE izenArtistikoa = ?";
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
    public ImageIcon obtenerImagenPodcaster(String podcaster) {
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
            String sql = "SELECT irudia FROM PODCASTER WHERE izenArtistikoa = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, podcaster);
            rs = stmt.executeQuery();

            // Irudia aurkitzen bada, ImageIcon-ra bihurtzen da
            if (rs.next()) {
                Blob blob = rs.getBlob("irudia");
                if (blob != null) {
                    try (ResultSet tempRS = stmt.executeQuery()) {
                        if (tempRS.next()) {
                            blob = tempRS.getBlob("irudia");
                            if (blob != null) {
                                try (ByteArrayInputStream is = new ByteArrayInputStream(blob.getBytes(1, (int) blob.length()))) {
                                    Image image = ImageIO.read(is);
                                    imagenPodcaster = new ImageIcon(image);
                                }
                            }
                        }
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