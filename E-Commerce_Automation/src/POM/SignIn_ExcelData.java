package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.BaseTest;

public class SignIn_ExcelData extends BaseTest {

	WebDriver driver;
	
	@FindBy(id="email")
	WebElement email_signin;
	
	@FindBy(id="passwd")
	WebElement pswd;
	
	@FindBy(id="SubmitLogin")
	WebElement submit;
	
	public SignIn_ExcelData(WebDriver d)
	{
		driver=d;
		PageFactory.initElements(d, this);
	}
	
	public void email_signin(Object email)
	{
		
		email_signin.sendKeys((CharSequence[]) email);
	}
	
	public void pswd_signin(Object pswrd) {
		pswd.sendKeys((CharSequence[]) pswrd);
	}
	
	public void submit()
	{
		submit.click();
	}
}
