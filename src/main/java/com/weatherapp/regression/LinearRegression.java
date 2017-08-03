package main.java.com.weatherapp.regression;

import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;
import org.apache.log4j.Logger;

import main.java.com.weatherapp.dto.RegressionDataDTO;
import main.java.com.weatherapp.dto.WeatherDTO;
import main.java.com.weatherapp.exception.WeatherAppException;

/**
 * Class for performing linear regression to predict temp/pressure/humidity
 * 
 * Date 03 Aug 2017
 * 
 * @author Pravda Rajeev
 * @version v0.1
 */
public class LinearRegression {

	/**
	 * Logger
	 */
	final static Logger logger = Logger.getLogger(LinearRegression.class);
	
	/**
	 * Method to input the train data set to the regression
	 * @param trainData
	 * @return
	 * @throws WeatherAppException 
	 */
	public static WeatherDTO trainData(RegressionDataDTO geoData,double[] inputParameters,WeatherDTO weather) throws WeatherAppException {
		try {
			OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
			
			regression.newSampleData(geoData.getHumidityData(), geoData.getFeatures());
			double humidityPredicted = predict(regression, inputParameters);
			regression.newSampleData(geoData.getPressureData(), geoData.getFeatures());
			double pressurePredicted = predict(regression, inputParameters);
			regression.newSampleData(geoData.getTemperatureData(), geoData.getFeatures());
			double tempPredicted = predict(regression, inputParameters);
			weather.setHumidity(humidityPredicted);
			weather.setPressure(pressurePredicted);
			weather.setTemperature(tempPredicted);
			return weather;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			throw new WeatherAppException(e.getMessage());
		}
	}
 
	/**
	 * Method to predict the output from the linear regression model
	 * 
	 * @param regression
	 * @param inputFeatures
	 * @return
	 * @throws WeatherAppException
	 */
	public static double predict(OLSMultipleLinearRegression regression, double[] inputFeatures) throws WeatherAppException {
		double prediction = 0.0;
		try {
			double[] beta = regression.estimateRegressionParameters();

			// intercept at beta[0]
			prediction = beta[0];
			for (int i = 1; i < beta.length; i++) {
				prediction += beta[i] * inputFeatures[i - 1];
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e);
			throw new WeatherAppException(e.getMessage());
		}
		return prediction;
	}
	
}
