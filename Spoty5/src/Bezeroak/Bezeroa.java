package Bezeroak;

import java.util.Date;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Bezero izeneko klase abstraktua
 */
public abstract class Bezeroa {

	protected int id_bezeroa;

	/**
	 * Bezeroa izango ahal dituen hizkuntzak
	 */
	protected String Hizkuntza; 

	/**
	 * Bezeroa izango duen izena
	 */
	protected String izena;

	/**
	 * Bezeroa izango duen abizena
	 */
	protected String abizena;

	/**
	 * Bezeroa izango duen jaiotze data
	 */
	protected Date Jdata;

	/**
	 * Bezeroa izango duen erabiltzailea
	 */
	protected String erabiltzailea;

	/**
	 * Bezeroa izango duen pasahitza
	 */
	protected String pasahitza;

	/**
	 * Bezeroa izango duen hizkuntza
	 */
	protected String hizkuntza;

	protected ArrayList<String> playListZerrenda;
	
	protected String mota;

	/**
	 * Bezero berri bat sortzeko konstruktorea izena, abizena, data, pasahitza,
	 * hizkuntza eta erabiltzailearekin
	 *
	 * @param izena            bezeroaren izena
	 * @param abizena          bezeroaren abizena
	 * @param jdata            bezeroaren jaiotze data
	 * @param pasahitza        bezeroaren pasahitza
	 * @param hizkuntza        bezeroaren gustokoaren hizkuntza
	 * @param erabiltzailea    bezeroaren izenaren erabiltzailea
	 * @param playListZerrenda bezeroaren playListZerrenda
	 */
	public Bezeroa(int id_bezeroa, String izena, String abizena, Date jdata, String erabiltzailea, String pasahitza,
			String hizkuntza, ArrayList<String> playListZerrenda, String mota) {
		super();
		this.id_bezeroa = id_bezeroa;
		this.izena = izena;
		this.abizena = abizena;
		Jdata = jdata;
		this.erabiltzailea = erabiltzailea;
		this.pasahitza = pasahitza;
		this.hizkuntza = hizkuntza;
		this.playListZerrenda = playListZerrenda;
		this.mota = mota;
	}
	
	

	public Bezeroa(int id_bezeroa, String izena, String abizena, Date jdata, String erabiltzailea, String pasahitza,
			String hizkuntza, String mota) {
		super();
		this.id_bezeroa = id_bezeroa;
		this.izena = izena;
		this.abizena = abizena;
		Jdata = jdata;
		this.erabiltzailea = erabiltzailea;
		this.pasahitza = pasahitza;
		this.hizkuntza = hizkuntza;
		this.mota = mota;
	}



	/**
	 * Bezeroaren izena lortzen du
	 *
	 * @return bezeroaren izena
	 */
	public String getIzena() {
		return izena;
	}

	public int getId_bezeroa() {
		return id_bezeroa;
	}

	public void setId_bezeroa(int id_bezeroa) {
		this.id_bezeroa = id_bezeroa;
	}

	/**
	 * Bezeroaren izena ezartzen du
	 *
	 * @param izena bezeroaren izena berria
	 */
	public void setIzena(String izena) {
		this.izena = izena;
	}

	/**
	 * Bezeroaren abizena lortzen du
	 *
	 * @return bezeroaren abizena
	 */
	public String getAbizena() {
		return abizena;
	}

	/**
	 * Bezeroaren abizena ezartzen du
	 *
	 * @param abizena bezeroaren abizen berria
	 */
	public void setAbizena(String abizena) {
		this.abizena = abizena;
	}

	/**
	 * Bezeroaren jaiotze data lortzen du
	 *
	 * @return bezeroaren jaiotze data
	 */
	public Date getJdata() {
		return Jdata;
	}

	/**
	 * Bezeroaren jaiotze data ezartzen du
	 *
	 * @param jdata bezeroaren jaiotze data berria
	 */
	public void setJdata(Date jdata) {
		Jdata = jdata;
	}

	/**
	 * Bezeroaren pasahitza lortzen du
	 *
	 * @return bezeroaren pasahitza
	 */
	public String getPasahitza() {
		return pasahitza;
	}

	/**
	 * Bezeroaren pasahitza ezartzen du
	 *
	 * @param pasahitza bezeroaren pasahitza berria
	 */
	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}

	/**
	 * Bezeroaren hizkuntza lortzen du
	 *
	 * @return bezeroaren hizkuntza
	 */
	public String getHizkuntza() {
		return hizkuntza;
	}

	/**
	 * Bezeroaren hizkuntza ezartzen du
	 *
	 * @param hizkuntza bezeroaren hizkuntza berria
	 */
	public void setHizkuntza(String hizkuntza) {
		this.hizkuntza = hizkuntza;
	}

	/**
	 * Bezeroaren erabiltzailea lortzen du
	 *
	 * @return bezeroaren erabiltzailea
	 */
	public String getErabiltzailea() {
		return erabiltzailea;
	}

	/**
	 * Bezeroaren hizkuntza ezartzen du
	 *
	 * @param erabiltzailea bezeroaren erabiltzaile berria
	 */
	public void setErabiltzailea(String erabiltzailea) {
		this.erabiltzailea = erabiltzailea;
	}

	/**
	 * Bezeroaren erabiltzailea lortzen du
	 *
	 * @return bezeroaren playListZerrenda
	 */
	public ArrayList<String> getPlayListZerrenda() {
		return playListZerrenda;
	}

	/**
	 * Bezeroaren playListZerrenda ezartzen du
	 *
	 * @param playListZerrenda bezeroaren erabiltzaile berria
	 */
	public void setPlayListZerrenda(ArrayList<String> playListZerrenda) {
		this.playListZerrenda = playListZerrenda;
	}

	

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	/**
	 * Artistaren izenan abizena, jaiotze data, pasahitza, hizkuntza eta
	 * erabiltzailearekin testu batean bihurtzen du objetua
	 *
	 * @return Artistaren izenan abizena, jaiotze data, pasahitza, hizkuntza,
	 *         erabiltzailearekin eta playListZerrenda duen testu errepresentazioa
	 */
	@Override
	public String toString() {
		return "Bezeroa [id_bezeroa=" + id_bezeroa + ", izena=" + izena + ", abizena=" + abizena + ", Jdata=" + Jdata
				+ ", erabiltzailea=" + erabiltzailea + ", pasahitza=" + pasahitza + ", hizkuntza=" + hizkuntza
				+ ", playListZerrenda=" + playListZerrenda + ", mota=" + mota + "]";
	}
	
	/**
	 * Objetuaren hash kodea kalkulatzen du
	 *
	 * @return objetuaren hash kodea
	 */
	@Override
	public int hashCode() {
		return Objects.hash(Jdata, abizena, erabiltzailea, hizkuntza, id_bezeroa, izena, mota, pasahitza,
				playListZerrenda);
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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bezeroa other = (Bezeroa) obj;
		return Objects.equals(Jdata, other.Jdata) && Objects.equals(abizena, other.abizena)
				&& Objects.equals(erabiltzailea, other.erabiltzailea) && hizkuntza == other.hizkuntza
				&& id_bezeroa == other.id_bezeroa && Objects.equals(izena, other.izena) && mota == other.mota
				&& Objects.equals(pasahitza, other.pasahitza)
				&& Objects.equals(playListZerrenda, other.playListZerrenda);
	}

}
