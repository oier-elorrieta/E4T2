package Artistak;

import java.sql.Blob;
import java.util.Objects;

/**
 * Artista izeneko klase abstraktua
 **/
public abstract class Artista {
	
	protected int id_artista;
	protected String izena;
	protected Blob irudia;
	protected String deskribapena;

	public int getId_artista() {
		return id_artista;
	}

	public String getDeskribapena() {
		return deskribapena;
	}

	public void setId_artista(int id_artista) {
		this.id_artista = id_artista;
	}

	public void setDeskribapena(String deskribapena) {
		this.deskribapena = deskribapena;
	}

	/**
	 * Artista sortzeko konstruktorea izenarekin
	 *
	 * @param izena artistaren izena
	 */
	

	public Artista(int id_artista, String izena, String deskribapena) {
		this.id_artista = id_artista;
		this.izena = izena;
		this.deskribapena = deskribapena;
	}

	public Blob getIrudia() {
		return irudia;
	}

	public void setIrudia(Blob irudia) {
		this.irudia = irudia;
	}

	/**
	 * Artistaren izena lortzen du
	 *
	 * @return artistaren izena
	 */
	public String getIzena() {
		return izena;
	}

	/**
	 * Artistaren izena ezartzen du
	 *
	 * @param izena artistaren izena berria
	 */
	public void setIzena(String izena) {
		izena = izena;
	}

	/**
	 * Artistaren izenarekin testu batean bihurtzen du objetua
	 *
	 * @return Artistaren izena duen testu errepresentazioa
	 */
	@Override
	public String toString() {
		return "Artista [id_artista=" + id_artista + ", izena=" + izena + ", irudia=" + irudia + ", deskribapena="
				+ deskribapena + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(deskribapena, id_artista, irudia, izena);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artista other = (Artista) obj;
		return Objects.equals(deskribapena, other.deskribapena) && id_artista == other.id_artista
				&& Objects.equals(irudia, other.irudia) && Objects.equals(izena, other.izena);
	}
	

}