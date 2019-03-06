package wez78_Music;


import javax.persistence.*;

public class AlbumManager {
	// create createAlbum(),updateAlbum(), deleteAlbum(),findAlbum()

	

	public void createAlbum(String title, String releaseDate, String coverImagePath, String recordingCompany, int numberOfTracks, String pmrcRating, int length) {	
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("wez78_Music");
		EntityManager em = emFactory.createEntityManager();
		em.getTransaction().begin();
         Album a  = new Album();
		a.setTitle(title);
		a.setAlbumID(java.util.UUID.randomUUID().toString());
		a.setReleaseDate(releaseDate);
		a.setRecordingCompany(recordingCompany);
		a.setNumberOfTracks(numberOfTracks);
		a.setPmrcRating(pmrcRating);
		a.setLength(length);
		em.persist(a);
		em.getTransaction().commit();
		
		// close the connection
		em.close();
		emFactory.close();
}
	public void updateAlbum(String albumID, String title, String releaseDate, String coverImagePath, String recordingCompany, int numberOfTracks, String pmrcRating, int length) {
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("wez78_Music");
		EntityManager em = emFactory.createEntityManager();
		
		//begin 
       em.getTransaction().begin();
		Album a = em.find(Album.class, albumID);

		if(!title.equals("")) {
			a.setTitle(title);
		}
		
		if(!releaseDate.equals("")) {
			a.setReleaseDate(releaseDate);
		}
		
		if(!coverImagePath.equals("")) {
			a.setCoverImagePath(coverImagePath);
		}
		
		if(!recordingCompany.equals("")) {
			a.setRecordingCompany(recordingCompany);
		}
		
		if(numberOfTracks > 0) {
			a.setNumberOfTracks(numberOfTracks);
		}
		
		if(!pmrcRating.equals("")) {
			a.setPmrcRating(pmrcRating);
		}
		
		if(length > 0) {
			a.setLength(length);
		}
		
		em.persist(a);
		
		em.getTransaction().commit();
		
		//close
		em.close();
		emFactory.close();
}


public void deleteAlbum(String albumID) {
	EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("wez78");
	EntityManager em = emFactory.createEntityManager();
	
	//begins 
	em.getTransaction().begin();
	
	Album a= em.find(Album.class, albumID);
	em.remove(a);
	
	
	em.getTransaction().commit();
	
	// Close the connection  
	em.close();
	emFactory.close();	
}


public Album findAlbum(String albumID) {
	EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("wez78");
	EntityManager em = emFactory.createEntityManager();
	
	Album a = em.find(Album.class, albumID);
	
	em.close();
	emFactory.close();	
	
	return a;
	
}
}