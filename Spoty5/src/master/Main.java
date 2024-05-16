package master;

import java.sql.Connection;

import Bezeroak.Bezeroa;

public class Main {
	public static Bezeroa bezero ;
    public static void main(String[] args) {
        
        Connection conexioa = KonexioaDB.hasi();
        KonexioaDB.itxi(conexioa);
       
    }
}
