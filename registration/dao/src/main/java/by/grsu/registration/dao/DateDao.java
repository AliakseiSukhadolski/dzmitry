package by.grsu.registration.dao;

import org.hibernate.Session;

import by.grsu.registration.dao.util.HibernateUtil;
import by.grsu.registration.model.RegisterDate;

public class DateDao {
	private HibernateUtil hibernateUtil;

	public DateDao() {
		hibernateUtil = HibernateUtil.getInstance();
	}
	
	public void addDate(RegisterDate date){
		Session session = null;
		try {
			session = hibernateUtil.getSessionFactory().getCurrentSession();
			session.getTransaction().begin();
			session.save(date);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
}
