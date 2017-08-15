package main.java.com.weatherapp.application;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.mahout.classifier.sgd.OnlineLogisticRegression;

import main.java.com.weatherapp.dto.ClimateDTO;
import main.java.com.weatherapp.dto.RegressionDataDTO;
import main.java.com.weatherapp.dto.WeatherDTO;
import main.java.com.weatherapp.enums.Climate;
import main.java.com.weatherapp.loader.DataLoader;
import main.java.com.weatherapp.regression.LinearRegression;
import main.java.com.weatherapp.regression.LogisticRegression;
import main.java.com.weatherapp.util.CommonUtils;

/**
 * Main class
 * 
 * Date 01 Aug 2017
 * 
 * @author Pravda Rajeev
 * @version v0.1
 */
public class PredictWeatherMain {

	/**
	 * Logger
	 */
	final static Logger logger = Logger.getLogger(PredictWeatherMain.class);

	/**
	 * weather data loaded from train_data_set
	 */
	static RegressionDataDTO geoData;

	/**
	 * climate data loaded from train_data_set
	 */
	static List<ClimateDTO> climateData;

	/**
	 * @return the geoData
	 */
	public RegressionDataDTO getGeoData() {
		return geoData;
	}

	/**
	 * @param geoData
	 *            the geoData to set
	 */
	public void setGeoData(RegressionDataDTO geoData) {
		PredictWeatherMain.geoData = geoData;
	}

	/**
	 * @return the climateData
	 */
	public List<ClimateDTO> getClimateData() {
		return climateData;
	}

	/**
	 * @param climateData
	 *            the climateData to set
	 */
	public void setClimateData(List<ClimateDTO> climateData) {
		PredictWeatherMain.climateData = climateData;
	}

	public static void main(String[] args) {
		try {
			// TODO Auto-generated method stub
			// args[0]=latitude|args[1]=longitude|args[2]=elevation|args[3]=timestamp|args[4]=output
			// file location

			// training_data loaded for weather prediction
			geoData = DataLoader.loadData();

			// training_data loaded for climate prediction
			climateData = DataLoader.loadClimateData();

			WeatherDTO weather = new WeatherDTO();
			weather.setLatitude(Double.parseDouble(args[0]));
			weather.setLongitude(Double.parseDouble(args[1]));
			weather.setElevation(Double.parseDouble(args[2]));
			weather.setLocation(
					CommonUtils.findLocation(weather.getLatitude(), weather.getLongitude(), weather.getElevation()));
			weather.setTime(CommonUtils.calenderTimeFromUnixTime(args[3]));

			// dealing weathercondition
			double[] inputParameters = new double[args.length - 1];
			for (int i = 0; i < (args.length - 1); ++i) {
				inputParameters[i] = Double.parseDouble(args[i]);
			}
			weather = LinearRegression.trainData(geoData, inputParameters, weather);

			// dealing climatecondition
			OnlineLogisticRegression olr = LogisticRegression.trainData(climateData);
			Climate climateCondition = LogisticRegression.predict(olr, inputParameters);
			weather.setClimateCondition(climateCondition);

			// output flushing
			logger.info("writing output file");
			CommonUtils.writeData(weather.toString(), args[4]);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}

	}
}
