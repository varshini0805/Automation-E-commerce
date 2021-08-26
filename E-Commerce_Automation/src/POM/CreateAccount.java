package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.BaseTest;

public class CreateAccount extends BaseTest{
	WebDriver driver;
	
	@FindBy(name="email_create")
	WebElement email;
	
	@FindBy(name= "SubmitCreate")
	WebElement clickCreate;

	@FindBy(id="email")
	WebElement email_signin;
	
	@FindBy(id="passwd")
	WebElement pswd;
	
	@FindBy(id="SubmitLogin")
	WebElement submit;
	
	
	public CreateAccount(WebDriver d)
	{
		driver=d;
		PageFactory.initElements(d, this);
	}
	
	public void enterEmail(String emailid)
	{
		email.sendKeys(emailid);
	}
	
	public void createClick()
	{
		clickCreate.click();
	}
	
	public void email_signin(String email)
	{
		
		email_signin.sendKeys(email);
	}
	
	public void pswd_signin(String pswrd) {
		pswd.sendKeys(pswrd);
	}
	
	public void submit()
	{
		submit.click();
	}

}
