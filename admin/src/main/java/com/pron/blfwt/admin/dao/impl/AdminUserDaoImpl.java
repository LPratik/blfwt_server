package com.pron.blfwt.admin.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pron.blfwt.admin.dao.AdminUserDao;
import com.pron.blfwt.admin.entity.AdminUser;
import com.pron.blfwt.admin.exceptions.ManagerDatabaseException;



@Repository
public class AdminUserDaoImpl implements AdminUserDao {

	@Autowired(required=false)
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional(readOnly=true)
	public AdminUser getAdminUser(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		AdminUser user = session.get(AdminUser.class, id);
		return user;
	}

	@Override
	public AdminUser getAdminUser(String email, String password) {
		Session session = sessionFactory.getCurrentSession();
		
		Criteria criteria = session.createCriteria(AdminUser.class);
		criteria.add(Restrictions.eq("email", email));
		criteria.add(Restrictions.eq("password", password));
		criteria.add(Restrictions.isNull("deleted"));
		
		AdminUser user = (AdminUser)criteria.uniqueResult();
		return user;
	}

	@Override
	public AdminUser updateAdminUser(AdminUser adminUser) throws ManagerDatabaseException {
		Session session = sessionFactory.getCurrentSession();
		session.save(adminUser);
		return adminUser;
	}


	
}
