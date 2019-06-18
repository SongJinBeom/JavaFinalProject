package edu.javaFinal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteFiles implements Runnable{
	
	ArrayList<String> a1;
	ArrayList<String> a2;
	String outputPath;
	int count = 1;
	public WriteFiles(ArrayList<String> a1, ArrayList<String> a2, String outputPath) {
		ArrayList<WriteFiles> writers = new ArrayList<WriteFiles>();
		
		this.a1 = a1;
		this.a2 = a2;
		this.outputPath = outputPath;
		
		writers.add(new WriteFiles(a1, a2, outputPath));
		writers.add(new WriteFiles(a1, a2, outputPath));
		
		ArrayList<Thread> threads = new ArrayList<Thread>();
		
		for(WriteFiles w1: writers) {
			Thread thread = new Thread(w1);
			thread.start();
			threads.add(thread);
		}
	
		for(Thread t1 : threads) {
			try {
				t1.join();
				count++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
		

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		ExcelWriter pen = new ExcelWriter();
		if(count ==1)
			pen.writeAFile(a1, outputPath, count);
		else
			pen.writeAFile(a2, outputPath, count);
	}
	
}