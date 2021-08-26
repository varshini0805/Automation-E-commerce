package ExcelSamples;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class GetMapData {

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
	
	
	
	@Test
	public void test1() throws IOException
	{
		Map<String, String> data = GetMapData.getMapData();
		
		for(Entry<String, String> map:data.entrySet())
		{
			System.out.println("Username : "+map.getKey()+" Password : "+map.getValue());
		}
	}
}


