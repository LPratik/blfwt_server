package com.pron.blfwt.admin.handler;

import java.io.IOException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pron.blfwt.admin.model.JsonResponse;


@Component
public class BaseHandler {
	
	@Autowired
	private MessageSource messageSource;
	    
  
	@Autowired
	protected ObjectMapper objectMapper;
	
    public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
    
    public BaseHandler() {
    }
    
    protected String resolveLocalizedMessage(String messageCode) {
    	 Locale currentLocale =  LocaleContextHolder.getLocale();
         
         String localizedErrorMessage = messageSource.getMessage(messageCode,new Object[]{}, currentLocale);

         return localizedErrorMessage;
	}
    
    
	protected JsonResponse getErrorDetails(JsonNode node) throws JsonParseException, JsonMappingException, IOException {
    	JsonResponse errors = JsonResponse.instance(node.get("code").intValue(),node.get("messageId").toString(),node.get("message").toString());
    	JsonNode nodes = node.get("errors");
        for (JsonNode errorNode: nodes) {
        	errors.addFieldError(errorNode.get("field").toString(), errorNode.get("message").toString());
        }
 
        return errors;
	
		}
}
