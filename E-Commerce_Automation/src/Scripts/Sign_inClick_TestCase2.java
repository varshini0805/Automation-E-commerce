package Scripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic.BaseTest;
import POM.CreateAccount;

public class Sign_inClick_TestCase2 extends BaseTest {

	
	 @DataProvider(name="SignIn")
	public Object[][] dataset()
	{
		return new Object[][]
				{
			{"varshi0805@yahoo.com","sujan" },
			{"test@gmail.com","rftyh"},
			{"mangofruitssss@gmail.com","12345"}
				};
	} 
	
	
	@Test(dataProvider="SignIn")
	
	//@Test()
	public void signin(String email,String pwd) throws IOException
	{
		CreateAccount createacc = new CreateAccount(driver);
		
		createacc.email_signin(email);
		createacc.pswd_signin(pwd);
		createacc.submit();
		
		
		String Expt_Txt = "Welcome to your account. Here you can manage all of your personal information and orders.";
		String Actual_Txt = driver.findElement(By.className("info-account")).getText();
		
		
		//Assert.assertEquals(Actual_Txt, Expt_Txt);
		if(Expt_Txt.equals(Actual_Txt))
		{
			Assert.assertTrue(true);
		System.out.println("Vadidated"); 
		}
		else
		{
			
			Assert.assertTrue(false);
			System.out.println("Error occured");
			//screenShot(driver,"title_SC");
		}
		
		 /*String Expt_title = "My account";
		
		if(driver.getTitle().equals(Expt_title))
		{
			
			Assert.assertTrue(true);
		}
		
		else
		{
			screenShot(driver,"title_SC");
			Assert.assertTrue(false);
			
		} */
		
		
		
	}
	
	
}
