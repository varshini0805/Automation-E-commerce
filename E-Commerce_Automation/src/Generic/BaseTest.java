package Generic;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public abstract class BaseTest implements AutoConstants {

	public WebDriver driver;
	
	
	
	static
	{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}
	
	@Parameters("Browser")
	
	@BeforeMethod
	public void openApplication(@Optional String br) throws IOException
	{
		ReadConfig	read_config = new ReadConfig();
		
		if(br.equals("chrome"))
		{
			driver= new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
			//read from Config file
			driver.get(read_config.getURL());
			driver.manage().window().maximize();	
		}
		
		if(br.equals("fireFox"))
		{
			driver= new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
			//read from Config file
			driver.get(read_config.getURL());
			driver.manage().window().maximize();
		}
				
	}
	
	/* @AfterMethod
	public void closeApplication()
	{
		driver.close();
	} */
	
	public static String screenShot(WebDriver driver,String name) throws IOException
	{
		
		TakesScreenshot t= (TakesScreenshot)driver;
		File source = t.getScreenshotAs(OutputType.FILE);
		String pathh = "C:\\Users\\Sujan\\Desktop\\Automtion Framework\\ScreenShot\\"+name+".png";
		File dest = new File(pathh);
		FileUtils.copyFile(source, dest);
		return pathh;
	}
	
	
	

	
	public void scrollInto(String xpath)
	{
		WebElement path = driver.findElement(By.xpath(xpath));
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",path);
	}
	
	
	
	public void sortings(String xpath,String value)
	{
		
		List<WebElement> list = driver.findElements(By.xpath(xpath));
		//Select s = new Select((WebElement) path);
		
		//List<WebElement> dmy = s.getOptions();
		for(int i=0;i<list.size();i++)
		{
			String day = list.get(i).getText();
			
			//System.out.println(" given value "+value);
			if(day.equals(value)) 
			{
				list.get(i).click();
				
			}
			
			
		/*	Assert.assertEquals(day, value);
				System.out.println("Yet to click");
				list.get(i).click();
				System.out.println("clicked"); */
		}
			
	}
	
	
	
}
