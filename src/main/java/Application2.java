import entity.Bond;
import entity.Currency;
import entity.Market;
import entity.ids.CurrencyId;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

public class Application2 {

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
			Bond bond = new Bond();
			bond.setName("AAA");
			bond.setIssuer("ISSUER");

			session.persist(bond);
			tx.commit();
			session.close();



		} catch (Exception exc){
			exc.printStackTrace();
			System.out.println("EXCEPTION: " );

		}
	}

}
