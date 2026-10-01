package example.hibernate.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import example.hibernate.entity.Employee;
import example.hibernate.utils.HibernateUtils;

public class FromClauseMain {

	public static void main(String[] args) {
		try (
				SessionFactory factory = HibernateUtils.getSessionFactory();
				Session session = factory.openSession()
				){
			//Fetching all employees and displaying them
			String hqlQuery = "from Employee emp";
			
			Query<Employee> qr =
			session.createQuery(hqlQuery, Employee.class);
			
			List<Employee> empList = qr.list();
			//Alternatives
			//empList.stream().forEach(emp -> System.out.println(emp));
			//empList.stream().forEach(System.out::println);
			
			for(Employee currentEmp : empList)
				System.out.println(currentEmp);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}





