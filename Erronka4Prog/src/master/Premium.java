package master;

import java.sql.Date;
import java.util.Objects;
/**
 * Premium izeneko klase publikoa
 */
public class Premium extends Bezeroa{
	
	/**
	 * Premium izango duen iraungitzeData
	 */
    private Date iraungitzeData;

    /**
     * Premium berri bat sortzeko konstruktorea izena, abizena, data, pasahitza, hizkuntza eta erabiltzailearekin
     * 
     * @param izena bezeroaren izena
     * @param abizena bezeroaren abizena
     * @param jdata bezeroaren jaiotze data
     * @param pasahitza bezeroaren pasahitza 
     * @param hizkuntza bezeroaren gustokoaren hizkuntza
     * @param erabiltzailea bezeroaren izenaren erabiltzailea 
     */
    public Premium(String izena, String abizena, Date jdata, String pasahitza, Hizkuntza hizkuntza,
            String erabiltzailea) {
        super(izena, abizena, jdata, pasahitza, hizkuntza, erabiltzailea);
    }

    /**
     * Premiumen iraungitzeData lortzen du
     * 
     * @return Premiumen iraungitzeData
     */
    public Date getIraungitzeData() {
        return iraungitzeData;
    }

    /**
     * Premiumen iraungitzeData ezartzen du
     * 
     * @param iraungitzeData Premiumen iraungitzeData berria
     */
    public void setIraungitzeData(Date iraungitzeData) {
        this.iraungitzeData = iraungitzeData;
    }
    
    /**
     * Premiumaren izena, abizena, Jdata, erabiltzailea, pasahitza, hizkuntza eta iraungitzeData testu batean bihurtzen du objetua
     * 
     * @return Premiumaren izena, abizena, Jdata, erabiltzailea, pasahitza, hizkuntza eta iraungitzeData duen testu errepresentazioa
     */
    @Override
    public String toString() {
        return "Premium [iraungitzeData=" + iraungitzeData + ", izena=" + izena + ", abizena=" + abizena + ", Jdata="
                + Jdata + ", erabiltzailea=" + erabiltzailea + ", pasahitza=" + pasahitza + ", hizkuntza=" + hizkuntza
                + "]";
    }

    /**
     * Objetuaren hash kodea kalkulatzen du
     * 
     * @return objetuaren hash kodea
     */
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(iraungitzeData);
		return result;
	}

    /**
     * Komparatzen du objetua beste objetu batekin jakiteko berdin direla ala ez
     * 
     * @param zein objetuarekin konparatuko den
     * @return true objetuak berdin badira, false objetuak desberdinak badira
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Premium other = (Premium) obj;
		return Objects.equals(iraungitzeData, other.iraungitzeData);
	}   
	
}