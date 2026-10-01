package example.hibernate.associations.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import example.hibernate.associations.one_to_one.unidirectional.entity.Passport;
import example.hibernate.associations.one_to_one.unidirectional.entity.Person;
import example.hibernate.associations.utils.HibernateUtils;

public class PersonPassportLinkerMain {

	public static void main(String[] args) {
		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
				Session session = factory.openSession()
				){
			//Find passports to be linked
			Passport passport1 = 
			session.find(Passport.class, "d230e161-5b5a-47ad-b281-4768645181ee");
			Passport passport2 = 
			session.find(Passport.class, "7ba2446b-03b2-4f29-baeb-db273155de9e");
			//Find persons to whom passports to be linked
			Person person1 = session.find(Person.class, 1);
			Person person2 = session.find(Person.class, 2);
			//Link them
			Transaction tx = session.beginTransaction();
				person1.setPassport(passport1);
				person2.setPassport(passport2);
			tx.commit();
			System.out.println("Passports linked to Persons");
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}




