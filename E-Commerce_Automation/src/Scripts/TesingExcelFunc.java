package Scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import ExcelUtilities.ExcelFunctions;

public class TesingExcelFunc {
	
	@Test
	public void testing() throws IOException
	{
		ExcelFunctions ef= new ExcelFunctions();
		String path ="C:\\Users\\Sujan\\Desktop\\Automtion Framework\\E-Commerce_Automation\\ExcelFiles\\TestData.xlsx";
	int roeCount = ef.getRowCount(path, 0);
	
	System.out.println("Row" + roeCount);
		
	int cellCount = ef.getCellCount(path, 0, 0);
	System.out.println("column" + cellCount);
		
		String cellData =ExcelFunctions.getCellData(path, 0, 3,1);
		System.out.println(cellData);
	}
	

}
