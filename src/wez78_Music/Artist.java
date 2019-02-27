package wez78_Music;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.sql.PreparedStatement;
import java.sql.Connection;

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
		this.firstName = firstName;
		this.lastName = lastName;
		this.bandName =  bandName;
		this.artistID= java.util.UUID.randomUUID().toString();
		String sql = "INSERT INTO artist (fist_name,last_name,band_name,artistID)" + "VALUES  (?,?,?,?);";
		try {
			  PreparedStatement stmt = db.Getconn().prepareStatement(sql);
				stmt.setString(1,this.firstName);
				stmt.setString(2,this.lastName);
				stmt.setString(3,this.bandName);
				stmt.setString(4,this.artistID);
				int i = stmt.executeUpdate();
				System.out.println(i + " record inserted");
				System.out.println(sql);
			}
			 catch(SQLException e) {
				 e.printStackTrace();
			 }
	}
	
	// create the second constructor
	public Artist (String artistID) {
		this.artistID = artistID;
		db = new DbUtilities();
		String sql = "SELECT artist_id from artist WHERE artist_id = ?;";
		try { 
			PreparedStatement stmt = db.Getconn().prepareStatement(sql);
			stmt.setString(1,this.artistID);
			ResultSet rs = db.getResultSet(sql);
			System.out.println(rs + " records selected"); 
			System.out.println(sql);
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
		//delete artist from the artist  
		this.artistID = artistID;
		String sql = "DELETE FROM artist WHERE artist_id = ?;";
		try {
			PreparedStatement stmt = db.Getconn().prepareStatement(sql);
			stmt.setString(1, this.artistID);
			int i = stmt.executeUpdate();
			System.out.println(i + " records deleted");
			System.out.println(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//delete artist from the song_artist table using artistID
		String sql2 = "DELETE FROM song_artist WHERE fk_artist_id = ?;";
		try {
			PreparedStatement stmt1 = db.Getconn().prepareStatement(sql2);
			stmt1.setString(1, this.artistID);
			int i = stmt1.executeUpdate();
			System.out.println(i + " records deleted");
			System.out.println(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
    }
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
		String sql = "UPDATE artist SET first_name = ? WHERE artist_id = ?;";
		try {
			PreparedStatement stmt = db.Getconn().prepareStatement(sql);
			stmt.setString(1, this.firstName);
			stmt.setString(2, this.artistID);
			int i = stmt.executeUpdate();
			System.out.println(i + " records updated");
			System.out.println(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
		String sql = "UPDATE artist SET last_name = ? WHERE artist_id = ?;";
		try {
			PreparedStatement stmt = db.Getconn().prepareStatement(sql);
			stmt.setString(1, this.lastName);
			stmt.setString(2, this.artistID);
			int i = stmt.executeUpdate();
			System.out.println(i + " records updated");
			System.out.println(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getBandName() {
		return bandName;
	}
	public void setBandName(String bandName) {
		this.bandName = bandName;
		String sql = "UPDATE artist SET band_name = ? WHERE artist_id = ?;";
		try {
			PreparedStatement stmt = db.Getconn().prepareStatement(sql);
			stmt.setString(1, this.bandName);
			stmt.setString(2, this.artistID);
			int i = stmt.executeUpdate();
			System.out.println(i + " records updated");
			System.out.println(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio= bio;
		String sql = "UPDATE artist SET bio = ? WHERE artist_id = ?;";
		try {
			PreparedStatement stmt = db.Getconn().prepareStatement(sql);
			stmt.setString(1, this.bio);
			stmt.setString(2, this.artistID);
			int i = stmt.executeUpdate();
			System.out.println(i + " records updated");
			System.out.println(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getArtistID() {
		 return artistID;
	}
	public void setArtistID(String artistID) {
		this.artistID = artistID;
	}

}
