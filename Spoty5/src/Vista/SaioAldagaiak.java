package Vista;


import Bezeroak.Bezeroa;
import Bezeroak.Free;
import Bezeroak.Premium;
import DAO.BezeroaDAO;

public class SaioAldagaiak {

	
	    private static SaioAldagaiak instance;
	    private BezeroaDAO bezeroaDAO;

	    private SaioAldagaiak() {
	        bezeroaDAO = new BezeroaDAO();
	    }

	    public static SaioAldagaiak getInstance() {
	        if (instance == null) {
	            instance = new SaioAldagaiak();
	        }
	        return instance;
	    }

	    public Bezeroa login(String erabiltzailea, String pasahitza) {
	        
	        Bezeroa bezeroa = bezeroaDAO.bezeroaLortu(erabiltzailea, pasahitza);
	        
	        return bezeroa;
	    }

	    
	    
	    
}
