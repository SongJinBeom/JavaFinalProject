package edu.javaFinal;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ExcelWriter {
	
	
	public static void writeAFile(ArrayList<String> lines, String targetFileName, int count) {
		PrintWriter outputStream = null;
		try {
			targetFileName = targetFileName + count + ".csv";
			outputStream = new PrintWriter(targetFileName);
		} catch (FileNotFoundException e) {
			System.out.println("Error writing the file " + targetFileName);
			System.exit(0);
		}
		for (String line : lines) {
			System.out.println(line);
			outputStream.println(line);
		}
		outputStream.close();
	}
	
}
