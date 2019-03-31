import entity.Address;
import entity.Bank;
import entity.User;
import entity.enumerations.UserType;
import org.hibernate.Session;
import utils.HibernateUtil;

import java.util.Date;

public class Application {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Date date = new Date(73, 5, 8);
			//	Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Bank bank=  new Bank();
            bank.setName("BANK 1");
            bank.getContacts().add("AA");
            bank.getContacts().add("BB");
            bank.getContacts().add("CC");

            bank.getContactsMapped().put("AA","SSS");
            bank.getContactsMapped().put("BB","QQQQQQ");

			Address address = new Address();
			address.setAddressLine1("ADDRESS LINE 1");
			address.setAddressLine2("ADDRESS LINE 2");
			address.setCity("Warsaw");
			address.setState("mazowieckie");
			address.setZipCode("62-800");
			User user = new User();
			user.setBirthDate(date);
			user.setFirstName("aaaa");
			user.setLastName("bbbb");
			user.setEmail("wwwwwww@wp.pl");
			user.setUserType(UserType.ADMIN);
			user.setAddress(address);
			user.getAddresses().add(address);
			bank.setAddress(address);

			session.save(user);
			session.save(bank);
			session.getTransaction().commit();
			session.refresh(user);
			System.out.println("age:" + user.getAge());
		} catch (RuntimeException exc) {
			System.out.println("err:" + exc.getMessage());
		} finally {
			session.close();
		}
	}

}
