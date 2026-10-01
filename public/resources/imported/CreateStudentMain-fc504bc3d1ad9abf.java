package example.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import example.hibernate.entity.Student;

public class CreateStudentMain {

	public static void main(String[] args) {
		SessionFactory factory = null;
		Session session = null;
		try {
			//Configure Hibernate
			Configuration conf = new Configuration();
			conf = conf.configure();
			
			//Obtain a SessionFactory
			factory = conf.buildSessionFactory();
			
			//Obtain a Session
			session = factory.openSession();
			
			//Create an object of Entity class
			Student studentObj = new Student(12, "Neeta", 489);
			
			//Obtain a Transaction and start it
			Transaction tx = session.beginTransaction();
			
			//Store the entity object into session
			session.persist(studentObj);
			
			//Commit the transaction
			tx.commit();
			
			//Close the Session
			session.close();
			
			//Close the SessionFactory
			factory.close();
			
			System.out.println("Student created.");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		

	}

}
