package example.hibernate.associations.main;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import example.hibernate.associations.one_to_one.unidirectional.entity.Person;
import example.hibernate.associations.utils.HibernateUtils;

public class CreatePersonMain {

	public static void main(String[] args) {
		try(
				SessionFactory factory = HibernateUtils.getSessionFactory();
				Session session = factory.openSession()
				){
			Person person1 = 
			new Person(null, "Tejas", "tejas@gmail.com", null);
			Person person2 = 
			new Person(null, "Anuya", "anuya@gmail.com", null);
			
			Transaction tx = session.beginTransaction();
				session.persist(person1);
				session.persist(person2);
			tx.commit();
			System.out.println("Persons created.");
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}






