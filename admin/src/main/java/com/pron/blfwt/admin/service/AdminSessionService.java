package com.pron.blfwt.admin.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pron.blfwt.admin.dto.AdminUserDTO;
import com.pron.blfwt.admin.exceptions.ManagerBusinessException;
import com.pron.blfwt.admin.exceptions.ManagerDatabaseException;
import com.pron.blfwt.admin.model.AdminUserVO;
import com.pron.blfwt.admin.model.JsonResponse;

public interface AdminSessionService {

	JsonResponse login(AdminUserVO adminUser, HttpServletRequest request, HttpServletResponse response) throws ManagerDatabaseException, ManagerBusinessException;
	AdminUserDTO checkSession(String sessionId, HttpServletResponse response) throws ManagerDatabaseException, ManagerBusinessException;
	void deleteSession(String sessionId, HttpServletResponse response) throws ManagerDatabaseException;
}
