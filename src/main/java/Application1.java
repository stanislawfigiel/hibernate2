import entity.Currency;
import entity.Market;
import entity.ids.CurrencyId;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;



public class Application1 {

	public static void main(String[] args) {

		SessionFactory sessionFactory = null;
		Session session = null;
		Session session1 = null;
		Transaction tx = null;
		Transaction tx1 = null;

		try{
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
//			tx = session.beginTransaction();
//			Currency currency = new Currency();
//			currency.setCountryName("UnitedStates");
//			currency.setName("Dollar");
//			currency.setSymbol("$");
//			session.persist(currency);
//			tx.commit();

			session1 = sessionFactory.openSession();
			tx1 = session1.beginTransaction();
			CurrencyId currencyId = new CurrencyId("Dollar", "UnitedStates");
			Currency currency1 = (Currency) session1.get(Currency.class, currencyId);

			System.out.println("CURRENCY2 NAME:" + currency1.getName());
			Market market = new Market();
			market.setMarketName("ALA");
			market.setCurrency(currency1);
			session1.persist(market);
			tx1.commit();
			session1.close();

		} catch (Exception exc){
			exc.printStackTrace();
			System.out.println("EXCEPTION: " );

		}


	}

}
