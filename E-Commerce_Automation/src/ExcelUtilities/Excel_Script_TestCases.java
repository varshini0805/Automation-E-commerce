package ExcelUtilities;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import ExcelSamples.GetAllData;
import ExcelSamples.GetMapData;
import ExcelSamples.WriteDataToExcel;
import ExcelSamples.getRowCount_Ex;

public class Excel_Script_TestCases {

	@Test
	public void testMethod() throws IOException
	{
		 List<Map<String, String>> data = GetAllData.getTestDataInList();
		 
		 for(Map<String,String> var: data)
		 {
	System.out.println(var);
		 }
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
	
	
	@Test
	public void test2() throws IOException {
		getRowCount_Ex.rowCount();
		getRowCount_Ex.getCellValue();
		getRowCount_Ex.getCellNumbers();
	}
	
	@Test
	public void testM() throws InvalidFormatException, IOException
	{
		WriteDataToExcel.writeData("new user333", 1, 1);
	}

	
}
