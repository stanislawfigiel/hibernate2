import entity.BondSingleTable;
import entity.BondTablePerClass;
import entity.Portfolio;
import entity.PortfolioSingleTable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.math.BigDecimal;

public class Application4 {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Session session1 = null;
		Transaction tx = null;
		Transaction tx1 = null;

		try{
			BigDecimal bd = new BigDecimal(11);
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			PortfolioSingleTable portfolio = new PortfolioSingleTable();
			portfolio.setName("TEST NAME");

			BondSingleTable bond = new BondSingleTable();
			bond.setName("AAA");
			bond.setIssuer("ISSUER");
			bond.setValue(bd);
			bond.setPortfolio(portfolio);
			portfolio.getInvestment().add(bond);


			session.persist(portfolio);
			tx.commit();


			BondSingleTable prt = session.get(BondSingleTable.class, 453L);

			System.out.println("OBJECT:" +  prt);
			session.close();



		} catch (Exception exc){
			exc.printStackTrace();
			System.out.println("EXCEPTION: " );

		}
	}

}
