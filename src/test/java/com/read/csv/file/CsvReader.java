package com.read.csv.file;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class CsvReader {

	public static void main(String[] args) throws IOException, CsvException {
		
		File csvFile = new File(System.getProperty("user.dir")+"//testData//loginData.csv");
		FileReader fileReader = new FileReader(csvFile);
		CSVReader csvReader = new CSVReader(fileReader);
		
		List<String[]> csvData = csvReader.readAll();
		for(String[] data : csvData) {
			for(String data1 : data) {
				System.out.print(data1 + " ");
				if(data1.equals("iamfd")) {
					System.out.println(data1);
				}
			}
			System.out.println("");
			
		}

	}

}
