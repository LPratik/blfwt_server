package com.pron.blfwt.admin.handler.impl;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pron.blfwt.admin.handler.BaseHandler;
import com.pron.blfwt.admin.model.JsonResponse;
import com.pron.blfwt.admin.utils.Messages;


 
@ControllerAdvice
public class RestErrorHandler extends BaseHandler{
 
	Logger LOGGER = LoggerFactory.getLogger(RestErrorHandler.class);
	
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public JsonResponse processValidationError(MethodArgumentNotValidException ex) {
    	LOGGER.error(ex.getMessage());
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        return processFieldErrors(fieldErrors);
    }
 
    private JsonResponse processFieldErrors(List<FieldError> fieldErrors) {
    	JsonResponse errors = JsonResponse.instance(HttpStatus.BAD_REQUEST.value(),Messages.Message_INVALID_REQUEST_PAYLOAD,resolveLocalizedMessage(Messages.Message_INVALID_REQUEST_PAYLOAD));
        for (FieldError fieldError: fieldErrors) {
        	errors.addFieldError(fieldError.getField(), fieldError.getCode());
        }
 
        return errors;
    }
}