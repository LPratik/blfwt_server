package com.pron.blfwt.admin.handler.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.pron.blfwt.admin.config.AuthenticatedRestAction;
import com.pron.blfwt.admin.config.UnAuthenticatedRestAction;
import com.pron.blfwt.admin.dto.AdminUserDTO;
import com.pron.blfwt.admin.exceptions.ManagerBusinessException;
import com.pron.blfwt.admin.exceptions.ManagerDatabaseException;
import com.pron.blfwt.admin.handler.ApplicationServiceHandler;
import com.pron.blfwt.admin.handler.BaseHandler;
import com.pron.blfwt.admin.model.AdminUserVO;
import com.pron.blfwt.admin.model.JsonResponse;
import com.pron.blfwt.admin.model.MemberVO;
import com.pron.blfwt.admin.service.AdminMemberService;
import com.pron.blfwt.admin.service.AdminSessionService;


@Component("applicationServiceHandler")
public class ApplicationServiceHandlerImpl extends BaseHandler implements ApplicationServiceHandler{
	Logger LOGGER = LoggerFactory.getLogger(ApplicationServiceHandlerImpl.class); 
	
	@Autowired
	private AdminSessionService adminSessionService; 
	
	@Autowired 
	private AdminMemberService adminMemberService;

	
	public ResponseEntity<?> process(AuthenticatedRestAction action, String sessionId, Object param,String paramId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		AdminUserDTO userVO = adminSessionService.checkSession(sessionId, response);
	
		switch(action){
		
			case GET_SESSION :
					//return ResponseEntity.status(HttpStatus.OK).body(JsonResponse.instance(HttpStatus.OK.value(),Messages.MESSAGE_GENERIC_OK,resolveLocalizedMessage(Messages.MESSAGE_GENERIC_OK) ,userVO));
			case DELETE_SESSION:
				 adminSessionService.deleteSession(sessionId, response);
				 break;
			
			case ADD_MEMBER :	 
				return adminMemberService.addMember((MemberVO) param, request, response);
				
			case GET_ALL_MEMBERS:
				return adminMemberService.getAllMembers(request, response);
				
			case GET_MEMBER_BY_ID:
				return adminMemberService.getMemberById(paramId,request,response);
			
			case GET_MEMBER_BY_NAME:
				return adminMemberService.getMemberByName(paramId, request, response);
			default :
				//return ResponseEntity.status(HttpStatus.OK).body(JsonResponse.instance(HttpStatus.FORBIDDEN.value(), Messages.MESSAGE_INVALID_USERTYPE_ACCESS,resolveLocalizedMessage(Messages.MESSAGE_INVALID_USERTYPE_ACCESS)));
		}
		return null;
	}

	public JsonResponse process(UnAuthenticatedRestAction action, String tenantId, Object paramMap, HttpServletRequest request, HttpServletResponse response) throws ManagerDatabaseException, ManagerBusinessException {
		switch(action){
		case POST_SESSION :
			return adminSessionService.login((AdminUserVO)paramMap, request, response);
		case MONITOR_SERVER:
			return null;
	    		
		default :
			//return JsonResponse.instance(HttpStatus.FORBIDDEN.value(), Messages.MESSAGE_INVALID_USERTYPE_ACCESS,resolveLocalizedMessage(Messages.MESSAGE_INVALID_USERTYPE_ACCESS));

		}
		return null;

	}

	public AdminSessionService getAdminSessionService() {
		return adminSessionService;
	}

	public void setAdminSessionService(AdminSessionService adminSessionService) {
		this.adminSessionService = adminSessionService;
	}

	
	
}
