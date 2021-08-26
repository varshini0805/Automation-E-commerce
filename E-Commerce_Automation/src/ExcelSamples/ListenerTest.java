package ExcelSamples;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener{

	@Override
	public void onTestStart(ITestResult result)
	{
		System.out.println(result.getName()+ " Test case started ");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Name of Test case Scuccess is "+result.getName());
	  }
	
	
	@Override
	public void onTestFailure(ITestResult result) 
	{
	   System.out.println("Name of Test case failed is "+result.getName());
	  }
	
	
	@Override
	 public void onTestSkipped(ITestResult result)
	{
		System.out.println("Name of Test case skipped is "+result.getName());

	}
	
	
	@Override
	 public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		    // not implemented
		  }
	
	
	@Override
	 public void onTestFailedWithTimeout(ITestResult result) {
		    onTestFailure(result);
		  }
	
	
	@Override
	 public void onStart(ITestContext context) {
		
		  }
	
	
	@Override
	 public void onFinish(ITestContext context) {
		    // not implemented
		  }
	
}
