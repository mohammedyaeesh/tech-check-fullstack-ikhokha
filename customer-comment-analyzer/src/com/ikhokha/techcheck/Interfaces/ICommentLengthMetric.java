package com.ikhokha.techcheck.Interfaces;

/*
 * Abstract methods for child class CommentLenghMetric.
 * Parent class is Metrics  
 */
public interface ICommentLengthMetric {

	//returns the length of a comment/line
	int getMaxLineLength();
	
	//sets the maximum length parameter
	void setMaxLineLength(int maxLineLength) ;
	
}
