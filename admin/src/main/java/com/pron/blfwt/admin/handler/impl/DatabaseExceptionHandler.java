package com.pron.blfwt.admin.handler.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pron.blfwt.admin.exceptions.ManagerDatabaseException;
import com.pron.blfwt.admin.model.JsonResponse;


@ControllerAdvice
public class DatabaseExceptionHandler {
	
	Logger LOGGER = LoggerFactory.getLogger(DatabaseExceptionHandler.class);
	
    @ExceptionHandler(value = ManagerDatabaseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public JsonResponse processException(ManagerDatabaseException ex) {
       	JsonResponse errors = JsonResponse.instance(HttpStatus.BAD_REQUEST.value(), ex.getExceptionCode(),ex.getMessage());
     	LOGGER.error(HttpStatus.BAD_REQUEST.value()+ " : "+ ex.getExceptionCode()+ " : "+ex.getMessage());
    	errors.addFieldError(ex.getExceptionCode(),ex.getMessage());
		return errors;
    }
}
