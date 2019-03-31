package utils;

import entity.Bank;
import entity.Currency;
import entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	public static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory(){

		try{
			Configuration configuration = new Configuration();

			configuration.addAnnotatedClass(User.class);
			configuration.addAnnotatedClass(Bank.class);
			configuration.addAnnotatedClass(Currency.class);

			configuration.addPackage("entity");

			return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().build());
		}
		catch(Exception exc){
			exc.printStackTrace();
			throw new RuntimeException("ERROR DURING SESSION CREATION");
		}

	}

	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}

}
