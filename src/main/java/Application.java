import entity.User;
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
			User user = new User();
			user.setBirthDate(date);
			user.setFirstName("aaaa");
			user.setLastName("bbbb");
			user.setEmail("wwwwwww@wp.pl");
			session.save(user);
			session.getTransaction().commit();
			//	session.close();
			session.refresh(user);
			System.out.println("age:" + user.getAge());
		} catch (RuntimeException exc) {
		} finally {
			session.close();
		}
	}

}
