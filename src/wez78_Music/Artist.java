package wez78_Music;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.persistence.*;

@Entity
@Table(name = "artist")
public class Artist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// create variables
	@Column(name = "artist_id")
	private String artistID;
	@Column(name = "first_name")
	private String  firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "band_name")
	private String bandName;
	@Column(name = "bio")
	private String bio;
	

	
	
	 
	
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
