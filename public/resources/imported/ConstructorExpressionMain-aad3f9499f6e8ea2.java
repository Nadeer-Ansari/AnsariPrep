package example.hibernate.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import example.hibernate.bean.NameAndSalary;
import example.hibernate.entity.Employee;
import example.hibernate.utils.HibernateUtils;

public class ConstructorExpressionMain {

	public static void main(String[] args) {
		try (
				SessionFactory factory = HibernateUtils.getSessionFactory();
				Session session = factory.openSession()
				){
			//Fetching name and salary of all employees and displaying them
			String hqlQuery = 
"select new example.hibernate.bean.NameAndSalary(emp.name, emp.salary) from Employee emp";
			Query<NameAndSalary> qr =
			session.createQuery(hqlQuery, NameAndSalary.class);
			
			List<NameAndSalary> dataList = qr.list();
			for(NameAndSalary data : dataList)
				System.out.println(data);			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}





