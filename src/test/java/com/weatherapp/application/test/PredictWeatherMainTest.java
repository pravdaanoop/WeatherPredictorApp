package test.java.com.weatherapp.application.test;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.Assert.assertNotEquals;

import main.java.com.weatherapp.application.PredictWeatherMain;

/**
 * Test class for PredictWeatherMain
 * 
 * Date 01 Aug 2017
 * 
 * @author Pravda Rajeev
 * @version v0.1
 */
public class PredictWeatherMainTest {

	/**
	 * Logger
	 */
	private final static Logger logger = LoggerFactory.getLogger(PredictWeatherMainTest.class);

	/**
	 * Load Datas for initial Testing
	 */

	@Before
	public void loadDatas() {

		logger.info("loaded data for testing PredictWeatherMain");
	}

	@Test
	public void mainTest() {
		PredictWeatherMain testObj = new PredictWeatherMain();
		assertNotEquals(testObj.getGeoData(), null);
		assertNotEquals(testObj.getClimateData(),null);

		logger.info("Test case completed for model fetch PredictWeatherMain");

	}

}
