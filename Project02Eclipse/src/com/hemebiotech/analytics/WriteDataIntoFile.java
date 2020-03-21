package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteDataIntoFile {
	
	/**
	 * Method to write into a file a sorted list of symptoms in alphabetical order with the appropriate number of occurrences.
	 *
	 * @param fileName
	 * @param hm
	 */
	public void write(String fileName, Map<String, Integer> hm) throws IOException {

		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

		for (Map.Entry<String, Integer> entry : hm.entrySet()) {

			try {
				writer.write(entry.getKey() + " = " + entry.getValue());
				writer.write(System.getProperty("line.separator"));           //writes each symptom in an own line

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		writer.close();

	}
}

