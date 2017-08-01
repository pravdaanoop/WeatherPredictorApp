package main.java.com.weatherapp.application;

import java.util.List;

import org.apache.log4j.Logger;

import main.java.com.weatherapp.dto.ClimateDTO;
import main.java.com.weatherapp.dto.RegressionDataDTO;

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
	 * @param geoData the geoData to set
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
	 * @param climateData the climateData to set
	 */
	public void setClimateData(List<ClimateDTO> climateData) {
		PredictWeatherMain.climateData = climateData;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
