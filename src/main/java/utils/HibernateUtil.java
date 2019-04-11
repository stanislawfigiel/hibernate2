package utils;

import entity.*;
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
			configuration.addAnnotatedClass(Market.class);
			configuration.addAnnotatedClass(Bond.class);
			configuration.addAnnotatedClass(InheritInvestmentTablePerClass.class);
			configuration.addAnnotatedClass(BondTablePerClass.class);
			configuration.addAnnotatedClass(Portfolio.class);
			configuration.addAnnotatedClass(InheritInvestmentSingleTable.class);
			configuration.addAnnotatedClass(BondSingleTable.class);


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
