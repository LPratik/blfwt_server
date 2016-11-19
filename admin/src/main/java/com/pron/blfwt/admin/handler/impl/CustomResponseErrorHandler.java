package com.pron.blfwt.admin.handler.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import com.pron.blfwt.admin.exceptions.ManagerBusinessException;




public class CustomResponseErrorHandler implements ResponseErrorHandler {

    public boolean hasError(ClientHttpResponse response) throws IOException {
        return false;
    }

    public void handleError(ClientHttpResponse response) throws IOException {
        String theString = response.getBody().toString();
       
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("code", response.getStatusCode().toString());
        properties.put("body", theString);
        properties.put("header", response.getHeaders());
        ManagerBusinessException exception = new ManagerBusinessException(response.getStatusCode().toString(),theString,response.getHeaders().toString());
        try {
			throw exception;
		} catch (ManagerBusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}