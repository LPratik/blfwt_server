package com.pron.blfwt.admin.handler.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pron.blfwt.admin.exceptions.ManagerBusinessException;
import com.pron.blfwt.admin.model.JsonResponse;



@ControllerAdvice
public class BusinessExceptionHandler {
	Logger LOGGER = LoggerFactory.getLogger(BusinessExceptionHandler.class);
 
    @ExceptionHandler(value = ManagerBusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public JsonResponse processException(ManagerBusinessException ex) {
    	JsonResponse errors = JsonResponse.instance(HttpStatus.BAD_REQUEST.value(), ex.getExceptionCode(),ex.getMessage());
    	LOGGER.error(HttpStatus.BAD_REQUEST.value()+ " : "+ ex.getExceptionCode()+ " : "+ex.getMessage());
    	errors.addFieldError(ex.getExceptionCode(),ex.getMessage());
		return errors;
    }
 


}
