package com.ikhokha.techcheck;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.ikhokha.techcheck.Classes.CommentLengthMetric;
import com.ikhokha.techcheck.Classes.Metric;
import com.ikhokha.techcheck.Classes.OccurenceMetric;
import com.ikhokha.techcheck.Enums.MetricType;

public class MetricSetup {	
	
	

	public MetricSetup(){
	}
	
	/*
	 * 
	 * Creates a list containing all the desired metrics & their definition
	 * Instructions to initialize : 
	 * OccurenceMetric(Key,MetricType,MatchTerm)
	 * CommentLengthMetric(Key,MetricType,MaxLineLength)
	 * 
	 */
	public List<Metric> setupMetrics() {
		
		 List<Metric> allMetrics = new ArrayList<Metric>();
		allMetrics.add(new CommentLengthMetric("SHORTER_THAN_15",MetricType.MAX_LENGTH,15));
		allMetrics.add(new OccurenceMetric("MOVER_MENTIONS",MetricType.OCCURANCE_COUNTER,"mover"));
		allMetrics.add(new OccurenceMetric("SHAKER_MENTIONS",MetricType.OCCURANCE_COUNTER,"shaker"));
		allMetrics.add(new OccurenceMetric("QUESTIONS",MetricType.OCCURANCE_COUNTER,"?"));
		//allMetrics.add(new OccurenceMetric("SPAM",MetricType.OCCURANCE_COUNTER,"http")); //all URL's have to contain http or https
		allMetrics.add(new OccurenceMetric("SPAM",MetricType.OCCURANCE_COUNTER_WITH_REGEX,".*(http|www).*"));
		
		return allMetrics;
	}
	

}

