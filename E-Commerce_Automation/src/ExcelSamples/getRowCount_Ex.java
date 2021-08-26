package ExcelSamples;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class getRowCount_Ex {
	
	public static void rowCount() throws IOException
	{
		XSSFWorkbook wb= new XSSFWorkbook("C:\\Users\\Sujan\\Desktop\\Automtion Framework\\E-Commerce_Automation\\ExcelFiles\\Sample.xlsx");
		XSSFSheet ws = wb.getSheet("Sheet1");
		int cnt = ws.getPhysicalNumberOfRows();
		System.out.println("no of rows " +cnt);
	}
	
	public static void getCellValue() throws IOException
	{
		XSSFWorkbook wb= new XSSFWorkbook("C:\\Users\\Sujan\\Desktop\\Automtion Framework\\E-Commerce_Automation\\ExcelFiles\\Sample.xlsx");
		XSSFSheet ws = wb.getSheet("Sheet1");
		String value = ws.getRow(0).getCell(0).getStringCellValue();
		System.out.println("Cell value "+value);
	}
	
	public static void getCellNumbers() throws IOException
	{
		XSSFWorkbook wb= new XSSFWorkbook("C:\\Users\\Sujan\\Desktop\\Automtion Framework\\E-Commerce_Automation\\ExcelFiles\\Sample.xlsx");
		XSSFSheet ws = wb.getSheet("Sheet1");
		double value = ws.getRow(2).getCell(1).getNumericCellValue();
		System.out.println("Cell value "+value);
	}
	
	public static void main(String[] args) throws IOException {
		getRowCount_Ex.rowCount();
		getRowCount_Ex.getCellValue();
		getRowCount_Ex.getCellNumbers();
	}

}
