package com.hemebiotech.analytics;

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
	
	public static void main(String args[]) throws Exception {

	}
}
