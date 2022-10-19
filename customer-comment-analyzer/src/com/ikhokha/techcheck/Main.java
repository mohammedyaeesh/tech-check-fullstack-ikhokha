package com.ikhokha.techcheck;

import java.io.File;
import java.util.*;
import java.util.concurrent.*;

import com.ikhokha.techcheck.Logic.CommentAnalyzer;
import com.ikhokha.techcheck.Logic.CommentProcessor;

public class Main {
	
	public static void main(String[] args) {
		
		try {
			CommentProcessor processor =  new CommentProcessor(); 
			File [] commentFiles = processor.getCommentFiles(); //Get all comment files	
			if(commentFiles.length > 0 ) { //if files exist, then process them		
				processor.processFiles(commentFiles);				
			}else {
				System.out.println("No comment files have been found. Terminating program.");		
			}
			
		} catch(Exception exception) {
			System.out.println("ERROR : main | Error details : "  + exception.getMessage());
			exception.printStackTrace();
		} finally {
			System.exit(0);//Successfully terminate the program
		}
		
	}
}
