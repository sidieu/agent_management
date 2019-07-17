/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sidieu.api.agent.exceptions;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.ResourceAccessException;

/**
 *
 * @author pcjava
 */
public class MyErrorHandler extends DefaultResponseErrorHandler {

	private Logger logger = Logger.getLogger(MyErrorHandler.class);

	@Override
	public void handleError(ClientHttpResponse response) throws RuntimeException, ResourceAccessException {
		try {
			System.out.println("Handler >>>>>> Error" + response.getStatusCode());
			logger.error("Handler >>>>>> Error" + response.getStatusCode());
		} catch (IOException ex) {
			System.out.println("Handler >>>>>> Error");
			logger.error("Handler >>>>>> Error" + ex.getCause());
		}
	}

	@Override
	protected boolean hasError(HttpStatus statusCode) throws RuntimeException, ResourceAccessException {
		System.out.println("Handler >>>>>> Statut " + statusCode.toString());
		logger.error("Handler >>>>>> Error" + statusCode);
		return super.hasError(statusCode); // To change body of generated methods, choose Tools | Templates.
	}

}
