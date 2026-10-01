package example.hibernate.associations.main;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import example.hibernate.associations.one_to_one.unidirectional.entity.Passport;
import example.hibernate.associations.utils.HibernateUtils;

public class CreatePassportMain {

	public static void main(String[] args) {
		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
				Session session = factory.openSession()
				){
			Passport passport1 = 
			new Passport(null, "Tejas", LocalDate.of(2031, 10, 25));
			
			Passport passport2 = 
			new Passport(null, "Anuya", LocalDate.of(2028, 5, 10));
			
			Transaction tx = session.beginTransaction();
				session.persist(passport1);
				session.persist(passport2);
			tx.commit();
			System.out.println("Passports created.");
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}






