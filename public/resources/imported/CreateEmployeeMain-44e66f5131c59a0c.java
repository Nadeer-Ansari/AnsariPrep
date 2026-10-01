package example.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import example.hibernate.entity.Employee;
import example.hibernate.utils.HibernateUtils;

public class CreateEmployeeMain {

	public static void main(String[] args) {
		try (
				SessionFactory factory = HibernateUtils.getSessionFactory();
				Session session = factory.openSession()
				){
			Employee emp = new Employee(null, "Ravi", 32654.7f);
			
			Transaction tx = session.beginTransaction();
			session.persist(emp);
			
			
			tx.commit();
			System.out.println("Employee created");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}




