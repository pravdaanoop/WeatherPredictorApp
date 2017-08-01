package main.java.com.weatherapp.loader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

import main.java.com.weatherapp.dto.RegressionDataDTO;
import main.java.com.weatherapp.exception.WeatherAppException;
import main.java.com.weatherapp.util.Constants;
import main.java.com.weatherapp.util.PropertyLoader;

/**
 * Class for loading data in regression models
 * 
 * Date 01 Aug 2017
 * 
 * @author Pravda Rajeev
 * @version v0.1
 */
public class DataLoader {
	/**
	 * Logger
	 */
	final static Logger logger = Logger.getLogger(DataLoader.class);
	
	/**
	 * Train_Data location
	 */
	static String inputCSVFile = PropertyLoader.INPUT_CSV_LOC;
	
	/**
	 * Train_Data record size
	 */
	static int recordSize = Integer.parseInt(PropertyLoader.TRAIN_DATA_RECORDS);
	
	/**
	 * Method loads input data for the weather prediction
	 * @return RegressionDataDTO
	 * @throws WeatherAppException 
	 */
	public static RegressionDataDTO loadData() throws WeatherAppException {
		// TODO Auto-generated method stub
		RegressionDataDTO dataLoad = new RegressionDataDTO();
		double[] pressure = new double[recordSize];
		double[] temperature = new double[recordSize];
		double[] humidity = new double[recordSize];
        double[][] variables = new double[recordSize][];  
        
        BufferedReader br = null ;
        try {
        	br = new BufferedReader(new FileReader(inputCSVFile));
            String record;
            int index = 0;
            while ( (record = br.readLine()) != null) {
            	// record: <temp><,><pressure><,><hum><,><lat><,><long><,><ele><,><timestamp><,><climatecondition>
                StringTokenizer tokenizer = new StringTokenizer(record, Constants.DELIMITTER_COMA);
            	while(tokenizer.hasMoreTokens()){
            		temperature[index] = Double.parseDouble(tokenizer.nextToken());
            		pressure[index] = Double.parseDouble(tokenizer.nextToken());
            		humidity[index] = Double.parseDouble(tokenizer.nextToken());
            		int tokenScore = tokenizer.countTokens() -1;//avoiding climatecondition
            		double[] features = new double[tokenScore];
            		for (int i = 0; i < features.length; i++) {
                        features[i] = Double.parseDouble(tokenizer.nextToken());
                    }
            		variables[index] = features;
                     index++;
                     tokenizer.nextToken();//avoiding climatecondition
            	}
               
            }
        } catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			throw new WeatherAppException(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			throw new WeatherAppException(e.getMessage());
		} 
        finally {
            try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error(e);
			}
        }
        dataLoad.setFeatures(variables);
        dataLoad.setHumidityData(humidity);
        dataLoad.setPressureData(pressure);
        dataLoad.setTemperatureData(temperature);
        logger.info("weather regression load completed");
		return dataLoad;
	}

}
