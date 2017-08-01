/**
 * 
 */
package main.java.com.weatherapp.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import main.java.com.weatherapp.enums.Climate;
import main.java.com.weatherapp.util.Constants;

/**
 * DTO used in predicting climate conditions
 * 
 * Date Date 01 Aug 2017
 * 
 * @author Pravda Rajeev
 * @version v0.1
 */
public class WeatherDTO {

	/**
	 * Represents the location where the weather record is captured.
	 */
	private String location;

	/**
	 * latitude of location.
	 */
	private double latitude;
	
	/**
	 * Longitude of location.
	 */
	private double longitude;
	
	/**
	 * Elevation of location from sea level.
	 */
	private double elevation;

	/**
	 * Calendar represents the time when the weather record captured.
	 */
	private Calendar time;

	/**
	 * Indicates the summary of climate condition. Can be either of
	 *Rain,SnowSunny
	 */
	private Climate climateCondition;

	/**
	 * Temperature measured.
	 */
	private double temperature;
	/**
	 * Pressure measured.
	 */
	private double pressure;
	/**
	 * Humidity measured.
	 */
	private double humidity;

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the elevation
	 */
	public double getElevation() {
		return elevation;
	}

	/**
	 * @param elevation the elevation to set
	 */
	public void setElevation(double elevation) {
		this.elevation = elevation;
	}

	/**
	 * @return the time
	 */
	public Calendar getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(Calendar time) {
		this.time = time;
	}

	/**
	 * @return the climateCondition
	 */
	public Climate getClimateCondition() {
		return climateCondition;
	}

	/**
	 * @param climateCondition the climateCondition to set
	 */
	public void setClimateCondition(Climate climateCondition) {
		this.climateCondition = climateCondition;
	}

	/**
	 * @return the temperature
	 */
	public double getTemperature() {
		return temperature;
	}

	/**
	 * @param temperature the temperature to set
	 */
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	/**
	 * @return the pressure
	 */
	public double getPressure() {
		return pressure;
	}

	/**
	 * @param pressure the pressure to set
	 */
	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

	/**
	 * @return the humidity
	 */
	public double getHumidity() {
		return humidity;
	}

	/**
	 * @param humidity the humidity to set
	 */
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public WeatherDTO() {
	}

	@Override
	public String toString() {
		DateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT, Locale.US);
		dateFormat.setTimeZone(TimeZone.getTimeZone(Constants.UTC));
		return String.format("%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s", location, Constants.DELIMITTER_PIPE, latitude, Constants.DELIMITTER_COMA,longitude, Constants.DELIMITTER_COMA,elevation,
				Constants.DELIMITTER_PIPE, dateFormat.format(time.getTime()), Constants.DELIMITTER_PIPE, climateCondition,
				Constants.DELIMITTER_PIPE, temperature, Constants.DELIMITTER_PIPE, pressure, Constants.DELIMITTER_PIPE,
				humidity);
	}
	
}
