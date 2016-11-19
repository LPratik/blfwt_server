/**
 * 
 */
package com.pron.blfwt.admin.exceptions;


public class ManagerDatabaseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9038994104747408118L;

	private String action;
	private String exceptionCode;
	private String message;
	
	/*
	 * 
	 */
	public ManagerDatabaseException(String action, String exceptionCode, String message) {

		this.action= action;
		this.exceptionCode = exceptionCode;
		this.message = message;
	}
	
	
	public String getAction() {
		return action;
	}


	public void setAction(String action) {
		this.action = action;
	}


	public String getExceptionCode() {
		return exceptionCode;
	}


	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	/**
	 * 
	 */
	public ManagerDatabaseException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public ManagerDatabaseException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public ManagerDatabaseException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ManagerDatabaseException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ManagerDatabaseException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
