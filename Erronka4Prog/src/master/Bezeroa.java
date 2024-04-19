package master;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import com.mysql.jdbc.Connection;

/**
 * Bezero izeneko klase abstraktua
 */
public abstract class Bezeroa {
    
    /**
     * Bezeroa izango ahal dituen hizkuntzak
     */
    public enum Hizkuntza {
        ES, EU, EN, FR, DE, CA, GA, AR
    }
    
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
    protected Hizkuntza hizkuntza;
    
    /**
     * Bezero berri bat sortzeko konstruktorea izena, abizena, data, pasahitza, hizkuntza eta erabiltzailearekin
     * 
     * @param izena bezeroaren izena
     * @param abizena bezeroaren abizena
     * @param jdata bezeroaren jaiotze data
     * @param pasahitza bezeroaren pasahitza 
     * @param hizkuntza bezeroaren gustokoaren hizkuntza
     * @param erabiltzailea bezeroaren izenaren erabiltzailea 
     */
    public Bezeroa(String izena, String abizena, Date jdata, String pasahitza, Hizkuntza hizkuntza, String erabiltzailea) {
        this.izena = izena;
        this.abizena = abizena;
        Jdata = jdata;
        this.pasahitza = pasahitza;
        this.hizkuntza = hizkuntza;
        this.erabiltzailea = erabiltzailea;
    }
    
    /**
     * Bezeroaren izena lortzen du
     * 
     * @return bezeroaren izena
     */
    public String getIzena() {
        return izena;
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
    public Hizkuntza getHizkuntza() {
        return hizkuntza;
    }
    
    /**
     * Bezeroaren hizkuntza ezartzen du
     * 
     * @param hizkuntza bezeroaren hizkuntza berria
     */
    public void setHizkuntza(Hizkuntza hizkuntza) {
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
     * Artistaren izenan abizena, jaiotze data, pasahitza, hizkuntza eta erabiltzailearekin testu batean bihurtzen du objetua
     * 
     * @return Artistaren izenan abizena, jaiotze data, pasahitza, hizkuntza eta erabiltzailearekin duen testu errepresentazioa
     */
    @Override
    public String toString() {
        return "Bezeroa [izena=" + izena + ", abizena=" + abizena + ", Jdata=" + Jdata + ", pasahitza=" + pasahitza
                + ", hizkuntza=" + hizkuntza + ", erabiltzailea=" + erabiltzailea + "]";
    }

    /**
     * Objetuaren hash kodea kalkulatzen du
     * 
     * @return objetuaren hash kodea
     */
    @Override
    public int hashCode() {
        return Objects.hash(Jdata, abizena, erabiltzailea, hizkuntza, izena, pasahitza);
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
                && Objects.equals(izena, other.izena) && Objects.equals(pasahitza, other.pasahitza);
    }  
    
}