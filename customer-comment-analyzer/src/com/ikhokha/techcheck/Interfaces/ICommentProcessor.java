package com.ikhokha.techcheck.Interfaces;

import java.io.File;
import java.util.Map;

public interface ICommentProcessor {
	File[] getCommentFiles();
	void processFiles(File [] commentFiles) ;
	void generateReport() ;
	void printResults() ;
	void addReportResults(Map<String, Integer> source, Map<String, Integer> target);
	
}
