package com.ikhokha.techcheck.Classes;

import java.util.Map;

import com.ikhokha.techcheck.Enums.MetricType;
import com.ikhokha.techcheck.Interfaces.IMetric;

public class Metric implements IMetric{

	private String metricKey;
	private MetricType metricType;
	
	Metric() { // Default constructor

	}	


	//Implementation for IMetric functions - Getters & Setters
	public String getMetricKey() {
		return metricKey;
	}

	public void setMetricKey(String metricKey) {
		this.metricKey = metricKey;		
	}

	public String getMetricType() {
		return metricType.toString();
    }

	public void setMetricType(MetricType type) {	
		/*
		 * Ensure that the value passed in is a valid MetricType
		 * If it is, then set the value. If it's not then throw an IllegalArgumentException with an appropriate error message
		 */
		try {			
			String toCompare = type.toString();
			if(MetricType.valueOf(toCompare).toString() == toCompare) {
				this.metricType = type; 
			}
					
		}catch(IllegalArgumentException exception) {
			
			String validKeys = "";
			for(MetricType metric : MetricType.values()) { //Get all valid metric keys so they can be displayed as hints in the error message
				validKeys += metric + "\n";
			}
			throw new IllegalArgumentException("ERROR : setMetricType | Error details : Ensure that the metric key used is one of the below:\n" + validKeys );
		}

    }
	

	@Override
	public void runMetric(String line, Metric metric, Map<String, Integer> resultsMap) {		
		// TODO Auto-generated method stub
	}

	/**
	 * This method increments a counter by 1 for a match type on the countMap.
	 * Uninitialized keys will be set to 1
	 * 
	 * @param countMap the map that keeps track of counts
	 * @param key      the key for the value to increment
	 */
	public void incOccurrence(Map<String, Integer> countMap, String key) {

		countMap.putIfAbsent(key, 0);
		countMap.put(key, countMap.get(key) + 1);
	}


	
	

}
