/**
 * 
 */
package main.java.com.weatherapp.util;

import java.util.ResourceBundle;

/**
 * Class for loading property
 * 
 * Date Date 01 Aug 2017
 * 
 * @author Pravda Rajeev
 * @version v0.1
 */
public class PropertyLoader {

	private static final ResourceBundle rb = ResourceBundle.getBundle("config");

	public static final String INPUT_CSV_LOC = rb.getString(Constants.INPUT_CSV_LOC);
	public static final String TRAIN_DATA_RECORDS = rb.getString(Constants.TRAIN_DATA_RECORDS);
	public static final String INTERCEPT_VALUE = rb.getString(Constants.INTERCEPT_VALUE);
	public static final String CLIMATE_TRAIN_PARAM_LENGTH = rb.getString(Constants.CLIMATE_TRAIN_PARAM_LENGTH);
	public static final String OUTPUT_CATEGORY_SIZE = rb.getString(Constants.OUTPUT_CATEGORY_SIZE);
	public static final String INPUT_FEATURE_SIZE = rb.getString(Constants.INPUT_FEATURE_SIZE);

	

}
