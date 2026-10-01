package example.hibernate.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import example.hibernate.entity.Employee;

public class HibernateUtils {
	public static SessionFactory getSessionFactory() {
		Configuration conf = new Configuration();
		conf.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		conf.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/cdac");
		conf.setProperty("hibernate.connection.username", "root");
		conf.setProperty("hibernate.connection.password", "password");
		conf.setProperty("hibernate.hbm2ddl.auto", "update");
		conf.setProperty("hibernate.show_sql", "true");
		
		//Class<Employee> entityClass = Employee.class;
		conf.addAnnotatedClass(Employee.class);
		SessionFactory factory = conf.buildSessionFactory();
		return factory;
	}
}






