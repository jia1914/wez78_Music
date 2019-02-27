package wez78_Music;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.sql.Connection;


public class Song {
	// create variabels
	private String songID;
	private String title;
	private int length;
	private String filePath;
	private String releaseDate;
	private String recordDate;
	private DbUtilities db;
	private String Artist;
	private Map<String,Artist> songArtist;
	
	
	
	// create first class constructor
	public Song(String title,int length,String releaseDate,String recordDate) {
		
		db = new DbUtilities();
		this.title = title;
		this.length = length;
		this.releaseDate = releaseDate;
		this.recordDate = recordDate;
		this.songID= java.util.UUID.randomUUID().toString();
		this.songArtist = new HashMap<String,Artist>();
		
		
		String sql = "INSERT INTO song (title,length,release_date,record_date,song_id)" + "VALUES  (?,?,?,?,?);"; 
		try {
		  PreparedStatement stmt = db.Getconn().prepareStatement(sql);
			stmt.setString(1,this.title);
			stmt.setInt(2,this.length);
			stmt.setString(3,this.releaseDate);
			stmt.setString(4,this.recordDate);
			stmt.setString(5,songID);
			int i = stmt.executeUpdate();
			System.out.println(i + " record inserted");
			System.out.println(sql);
		}
		 catch(SQLException e) {
			 e.printStackTrace();
		 }
}
	// create the second class constructor
	public Song(String songID) { 
		
		this.songID = songID;
		this.songArtist = new HashMap<String,Artist>();
		db = new DbUtilities();
		String sql = "SELECT song_id from song WHERE song_id = ?;"; 
	try { 
		PreparedStatement stmt = db.Getconn().prepareStatement(sql);
		stmt.setString(1,this.songID);
		ResultSet rs = db.getResultSet(sql);
			if(rs.next()) {
				this.songID = rs.getString("song_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	String sql2 = "SELECT fk_artist_id FROM song_artist WHERE fk_song_id = ?;";
	try {
		PreparedStatement stmt1 = db.Getconn().prepareStatement(sql2);  
		stmt1.setString(1, this.songID);
		ResultSet rs1 = stmt1.executeQuery();
		System.out.println(sql2);
		if(rs1.next()){
			this.songArtist.put(rs1.getString("fk_artist_id"), new Artist(rs1.getString("fk_artist_id")));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	// create the third class constructor
	public void deleteSong(String songID) {
		this.songID = songID;
		//delete song from the song table
		db = new DbUtilities();
		String sql = "DELETE FROM song WHERE song_id = ?;";
		try {
			PreparedStatement stmt = db.Getconn().prepareStatement(sql);
			stmt.setString(1, this.songID);
			int i = stmt.executeUpdate();
			System.out.println(i + " records deleted");
			System.out.println(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
		// delete song from playlist_song
		String sql2 = "DELETE FROM playlist_song WHERE fk_song_id = ?;";
		try {
			PreparedStatement stmt1 = db.Getconn().prepareStatement(sql2);
			stmt1.setString(1, this.songID);
			int i = stmt1.executeUpdate();
			System.out.println(i + " records deleted");
			System.out.println(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//delete fk_song_id from song_artist
		String sql3= "DELETE FROM song_artist WHERE fk_song_id = ?;";
		try {
			PreparedStatement stmt2 = db.Getconn().prepareStatement(sql3);
			stmt2.setString(1, this.songID);
			int i = stmt2.executeUpdate();
			System.out.println(i + " records deleted");
			System.out.println(sql3);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// delete song_id from song_genre
		String sql4 = "DELETE FROM song_genre WHERE fk_song_id = ?;";
		try {
			PreparedStatement stmt3 = db.Getconn().prepareStatement(sql4);
			stmt3.setString(1, this.songID);
			int i = stmt3.executeUpdate();
			System.out.println(i + " records deleted");
			System.out.println(sql4);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//delete song_id from album_song
		String sql5 = "DELETE FROM album_song WHERE song_id = ?;";
		try {
			PreparedStatement stmt4 = db.Getconn().prepareStatement(sql5);
			stmt4.setString(1, this.songID);
			int i = stmt4.executeUpdate();
			System.out.println(i + " records deleted");
			System.out.println(sql5);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addArtist(Artist artist) {
		db= new DbUtilities();
		this.songArtist.put(artist.getArtistID(),artist);
		String sql ="Insert INTO song_artist (fk_song_id,fk_artist_id) VALUES (?,?);";
		try { 
			java.sql.PreparedStatement stmt = db.Getconn().prepareStatement(sql);
			stmt.setString(1, this.songID);
			stmt.setString(2, artist.getArtistID());
			int i = stmt.executeUpdate();
			System.out.println(i + " record inserted");
			System.out.println(sql);
		}
		 catch(SQLException e) {
			 e.printStackTrace();
		 }	
	}
	
	public void deleteArtist(String artistID) {
		db= new DbUtilities();
		this.songArtist.remove(artistID);
		String sql = "DELETE FROM song_artist WHERE fk_artist_id = ?;";
		try {
			PreparedStatement stmt = db.Getconn().prepareStatement(sql);
			stmt.setString(1, artistID);
			int i = stmt.executeUpdate();
			System.out.println(i + " records deleted");
			System.out.println(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteArtist(Artist artist) {
		this.songArtist.remove(artist.getArtistID());
		db = new DbUtilities();
		String sql = "DELETE FROM song_artist WHERE fk_artist_id = ?;";
		try {
			PreparedStatement stmt = db.Getconn().prepareStatement(sql);
			stmt.setString(1, artist.getArtistID());
			int i = stmt.executeUpdate();
			System.out.println(i + " records deleted");
			System.out.println(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
 
	// generate getters and setters
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
		String sql = "UPDATE song SET title = ? WHERE song_id = ?;";
		try {
			PreparedStatement stmt = db.Getconn().prepareStatement(sql);
			stmt.setString(1, this.title);
			stmt.setString(2, this.songID);
			int i = stmt.executeUpdate();
			System.out.println(i + " records updated");
			System.out.println(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
		String sql = "UPDATE song SET length = ? WHERE song_id = ?;";
		try {
			PreparedStatement stmt = db.Getconn().prepareStatement(sql);
			stmt.setInt(1, this.length);
			stmt.setString(2, this.songID);
			int i = stmt.executeUpdate();
			System.out.println(i + " records updated");
			System.out.println(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
		String sql = "UPDATE song SET file_path = ? WHERE song_id = ?;";
		try {
			PreparedStatement stmt = db.Getconn().prepareStatement(sql);
			stmt.setString(1, this.filePath);
			stmt.setString(2, this.songID);
			int i = stmt.executeUpdate();
			System.out.println(i + " records updated");
			System.out.println(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
		String sql = "UPDATE song SET release_date = ? WHERE song_id = ?;";
		try {
			PreparedStatement stmt = db.Getconn().prepareStatement(sql);
			stmt.setString(1, this.releaseDate);
			stmt.setString(2, this.songID);
			int i = stmt.executeUpdate();
			System.out.println(i + " records updated");
			System.out.println(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
		String sql = "UPDATE song SET record_date = ? WHERE song_id = ?;";
		try {
			PreparedStatement stmt = db.Getconn().prepareStatement(sql);
			stmt.setString(1, this.recordDate);
			stmt.setString(2, this.songID);
			int i = stmt.executeUpdate();
			System.out.println(i + " records updated");
			System.out.println(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getSongID() {
		 return songID;
	}
	public void setSongID(String songID) {
		this.songID = songID;
	}

	public Map<String, Artist> getSongArtist() {
		return songArtist;
	}
}