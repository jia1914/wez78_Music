package wez78_Music;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.sql.Connection;
import javax.persistence.*;

@Entity
@Table(name = "album")

public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	// create variables
	@Column(name = "album_id")
	private String albumID;
	@Column(name = "title")
	private String title;
	@Column(name = "release_date")
	private String releaseDate;
	@Column(name = "recording_company_name")
	private String recordingCompany;
	@Column(name = "number_of_tracks")
	private int  numberOfTracks;
	@Column(name = "PMRC_rating")
	private String pmrcRating;
	@Column(name = "cover_image_path")
	private String coverImagePath;
	@Column(name = "length")
	private int length;
	@Transient
	private HashMap<String,Song> albumSongs;
	
	// create the first constructor
	public Album() {
		this.albumSongs= new HashMap<String, Song>();
		this.albumID = java.util.UUID.randomUUID().toString();
	}
	public void deleteAlbum(String albumID) {
      this.albumID = albumID;
	}	
	public void addSong(Song song) {
		this.albumSongs.put(song.getSongID(), song);
	}
	public void deleteSong(String songID) {
		this.albumSongs.remove(songID);
	}

	// generate getter and setter
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getRecordingCompany() {
		return recordingCompany;
	}

	public void setRecordingCompany(String recordingCompany) {
		this.recordingCompany = recordingCompany;
	}
		
	
	public String getCoverImagePath() {
		return coverImagePath;
	}

	public void setCoverImagePath(String coverImagePath) {
		this.coverImagePath = coverImagePath;
	}

	public int getNumberOfTracks() {
		return numberOfTracks;
	}

	public void setNumberOfTracks(int numberOfTracks) {
		this.numberOfTracks = numberOfTracks;
	}

	public String getPmrcRating() {
		return pmrcRating;
	}

	public void setPmrcRating(String pmrcRating) {
		this.pmrcRating = pmrcRating;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	public String getAlbumID() {
		return albumID;
	}
	public void setAlbumID(String albumID) {
		this.albumID = albumID;
	}
	public Map<String, Song> getAlbumSongs() {
		return albumSongs;
	}
	
	}
	
	

