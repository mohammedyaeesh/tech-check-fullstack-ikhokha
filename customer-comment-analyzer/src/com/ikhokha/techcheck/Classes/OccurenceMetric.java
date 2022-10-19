package com.ikhokha.techcheck.Classes;

import java.util.Map;
import java.util.regex.Pattern;

import com.ikhokha.techcheck.Enums.MetricType;
import com.ikhokha.techcheck.Interfaces.IOccurenceMetric;

public class OccurenceMetric extends Metric implements IOccurenceMetric {
	         
	private String matchTerm;

	public OccurenceMetric(String metricKey, MetricType metricType, String matchTerm) {
		if(metricKey.isEmpty()|| metricType == null)  // Object cannot be instantiated without a key or type since this is vital to process the metric and output the result
			throw new NullPointerException("The Metric Key or Type has not been set ");
		
		this.setMetricKey(metricKey);
		this.setMetricType(metricType); 
		this.setMatchTerm(matchTerm);
	}
	
	public OccurenceMetric(String metricKey, MetricType occuranceCounterWithRegex, Pattern pattern) {
		// TODO Auto-generated constructor stub
	}

	public String getMatchTerm() {
		return matchTerm;
	}

	public void setMatchTerm(String matchTerm) {
		if(matchTerm.isEmpty()) //A match term is required to get the count of occurrences
			throw new NullPointerException("Please set a term to find the occurrences of it");

		this.matchTerm = matchTerm.trim();//Remove starting and trailing whitespaces - not lowercasing it here incase we have a regex
	}
	
	@Override
	public void runMetric(String line,Metric metric, Map<String, Integer> resultsMap) {	
		if(metric.getMetricType().equalsIgnoreCase(MetricType.OCCURANCE_COUNTER.toString())) {
			
			if (line.toLowerCase().contains(((OccurenceMetric) metric).getMatchTerm().toLowerCase()))//Check if line contains a match 
				incOccurrence(resultsMap,  metric.getMetricKey());			
			
		}
		else if(metric.getMetricType().equalsIgnoreCase(MetricType.OCCURANCE_COUNTER_WITH_REGEX.toString())) {  
			
			if (Pattern.matches(((OccurenceMetric) metric).getMatchTerm(),line.toLowerCase()))  // Check if regex matches line
				incOccurrence(resultsMap,  metric.getMetricKey());	
			
		}		
		else {
			super.runMetric(line, metric, resultsMap);
		}
	}
	

	
	
}
