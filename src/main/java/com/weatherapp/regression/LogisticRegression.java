/**
 * 
 */
package main.java.com.weatherapp.regression;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.mahout.classifier.sgd.L1;
import org.apache.mahout.classifier.sgd.OnlineLogisticRegression;
import org.apache.mahout.math.Vector;

import main.java.com.weatherapp.dto.ClimateDTO;
import main.java.com.weatherapp.enums.Climate;
import main.java.com.weatherapp.exception.WeatherAppException;
import main.java.com.weatherapp.util.PropertyLoader;

/**
 * Class for performing logistic regression to predict climatic conditions
 * 
 * Date 23 July 2017
 * 
 * @author Pravda Rajeev
 * @version v0.1
 */
public class LogisticRegression {
	/**
	 * Logger
	 */
	final static Logger logger = Logger.getLogger(LogisticRegression.class);
	

	/**
	 * Method to input the train data set to the regression
	 * @param trainData
	 * @return
	 * @throws WeatherAppException 
	 */
	public static OnlineLogisticRegression trainData(List<ClimateDTO> trainData) throws WeatherAppException {
		try {
			int numCategory = Integer.parseInt(PropertyLoader.OUTPUT_CATEGORY_SIZE);
			int numFeatures = Integer.parseInt(PropertyLoader.INPUT_FEATURE_SIZE);
			OnlineLogisticRegression olr = new OnlineLogisticRegression(numCategory, numFeatures, new L1());
				for (ClimateDTO observation : trainData) {
					olr.train(observation.getActual(), observation.getVector());
			}
			return olr;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			throw new WeatherAppException(e.getMessage());
		}
	}
 
	/**
	 * Method to predict the climate from regression
	 * @param olr
	 * @param inputParam
	 * @return
	 * @throws WeatherAppException 
	 */
	public static Climate predict(OnlineLogisticRegression olr,double[]inputParam) throws WeatherAppException {
		
		try {
			String[] input = new String[inputParam.length];
			for (int i = 0; i < input.length; i++)
				input[i] = String.valueOf(inputParam[i]);
			ClimateDTO newObservation = new ClimateDTO(input);
			Vector result = olr.classifyFull(newObservation.getVector());
			if(result.size() == Climate.values().length){
				double rainProb = result.get(0);
				double snowProb = result.get(1);
				double sunnyProb = result.get(2);
				if((rainProb >=snowProb )&&(rainProb >=sunnyProb )){
					return Climate.Rain;
				}else if ((snowProb >=rainProb )&&(snowProb >=sunnyProb )){
					return Climate.Snow;
				}else if ((sunnyProb >=rainProb )&&(sunnyProb >=snowProb )){
					return Climate.Sunny;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e);
			throw new WeatherAppException(e.getMessage());
		}
		return null;
	}
}
