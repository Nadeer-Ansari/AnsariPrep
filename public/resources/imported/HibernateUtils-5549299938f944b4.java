package example.hibernate.associations.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import example.hibernate.associations.many_to_many.bidirectional.entity.Candidate;
import example.hibernate.associations.many_to_many.bidirectional.entity.Certification;
import example.hibernate.associations.one_to_many.unidirectional.entity.IplPlayer;
import example.hibernate.associations.one_to_many.unidirectional.entity.IplTeam;
import example.hibernate.associations.one_to_one.unidirectional.entity.Passport;
import example.hibernate.associations.one_to_one.unidirectional.entity.Person;

public class HibernateUtils {
	public static SessionFactory getSessionFactory() {
		Configuration conf = new Configuration();
		conf.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		conf.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/associations");
		conf.setProperty("hibernate.connection.username", "root");
		conf.setProperty("hibernate.connection.password", "password");
		conf.setProperty("hibernate.hbm2ddl.auto", "update");
		conf.setProperty("hibernate.show_sql", "true");
		conf.addAnnotatedClasses(
				Person.class, 
				Passport.class,
				IplTeam.class,
				IplPlayer.class,
				Candidate.class,
				Certification.class
		);
		SessionFactory factory = conf.buildSessionFactory();
		return factory;
	}
}









