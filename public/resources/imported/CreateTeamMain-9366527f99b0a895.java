package example.hibernate.associations.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import example.hibernate.associations.one_to_many.unidirectional.entity.IplTeam;
import example.hibernate.associations.utils.HibernateUtils;

public class CreateTeamMain {

	public static void main(String[] args) {
		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
				Session session = factory.openSession()
				){
			IplTeam team1 = 
			new IplTeam("RCB", "Royal Challengers Bangalore", 1, null);
			
			IplTeam team2 = 
			new IplTeam("SRH", "Sunrisers Hyderabad", 2, null);
			
			Transaction tx = session.beginTransaction();
				session.persist(team1);
				session.persist(team2);
			tx.commit();
			System.out.println("IPL teams created.");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}
	
	
	
	
	
	

}
