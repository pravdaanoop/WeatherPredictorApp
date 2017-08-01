package test.java.com.weatherapp.loader.test;

import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import main.java.com.weatherapp.exception.WeatherAppException;
import main.java.com.weatherapp.loader.DataLoader;

/**
 * Test class for DataLoader
 * 
 * Date 01 Aug 2017
 * 
 * @author Pravda Rajeev
 * @version v0.1
 */
public class DataLoaderTest {

	/**
	 * Logger
	 */
	private final static Logger logger = LoggerFactory.getLogger(DataLoaderTest.class);
	
	@Before
	public void loadDatas() {

		logger.info("loaded data for testing DataLoader");
	}
	
	@Test
	public void loadDataTest() {
		try {
			assertNotEquals(DataLoader.loadData(), null);
		} catch (WeatherAppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("Test case completed for DataLoader.loadData()");

	}
	
	@Test
	public void loadClimateDataTest() {
		try {
			assertNotEquals(DataLoader.loadClimateData(), null);
		} catch (WeatherAppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("Test case completed for DataLoader.loadClimateData()");

	}
}
