/**
 * 
 */
package com.learning.resturant.exception;

/**
 * @author VINAY
 * 
 */
public class FileReaderException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1218584876820370926L;

	public FileReaderException() {
	}

	/**
	 * @param message
	 */
	public FileReaderException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public FileReaderException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public FileReaderException(String message, Throwable cause) {
		super(message, cause);
	}
}