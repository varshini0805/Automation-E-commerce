package ExcelSamples;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(ExcelSamples.ListenerTest.class)

public class Handle_Alert {

	
	
	public WebDriver driver;
	
	
	public Boolean isAlertTrue()
	{
		try
		{
			driver.switchTo().alert();
			
			return true;
		}
		catch(Exception ex)
		{
			return false;
		}

	}
	
	@Test 
	public void test1()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\\\JavaWorkspace\\\\Driver\\\\chromedriver.exe");
		driver = new ChromeDriver();
	    driver.get("http://demo.guru99.com/V1/index.php");
		driver.manage().window().maximize();
		driver.findElement(By.name("uid")).sendKeys("mngr344286");
		driver.findElement(By.name("password")).sendKeys("Avesune");
		driver.findElement(By.name("btnLogin")).click();

		//Avesune
		
		if(isAlertTrue()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			//Assert.assertTrue(false);
			System.out.println("Login failed");

		}
		else
		{
			Assert.assertTrue(true);
			System.out.println("Login passed");
			driver.findElement(By.xpath("//a[.='Log out']")).click();
			
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
	@Test
	public void failTest()
	{
		System.out.println("This test will fail");
		Assert.assertTrue(false);
	}
}



