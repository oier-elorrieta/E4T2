package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

import master.KonexioaDB;

public class NirePlayListDAO {
	
	public static List<String> BezeroPlayListZerrenda(String erabiltzaileIzena) {

		List<String> playListZerrenda = new ArrayList<>();
        Connection con = KonexioaDB.hasi(); // Datu-basearekin konexioa lortu
       

        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        
        return playListZerrenda;
    }
	
	
}


