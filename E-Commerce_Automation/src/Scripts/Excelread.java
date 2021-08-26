package Scripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import ExcelSamples.GetAllData;

public class Excelread {
	
	@Test
	public void signinExcel() throws IOException
	{
		System.setProperty("webdriver.chrome.driver","C:\\JavaWorkspace\\Driver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
		//driver.findElement(By.id("search_query_top")).sendKeys(GetAllData.getTestDataInList().get(1).get("UserName"));
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(GetAllData.getTestDataInList().get(1).get("UserName"));
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(GetAllData.getTestDataInList().get(1).get("Password"));
		driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
	}

}
