package wez78_Music;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class Album {

	// create variables
	private String albumID;
	private String title;
	private String releaseDate;
	private String recordingCompany;
	private int  numberOfTracks;
	private String pmrcRating;
	private int length;
	private DbUtilities db;
	
	// create the first constructor
	public Album(String title, String releaseDate, String recordingCompany,int numberOfTracks, String pmrcRating, int length) {
		db = new DbUtilities();
		this.title = title;
		this.releaseDate = releaseDate;
		this.recordingCompany = recordingCompany;
		this.numberOfTracks = numberOfTracks;
		this.pmrcRating = pmrcRating;
		this.length = length;
		UUID.fromString(albumID); 
		String sql = "INSERT INTO album (title,release_date,recording_company_name, number_of_tracks,PMRC_rating,length) VALUES  ('" + title+"', '"+ releaseDate+ "','"+recordingCompany+"','" + numberOfTracks +"','" + pmrcRating +"','" + length +"');"; 
		System.out.println(sql);
		db.executeQuery(sql);
	}
	
	// create the second constructor
	public Album(String albumID) {
		db = new DbUtilities();
		this.albumID = albumID;
		String sql = "SELECT album_id from album WHERE album_id = '"+ this.albumID+"';";
		try { 
			ResultSet rs = db.getResultSet(sql);
				if(rs.next()) {
					this.albumID = rs.getString("album_id");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	// create the third constructor
	public void deleteAlbum(String albumID) {
		db = new DbUtilities();
		String sql = "DELETE FROM album WHERE album_id = '"+ albumID+"';";
		System.out.println(sql);
		db.executeQuery(sql);
	}

	// generate getter and setter
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		String sql = "UPDATE album WHERE title = '"+ this.title + "';"; 
		this.title = title;
		System.out.println(sql);
		db.executeQuery(sql);
		
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
	
	}
	
	

