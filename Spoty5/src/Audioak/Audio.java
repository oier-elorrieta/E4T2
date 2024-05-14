package Audioak;

<<<<<<< HEAD
import java.sql.Blob;
import java.sql.Time;
=======

import java.util.Date;
>>>>>>> cf7e46fc3ab11fe1c079139c7697b4493dd5a1c8
import java.util.Objects;



/**
 * Audio izeneko klase abstraktua
 */
public abstract class Audio {
	

	protected int Id_audio;
	
	/**
	 * Audioa izango duen izenburua
	 */
    protected String Izena;
    
    /**
     * Audioa izangoo duen iraupena
     */
<<<<<<< HEAD
    protected Time Iraupena;
=======
    protected Date Iraupena;
>>>>>>> cf7e46fc3ab11fe1c079139c7697b4493dd5a1c8
    
    /**
     * Audioa izango dituen argazkiak
     */
    
    protected Blob Irudia;
    /**
     * Audioa izango dituen kolaboratzaileen izenak
     */
    protected String Kolaboratzaileak;
    
    /**
     * Audioa izango dituen erreprodukzio kantitateak
     */
    protected int Erreprodukzioak;
    
    /**
     * Audioa sortzeko konstruktorea izenburua, iraupena, kolaboratzaileak eta erreprodukzioarekin
     * 
     * @param izenburua audioaren izenburua
     * @param iraupena audioaren iraupena
     * @param kolaboratzaileak audioaren kolaboratzaileak
     * @param erreprodukzioak audioaren erreprodukzioak
     */
<<<<<<< HEAD
    public Audio(int id_audio, String izena, Time iraupena, Blob irudia, String kolaboratzaileak, int erreprodukzioak) {
=======
    public Audio(int id_audio, String izena, Date iraupena, String kolaboratzaileak, int erreprodukzioak) {
>>>>>>> cf7e46fc3ab11fe1c079139c7697b4493dd5a1c8
    	Id_audio = id_audio;
        Izena = izena;
        Iraupena = iraupena;
        Irudia = irudia;
        Kolaboratzaileak = kolaboratzaileak;
        Erreprodukzioak = erreprodukzioak;
    }
    

    public Audio(int id_audio, String izena, Time iraupena, Blob irudia) {
    	Id_audio = id_audio;
        Izenburua = izena;
        Iraupena = iraupena;
        Irudia = irudia;
	}


	public Blob getIrudia() {
		return Irudia;
	}


	public void setIrudia(Blob irudia) {
		Irudia = irudia;
	}


	public int getId_audio() {
    	return Id_audio;
    }
    
    public void setId_audio(int id_audio) {
    	Id_audio = id_audio;
    }
    
    /**
     * Audioaren izenburua lortzen du
     * 
     * @return audioaren izenburua
     */
    public String getIzena() {
        return Izena;
    }
    
    /**
     * Audioaren izenburua ezartzen du
     * 
     * @param izenburua audioaren izenburu berria
     */
    public void setIzena(String izena) {
        Izena = izena;
    }

    /**
     * Audioaren iraupena lortze du
     * 
     * @return audioaren iraupena
     */
<<<<<<< HEAD
    public Time getIraupena() {
=======
    public Date getIraupena() {
>>>>>>> cf7e46fc3ab11fe1c079139c7697b4493dd5a1c8
        return Iraupena;
    }
    
    /**
     * Audioaren iraupena ezartzen du
     * 
     * @param iraupena audioaren iraupen berria
     */
<<<<<<< HEAD
    public void setIraupena(Time iraupena) {
=======
    public void setIraupena(Date iraupena) {
>>>>>>> cf7e46fc3ab11fe1c079139c7697b4493dd5a1c8
        Iraupena = iraupena;
    }

    /**
     * Audioaren kolaboratzaileak lortzen du
     * 
     * @return audioaren kolaboratzaileak
     */
    public String getKolaboratzaileak() {
        return Kolaboratzaileak;
    }
    
    /**
     * Audioaren kolaboratzaileak ezartzen ditu
     * 
     * @param kolaboratzaileak audioaren kolaboratzaile berriak
     */
    public void setKolaboratzaileak(String kolaboratzaileak) {
        Kolaboratzaileak = kolaboratzaileak;
    }

    /**
     * Audioaren erreprodukzioak lortzen du
     * 
     * @return audioaren erreprodukzioak
     */
    public int getErreprodukzioak() {
        return Erreprodukzioak;
    }

    /**
     * Audioaren erreprodukzioak ezartzen ditu
     * 
     * @param erreprodukzioak audioaren erreprodukzio kantitae berriak
     */
    public void setErreprodukzioak(int erreprodukzioak) {
        Erreprodukzioak = erreprodukzioak;
    }

    /**
     * Audioa izenburua, iraupena, kolaboratzaileak eta erreprodukzioak testu batean bihurtzen du objetua
     * 
     * @return Artistaren izenburua, iraupena, kolaboratzaileak eta erreprodukzioak duen testu errepresentazioa
     */
    
    @Override
<<<<<<< HEAD
   	public String toString() {
   		return "Audio [Id_audio=" + Id_audio + ", Izenburua=" + Izenburua + ", Iraupena=" + Iraupena + ", Irudia="
   				+ Irudia + ", Kolaboratzaileak=" + Kolaboratzaileak + ", Erreprodukzioak=" + Erreprodukzioak + "]";
   	}


	

    /**
     * Objetuaren hash kodea kalkulatzen du
     * 
     * @return objetuaren hash kodea
     */
	

    @Override
	public int hashCode() {
		return Objects.hash(Erreprodukzioak, Id_audio, Iraupena, Irudia, Izenburua, Kolaboratzaileak);
	}


	@Override
=======
    public String toString() {
        return "Audio [id_audio=" + Id_audio + "Izena=" + Izena + ", Iraupena=" + Iraupena + ", Kolaboratzaileak=" + Kolaboratzaileak
                + ", Erreprodukzioak=" + Erreprodukzioak + "]";
    }

    @Override
	public int hashCode() {
		return Objects.hash(Erreprodukzioak, Id_audio, Iraupena, Izena, Kolaboratzaileak);
	}

	
    
    /**
     * Komparatzen du objetua beste objetu batekin jakiteko berdin direla ala ez
     * 
     * @param zein objetuarekin konparatuko den
     * @return true objetuak berdin badira, false objetuak desberdinak badira
     */
	
    @Override
>>>>>>> cf7e46fc3ab11fe1c079139c7697b4493dd5a1c8
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Audio other = (Audio) obj;
		return Erreprodukzioak == other.Erreprodukzioak && Id_audio == other.Id_audio
<<<<<<< HEAD
				&& Objects.equals(Iraupena, other.Iraupena) && Objects.equals(Irudia, other.Irudia)
				&& Objects.equals(Izenburua, other.Izenburua)
				&& Objects.equals(Kolaboratzaileak, other.Kolaboratzaileak);
	}
	
    
=======
				&& Objects.equals(Iraupena, other.Iraupena) && Objects.equals(Izena, other.Izena)
				&& Objects.equals(Kolaboratzaileak, other.Kolaboratzaileak);
	}
>>>>>>> cf7e46fc3ab11fe1c079139c7697b4493dd5a1c8
}
