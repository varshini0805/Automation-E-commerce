package Scripts;

import java.awt.AWTException;

import org.testng.annotations.Test;

import Generic.BaseTest;
import POM.ContactUs;
import POM.CreateAccount;

public class ContactUs_TestCase5 extends BaseTest{

	@Test
	public void testcase() throws InterruptedException, AWTException
	{
		String Scroll_1= "//label[.='Subject Heading']";
		String select_list="//select[@id='id_contact']//option";
		String Fpath="C:\\Users\\Sujan\\Desktop\\Java & Selenium\\info.txt";
		ContactUs cu= new ContactUs(driver);
	
	cu.contactUs_click();
	scrollInto(Scroll_1);
	sortings(select_list,"Customer service");
	
	CreateAccount createacc = new CreateAccount(driver);
	
	createacc.email_signin("varshi@gmail.com");
	
	cu.OrderRef("ytfrd");
	
	cu.file_upload_click(Fpath);
	
	cu.message("Hi all");
	
	cu.sendKey();
	
	}
	
	
}
