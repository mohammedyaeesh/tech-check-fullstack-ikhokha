package com.ikhokha.techcheck.Interfaces;

import java.util.Map;

import com.ikhokha.techcheck.Classes.Metric;
import com.ikhokha.techcheck.Enums.MetricType;

/*
 * Abstract methods for base class (Metrics)  
 */
public interface IMetric {
	
    //Abstract methods for Getters & Setters
	String getMetricKey();
	void setMetricKey(String metricKey);
	
    String getMetricType();
    void setMetricType(MetricType metricType);
    
    //Contains logic to process the metric
    void runMetric(String line,Metric metric, Map<String, Integer> resultsMap);
    
    void incOccurrence(Map<String, Integer> countMap, String key);
    
}
