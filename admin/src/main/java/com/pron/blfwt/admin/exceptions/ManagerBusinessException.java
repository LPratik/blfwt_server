/**
 * 
 */
package com.pron.blfwt.admin.exceptions;


public class ManagerBusinessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -812601769505225751L;

	private String action;
	private String exceptionCode;
	private String message;
	/**
	 * 
	 */
	public ManagerBusinessException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public ManagerBusinessException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ManagerBusinessException(String action, String exceptionCode, String message) {

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
	 * @param cause
	 */
	public ManagerBusinessException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ManagerBusinessException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ManagerBusinessException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
