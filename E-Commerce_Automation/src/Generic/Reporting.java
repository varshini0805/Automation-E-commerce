package Generic;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import ExcelSamples.ExtentReportsEx;


public class Reporting extends TestListenerAdapter {

	WebDriver driver;
	public	ExtentHtmlReporter ExHtml;
	
	public ExtentReports ExReport;
	
	public ExtentTest ExTest;
	
	String pth;
	
	@BeforeTest
	public void onStart(ITestContext testContext)
	{
		
		String TimeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String RepName= "TestReport"+TimeStamp+".html";
		 ExHtml = new ExtentHtmlReporter("C:\\Users\\Sujan\\Desktop\\Automtion Framework\\E-Commerce_Automation\\test-output\\"+RepName);
		 ExHtml.loadConfig("C:\\Users\\Sujan\\Desktop\\Automtion Framework\\E-Commerce_Automation\\extent-config.xml");
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
	
	public void onTestSuccess(ITestResult tr) {
		
		ExTest=ExReport.createTest(tr.getName());
		ExTest.log(Status.PASS, "Test case passed is "+tr.getName());
	  }

	  public void onTestFailure(ITestResult tr){
		  
		  if(tr.getStatus()==ITestResult.FAILURE)
			{
			  ExTest=ExReport.createTest(tr.getName());
				ExTest.log(Status.FAIL, "Test case failed is "+tr.getName());
				
				ExTest.log(Status.FAIL, "Test case error is "+tr.getThrowable());
			
			
				try {
					pth = BaseTest.screenShot(driver, tr.getName());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					ExTest.addScreenCaptureFromPath(pth);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		  
		  
		  
		  
//		  ExTest=ExReport.createTest(tr.getName());
//		  ExTest.log(Status.FAIL, "Test case failed is "+tr.getName());
//			//String path="C:\\Users\\Sujan\\Desktop\\Automtion Framework\\ScreenShot\\ExtentReport"+tr.getName()+".png"; 
//			//File fl= new File(path);
//			
//			
//					String scn=null;
//					try {
//						scn = BaseTest.screenShot(driver, tr.getName());
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					
//					try {
//						ExTest.fail("ScreenShot is below"+ExTest.addScreenCaptureFromPath(scn));
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//		
		
	  }

	  @Override
	  public void onTestSkipped(ITestResult tr) {
		  
		  ExTest=ExReport.createTest(tr.getName());
		  ExTest.log(Status.SKIP, "Test case skipped is "+tr.getName());
	  }
	
	  public void onFinish(ITestContext testContext) 
	  {

			ExReport.flush();
		}

}
