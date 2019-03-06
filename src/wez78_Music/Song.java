package wez78_Music;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.sql.Connection;
import javax.persistence.*;

@Entity
@Table (name="song")
public class Song {
	// create variabels
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "song_id")
	private String songID;
	@Column(name = "title")
	private String title;
	@Column(name = "length")
	private int length;
	@Column(name = "file_path")
	private String filePath;
	@Column(name = "release_date")
	private String releaseDate;
	@Column(name = "record_date")
	private String recordDate;
	@Transient
	private Map<String,Artist> songArtist;
	
	
	
 
	// create the third class constructor
	public void deleteSong(String songID) {
		this.songID = songID;
	}
	
	public void addArtist(Artist artist) {
		this.songArtist.put(artist.getArtistID(),artist);
	}
	
	public void deleteArtist(String artistID) {
		this.songArtist.remove(artistID);
	}
	
 
	// generate getters and setters
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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

	public Map<String, Artist> getSongArtist() {
		return songArtist;
	}
}