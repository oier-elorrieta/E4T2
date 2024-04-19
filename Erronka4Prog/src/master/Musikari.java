package master;

import java.util.ArrayList;

abstract class Musikari extends Artistak {
    
    protected ArrayList <String> AlbumZerrenda;

    public Musikari(String izena, ArrayList<String> albumZerrenda) {
		super(izena);
		AlbumZerrenda = albumZerrenda;
	}

	@Override
    public String toString() {
        final int maxLen = 10;
        return "Musikari [AlbumZerrenda="
                + (AlbumZerrenda != null ? AlbumZerrenda.subList(0, Math.min(AlbumZerrenda.size(), maxLen)) : null)
                + "]";
    }

    public ArrayList<String> getAlbumZerrenda() {
        return AlbumZerrenda;
    }

    public void setAlbumZerrenda(ArrayList<String> albumZerrenda) {
        AlbumZerrenda = albumZerrenda;
    }
    
    
}
