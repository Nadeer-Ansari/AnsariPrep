package example.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import example.hibernate.entity.Employee;
import example.hibernate.utils.HibernateUtils;

public class UpdateEmployeeMain {

	public static void main(String[] args) {
		try (
				SessionFactory factory = HibernateUtils.getSessionFactory();
				Session session = factory.openSession()
				){
			
			Employee foundEmp = session.find(Employee.class, 2);
			if(foundEmp != null) {
				Transaction tx = session.beginTransaction();
				foundEmp.setName("Jayesh");
				foundEmp.setSalary(50000);
				tx.commit();
				System.out.println("Employee updated.");
			}				
			else
				System.out.println("Employee with given ID does not exist");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}






