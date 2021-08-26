package ExcelSamples;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteDataToExcel {
	
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
	
	@Test
	public void testM() throws InvalidFormatException, IOException
	{
		WriteDataToExcel.writeData("new user333", 1, 1);
	}

}
