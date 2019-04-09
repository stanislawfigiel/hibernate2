import entity.Bond;
import entity.BondTablePerClass;
import entity.Portfolio;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

public class Application3 {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Session session1 = null;
		Transaction tx = null;
		Transaction tx1 = null;

		try{
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Portfolio portfolio = new Portfolio();
			portfolio.setName("TEST NAME");

			BondTablePerClass bond = new BondTablePerClass();
			bond.setName("AAA");
			bond.setIssuer("ISSUER");
			bond.setPortfolio(portfolio);
			portfolio.getInvestment().add(bond);


			session.persist(portfolio);
			tx.commit();
			session.close();



		} catch (Exception exc){
			exc.printStackTrace();
			System.out.println("EXCEPTION: " );

		}
	}

}
