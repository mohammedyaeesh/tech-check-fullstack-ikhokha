package com.ikhokha.techcheck.Logic;

import java.io.*;
import java.util.*;
import java.util.concurrent.Callable;

import com.ikhokha.techcheck.MetricSetup;
import com.ikhokha.techcheck.Classes.CommentLengthMetric;
import com.ikhokha.techcheck.Classes.Metric;
import com.ikhokha.techcheck.Classes.OccurenceMetric;
import com.ikhokha.techcheck.Enums.MetricType;

//Using callable for a value returning task
public class CommentAnalyzer implements Callable<Map<String, Integer>> {

	private File file;
	
	public CommentAnalyzer(File file) {
		this.file = file;
	}
	
	@Override
	public Map<String, Integer> call() throws Exception {
		
		Map<String, Integer> resultsMap = new HashMap<>();
		MetricSetup metricSetup = new MetricSetup();
		List<Metric> allMetrics = metricSetup.setupMetrics();// Gets all metrics which have been defined  
		
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

			String line = null;
			while ((line = reader.readLine()) != null) {
				for(Metric metric : allMetrics) {					
						metric.runMetric(line, metric, resultsMap);					
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + file.getAbsolutePath());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO Error processing file: " + file.getAbsolutePath());
			e.printStackTrace();
		}

		return resultsMap;
		
	}
	
}
