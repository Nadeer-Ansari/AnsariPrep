package example.hibernate.associations.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import example.hibernate.associations.many_to_many.bidirectional.entity.Candidate;
import example.hibernate.associations.many_to_many.bidirectional.entity.Certification;
import example.hibernate.associations.utils.HibernateUtils;

public class CandidateCertificationLinkerMain {

	public static void main(String[] args) {
		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
				Session session = factory.openSession()
				){
			//Find the candidates
			Candidate cd1 = session.find(Candidate.class, 1);
			Candidate cd2 = session.find(Candidate.class, 2);
			//Find the certifications
			Certification c1 = session.find(Certification.class, "C1");
			Certification c2 = session.find(Certification.class, "C2");
			Certification c3 = session.find(Certification.class, "C3");
			//Link them
			Transaction tx = session.beginTransaction();
				cd1.addCertification(c1);
				cd1.addCertification(c3);
				cd2.addCertification(c2);
				cd2.addCertification(c3);
			tx.commit();
			System.out.println("Certifications linked to candidates");
			
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}



