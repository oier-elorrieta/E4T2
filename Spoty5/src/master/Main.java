package master;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        
        Connection conexioa = KonexioaDB.hasi();
        KonexioaDB.itxi(conexioa);
    }
}
