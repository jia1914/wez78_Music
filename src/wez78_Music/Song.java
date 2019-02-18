package wez78_Music;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID; 

public class Song {
	// create variabels
	private String songID;
	private String title;
	private int length;
	private String filePath;
	private String releaseDate;
	private String recordDate;
	private DbUtilities db;
	

	
	// create first class constructor
	public Song(String title,int length,String releaseDate,String recordDate) {
		
		db = new DbUtilities();
		this.title = title;
		this.length = length;
		this.releaseDate = releaseDate;
		this.recordDate = recordDate;
		UUID.fromString(songID); 
		String sql = "INSERT INTO song (title,length,release_date,record_date) VALUES  ('" + title+"', '"+ length+ "','"+releaseDate+"','"+recordDate+"');"; 
		System.out.println(sql);
		db.executeQuery(sql);
		

}
	// create the second class constructor
	public Song(String songID) { 
		
		this.songID = songID;
		db = new DbUtilities();
		String sql = "SELECT song_id from song WHERE song_id = '"+ this.songID+"';"; 
	try { 
		ResultSet rs = db.getResultSet(sql);
			if(rs.next()) {
				this.songID = rs.getString("song_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// create the third class constructor
	public void deleteSong(String songID) {

		this.songID = songID;
		db = new DbUtilities();
		String sql = "DELETE FROM song WHERE song_id = '"+ this.songID+"';";
		System.out.println(sql);
		db.executeQuery(sql);
	}
	
	// generate getters and setters
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		String sql = "UPDATE song SET title = '"+ title + "' WHERE song_id = '" + this.songID+ "';";
		this.title = title;
		System.out.println(sql);
		db.executeQuery(sql);
		
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}

	public String getSongID() {
		 return songID;
	}
	public void setSongID(String songID) {
		this.songID = songID;
	}

	
	 
	
	
	
}