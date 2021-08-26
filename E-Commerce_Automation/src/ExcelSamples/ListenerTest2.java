package ExcelSamples;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class ListenerTest2 extends TestListenerAdapter {

	 @Override
	  public void onTestSuccess(ITestResult tr) {
	  System.out.println("Test passed");
	  }

	  @Override
	  public void onTestFailure(ITestResult tr) {
	   System.out.println("Test failed");
	  }

	  @Override
	  public void onTestSkipped(ITestResult tr) {
	    System.out.println(" test Skipped");
	  }
	  
	  @Override
	  public void onStart(ITestContext testContext) {
	   System.out.println("Test started");
	  }

	
}
