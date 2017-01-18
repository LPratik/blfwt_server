package com.pron.blfwt.admin.service;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pron.blfwt.admin.utils.Constants;
import com.pron.blfwt.admin.model.JsonResponse;

@Component
public class BaseService {

	public  Logger LOGGER = LoggerFactory.getLogger(BaseService.class);
	@Autowired
	protected ObjectMapper objectMapper;
	
	
	@Autowired
	private MessageSource messageSource;

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	protected String resolveLocalizedMessage(String messageCode) {
   	 Locale currentLocale =  LocaleContextHolder.getLocale();
        
        String localizedErrorMessage = messageSource.getMessage(messageCode,new Object[]{}, currentLocale);

        return localizedErrorMessage;
	}
	protected JsonResponse getErrorDetails(JsonNode node) throws JsonParseException, JsonMappingException, IOException {
    	JsonResponse errors = JsonResponse.instance(node.get("code").intValue(),node.get("messageId").textValue(),node.get("message").textValue());
    	JsonNode nodes = node.get("errors");
        for (JsonNode errorNode: nodes) {
        	errors.addFieldError(errorNode.get("field").textValue(), errorNode.get("message").textValue());
        }
 
        return errors;
	
		}
	
	
	protected void addCookie(HttpServletResponse response, String cookieName, String sessionId, int cookieAge){
		Cookie cookie = new Cookie(cookieName, sessionId);
		cookie.setMaxAge(cookieAge);
		cookie.setSecure(Constants.COOKIE_SECURE);
		cookie.setPath("/");
		response.addCookie(cookie);
	}
}
