package Audioak;

import java.sql.Blob;
import java.util.Date;
import java.util.Objects;

/**
 * Album izeneko klasea
 */
public class Album {
	
	private int id_album;
	private String izenburua;
	private Date urtea;
	private String generoa;
	private  Blob irudia;
	
	/**
	 * Albuma sortzeko konstruktorea izenburua eta argitaratze urtearekin
	 *
	 * @param izenburua        albumaren izenburua
	 * @param argitaratzeUrtea albumaren argitaratze urtea
	 */
	public Album(int id_album, String izenburua, Date urtea, String generoa, Blob irudia) {
		this.id_album = id_album;
		this.izenburua = izenburua;
		this.urtea = urtea;
		this.generoa = generoa;
		this.irudia = irudia;
	}

	public int getId_album() {
		return id_album;
	}
	
	public void setId_album(int id_album) {
		this.id_album = id_album;
	}
	
	public String getIzenburua() {
		return izenburua;
	}
	
	public void setIzenburua(String izenburua) {
		this.izenburua = izenburua;
	}
	
	public Date getUrtea() {
		return urtea;
	}
	
	public void setUrtea(Date urtea) {
		this.urtea = urtea;
	}
	
	public String getGeneroa() {
		return generoa;
	}
	
	public void setGeneroa(String generoa) {
		this.generoa = generoa;
	}
	
	public Blob getIrudia() {
		return irudia;
	}
	
	public void setIrudia(Blob irudia) {
		this.irudia = irudia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(generoa, id_album, irudia, izenburua, urtea);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Album other = (Album) obj;
		return Objects.equals(generoa, other.generoa) && id_album == other.id_album
				&& Objects.equals(irudia, other.irudia) && Objects.equals(izenburua, other.izenburua)
				&& Objects.equals(urtea, other.urtea);
	}

}