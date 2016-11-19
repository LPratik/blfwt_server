package com.pron.blfwt.admin.handler.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pron.blfwt.admin.handler.BaseHandler;
import com.pron.blfwt.admin.model.JsonResponse;
import com.pron.blfwt.admin.utils.Constants;
import com.pron.blfwt.admin.utils.Messages;



@ControllerAdvice
class GlobalDefaultExceptionHandler extends BaseHandler{

	Logger LOGGER = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);
	
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public JsonResponse defaultErrorHandler( HttpMessageNotReadableException e) throws Exception {
    	LOGGER.error(e.getMessage());
    	e.printStackTrace();    	
    	JsonResponse errors = JsonResponse.instance(HttpStatus.BAD_REQUEST.value(), Messages.Message_INVALID_REQUEST_PAYLOAD,resolveLocalizedMessage(Messages.Message_INVALID_REQUEST_PAYLOAD));
    	errors.addFieldError(Constants.PARAM_GLOBAL, Messages.Message_INVALID_REQUEST_PAYLOAD);
    	return errors;
       
    }

    @ExceptionHandler(value = {NullPointerException.class,RuntimeException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public JsonResponse defaultErrorHandler( RuntimeException e) throws Exception {
    	LOGGER.error(e.getMessage());
    	e.printStackTrace(); 
    	JsonResponse errors = JsonResponse.instance(HttpStatus.INTERNAL_SERVER_ERROR.value(), Messages.MESSAGE_GENERIC_UNEXPECTED_ERROR,resolveLocalizedMessage(Messages.MESSAGE_GENERIC_UNEXPECTED_ERROR));
    	errors.addFieldError(Constants.PARAM_GLOBAL, Messages.MESSAGE_GENERIC_UNEXPECTED_ERROR);
    	return errors;
    }
}