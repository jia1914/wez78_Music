package wez78_Music;
import java.net.URL;
import java.sql.*;

 

public class Music_Tester {
public static void main(String [] args)throws SQLException  {
	// test song
	SongManager s = new SongManager();
	//s.createSong("Speed Trials2", 4, "songs/elliotsmith/speedtrials.mp3", "2001-10-10", "2001-10-10");
	//s.updateSong("0437c71f-fee1-4f70-9f9e-ac423be67c56", "Custer", 4, "Slipnot.mp3", "1999-01-01", "1999-01-01");
	//s.deleteSong("0437c71f-fee1-4f70-9f9e-ac423be67c56");
	
	//test artist
	ArtistManager t  = new ArtistManager();
	//t.createArtist("Wub wub wub", "lol", "Kero Kero Bonito", "Kero Kero Bonito");
    //t.updateArtist("0279c548-b564-4230-98bb-2ca46d09e516", "Sean", "Paul", "Jamaica", "Reaggae dance hall musician");
	//t.deleteArtist("0279c548-b564-4230-98bb-2ca46d09e516");
	
	//test album
	AlbumManager a = new AlbumManager();
	//a.createAlbum("The Way Up", "2014-10-08", "images/revolver.jpg", "Columbia", 14, "PAL", 102.4);
	//a.updateAlbum("0590ad5d-8ca9-42e3-babd-e8c15e677d24", "Darkside of the Moon", "1971-10-08", "images/revolver.jpg", "A recording company", 9, "Mature", 80);
	//a.deleteAlbum("0590ad5d-8ca9-42e3-babd-e8c15e677d24");
	


}
}