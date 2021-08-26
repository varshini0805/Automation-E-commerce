package ExcelSamples;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsEx {

	WebDriver driver;
	public	ExtentHtmlReporter ExHtml;
	
	public ExtentReports ExReport;
	
	public ExtentTest ExTest;
	
	@BeforeTest
	public void SetExtent()
	{
		 ExHtml = new ExtentHtmlReporter("C:\\Users\\Sujan\\Desktop\\Automtion Framework\\E-Commerce_Automation\\test-output\\myReport.html");
		 ExHtml.config().setDocumentTitle("Automation Test Report"); //title of report
		 ExHtml.config().setReportName("Functional Test report"); //name of report
		 ExHtml.config().setTheme(Theme.DARK);
		 
		 ExReport	= new ExtentReports();
		 ExReport.attachReporter(ExHtml);
		 
		 ExReport.setSystemInfo("Host name", "Local host");
		 ExReport.setSystemInfo("OS", "Windows 10");
		 ExReport.setSystemInfo("Tester Name","Varshini");
		 ExReport.setSystemInfo("Browser","Chrome");
		 
	}
	
	public static String screenShot(WebDriver driver,String name) throws IOException
	{
		// SimpleDateFormat dt = new SimpleDateFormat();
		TakesScreenshot t= (TakesScreenshot)driver;
		File source = t.getScreenshotAs(OutputType.FILE);
		String scrn = "C:\\Users\\Sujan\\Desktop\\Automtion Framework\\ScreenShot\\ExtentReport\\"+name+".png";
		
		File dest = new File(scrn);
		FileUtils.copyFile(source, dest);
		return scrn;
		
	}
	
	@AfterTest
	public void endReport()
	{
		ExReport.flush();
	}
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\JavaWorkspace\\Driver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			ExTest.log(Status.FAIL, "Test case failed is "+result.getName());
			
			ExTest.log(Status.FAIL, "Test case error is "+result.getThrowable());
		String pth = ExtentReportsEx.screenShot(driver, result.getName());
			ExTest.addScreenCaptureFromPath(pth);
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			ExTest.log(Status.SKIP, "Test case skipped is "+result.getName());
		}
		
		else if(result.getStatus()==ITestResult.SUCCESS) 
		{
			ExTest.log(Status.PASS, "Test case passed is "+result.getName());
		}
	}
	
	@Test
	public void VerfiyTitle()
	{
		ExTest=ExReport.createTest(" Verify Title");
		String Actualtitle = driver.getTitle();
		System.out.println(Actualtitle);
		
		String expectedTxt="nopCommerce demo stores"; 
		Assert.assertEquals(Actualtitle, expectedTxt);
	}
	
	@Test
	public void LogoTest()
	{
		ExTest=ExReport.createTest(" Verify Logo");
		WebElement logo = driver.findElement(By.xpath("//img[@alt=\"nopCommerce demo store\"]"));
		boolean logoStatus = logo.isDisplayed();
		if(logoStatus==true)
		{
			System.out.println("Logo is present");
		}
		else
		{
			System.out.println("Logo not displayed");
		}
	}
	
	@Test
	public void LoginTest()
	{
		ExTest=ExReport.createTest(" Verify Login");
		boolean btn = driver.findElement(By.xpath("//a[.='Log in']")).isEnabled();
		
		Assert.assertTrue(btn);
	}
}
