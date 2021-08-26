package ExcelSamples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Generic.AutoConstants;

public class ParallelExecution implements AutoConstants{

	//public WebDriver driver;
	@Test
	public void test1() throws InterruptedException
	{
		System.out.println("I am inside Test1");
		
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://www.google.com/");	
		Thread.sleep(2000);
	
	}
	
	@Test
	public void test2()
	{
		System.out.println("I am inside Test2");
		
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		ChromeDriver	driver= new ChromeDriver();
		driver.get("https://www.amazon.com/");
	}
}
