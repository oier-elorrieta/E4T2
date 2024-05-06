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

public class AlbumDAO {

    public List<String> albumAbestiakHartu(String albumIzena) {
        List<String> abestiak = new ArrayList<>();
       
        try (Connection con = KonexioaDB.hasi();
             PreparedStatement stmt = con.prepareStatement("SELECT a.izena FROM abestia ab INNER JOIN audio a ON ab.id_audio = a.id_audio INNER JOIN album al ON ab.id_album = al.id_album WHERE al.izenburua = ?")) {
            stmt.setString(1, albumIzena);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    abestiak.add(rs.getString("izena"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        return abestiak;
    }
    
    
    //
    //jarraitu astelehenean 06/05/2024
    //
    public String AlbumInformazioaLortu(String albumIzena) {

        String Albuminformazioa = "";
        Connection con = KonexioaDB.hasi(); // Datu-basearekin konexioa lortu
        if (con == null) {
            System.out.println("Ezin da konexioa egin.");
            return Albuminformazioa;
        }

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Artista baten informazioa lortzeko SQL kontsulta
            String sql = "SELECT urtea, generoa FROM album WHERE izenburua = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, albumIzena);
            rs = stmt.executeQuery();
            
            // Artista baten informazioa eraikitzeko
            if (rs.next()) {
                String Data = rs.getString("urtea");
                String Generoa = rs.getString("generoa");
                Albuminformazioa = "Albumaren irteera data: " + Data + "\nGeneroa: " + Generoa;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Konexioa itxi eta baliabideak askatu
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                KonexioaDB.itxi(con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return Albuminformazioa;
    }

       
        public ImageIcon AlbumIrudiaLortu(String albumIzena) {
            ImageIcon imagenAlbum = null;
            Connection con = KonexioaDB.hasi(); // Obtener conexión con la base de datos
            if (con == null) {
                System.out.println("Ezin da konexioa egin.");
                return imagenAlbum;
            }
            PreparedStatement stmt = null;
            ResultSet rs = null;

            try {
                // Consulta SQL para obtener la imagen del álbum
                String sql = "SELECT irudia FROM audio WHERE izena = ?";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, albumIzena);
                rs = stmt.executeQuery();

                // Si se encuentra la imagen, convertirla en ImageIcon
                if (rs.next()) {
                    Blob blob = rs.getBlob("irudia");
                    if (blob != null) {
                        try (ByteArrayInputStream is = new ByteArrayInputStream(blob.getBytes(1, (int) blob.length()))) {
                            Image image = ImageIO.read(is);
                            imagenAlbum = new ImageIcon(image);
                        }
                    }
                }
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            } finally {
                // Liberar recursos
                try {
                    if (rs != null) rs.close();
                    if (stmt != null) stmt.close();
                    KonexioaDB.itxi(con); // Cerrar la conexión con la base de datos
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return imagenAlbum;
        }
 }