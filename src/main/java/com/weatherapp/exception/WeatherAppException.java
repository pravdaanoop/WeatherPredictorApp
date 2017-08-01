/**
 * 
 */
package main.java.com.weatherapp.exception;
import org.apache.log4j.Logger;

/**
 * Exception handling class
 * 
 * Date 01 Aug 2017
 * 
 * @author Pravda Rajeev
 * @version v0.1
 */
public class WeatherAppException extends Exception{
	/**
	 * version ID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * logger
	 */
	final static Logger logger = Logger.getLogger(WeatherAppException.class);

	/**
	 * 
	 * @param message
	 *            Passing message argument to superclass. 
	 */
	public WeatherAppException(String message) {
		super(message);
		logger.info("Exception : " + message);
	}
}
