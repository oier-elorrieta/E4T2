package DAO;


import java.io.IOException;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;

import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.Timer;

import Audioak.Abestia;
import Audioak.Album;
import master.KonexioaDB;

public class ErreproduzioaDAO {
    private List<Abestia> abestiak;
    private int currentIndex = 0;
    private Clip clip;

    public ErreproduzioaDAO() {
       
    }
    
    public ErreproduzioaDAO(Album album) {
        AlbumDAO albumDAO = new AlbumDAO();
        abestiak = albumDAO.abestiakLortuAlbumetik(album);
    }

 
	
	public Abestia abestiaLortu(String abestiaIzen) {
		Abestia abestia = null;
	    Connection con = KonexioaDB.hasi(); 

	    if (con == null) {
	        System.out.println("Ezin da konexioa egin.");
	       
	    }

	    PreparedStatement stmt = null;
	    ResultSet rs = null;

	    try {
		       
	        String sql = "SELECT * FROM audio WHERE izena = ? ";
	        stmt = con.prepareStatement(sql);
	        stmt.setString(1, abestiaIzen);
	        rs = stmt.executeQuery();

	        
	        while (rs.next()) {
	            int id_audio = rs.getInt("id_audio");
	            String izena = rs.getString("izena");
	            Time iraupena = rs.getTime("iraupena");
	            Blob irudia = rs.getBlob("irudia");
	            abestia = new Abestia(id_audio, izena, iraupena, irudia);


	           
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

	    
	    return abestia;
	}
	
	public boolean gehituGustokoa(int bezeroaId, int audioId) {
	    Connection connection = null;
	    PreparedStatement statement = null;

	    try {
	        connection = KonexioaDB.hasi();

	        String sql = "INSERT INTO gustukoak (id_bezeroa, id_audio) VALUES (?, ?)";
	        statement = connection.prepareStatement(sql);
	        statement.setInt(1, bezeroaId);
	        statement.setInt(2, audioId);

	        int rowsAffected = statement.executeUpdate();
	        return rowsAffected > 0; 
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false; 
	    } finally {
	        KonexioaDB.itxi(connection);
	        if (statement != null) {
	            try {
	                statement.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}
}