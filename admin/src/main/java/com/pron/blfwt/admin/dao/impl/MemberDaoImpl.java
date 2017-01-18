package com.pron.blfwt.admin.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pron.blfwt.admin.dao.MemberDao;
import com.pron.blfwt.admin.entity.AdminSession;
import com.pron.blfwt.admin.entity.Member;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired(required=false)
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional(readOnly=true)
	public Member getMemberById(Integer memberId) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Member.class);
		criteria.add(Restrictions.eq("id", memberId));
		criteria.add(Restrictions.isNull("deleted"));
		Member member = (Member) criteria.uniqueResult();
		return member;
	}

	@Override
	public Member addMember(Member member) {
		Session session = sessionFactory.getCurrentSession();
		Date currentDate  = UtilsDAO.getDBTimeStamp(session);
		member.setCreated(currentDate);
		session.save(member);
		return member;
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Member> getAllMembers() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Member.class);
		criteria.add(Restrictions.isNull("deleted"));
		List<Member> memberList = criteria.list();
		return memberList;
	}

	@Override
	@Transactional(readOnly=true)
	public Member getMemberByName(String memberName) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Member.class);
		criteria.add(Restrictions.eq("name", memberName));
		//criteria.add(Restrictions.like("name", "%"+memberName+"%"));
		criteria.add(Restrictions.isNull("deleted"));
		Member member = (Member) criteria.uniqueResult();
		return member;
	}

}
