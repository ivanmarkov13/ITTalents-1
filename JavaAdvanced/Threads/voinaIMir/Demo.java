package voinaIMir;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Demo {

	public static void main(String[] args) throws InterruptedException {
		
		File f = new File("Voinaimir.txt"); //create new file
		String text=null; 
		try {
			 text = readFile(f);
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
		
		int numberOfThreads=5; //number of threads
		int textPerThread = text.length()/numberOfThreads; //get the size of text each tread has to read
		int startIndex = 0; // a start and end index for every substring from the text
		int endIndex = startIndex+textPerThread;
		
		Long startTime = System.currentTimeMillis(); 
		coountCommas(text, numberOfThreads, startIndex, endIndex, textPerThread);
		Long endTime = System.currentTimeMillis();
		
		System.out.println("Five treads count the commas for " + (endTime-startTime) + " ms.");
		System.out.println("Commas - " + ComaCounter.getCommas());
		
		
	}
	
	//a method that receives as parameters - the text, the numberOfThreads, start and end index and the text size to be read by each thread
	public static void coountCommas(String text, int numberOfThreads, int startIndex, int endIndex, int textPerThread) throws InterruptedException {
		for (int i = 0; i < numberOfThreads; i++) { //for every thread
			String t = text.substring(startIndex,endIndex); //create a substring for each thread
			Thread thread = new Thread(new ComaCounter(t,i));
			thread.start();
			thread.join();
			
			if(i==numberOfThreads-1) { 
				startIndex=endIndex+1;
				endIndex=text.length()-1;
				//if it's the last one it should read to the end of the text
			}
			else {
				startIndex=endIndex+1;
				endIndex+=textPerThread;
			}
			
		}
	}
	
	//a method that reads a file by scanner and stores the text in stringbuilder
	public static String readFile(File f) throws FileNotFoundException {
		Scanner sc = new Scanner(f);
		StringBuilder sb = new StringBuilder();
		String line = sc.nextLine();
		String lineSeparator = System.lineSeparator();
		if (sc.hasNextLine()) {
			sb.append(line);
		 }
		 while (sc.hasNextLine()) {
		    sb.append(lineSeparator + sc.nextLine());
		}
		 sc.close();
		 return sb.toString();
	}
}
