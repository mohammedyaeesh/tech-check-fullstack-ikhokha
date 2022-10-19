package com.ikhokha.techcheck.Classes;

import java.util.Map;

import com.ikhokha.techcheck.Enums.MetricType;
import com.ikhokha.techcheck.Interfaces.ICommentLengthMetric;

public class CommentLengthMetric extends Metric implements ICommentLengthMetric {
	
	
	private int maxLineLength = 0 ; //Default to 0
	
	public CommentLengthMetric(String metricKey, MetricType type, int maxLineLength) {
		
		if(metricKey.isEmpty() || type == null)// Object cannot be instantiated without a key or type since this is vital to process the metric and output the result
			throw new NullPointerException("The Metric Key or Type has not been set ");
		
		this.setMetricKey(metricKey); 
		this.setMetricType(type); 
		this.setMaxLineLength(maxLineLength);		
	}
	
	public int getMaxLineLength() {
		return maxLineLength;
	}

	public void setMaxLineLength(int maxLineLength) {
		if(maxLineLength < 0) //Ensure that max length captured is greater than 1 character
			throw new NullPointerException("The Maximum Line Length must be greater than >= 1");

		this.maxLineLength = maxLineLength;
	}
	
	@Override
	public void runMetric(String line,Metric metric, Map<String, Integer> resultsMap) {
		// MetricType.MAX_LENGTH => Determines the occurences of lines which are less than N characters, where N is specified in the Metric initialization
		if(metric.getMetricType().equalsIgnoreCase(MetricType.MAX_LENGTH.toString())) {
			if (line.length() < ((CommentLengthMetric) metric).getMaxLineLength()) 
				incOccurrence(resultsMap, metric.getMetricKey());	
		}else {
			super.runMetric(line, metric, resultsMap);
		}
		
	}
}
