package edu.javaFinal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ExcelWriter {
	
	public void writeAFile(ArrayList<String> lines, String targetFileName, int count) {
		PrintWriter outputStream = null;
		
		try {
			targetFileName = targetFileName + count + ".csv";
			outputStream = new PrintWriter(targetFileName);
		} catch (FileNotFoundException e) {
			System.out.println("Error writing the file " + targetFileName);
			System.exit(0);
		}
		
		
		for (String line : lines) {
			//System.out.println(line);
			outputStream.println(line);
			outputStream.flush();
		}
		outputStream.close();
	}
}

	


