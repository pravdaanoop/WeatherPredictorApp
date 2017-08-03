package test.java.com.weatherapp.regression.test;

import static org.junit.Assert.assertNotEquals;

import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import main.java.com.weatherapp.dto.RegressionDataDTO;
import main.java.com.weatherapp.dto.WeatherDTO;
import main.java.com.weatherapp.exception.WeatherAppException;
import main.java.com.weatherapp.loader.DataLoader;
import main.java.com.weatherapp.regression.LinearRegression;

/**
 * Test class for LinearRegression
 * 
 * Date 03 Aug 2017
 * 
 * @author Pravda Rajeev
 * @version v0.1
 */
public class LinearRegressionTest {
	
	/**
	 * Logger
	 */
	final static Logger logger = Logger.getLogger(LinearRegressionTest.class);
	
	private static RegressionDataDTO geoData;
	
	private static OLSMultipleLinearRegression regression;
	
	private static double[]inputParam;
	
	private static WeatherDTO weather;
	
	@Before
	public void loadDatas() {
		try {
			geoData = DataLoader.loadData();
			inputParam[0] = 21.233443;
			inputParam[1] = 45.455433;
			inputParam[2] = 45.455566;
			inputParam[3] = 1500760956;
			regression.newSampleData(geoData.getHumidityData(), geoData.getFeatures());
		} catch (WeatherAppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("loaded data for testing LinearRegression");
	}
	
	@Test
	public void trainDataTest() {
		
		try {
			assertNotEquals(LinearRegression.trainData(geoData,inputParam,weather), null);
		} catch (WeatherAppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("Test case completed for LinearRegression.trainData()");

	}
	
	@Test
	public void predictTest() {
		
		try {
			assertNotEquals(LinearRegression.predict(regression,inputParam), null);
		} catch (WeatherAppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("Test case completed for LinearRegression.predict()");

	}
}
