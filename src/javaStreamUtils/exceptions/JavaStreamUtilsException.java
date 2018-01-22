/**
 * 
 */
package javaStreamUtils.exceptions;

/**
 * @author gabriel
 *
 */
public class JavaStreamUtilsException extends Exception {

	private Exception exception;
	/**
	 * 
	 */
	public JavaStreamUtilsException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public JavaStreamUtilsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	public JavaStreamUtilsException(String message,Exception e) {
		super(message);
		this.exception= e;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public JavaStreamUtilsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public JavaStreamUtilsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public JavaStreamUtilsException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	
	public Exception getException(){
		return this.exception;
	}
}
