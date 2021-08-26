package Scripts;

import java.io.IOException;

import org.testng.annotations.Test;

import ExcelUtilities.ExcelFunctions;
import Generic.BaseTest;
import POM.CreateAccount;
import POM.SignIn_ExcelData;

public class SignIn_ExcelData_TestCase7 extends BaseTest{
	
	@Test
	public void testMthd() throws IOException
	{
		SignIn_ExcelData createacc = new SignIn_ExcelData(driver);
		createacc.email_signin(ExcelFunctions.getTestDataInListObj().get(0).get("UserName"));
		//createacc.pswd_signin(ExcelFunctions.getTestDataInList().get(1).get("Password"));
		createacc.submit();
	}

}
