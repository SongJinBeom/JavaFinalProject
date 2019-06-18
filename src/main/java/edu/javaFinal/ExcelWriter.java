package edu.javaFinal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ExcelWriter {
	
	
	public static void writeAFile(ArrayList<String> lines, String targetFileName, int count) {
		File file = new File(targetFileName+count+".csv");
		try {
			if(!file.exists()) {
				file.getParentFile().mkdir();
				file.createNewFile();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			BufferedWriter stream = new BufferedWriter(new FileWriter(file, true));
			String line = "";
			
			for(String cell : lines) {
				stream.write(cell);
				stream.flush();
			}
			stream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
//	
//	try {
//		BufferedWriter stream = new BufferedWriter(new FileWriter(output, true));
//		String oneLine = "";
//		
//		if(type == 0 && isFirst1) {
//			isFirst1 = !isFirst1;
//		}else if(type == 1 && isFirst2) {
//			isFirst2 = !isFirst2;
//		}
//		for(String row : data) {
//			oneLine = oneLine + row + ",";
//		}
//		System.out.println("oneLine: "+oneLine);
//		stream.write(oneLine + "\n");
//		stream.flush();
//		stream.close();
//	} catch(IOException e) {
//		e.printStackTrace();
//	}
	
}

