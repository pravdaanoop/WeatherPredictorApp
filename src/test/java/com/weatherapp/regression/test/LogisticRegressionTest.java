package test.java.com.weatherapp.regression.test;

import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.mahout.classifier.sgd.OnlineLogisticRegression;
import org.junit.Before;
import org.junit.Test;

import main.java.com.weatherapp.dto.ClimateDTO;
import main.java.com.weatherapp.exception.WeatherAppException;
import main.java.com.weatherapp.loader.DataLoader;
import main.java.com.weatherapp.regression.LogisticRegression;


/**
 * Test class for LogisticRegression
 * 
 * Date 01 Aug 2017
 * 
 * @author Pravda Rajeev
 * @version v0.1
 */
public class LogisticRegressionTest {
	
	/**
	 * Logger
	 */
	final static Logger logger = Logger.getLogger(LogisticRegressionTest.class);
	
	private static List<ClimateDTO> trainData;
	
	private static OnlineLogisticRegression olr;
	
	private static double[]inputParam;
	
	@Before
	public void loadDatas() {
		try {
			trainData =DataLoader.loadClimateData();
			olr = LogisticRegression.trainData(trainData);
			inputParam[0] = 21.233443;
			inputParam[1] = 45.455433;
			inputParam[2] = 45.455566;
			inputParam[3] = 1500760956;
		} catch (WeatherAppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("loaded data for testing LogisticRegression");
	}
	
	@Test
	public void trainDataTest() {
		
		try {
			assertNotEquals(LogisticRegression.trainData(trainData), null);
		} catch (WeatherAppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("Test case completed for LogisticRegression.trainData()");

	}
	
	@Test
	public void predictTest() {
		
		try {
			assertNotEquals(LogisticRegression.predict(olr,inputParam), null);
		} catch (WeatherAppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("Test case completed for LogisticRegression.predict()");

	}
}
