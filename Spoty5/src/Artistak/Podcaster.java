package Artistak;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.Objects;
/**
 * Podcaster klasea Artistak klasearen luzapena da.
 */
public class Podcaster extends Artista{

	public Podcaster(int id_artista, String izena, String deskribapena) {
		super(id_artista, izena, deskribapena);
	}

	@Override
	public String toString() {
		return "Podcaster [id_artista=" + id_artista + ", izena=" + izena + ", irudia=" + irudia + ", deskribapena="
				+ deskribapena + ", getId_artista()=" + getId_artista() + ", getDeskribapena()=" + getDeskribapena()
				+ ", getIrudia()=" + getIrudia() + ", getIzena()=" + getIzena() + ", toString()=" + super.toString()
				+ ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + "]";
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	
	
}