package com.ikhokha.techcheck.Interfaces;

/*
 * Abstract methods for child class OccurenceMetric.
 * Parent class is Metrics  
 */
public interface IOccurenceMetric {
	
	//Returns the term we're looking for
	String getMatchTerm();
	
	//Sets the match term we're looking for
	void setMatchTerm(String matchTerm); 
	
}
