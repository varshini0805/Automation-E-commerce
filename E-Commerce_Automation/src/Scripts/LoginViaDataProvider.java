package Scripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelUtilities.ExcelFunctions;
import Generic.BaseTest;
import POM.CreateAccount;

public class LoginViaDataProvider extends BaseTest {
	
	@DataProvider(name="LoginDetails")
	public String[][] getData() throws IOException
	{
		String path ="C:\\Users\\Sujan\\Desktop\\Automtion Framework\\E-Commerce_Automation\\ExcelFiles\\TestData.xlsx";
		int rownum= ExcelFunctions.getRowCount(path, 0);
		int cellnum= ExcelFunctions.getCellCount(path, 0, 0);
		
	//	System.out.println(rownum + " "+cellnum);
		
		String[][] login = new String[rownum][cellnum];
		
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<cellnum;j++)
			{
				login[i-1][j]=ExcelFunctions.getCellData(path, 0, i, j);
			}
		}
		return login;
		
	}
	
	@Test(dataProvider="LoginDetails")
	public void LoginTest(String email,String password)
	{
		CreateAccount createacc = new CreateAccount(driver);
		System.out.println(email+ " " +password);
		createacc.email_signin(email);
		createacc.pswd_signin(password);
		createacc.submit();
		
		String Expt_Txt = "Welcome to your account. Here you can manage all of your personal information and orders.";
		String Actual_Txt = driver.findElement(By.className("info-account")).getText();
		
		
		//Assert.assertEquals(Actual_Txt, Expt_Txt);
		if(Expt_Txt.equals(Actual_Txt))
		{
			//Assert.assertTrue(true);
		System.out.println("Vadidated"); 
		}
		else
		{
			System.out.println("Error occured");
			//Assert.assertTrue(false);
			
			//screenShot(driver,"title_SC");
		}
		
	}
}
