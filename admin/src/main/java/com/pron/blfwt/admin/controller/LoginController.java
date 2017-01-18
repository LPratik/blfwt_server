package com.pron.blfwt.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pron.blfwt.admin.config.AuthenticatedRestAction;
import com.pron.blfwt.admin.config.UnAuthenticatedRestAction;
import com.pron.blfwt.admin.exceptions.ManagerBusinessException;
import com.pron.blfwt.admin.exceptions.ManagerDatabaseException;
import com.pron.blfwt.admin.handler.ApplicationServiceHandler;
import com.pron.blfwt.admin.model.AdminUserVO;
import com.pron.blfwt.admin.model.JsonResponse;
import com.pron.blfwt.admin.utils.Constants;
/**
 * 
 * @author Proneuver
 *
 */
		
@RestController
@RequestMapping("/session")
public class LoginController{
	
	Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private ApplicationServiceHandler applicationServiceHandler;
	
	
	/*@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    binder.setValidator(new AdminUserValidator());
	}*/

	/**
	 * This method is used to get current session.
	 * @param sessionId
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody ResponseEntity<?> getSession(@CookieValue(name=Constants.ADMIN_SESSION_ID, required=false) String sessionId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOGGER.info(sessionId);
		return applicationServiceHandler.process(AuthenticatedRestAction.GET_SESSION, sessionId, null,null, request, response);
    }
	
	/**
	 * This method is used to create session for admin user.
	 * @param adminUserVO
	 * @param request
	 * @param response
	 * @return
	 * @throws ManagerBusinessException 
	 * @throws ManagerDatabaseException 
	 */
	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody JsonResponse login(@Validated @RequestBody AdminUserVO adminUserVO,HttpServletRequest request, HttpServletResponse response) throws ManagerDatabaseException, ManagerBusinessException {
		return applicationServiceHandler.process(UnAuthenticatedRestAction.POST_SESSION, null, adminUserVO, request, response);
    }
	
	
	/**
	 * This method is used to delete current session.
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody ResponseEntity<?> deleteSession(@CookieValue(name=Constants.ADMIN_SESSION_ID, required=false) String sessionId, HttpServletRequest request, HttpServletResponse response)  throws Exception {
		LOGGER.info(sessionId);
		return applicationServiceHandler.process(AuthenticatedRestAction.DELETE_SESSION, sessionId, null,null, request, response);
 
    }

}
