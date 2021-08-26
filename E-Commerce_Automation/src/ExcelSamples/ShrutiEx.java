package ExcelSamples;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ShrutiEx {
	
	
	public static List<Map<String,String>> getTestDatalist() throws IOException

	{

		Map<String,String>testdata=null;

		XSSFWorkbook workbook=new XSSFWorkbook("C:\\\\Users\\\\Sujan\\\\Desktop\\\\Automtion Framework\\\\E-Commerce_Automation\\\\ExcelFiles\\\\TestDataRowColumns.xlsx");

		XSSFSheet sheet = workbook.getSheet("Sheet1");

		

		
	int lastrowcount = sheet.getPhysicalNumberOfRows();

	short lastcolumn = sheet.getRow(0).getLastCellNum();

	System.out.println(lastrowcount);

	System.out.println(lastcolumn);





	ArrayList list=new ArrayList();

	for(int i=0;i<lastcolumn;i++)

	{

	XSSFRow rowcount = sheet.getRow(0);

	XSSFCell cell = rowcount.getCell(i);



	String rowHeaders = cell.getStringCellValue();



	  list.add(rowHeaders);

	}



	ArrayList<Map<String,String>> testdataAll=new ArrayList<Map<String,String>>();

	for(int j=1;j<lastrowcount;j++) 

	{

	XSSFRow rows = sheet.getRow(j);

	testdata=new TreeMap<String,String>();





	for(int k=0;k<lastcolumn;k++)

	{

		String colvalues = rows.getCell(k).getStringCellValue();

		testdata.put((String) list.get(k),colvalues);

	}

	testdataAll.add(testdata);

	}





	return testdataAll;

	}

	
	@Test
	public void testMethod() throws IOException
	{
		
	List<Map<String, String>> data = ShrutiEx.getTestDatalist();

for(Map<String,String>var:data)
{
	System.out.println(var);
}

	}

}
