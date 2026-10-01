package example.hibernate.associations.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import example.hibernate.associations.many_to_many.bidirectional.entity.Certification;
import example.hibernate.associations.utils.HibernateUtils;

public class CreateCertificationMain {

	public static void main(String[] args) {
		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
				Session session = factory.openSession()
				){
			Certification c1 = new Certification("C1", "AWS", null);
			Certification c2 = new Certification("C2", "Scrum", null);
			Certification c3 = new Certification("C3", "DevOps", null);
			
			Transaction tx = session.beginTransaction();
				session.persist(c1);
				session.persist(c2);
				session.persist(c3);
			tx.commit();
			System.out.println("Certifications created.");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
