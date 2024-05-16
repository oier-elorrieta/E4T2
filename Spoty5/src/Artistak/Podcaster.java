package Artistak;

import java.sql.Blob;

/**
 * Podcaster klasea Artistak klasearen luzapena da.
 */
public class Podcaster extends Artista{
	
	public Podcaster(int id_artista, String izena, Blob irudia, String deskribapena) {
		super(id_artista, izena, irudia, deskribapena);
	}
	
	@Override
	public String toString() {
		return "Podcaster [id_artista=" + id_artista + ", izena=" + izena + ", irudia=" + irudia + ", deskribapena="
				+ deskribapena + "]";
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