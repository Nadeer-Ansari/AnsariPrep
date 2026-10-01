package example.hibernate.associations.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import example.hibernate.associations.one_to_many.unidirectional.entity.IplPlayer;
import example.hibernate.associations.utils.HibernateUtils;

public class CreatePlayerMain {

	public static void main(String[] args) {
		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
				Session session = factory.openSession()
				){
			IplPlayer player1 = new IplPlayer(null, "Virat Kohli", 37);
			IplPlayer player2 = new IplPlayer(null, "Rajat Patidar", 30);
			IplPlayer player3 = new IplPlayer(null, "Krunal Pandya", 31);
			IplPlayer player4 = new IplPlayer(null, "Josh Hazlewood", 35);
			IplPlayer player5 = new IplPlayer(null, "Abhishek Sharma", 26);
			IplPlayer player6 = new IplPlayer(null, "Travis Head", 36);
			IplPlayer player7 = new IplPlayer(null, "Ishan Kishan", 32);
			
			Transaction tx = session.beginTransaction();
				session.persist(player1);
				session.persist(player2);
				session.persist(player3);
				session.persist(player4);
				session.persist(player5);
				session.persist(player6);
				session.persist(player7);
			tx.commit();
			System.out.println("IPL players created");
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}






