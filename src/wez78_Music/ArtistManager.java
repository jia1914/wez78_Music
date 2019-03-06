package wez78_Music;
import javax.persistence.*;
public class ArtistManager {
	//create createArtist(),updateArtist(),deleteArtist(),findArtist()
	

		
		public void createArtist(String firstName, String lastName, String bandName, String bio) {
			EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("wez78_Music");
			EntityManager em = emFactory.createEntityManager();
			
			//starts 
			em.getTransaction().begin();
			Artist t = new Artist();
			
			t.setArtistID(java.util.UUID.randomUUID().toString());
			t.setFirstName(firstName);
			t.setLastName(lastName);
			t.setBandName(bandName);
			t.setBio(bio);
			em.persist(t);
			em.getTransaction().commit();
			//Close connection  
			em.close();
			emFactory.close();
		}

		public void updateArtist(String artistID, String firstName, String lastName, String bandName, String bio) {
			
			EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("wez78_Music");
			EntityManager em = emFactory.createEntityManager();
			
			//starts 
			em.getTransaction().begin();
			Artist t = em.find(Artist.class, artistID);
			
			 
			if(!firstName.equals("")) {
				t.setFirstName(firstName);
			}

			if(!lastName.equals("")) {
				t.setLastName(lastName);
			}
			
			if(!bandName.equals("")) {
				t.setBandName(bandName);
			}
			
			if(!bio.equals("")) {
				t.setBio(bio);
			}
			
			em.persist(t);
			em.getTransaction().commit();
			
			//Close connection 
			em.close();
			emFactory.close();
		}
		
		public void deleteArtist(String artistID) {
			
			EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("wez78_Music");
			EntityManager em = emFactory.createEntityManager();
			
			//starts 
			em.getTransaction().begin();
			Artist t = em.find(Artist.class, artistID);
			
			em.remove(t);
			em.getTransaction().commit();
			
			//Close connection  
			em.close();
			emFactory.close();
		}
		
		public Artist findArtist(String artistID) {
			EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("wez78_Music");
			EntityManager em = emFactory.createEntityManager();
			
			//starts 
			em.getTransaction().begin();
			Artist t = em.find(Artist.class, artistID);
			
			//Close connection 
			em.close();
			emFactory.close();
			
			return t;
		}
		
}


