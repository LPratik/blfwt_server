package com.pron.blfwt.admin.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;

import com.pron.blfwt.admin.config.AuthenticatedRestAction;
import com.pron.blfwt.admin.config.UnAuthenticatedRestAction;
import com.pron.blfwt.admin.exceptions.ManagerBusinessException;
import com.pron.blfwt.admin.exceptions.ManagerDatabaseException;
import com.pron.blfwt.admin.model.JsonResponse;



public interface ApplicationServiceHandler {

	public ResponseEntity<?> process(AuthenticatedRestAction action, final String sessionId,Object param, String schoolId, HttpServletRequest httpRequest,HttpServletResponse response) throws ManagerDatabaseException, ManagerBusinessException, Exception;

	public JsonResponse process(UnAuthenticatedRestAction action, final String sessionId,Object param,HttpServletRequest httpRequest, HttpServletResponse response) throws ManagerDatabaseException, ManagerBusinessException;

}
