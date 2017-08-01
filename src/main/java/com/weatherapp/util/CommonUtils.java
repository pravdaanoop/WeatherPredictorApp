package main.java.com.weatherapp.util;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.log4j.Logger;

import main.java.com.weatherapp.exception.WeatherAppException;


/**
 * Class with common utility functions
 * 
 * Date 01 Aug 2017
 * 
 * @author Pravda Rajeev
 * @version v0.1
 */
public class CommonUtils {

	/**
	 * Logger
	 */
	final static Logger logger = Logger.getLogger(CommonUtils.class);

	/**
	 * @param latitude
	 * @param longitude
	 * @param elevation
	 * @return
	 * Method for finding location form cordinates. Not implemented as of now as location is optional
	 */
	public static String findLocation(double latitude, double longitude, double elevation) {
		return Constants.NA;
	}

	/**
	 * Method to find Calendar from unix time
	 * @param unixTime
	 * @return
	 * @throws WeatherAppException 
	 */
	public static Calendar calenderTimeFromUnixTime(String time) throws WeatherAppException {
		try {
			Date date = new Date();
			long unixTime = Long.parseLong(time);
			date.setTime(unixTime * 1000);
			Calendar myCal = new GregorianCalendar();
			myCal.setTime(date);
			return myCal;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			throw new WeatherAppException(e.getMessage());
		}
	}

	/**
	 * Method to write output to file
	 * @param Data
	 * @param outputLocation
	 * @return
	 * @throws WeatherAppException 
	 * 
	 */
	public static boolean writeData(String data, String outputLocation) throws WeatherAppException {
		boolean returnBoolean = false;
		Writer writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(outputLocation));
			writer.write(data + "\n");
			writer.flush();
			returnBoolean = true;
		} catch (Exception e) {
			logger.error(e);
			throw new WeatherAppException(e.getMessage());
		} finally {
			if (writer != null)
				try {
					writer.close();
				} catch (IOException e) {
					logger.error(e);
					throw new WeatherAppException(e.getMessage());
				}

		}
		return returnBoolean;
	}

}
