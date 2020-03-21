package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.List;


public class AnalyticsCounter {
	private Map<String, Integer> countMap;

	public AnalyticsCounter() {

		countMap = new HashMap<>();
	}

	/**
	 * Method to generate a list of symptoms with the appropriate number of
	 * occurrences for each symptom.
	 *
	 * @param fileList
	 */
	public void generateCountMap(List<String> fileList) {

		for (String line : fileList) {
			if (countMap.containsKey(line)) {
				countMap.put(line, countMap.get(line) + 1);// increase the occurrence count number for repeated symptom
															// in a list
			} else {
				countMap.put(line, 1);
			}
		}
	}
	
	/**
	 * Method to read symptoms from file.
	 *
	 * @return success / failure of this operation
	 */
	public 	List<String> readSymptomsFromFile(String fileName) {
		ReadSymptomDataFromFile readSymptomDataFromFile =   new ReadSymptomDataFromFile(fileName); 

		return readSymptomDataFromFile.getSymptoms();
	}
	
	/**
	 * Method to sort the list of symptoms in alphabetical order.
	 *
	 * @return success / failure of this operation
	 */
	public Map<String, Integer> getSortedByName(){
		return new TreeMap<String, Integer>(countMap); // sort the map by its key entries
	}
	
	/**
	 * Method to write output result into a file.
	 *
	 * 
	 */
	public void writeDataIntoFile(String fileName) throws IOException {
		WriteDataIntoFile writeData = new WriteDataIntoFile();

		writeData.write(fileName, getSortedByName());  
	}
	
	/**
	 * Main entry point to the application.
	 *
	 * 
	 */	
	public static void main(String args[]) throws Exception {
		
		AnalyticsCounter analyticsCounter = new AnalyticsCounter();

		List<String> rawData = analyticsCounter.readSymptomsFromFile("symptoms.txt");//read symptoms from file
		
		analyticsCounter.generateCountMap(rawData);//get symptoms
		
		analyticsCounter.writeDataIntoFile("result_out.txt");//write output result into a file 
		
		System.out.println("Check new generated text file results_out.txt with the list of sorted symptoms");

	}
}
