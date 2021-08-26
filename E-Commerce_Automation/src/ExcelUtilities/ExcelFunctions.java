package ExcelUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFunctions {

	public static List<Map<String,String>> getTestDataInList() throws IOException
	{
		Map<String,String> testdata = null;
		
		XSSFWorkbook wb= new XSSFWorkbook("C:\\Users\\Sujan\\Desktop\\Automtion Framework\\E-Commerce_Automation\\ExcelFiles\\TestData.xlsx");
		XSSFSheet sheet= wb.getSheetAt(0);
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		
		int lastColumn = sheet.getRow(0).getLastCellNum();
		
		LinkedList list = new LinkedList();
		
		for(int i=0;i<lastColumn;i++)
		{
			XSSFRow rowcnt=sheet.getRow(0);
			
			XSSFCell cell= rowcnt.getCell(i);
			
			String rowHeaders = cell.getStringCellValue();
			
			list.add(rowHeaders);
			
		}
		
		LinkedList <Map<String,String>> testdataAll = new LinkedList <Map<String,String>>();
		
		for(int j=1;j<rowCount;j++)
		{
			XSSFRow rows= sheet.getRow(j);
			testdata= new TreeMap<String,String>();
			
			for(int k=0; k<lastColumn;k++)
			{
				String colValues= rows.getCell(k).getStringCellValue();
				
				testdata.put((String)list.get(k), colValues);
	
			}
			
			testdataAll.add(testdata);
			
		}
		return testdataAll;	
	}
	
	public static List<Map<Object,Object>> getTestDataInListObj() throws IOException
	{
		Map<Object,Object> testdata = null;
		
		XSSFWorkbook wb= new XSSFWorkbook("C:\\Users\\Sujan\\Desktop\\Automtion Framework\\E-Commerce_Automation\\ExcelFiles\\TestData.xlsx");
		XSSFSheet sheet= wb.getSheetAt(0);
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		
		int lastColumn = sheet.getRow(0).getLastCellNum();
		
		LinkedList list = new LinkedList();
		
		for(int i=0;i<lastColumn;i++)
		{
			XSSFRow rowcnt=sheet.getRow(0);
			
			XSSFCell cell= rowcnt.getCell(i);
			
			String rowHeaders = cell.getStringCellValue();
			
			list.add(rowHeaders);
			
		}
		
		LinkedList <Map<Object,Object>> testdataAll = new LinkedList <Map<Object,Object>>();
		
		for(int j=1;j<rowCount;j++)
		{
			XSSFRow rows= sheet.getRow(j);
			testdata= new TreeMap<Object,Object>();
			
			for(int k=0; k<lastColumn;k++)
			{
				String colValues= rows.getCell(k).getStringCellValue();
				
				testdata.put((String)list.get(k), colValues);
	
			}
			
			testdataAll.add(testdata);
			
		}
		return testdataAll;	
	}	
	
		public static Map<String,String> getMapData() throws IOException
		{
			
			XSSFWorkbook wb= new XSSFWorkbook("C:\\Users\\Sujan\\Desktop\\Automtion Framework\\E-Commerce_Automation\\ExcelFiles\\TestData.xlsx");
			XSSFSheet sheet = wb.getSheetAt(0);
			int lastrowcnt = sheet.getLastRowNum();
			
			LinkedHashMap<String,String> testdata= new LinkedHashMap<String,String>();
			
			for(int i=0;i<=lastrowcnt;i++)
			{
				XSSFRow row = sheet.getRow(i);
				
				String key = row.getCell(0).getStringCellValue().trim();
				
				String Value= row.getCell(1).getStringCellValue().trim();
				
				testdata.put(key, Value);
				
			}
			return testdata;
			
			
		}
		
		public static void rowCount() throws IOException
		{
			XSSFWorkbook wb= new XSSFWorkbook("C:\\Users\\Sujan\\Desktop\\Automtion Framework\\E-Commerce_Automation\\ExcelFiles\\Sample.xlsx");
			XSSFSheet ws = wb.getSheet("Sheet1");
			int cnt = ws.getPhysicalNumberOfRows();
			System.out.println("no of rows " +cnt);
		}
		
		public static void getCellValue() throws IOException
		{
			XSSFWorkbook wb= new XSSFWorkbook("C:\\Users\\Sujan\\Desktop\\Automtion Framework\\E-Commerce_Automation\\ExcelFiles\\TestData.xlsx");
			XSSFSheet ws = wb.getSheet("Sheet1");
			String value = ws.getRow(0).getCell(0).getStringCellValue();
			System.out.println("Cell value "+value);
		}
		
		public static void getCellNumbers() throws IOException
		{
			XSSFWorkbook wb= new XSSFWorkbook("C:\\Users\\Sujan\\Desktop\\Automtion Framework\\E-Commerce_Automation\\ExcelFiles\\TestData.xlsx");
			XSSFSheet ws = wb.getSheet("Sheet1");
			double value = ws.getRow(2).getCell(1).getNumericCellValue();
			System.out.println("Cell value "+value);
		}
		
		public static void writeData(String name, int i,int j) throws InvalidFormatException, IOException
		{
			File src = new File("C:\\Users\\Sujan\\Desktop\\Automtion Framework\\E-Commerce_Automation\\ExcelFiles\\TestData.xlsx");
			FileInputStream fin = new FileInputStream(src);
			
			XSSFWorkbook wb= new XSSFWorkbook(fin);
			XSSFSheet sh= wb.getSheetAt(0);
			
			sh.getRow(i).getCell(j).setCellValue(name);
			
			FileOutputStream fout = new FileOutputStream(src);
		wb.write(fout);
		wb.close();
			
		}
		
		public static int getRowCount(String filePath,int sheetNum) throws IOException
		{
			XSSFWorkbook wb= new XSSFWorkbook(filePath);
			XSSFSheet sh= wb.getSheetAt(sheetNum);
			int rowCount = sh.getLastRowNum();
		
			wb.close();
			
			return rowCount;
		}
		
		public static int getCellCount(String filePath,int sheetNum,int r) throws IOException
		{
			XSSFWorkbook wb= new XSSFWorkbook(filePath);
			XSSFSheet sh= wb.getSheetAt(sheetNum);
			int cellCount = sh.getRow(r).getLastCellNum();
			
			wb.close();
			
			return cellCount;
		}
		
		public static String getCellData(String filePath,int sheetNum,int r,int c) throws IOException
		{
			XSSFWorkbook wb= new XSSFWorkbook(filePath);
			XSSFSheet sh= wb.getSheetAt(sheetNum);
			 XSSFCell celldata = sh.getRow(r).getCell(c);
			 String cellvalue=null;
			 
			 try
			 {
			DataFormatter formatter = new DataFormatter();
			  cellvalue = formatter.formatCellValue(celldata);
			
			 }
			 catch(Exception ex)
			 {
				 System.out.println("Data not formatted");
			 }
			 
			 return cellvalue;
		}
}
