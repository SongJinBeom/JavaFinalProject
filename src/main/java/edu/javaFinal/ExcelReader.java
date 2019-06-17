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

		public ArrayList<String> getData(InputStream is) {
			ArrayList<String> values = new ArrayList<String>();
			
			try (InputStream inp = is) {
			    
			        Workbook wb = WorkbookFactory.create(inp);
			        Sheet sheet = wb.getSheetAt(0);
			        
			        int rows=sheet.getPhysicalNumberOfRows();
			        Row row;
			        Cell cell;
			        for(int rowIndex=1;rowIndex<rows;rowIndex++)
			        {
			        	row=sheet.getRow(rowIndex);
			        	String rvalue= " ";
			        	if(row!=null)
			        	{
			        		int cells=row.getPhysicalNumberOfCells();
			        		for(int columnIndex=0;columnIndex<cells;columnIndex++)
			        		{
			        			cell=row.getCell(columnIndex);
			        			String value="";

			        			switch(cell.getCellType())
			        			{
			        			   case NUMERIC:
			        				   value=Double.toString((int) cell.getNumericCellValue());
			        				   rvalue=rvalue+value+",";
			        				   break;
			        				   
			        			   case STRING:
			        				   value=cell.getStringCellValue();
			        				   if(value.contains(","))
			        				   {
			        					   rvalue=rvalue+"\"" +value+ "\""+",";
			        					   break;
			        				   }
			        				   if(value.contains("\n"))
			        				   {
			        					   rvalue=rvalue+"\""+value+"\""+",";
			        					   break;
			        				   }
			        				   rvalue=rvalue+value+",";
			        				   break;
			        			   case BLANK:
			        				 
			        				   value="";
			        				   rvalue=rvalue+value+",";
			        				   break;
								
			        			   default:
									break;
			        			}
			        		}
			        		System.out.println(rvalue);
			        		values.add(rvalue);
			        	}
			         }  
			    } catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
			    	System.out.println("The file path does not exist. Please check your CLI argument!");
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			return values;
		}


	public ArrayList<String> getData1(InputStream is) {
		ArrayList<String> values = new ArrayList<String>();
		String file = new String();
		try (InputStream inp = is) {

			System.out.println(file);
			Workbook wb = WorkbookFactory.create(inp);
			Sheet sheet = wb.getSheetAt(0);

			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);

				String arr[] = row.toString().trim().split(",");
				boolean isnull = true;

				for (int k = 0; k < arr.length; k++) {
					if (arr[k] != null) {
						isnull = false;
						break;
					}
				}
				if (!isnull) {

					file = "";
					DataFormatter formatter = new DataFormatter();
					for (int j = 0; j < row.getLastCellNum(); j++) {
						Cell cell = row.getCell(j);
						if (cell == null) {
							cell = row.createCell(3);
						}
						file = (file + formatter.formatCellValue(cell)).trim() + ",";
					}
					System.out.println(file);
					values.add(file);
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
		try (InputStream inp = is) {
			System.out.println(file);
			Workbook wb = WorkbookFactory.create(inp);
			Sheet sheet = wb.getSheetAt(0);

			for (int i = 2; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				file = "";
				DataFormatter formatter = new DataFormatter();
				for (int j = 0; j < row.getLastCellNum(); j++) {
					Cell cell = row.getCell(j);
					if (cell == null) {
						cell = row.createCell(3);
					}
					file = (file + formatter.formatCellValue(cell)).trim() + ",";
				}
				values.add(file);

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
