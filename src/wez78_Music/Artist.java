package wez78_Music;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class Artist {
	// create variables
	private String artistID;
	private String  firstName;
	private String lastName;
	private String bandName;
	private String bio;
	private DbUtilities db;
	
	
	//create the first constructor
	public Artist (String firstName, String lastName, String bandName){
		db = new DbUtilities();
		this.lastName = lastName;
		this.bandName =  bandName;
		UUID.fromString(artistID); 
		String sql = "INSERT INTO artist (fist_name,last_name,band_name) VALUES  ('" + firstName+"', '"+ lastName+ "','"+bandName+"');"; 
		System.out.println(sql);
		db.executeQuery(sql);
	}
	
	// create the second constructor
	public Artist (String artistID) {
		this.artistID = artistID;
		db = new DbUtilities();
		String sql = "SELECT artist_id from artist WHERE artist_id = '"+ this.artistID+"';";
		try { 
			ResultSet rs = db.getResultSet(sql);
				if(rs.next()) {
					this.artistID = rs.getString("artist_id");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	// create the third constructor
	public void deleteArtist(String aristID) {
		db = new DbUtilities();
		String sql = "DELETE FROM artist WHERE artist_id ='"+ aristID+"';";
		System.out.println(sql);
		db.executeQuery(sql);
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getBandName() {
		return bandName;
	}
	public void setBandName(String bandName) {
		this.bandName = bandName;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio= bio;
	}
	public String getArtistID() {
		 return artistID;
	}
	public void setArtistID(String artistID) {
		this.artistID = artistID;
	}

}
