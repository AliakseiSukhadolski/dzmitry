package by.grsu.registration.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import by.grsu.registration.dao.util.HibernateUtil;
import by.grsu.registration.model.User;

public class UserDao {
	
	private HibernateUtil hibernateUtil;
	
	public UserDao(){
		hibernateUtil = HibernateUtil.getInstance();
	}
	
	public User getUser(String email, String password){
		User user = null;
		Session session = null;
		try {
			session = hibernateUtil.getSessionFactory().getCurrentSession();
			session.getTransaction().begin();
			Criteria cr = session.createCriteria(User.class);
			cr.add(Restrictions.eq("email", email));
			cr.add(Restrictions.eq("password", password));
			user = (User) cr.uniqueResult();
			session.getTransaction().commit();
			return user;
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
		return user;
	}
	

}
