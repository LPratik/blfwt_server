package com.pron.blfwt.admin.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pron.blfwt.admin.config.AuthenticatedRestAction;
import com.pron.blfwt.admin.config.UnAuthenticatedRestAction;
import com.pron.blfwt.admin.dao.AdminUserDao;
import com.pron.blfwt.admin.dao.AdminUserSessionDao;
import com.pron.blfwt.admin.dto.AdminUserDTO;
import com.pron.blfwt.admin.entity.AdminSession;
import com.pron.blfwt.admin.entity.AdminUser;
import com.pron.blfwt.admin.exceptions.ManagerBusinessException;
import com.pron.blfwt.admin.exceptions.ManagerDatabaseException;
import com.pron.blfwt.admin.handler.BaseHandler;
import com.pron.blfwt.admin.model.AdminUserVO;
import com.pron.blfwt.admin.model.JsonResponse;
import com.pron.blfwt.admin.service.AdminSessionService;
import com.pron.blfwt.admin.utils.Constants;
import com.pron.blfwt.admin.utils.Messages;


@Service("adminSessionService")
public class AdminSessionServiceImpl extends BaseHandler implements AdminSessionService{
	
	@Autowired
	private AdminUserSessionDao adminUserSessionDao; 
	
	@Autowired
	private AdminUserDao adminUserDao;
	
	@Autowired
	private Mapper dozerBeanMapper;

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public JsonResponse login(AdminUserVO adminUserVO, HttpServletRequest request, HttpServletResponse response) throws ManagerDatabaseException, ManagerBusinessException {
		AdminUser dbAdminUser = adminUserDao.getAdminUser(adminUserVO.getEmail(), adminUserVO.getPassword());
		if(dbAdminUser != null){
			String sessionId = UUID.randomUUID().toString();
			adminUserSessionDao.createSession(sessionId, dbAdminUser);
			addCookie(response, Constants.ADMIN_SESSION_ID, sessionId, Constants.ADMIN_SESSION_COOKIE_MAX_AGE);
			AdminUserDTO adminUserDto =  dozerBeanMapper.map(dbAdminUser, AdminUserDTO.class);
			//adminUserDto.setPassword(null);
			return JsonResponse.instance(HttpStatus.OK.value(),Messages.MESSAGE_GENERIC_OK,resolveLocalizedMessage(Messages.MESSAGE_GENERIC_OK), adminUserDto);
		}
		else
		{
			throw new ManagerBusinessException(UnAuthenticatedRestAction.POST_SESSION.name(),Messages.Message_INVALID_USER_PASSWORD,resolveLocalizedMessage(Messages.Message_INVALID_USER_PASSWORD));
		}
	}

	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public AdminUserDTO checkSession(String sessionId, HttpServletResponse response) throws ManagerDatabaseException, ManagerBusinessException {
		AdminSession session = adminUserSessionDao.getSession(sessionId);
		if(session != null){
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.MINUTE, -Constants.SESSION_TIME_INTERVAL);
			Date lastAcessDate = calendar.getTime();
			if(session.getLastAccess().after(lastAcessDate)){
				adminUserSessionDao.updateSession(session);
				AdminUserDTO adminUserDTO = dozerBeanMapper.map(session.getAdminUser(),  AdminUserDTO.class);
				return adminUserDTO;
			}
			else
			{
				addCookie(response, Constants.ADMIN_SESSION_ID, Constants.EMPTY_STRING, Constants.COOKIE_EMPTY_STRING_AGE);
				throw new ManagerBusinessException(AuthenticatedRestAction.GET_SESSION.name(),Messages.Message_INVALID_SESSION,resolveLocalizedMessage(Messages.Message_INVALID_SESSION) );
			}
		}
		else
		{
			throw new ManagerBusinessException(AuthenticatedRestAction.GET_SESSION.name(),Messages.Message_INVALID_SESSION,resolveLocalizedMessage(Messages.Message_INVALID_SESSION) );
		}
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void deleteSession(String sessionId, HttpServletResponse response) throws ManagerDatabaseException {
		AdminSession session = adminUserSessionDao.getSession(sessionId);
		adminUserSessionDao.deleteSession(session);
		addCookie(response, Constants.ADMIN_SESSION_ID, Constants.EMPTY_STRING, Constants.COOKIE_EMPTY_STRING_AGE);
	}
	
	private void addCookie(HttpServletResponse response, String cookieName, String sessionId, int cookieAge){
		Cookie cookie = new Cookie(cookieName, sessionId);
		cookie.setMaxAge(cookieAge);
		cookie.setSecure(Constants.COOKIE_SECURE);
		cookie.setPath("/");
		response.addCookie(cookie);
	}

	public AdminUserSessionDao getAdminUserSessionDao() {
		return adminUserSessionDao;
	}

	public void setAdminUserSessionDao(AdminUserSessionDao adminUserSessionDao) {
		this.adminUserSessionDao = adminUserSessionDao;
	}

	public Mapper getDozerBeanMapper() {
		return dozerBeanMapper;
	}

	public void setDozerBeanMapper(Mapper dozerBeanMapper) {
		this.dozerBeanMapper = dozerBeanMapper;
	}
}
