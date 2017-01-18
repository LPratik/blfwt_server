package com.pron.blfwt.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pron.blfwt.admin.config.AuthenticatedRestAction;
import com.pron.blfwt.admin.config.UnAuthenticatedRestAction;
import com.pron.blfwt.admin.exceptions.ManagerBusinessException;
import com.pron.blfwt.admin.exceptions.ManagerDatabaseException;
import com.pron.blfwt.admin.handler.ApplicationServiceHandler;
import com.pron.blfwt.admin.model.JsonResponse;
import com.pron.blfwt.admin.model.MemberVO;
import com.pron.blfwt.admin.utils.Constants;

@RestController
@RequestMapping("/member")
public class MemberController {

	Logger LOGGER = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private ApplicationServiceHandler applicationServiceHandler;
	
	
	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody ResponseEntity<?> addNewMember (
			@CookieValue(name=Constants.ADMIN_SESSION_ID, required=false) String sessionId, 
			@RequestBody MemberVO memberVO,
			HttpServletRequest request, HttpServletResponse response) throws ManagerDatabaseException, ManagerBusinessException, Exception{
		return applicationServiceHandler.process(AuthenticatedRestAction.ADD_MEMBER, sessionId, memberVO, null, request, response);
	}
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getAllMembers (
			@CookieValue(name=Constants.ADMIN_SESSION_ID, required=false) String sessionId,
			HttpServletRequest request, HttpServletResponse response) throws ManagerDatabaseException, ManagerBusinessException, Exception{
		return applicationServiceHandler.process(AuthenticatedRestAction.GET_ALL_MEMBERS, sessionId, null, null, request, response);
	}
	
	@RequestMapping(path = "/{memberId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getMemberById (
			@CookieValue(name=Constants.ADMIN_SESSION_ID, required=false) String sessionId,
			@PathVariable(Constants.PARAM_MEMBER_ID) String memberId, 
			HttpServletRequest request, HttpServletResponse response) throws ManagerDatabaseException, ManagerBusinessException, Exception{
		return applicationServiceHandler.process(AuthenticatedRestAction.GET_MEMBER_BY_ID, sessionId, null, memberId, request, response);
	}
	
	@RequestMapping(path = "/{memberName}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getMemberByName (
			@CookieValue(name=Constants.ADMIN_SESSION_ID, required=false) String sessionId,
			@RequestParam(Constants.PARAM_MEMBER_NAME) String memberName,
			HttpServletRequest request, HttpServletResponse response) throws ManagerDatabaseException, ManagerBusinessException, Exception{
		return applicationServiceHandler.process(AuthenticatedRestAction.GET_MEMBER_BY_NAME, sessionId, null, memberName, request, response);
	}
}
