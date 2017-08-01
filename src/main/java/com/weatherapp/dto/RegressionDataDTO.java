/**
 * 
 */
package main.java.com.weatherapp.dto;

/**
 * DTO used in predicting weather conditions
 * 
 * Date Date 01 Aug 2017
 * 
 * @author Pravda Rajeev
 * @version v0.1
 */
public class RegressionDataDTO {
/**
 * holds the pressure values from train data set
 */
private double[] pressureData;

/**
 * holds the humidity values from train data set
 */
private double[] humidityData;

/**
 * holds the temperature values from train data set
 */
private double[] temperatureData;

/**
 * holds the features which governs the output from train data set
 */
private double[][] features;

/**
 * @return the pressureData
 */
public double[] getPressureData() {
	return pressureData;
}
/**
 * @param pressureData the pressureData to set
 */
public void setPressureData(double[] pressureData) {
	this.pressureData = pressureData;
}
/**
 * @return the humidityData
 */
public double[] getHumidityData() {
	return humidityData;
}
/**
 * @param humidityData the humidityData to set
 */
public void setHumidityData(double[] humidityData) {
	this.humidityData = humidityData;
}
/**
 * @return the temperatureData
 */
public double[] getTemperatureData() {
	return temperatureData;
}
/**
 * @param temperatureData the temperatureData to set
 */
public void setTemperatureData(double[] temperatureData) {
	this.temperatureData = temperatureData;
}
/**
 * @return the features
 */
public double[][] getFeatures() {
	return features;
}
/**
 * @param features the features to set
 */
public void setFeatures(double[][] features) {
	this.features = features;
}
}
