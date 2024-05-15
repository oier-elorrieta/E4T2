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
	        int result = bezeroaDAO.baieztatuBezeroa(erabiltzailea, pasahitza);

	        if (result == BezeroaDAO.PREMIUM_USER || result == BezeroaDAO.FREE_USER) {
	            // Usuario autenticado correctamente
	            if (result == BezeroaDAO.PREMIUM_USER) {
	                return new Premium(erabiltzailea, pasahitza);
	            } else {
	                return new Free(erabiltzailea, pasahitza);
	            }
	        } else if (result == BezeroaDAO.INVALID) {
	           
	        }

	        return null;
	    }
	    
	}
