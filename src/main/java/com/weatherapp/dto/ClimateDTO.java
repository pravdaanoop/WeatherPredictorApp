/**
 * 
 */
package main.java.com.weatherapp.dto;


import org.apache.mahout.math.DenseVector;
import org.apache.mahout.math.Vector;
import org.apache.mahout.vectorizer.encoders.ConstantValueEncoder;

import main.java.com.weatherapp.enums.Climate;
import main.java.com.weatherapp.util.Constants;
import main.java.com.weatherapp.util.PropertyLoader;

/**
 * DTO used in predicting climatic conditions
 * 
 * Date 01 Aug 2017
 * 
 * @author Pravda Rajeev
 * @version v0.1
 */
public class ClimateDTO {
	
	/**
	 * vector for setting the categories & feature required for logistic regression model
	 */
	private DenseVector vector = new DenseVector(5);
	
	/**
	 * output predicted
	 */
	private int actual;

/**
 * The Method sets the vector from each record of train_data_set for the regression model
 * @param values
 */
public ClimateDTO(String[] values) {
	ConstantValueEncoder interceptEncoder = new ConstantValueEncoder(Constants.INTERCEPT);
//to deal intercept
	interceptEncoder.addToVector(PropertyLoader.INTERCEPT_VALUE, vector);
	for(int i =0;i<values.length;++i){
		if(i == Integer.parseInt(PropertyLoader.CLIMATE_TRAIN_PARAM_LENGTH)){
		if(Climate.Rain.equals(values[i])){
			this.actual = Climate.getCodeFromClimate(Climate.Rain);
		}else if(Climate.Snow.equals(values[i])){
			this.actual = Climate.getCodeFromClimate(Climate.Snow);
		}else if(Climate.Sunny.equals(values[i])){
			this.actual = Climate.getCodeFromClimate(Climate.Sunny);
		}
		}else{
			vector.set(i, Double.valueOf(values[i]));
		}
	}
	
}
/**
 * @return Vector
 */
public Vector getVector() {
	return vector;
}

/**
 * @return regression output 
 */
public int getActual() {
	return actual;
}
}
