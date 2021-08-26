package ExcelSamples;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class GetAllData {

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
	
	@Test
	public void testMethod() throws IOException
	{
		 List<Map<String, String>> data = GetAllData.getTestDataInList();
		 
		 for(Map<String,String> var: data)
		 {
	System.out.println(var);
		 }
	}
	
}
