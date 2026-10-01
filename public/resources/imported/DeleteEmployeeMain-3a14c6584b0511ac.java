package example.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import example.hibernate.entity.Employee;
import example.hibernate.utils.HibernateUtils;

public class DeleteEmployeeMain {

	public static void main(String[] args) {
		try (
				SessionFactory factory = HibernateUtils.getSessionFactory();
				Session session = factory.openSession()
				){
			
			Employee foundEmp = session.find(Employee.class, 4);
			if(foundEmp != null) {
				Transaction tx = session.beginTransaction();
				session.remove(foundEmp);
				tx.commit();
				System.out.println("Employee deleted.");
			}				
			else
				System.out.println("Employee with given ID does not exist");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}






