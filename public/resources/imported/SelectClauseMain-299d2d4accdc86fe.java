package example.hibernate.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import example.hibernate.entity.Employee;
import example.hibernate.utils.HibernateUtils;

public class SelectClauseMain {

	public static void main(String[] args) {
		try (
				SessionFactory factory = HibernateUtils.getSessionFactory();
				Session session = factory.openSession()
				){
			//Fetching name and salary of all employees and displaying them
			String hqlQuery = 
			"select emp.name, emp.salary from Employee emp";
			
			Query<Object[]> qr =
			session.createQuery(hqlQuery, Object[].class);
			
			List<Object[]> empDataList = qr.list();
			for(Object[] empData : empDataList) {
				Object empName = empData[0];
				Object empSal = empData[1];
				System.out.println(empName + " " + empSal);
			}
			
			
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}





