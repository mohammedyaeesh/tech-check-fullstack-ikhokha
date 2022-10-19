package com.ikhokha.techcheck.Logic;

import java.io.File;
import java.util.*;
import java.util.concurrent.*;
import com.ikhokha.techcheck.Interfaces.ICommentProcessor;

public class CommentProcessor implements ICommentProcessor {
	
	private static final int MAX_POOL=5; //Maximum number of threads to use
	
	private static  Map<String, Integer> totalResults = new HashMap<>();
	private static List<Future<Map<String, Integer>>> fileResults = new ArrayList<>();
	
	public CommentProcessor() {
		
	}	
	
	public File[] getCommentFiles() {
		
		File docPath = new File("docs");
		File[] commentFiles = docPath.listFiles((d, n) -> n.endsWith(".txt"));
		
		return commentFiles;
	}
	
	
	public void processFiles(File [] commentFiles) {

		ExecutorService executor = Executors.newFixedThreadPool(MAX_POOL);	
		try {
			for (File commentFile : commentFiles) {			
				Callable<Map<String,Integer>> callableTask = new CommentAnalyzer(commentFile);
				Future<Map<String, Integer>> futureTask = executor.submit(callableTask);
				fileResults.add(futureTask);//Push each files results 			
			}			
			generateReport();//Combines all results
			printResults();
		} catch (Exception exception) {
			System.out.println("ERROR : processResults | Error details : "  + exception.getMessage());
			exception.printStackTrace();
		} finally {				
			executor.shutdown(); //Terminate all threads once they're completed
		}
	
	}
	
	//Gets the metric results of a file 
	public void generateReport() {
		for (Future<Map<String, Integer>> future : fileResults) {
			try {
				addReportResults(future.get(), totalResults);
			} catch (Exception exception){
				System.out.println("ERROR : processResults | Error details : "  + exception.getMessage());
				exception.printStackTrace();				
			}
			
		}
	}
	
	//Outputs final results once all files have been processed
	public void printResults() {
			System.out.println("RESULTS\n=======");
			totalResults.forEach((k,v) -> System.out.println(k + " : " + v));
    }
    	
	   /**
		 * This method adds the result counts from a source map to the target map 
		 * @param source the source map
		 * @param target the target map
		 */
	public void addReportResults(Map<String, Integer> source, Map<String, Integer> target) {
			try {
				for (Map.Entry<String, Integer> entry : source.entrySet()) {			
					if (target.get(entry.getKey()) != null) {
						target.put(entry.getKey(), target.get(entry.getKey()) + entry.getValue());
					}else {
						target.put(entry.getKey(), entry.getValue());
					}
				}
			}
			catch(Exception e) {
				System.out.println("An unexpected error has occured when adding results to the report :" + e);
			}
	}
		

}
