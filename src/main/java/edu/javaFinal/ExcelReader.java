package edu.javaFinal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	

	public ArrayList<String> getData1(InputStream is) {
		ArrayList<String> values = new ArrayList<String>();
		String file = new String();
		int index = 1;
		try (InputStream inp = is) {
			Workbook wb = WorkbookFactory.create(inp);
			Sheet sheet = wb.getSheetAt(0);
			Row row = sheet.getRow(index);
			while (row != null) {
				String[] data = new String[7];
				for (int i = 0; i < data.length; i++) {
					Cell cell = row.getCell(i);
					if (cell == null) {
						cell = row.createCell(i);
					}
					data[i] = cell.toString().trim();
				}

				String temp = "";
				String[] rrow = new String[8];
				String[] origin = new String[7];
				for (int i = 0; i < data.length; i++) {
					if (data[i].indexOf('"') != -1) {
						data[i] = data[i].replace(',', ' ');
					}
					rrow[i + 1] = "\"" + data[i] + "\"";
					origin[i] = data[i] +"|";
					temp += data[i];
				}
				if (temp.isEmpty()) {
					row = sheet.getRow(++index);
				} else {
					String k = "";
					
					for(int i = 0; i<origin.length;i++) {
						String t1 = origin[i];
						k+=t1;
					}
					//System.out.println(k);
					values.add(k);
					row = sheet.getRow(++index);

				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return values;
	}

	
	public ArrayList<String> getData2(InputStream is) {
		ArrayList<String> values = new ArrayList<String>();
		String file = new String();
		int index = 2;
		try (InputStream inp = is) {
			Workbook wb = WorkbookFactory.create(inp);
			Sheet sheet = wb.getSheetAt(0);
			Row row = sheet.getRow(index);
			while (row != null) {
				String[] data = new String[7];
				for (int i = 0; i < data.length; i++) {
					Cell cell = row.getCell(i);
					if (cell == null) {
						cell = row.createCell(i);
					}
					data[i] = cell.toString().trim();
				}

				String temp = "";
				String[] rrow = new String[8];
				String[] origin = new String[7];
				for (int i = 0; i < data.length; i++) {
					if (data[i].indexOf('"') != -1) {
						data[i] = data[i].replace(',', ' ');
					}
					rrow[i + 1] = "\"" + data[i] + "\"";
					origin[i] = data[i]+",";
					temp += data[i];
				}
				if (temp.isEmpty()) {
					row = sheet.getRow(++index);
				} else {
					String k = "";
					for(String t1: origin) {
						k+=t1;
					}
					//System.out.println(k);
					values.add(k);
					row = sheet.getRow(++index);

				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return values;
	}

}
