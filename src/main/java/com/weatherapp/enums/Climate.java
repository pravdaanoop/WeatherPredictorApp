/**
 * 
 */
package main.java.com.weatherapp.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Enum which holds the climatic conditions
 * 
 * Date 01 Aug 2017
 * 
 * @author Pravda Rajeev
 * @version v0.1
 */
public enum Climate {

	/**
	 * Weather : Rainy day
	 */
	Rain(0),
	/**
	 * Weather : Snow fall
	 */
	Snow(1),
	/**
	 * Weather : Sunny day
	 */
	Sunny(2);

	/**
	 * map to hold the integer value & enum
	 */
	private static final Map<Integer, Climate> lookup = new HashMap<Integer, Climate>();
	
	/**
	 * reverse map of the lookup map
	 */
	private static final Map<Climate, Integer> reverseLookup = new HashMap<Climate, Integer>();

	static {
		for (Climate w : EnumSet.allOf(Climate.class)) {
			lookup.put(w.getCode(), w);
			reverseLookup.put(w, w.getCode());
		}
	}

	/**
	 * integer value corresponding to the enum
	 */
	private int code;

	private Climate(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	/**
	 * Method to get enum from code value
	 * @param code
	 * @return
	 */
	public static Climate getClimateFromCode(int code) {
		return lookup.get(code);
	}

	/**
	 * Method to get code value from given enum
	 * @param climate
	 * @return
	 */
	public static int getCodeFromClimate(Climate climate) {
		return reverseLookup.get(climate);
	}
}
