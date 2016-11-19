package com.pron.blfwt.admin.dao.impl;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pron.blfwt.admin.dao.AdminUserSessionDao;
import com.pron.blfwt.admin.entity.AdminSession;
import com.pron.blfwt.admin.entity.AdminUser;




@Repository
public class AdminUserSessionDaoImpl implements AdminUserSessionDao {

	@Autowired(required=false)
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional(readOnly=true)
	public AdminSession createSession(String sessionId, AdminUser adminUser) {
		Session session = sessionFactory.getCurrentSession();
		Date currentDate = UtilsDAO.getDBTimeStamp(session);
		AdminSession adminSession = new AdminSession();
		adminSession.setSessionId(sessionId);
		adminSession.setAdminUser(adminUser);
		adminSession.setCreated(currentDate);
		adminSession.setLastAccess(currentDate);
		session.save(adminSession);
		return adminSession;
	}

	@Override
	public AdminSession getSession(String sessionId) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(AdminSession.class);
		criteria.add(Restrictions.eq("sessionId", sessionId));
		criteria.add(Restrictions.isNull("deleted"));
		AdminSession adminSession = (AdminSession) criteria.uniqueResult();
		return adminSession;
	}

	@Override
	public boolean deleteSession(AdminSession adminSession) {
		Session session = sessionFactory.getCurrentSession();
		adminSession.setDeleted(UtilsDAO.getDBTimeStamp(session));
		session.save(adminSession);
		return true;
	}

	@Override
	public boolean updateSession(AdminSession adminSession) {
		Session session = sessionFactory.getCurrentSession();
		adminSession.setLastAccess(UtilsDAO.getDBTimeStamp(session));
		session.save(adminSession);
		return true;
	}

}
