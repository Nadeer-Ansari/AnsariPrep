package example.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import example.hibernate.entity.Employee;
import example.hibernate.utils.HibernateUtils;

public class RetrieveEmployeeMain {

	public static void main(String[] args) {
		try (
				SessionFactory factory = HibernateUtils.getSessionFactory();
				Session session = factory.openSession()
				){
			//Class<Employee> entityClass = Employee.class;
			//Object empId = 4;
			Employee foundEmp = session.find(Employee.class, 2);
			if(foundEmp != null)
				System.out.println(foundEmp);
			else
				System.out.println("Employee with given ID does not exist");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}






