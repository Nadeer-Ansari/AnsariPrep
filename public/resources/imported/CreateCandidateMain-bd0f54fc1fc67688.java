package example.hibernate.associations.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import example.hibernate.associations.many_to_many.bidirectional.entity.Candidate;
import example.hibernate.associations.utils.HibernateUtils;

public class CreateCandidateMain {

	public static void main(String[] args) {
		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
				Session session = factory.openSession()
				){
			Candidate cd1 = new Candidate(null, "Ajay", null);
			Candidate cd2 = new Candidate(null, "Vijay", null);
			Transaction tx = session.beginTransaction();
				session.persist(cd1);
				session.persist(cd2);
			tx.commit();
			System.out.println("Candidates created.");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

}




